package com.dxj.wecard.weixin.component.model;

import java.util.List;

/**
 * 授权信息
 * @author liulihai
 *
 */
public class AuthorizerInfo {
	private String authorizer_appid;
	
	private List<Funcion> func_info;
	
    
    public String getAuthorizer_appid() {
        return authorizer_appid;
    }

    
    public void setAuthorizer_appid(String authorizer_appid) {
        this.authorizer_appid = authorizer_appid;
    }

    public List<Funcion> getFunc_info() {
        return func_info;
    }
    
    public void setFunc_info(List<Funcion> func_info) {
        this.func_info = func_info;
    }
	
}
