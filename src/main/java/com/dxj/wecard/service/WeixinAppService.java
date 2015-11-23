package com.dxj.wecard.service;

import com.dxj.wecard.model.AuthorizerInfo;
import com.dxj.wecard.model.Partner;
import com.dxj.wecard.model.WeixinApp;

public interface WeixinAppService {

	int delete(String id);

	int insert(WeixinApp record);

	WeixinApp getById(String id);

	int update(WeixinApp record);
	
	WeixinApp getWeixinByPartner(Integer id);
	
	int saveAuth(AuthorizerInfo token,Partner partner);
	
	int unAuthorizerUpdate(String appid);
}