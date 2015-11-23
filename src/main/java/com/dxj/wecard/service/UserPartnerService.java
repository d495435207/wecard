package com.dxj.wecard.service;

import com.dxj.wecard.model.Fund;
import com.dxj.wecard.model.Partner;
import com.dxj.wecard.model.User;
import com.dxj.wecard.model.UserPartner;

public interface UserPartnerService {

	int insert(UserPartner record);
	int delete(UserPartner record);
	int deleteUser(String partnerId , String userId);

	int addPartner(User user, Partner partner);

	int addUserPartner(User user, Partner partner);

	Partner getPartnerByUser(String phone);

	int deleteUserPartner(User user);

	int deletePartner(User user);
}