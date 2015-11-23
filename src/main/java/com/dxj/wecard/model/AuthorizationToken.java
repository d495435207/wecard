package com.dxj.wecard.model;

import java.io.Serializable;

/**
 * 类AuthorizationInfo.java的实现描述：
 * 
 * 
 * 授权成功返回的授权信息
 * 
 * 辅助model
 * 
 * 微信文档描述：
 *              https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419318587&token=&lang=zh_CN
 *              3、使用授权码换取公众号的授权信息
 *              
 * @author lizhihui 2015年9月23日 上午9:46:19
 */
public class AuthorizationToken implements Serializable{
   
    /**authorizer_appid
     * 
     */
    private static final long serialVersionUID = 1L;

    //授权方appid
    private String authorizerAppid;
    
    //authorizer_access_token
    //授权方令牌（在授权的公众号具备API权限时，才有此返回值）
    private String authorizerAccessToken;
    //有效期（在授权的公众号具备API权限时，才有此返回值）
    private Integer expiresIn;
    
    //刷新令牌（在授权的公众号具备API权限时，才有此返回值），
    //刷新令牌主要用于公众号第三方平台获取和刷新已授权用户的access_token，
    //只会在授权时刻提供，请妥善保存。 
    //一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌
    private String authorizerRefreshToken;
    
    //公众号授权给开发者的权限集列表
    //（请注意，当出现用户已经将消息与菜单权限集授权给了某个第三方，
    //再授权给另一个第三方时，由于该权限集是互斥的，
    //后一个第三方的授权将去除此权限集，开发者可以在返回的func_info信息中验证这一点，
    //避免信息遗漏），1到13分别代表：
//    消息与菜单权限集
//    用户管理权限集
//    帐号管理权限集
//    网页授权权限集
//    微信小店权限集
//    多客服权限集
//    业务通知权限集
//    微信卡券权限集
//    微信扫一扫权限集
//    微信连WIFI权限集
//    素材管理权限集
//    摇一摇周边权限集
//    微信门店权限集
//    请注意，该字段的返回不会考虑公众号是否具备该权限集的权限（因为可能部分具备），请根据公众号的帐号类型和认证情况，来判断公众号的接口权限。
    private String funcInfo;

    
    public String getAuthorizerAppid() {
        return authorizerAppid;
    }

    
    public void setAuthorizerAppid(String authorizerAppid) {
        this.authorizerAppid = authorizerAppid;
    }

    
    public String getAuthorizerAccessToken() {
        return authorizerAccessToken;
    }

    
    public void setAuthorizerAccessToken(String authorizerAccessToken) {
        this.authorizerAccessToken = authorizerAccessToken;
    }

    
    public Integer getExpiresIn() {
        return expiresIn;
    }

    
    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    
    public String getAuthorizerRefreshToken() {
        return authorizerRefreshToken;
    }

    
    public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
        this.authorizerRefreshToken = authorizerRefreshToken;
    }

    
    public String getFuncInfo() {
        return funcInfo;
    }

    
    public void setFuncInfo(String funcInfo) {
        this.funcInfo = funcInfo;
    }

}
