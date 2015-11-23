package com.dxj.wecard.dao;

import java.util.Map;

import com.dxj.wecard.model.AuthorizerInfo;

public interface AuthorizerInfoMapper {
    int insert(AuthorizerInfo authorizerInfo);
    
    int updateUnauthorizerEvent(Map<String,Object> map);
    /**
     *
     * @mbggenerated
     */
    int insertSelective(AuthorizerInfo authorizerInfo);
    
    AuthorizerInfo selectByAppid(String appId);
    
    int updateAuthorizer(AuthorizerInfo authorizerInfo);
    int deleteByAppid(String appId);
}