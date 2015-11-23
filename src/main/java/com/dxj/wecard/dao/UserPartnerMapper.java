package com.dxj.wecard.dao;

import com.dxj.wecard.model.UserPartner;

public interface UserPartnerMapper {

	/**
	 * @mbggenerated
	 */
	int insert(UserPartner record);
	int delete(UserPartner record);
	/**
	 * @mbggenerated
	 */
	int insertSelective(UserPartner record);
	int deleteSelective(UserPartner record);
	int deleteUser(String partnerId, String userId);
	
}