package com.dxj.wecard.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxj.wecard.dao.PartnerMapper;
import com.dxj.wecard.dao.UserMapper;
import com.dxj.wecard.dao.UserPartnerMapper;
import com.dxj.wecard.model.Partner;
import com.dxj.wecard.model.User;
import com.dxj.wecard.model.UserPartner;
import com.dxj.wecard.service.UserPartnerService;

@Service("userPartnerService")
public class UserPartnerServiceImpl implements UserPartnerService {

	@Autowired
	private UserPartnerMapper userPartnerMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PartnerMapper partnerMapper;

	@Override
	public int insert(UserPartner record) {
		return userPartnerMapper.insert(record);
	}
	
	@Override
	public int delete(UserPartner record) {
		return userPartnerMapper.delete(record);
	}

	@Override
	@Transactional
	public int addUserPartner(User user, Partner partner) {
		user.setAtTime(Calendar.getInstance().getTime());
		int result_user = userMapper.insert(user);
		int result_partner = partnerMapper.insert(partner);
		UserPartner userPartner = new UserPartner();
		userPartner.setUserId(user.getId());
		userPartner.setPartnerId(partner.getId());
		int result_userPartner = userPartnerMapper.insert(userPartner);
		if (result_user == 1 && result_partner == 1 && result_userPartner == 1) {
			return 1;
		}
		return 0;
	}
	
	@Override
	@Transactional
	public int deleteUserPartner(User user) {
		UserPartner userPartner = new UserPartner();
		userPartner.setUserId(user.getId());
		int result_userPartner = userPartnerMapper.delete(userPartner);
		if (result_userPartner == 1) {
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteUser(String partnerId , String userId){
		return userPartnerMapper.deleteUser(partnerId,userId);
	}
	
	@Override
	@Transactional
	public int addPartner(User user, Partner partner) {
		int result_partner = partnerMapper.insert(partner);
		UserPartner userPartner = new UserPartner();
		userPartner.setUserId(user.getId());
		userPartner.setPartnerId(partner.getId());
		int result_userPartner = userPartnerMapper.insert(userPartner);
		if (result_partner == 1 && result_userPartner == 1) {
			return 1;
		}
		return 0;
	}
	
	@Override
	@Transactional
	public int deletePartner(User user) {
		UserPartner userPartner = new UserPartner();
		userPartner.setUserId(user.getId());
		int result_userPartner = userPartnerMapper.delete(userPartner);
		if (result_userPartner == 1) {
			return 1;
		}
		return 0;
	}

	@Override
	public Partner getPartnerByUser(String phone) {
		return partnerMapper.getPartnerByUser(phone);
	}
}