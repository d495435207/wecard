package com.dxj.wecard.dao;

import com.dxj.wecard.model.AuthorizationToken;

public interface AuthorizationTokenMapper {
    int insert(AuthorizationToken record);

    
    int delete(String authorizerAppid);
    
    int update(AuthorizationToken record);
    /**
     *
     * @mbggenerated
     */
    AuthorizationToken selectByPrimaryKey(String authorizerAppid);
    
    

}