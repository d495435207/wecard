package com.dxj.wecard.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxj.wecard.controller.UserController;
import com.dxj.wecard.dao.WeixinAppMapper;
import com.dxj.wecard.model.AuthorizerInfo;
import com.dxj.wecard.model.Partner;
import com.dxj.wecard.model.WeixinApp;
import com.dxj.wecard.service.WeixinAppService;

@Service("weixinAppService")
public class WeixinAppServiceImpl implements WeixinAppService {
    static final Logger logger = LogManager.getLogger(WeixinAppServiceImpl.class);
	@Autowired
	private WeixinAppMapper weixinAppMapper;

	@Override
	public int delete(String id) {
		return weixinAppMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(WeixinApp record) {
		return weixinAppMapper.insert(record);
	}

	@Override
	public WeixinApp getById(String id) {
		return weixinAppMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(WeixinApp record) {
		return weixinAppMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public WeixinApp getWeixinByPartner(Integer id){
		return weixinAppMapper.getWeixinByPartner(id);
	}

    /* (non-Javadoc)
     * @see com.dxj.wecard.service.WeixinAppService#saveAuth(com.dxj.wecard.model.AuthorizerInfo)
     */
    @Override
    public int saveAuth(AuthorizerInfo token,Partner partner) {
        int save=0;
        try{
            WeixinApp weixinUser=new WeixinApp();
            weixinUser.setId(token.getAppId());
            weixinUser.setIsAuth(1);
            weixinUser.setPartnerId(partner.getId());
            weixinUser.setLogo(token.getHeadImg());
            weixinUser.setName(token.getNickName());
            weixinUser.setQrcode(token.getQrcodeUrl());
            save=weixinAppMapper.insert(weixinUser);
        }catch(Exception e){
            logger.error(e);
        }
        
        return save;
    }

    /* (non-Javadoc)
     * @see com.dxj.wecard.service.WeixinAppService#unAuthorizerUpdate(java.lang.String)
     */
    @Override
    public int unAuthorizerUpdate(String appId) {
        return weixinAppMapper.unAuthorizerUpdate(appId);
    }
}