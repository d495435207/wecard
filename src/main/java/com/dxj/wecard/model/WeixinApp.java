package com.dxj.wecard.model;

import java.io.Serializable;

public class WeixinApp implements Serializable {

	/**
	 * 微信公众号id=appid
	 * @mbggenerated
	 */
	private String id;
	/**
	 * 合作伙伴id
	 * @mbggenerated
	 */
	private Integer partnerId;
	/**
	 * 是否授权，值为0时是未知，值为1时是已授权，值为2时是未授权
	 * @mbggenerated
	 */
	private Integer isAuth;
	/**
	 * 公众号名称
	 * @mbggenerated
	 */
	private String name;
	/**
	 * 微信号
	 * @mbggenerated
	 */
	private String code;
	/**
	 * 开发者微信号
	 * @mbggenerated
	 */
	private String devCode;
	/**
	 * 公众号原始id
	 * @mbggenerated
	 */
	private String rawId;
	/**
	 * AppSecret
	 * @mbggenerated
	 */
	private String appSecret;
	/**
	 * 公众号logo url
	 * @mbggenerated
	 */
	private String logo;
	/**
	 * 二维码 url
	 * @mbggenerated
	 */
	private String qrcode;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of weixin_app.id
	 * @mbggenerated
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id  the value for weixin_app.id
	 * @mbggenerated
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * @return  the value of weixin_app.partner_id
	 * @mbggenerated
	 */
	public Integer getPartnerId() {
		return partnerId;
	}

	/**
	 * @param partnerId  the value for weixin_app.partner_id
	 * @mbggenerated
	 */
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * @return  the value of weixin_app.is_auth
	 * @mbggenerated
	 */
	public Integer getIsAuth() {
		return isAuth;
	}

	/**
	 * @param isAuth  the value for weixin_app.is_auth
	 * @mbggenerated
	 */
	public void setIsAuth(Integer isAuth) {
		this.isAuth = isAuth;
	}

	/**
	 * @return  the value of weixin_app.name
	 * @mbggenerated
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name  the value for weixin_app.name
	 * @mbggenerated
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * @return  the value of weixin_app.code
	 * @mbggenerated
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code  the value for weixin_app.code
	 * @mbggenerated
	 */
	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	/**
	 * @return  the value of weixin_app.dev_code
	 * @mbggenerated
	 */
	public String getDevCode() {
		return devCode;
	}

	/**
	 * @param devCode  the value for weixin_app.dev_code
	 * @mbggenerated
	 */
	public void setDevCode(String devCode) {
		this.devCode = devCode == null ? null : devCode.trim();
	}

	/**
	 * @return  the value of weixin_app.raw_id
	 * @mbggenerated
	 */
	public String getRawId() {
		return rawId;
	}

	/**
	 * @param rawId  the value for weixin_app.raw_id
	 * @mbggenerated
	 */
	public void setRawId(String rawId) {
		this.rawId = rawId == null ? null : rawId.trim();
	}

	/**
	 * @return  the value of weixin_app.app_secret
	 * @mbggenerated
	 */
	public String getAppSecret() {
		return appSecret;
	}

	/**
	 * @param appSecret  the value for weixin_app.app_secret
	 * @mbggenerated
	 */
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret == null ? null : appSecret.trim();
	}

	/**
	 * @return  the value of weixin_app.logo
	 * @mbggenerated
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo  the value for weixin_app.logo
	 * @mbggenerated
	 */
	public void setLogo(String logo) {
		this.logo = logo == null ? null : logo.trim();
	}

	/**
	 * @return  the value of weixin_app.qrcode
	 * @mbggenerated
	 */
	public String getQrcode() {
		return qrcode;
	}

	/**
	 * @param qrcode  the value for weixin_app.qrcode
	 * @mbggenerated
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode == null ? null : qrcode.trim();
	}

	/**
	 * @mbggenerated
	 */@Override public boolean equals(Object that){if (this == that){return true;}if (that == null){return false;}if (getClass() != that.getClass()){return false;}WeixinApp other=(WeixinApp)that;return (this.getId() == null?other.getId() == null:this.getId().equals(other.getId())) && (this.getPartnerId() == null?other.getPartnerId() == null:this.getPartnerId().equals(other.getPartnerId())) && (this.getIsAuth() == null?other.getIsAuth() == null:this.getIsAuth().equals(other.getIsAuth())) && (this.getName() == null?other.getName() == null:this.getName().equals(other.getName())) && (this.getCode() == null?other.getCode() == null:this.getCode().equals(other.getCode())) && (this.getDevCode() == null?other.getDevCode() == null:this.getDevCode().equals(other.getDevCode())) && (this.getRawId() == null?other.getRawId() == null:this.getRawId().equals(other.getRawId())) && (this.getAppSecret() == null?other.getAppSecret() == null:this.getAppSecret().equals(other.getAppSecret())) && (this.getLogo() == null?other.getLogo() == null:this.getLogo().equals(other.getLogo())) && (this.getQrcode() == null?other.getQrcode() == null:this.getQrcode().equals(other.getQrcode()));}

	/**
	 * @mbggenerated
	 */@Override public int hashCode(){final int prime=31;int result=1;result=prime * result + ((getId() == null)?0:getId().hashCode());result=prime * result + ((getPartnerId() == null)?0:getPartnerId().hashCode());result=prime * result + ((getIsAuth() == null)?0:getIsAuth().hashCode());result=prime * result + ((getName() == null)?0:getName().hashCode());result=prime * result + ((getCode() == null)?0:getCode().hashCode());result=prime * result + ((getDevCode() == null)?0:getDevCode().hashCode());result=prime * result + ((getRawId() == null)?0:getRawId().hashCode());result=prime * result + ((getAppSecret() == null)?0:getAppSecret().hashCode());result=prime * result + ((getLogo() == null)?0:getLogo().hashCode());result=prime * result + ((getQrcode() == null)?0:getQrcode().hashCode());return result;}

	/**
	 * @mbggenerated
	 */@Override public String toString(){StringBuilder sb=new StringBuilder();sb.append(getClass().getSimpleName());sb.append(" [");sb.append("Hash = ").append(hashCode());sb.append(", id=").append(id);sb.append(", partnerId=").append(partnerId);sb.append(", isAuth=").append(isAuth);sb.append(", name=").append(name);sb.append(", code=").append(code);sb.append(", devCode=").append(devCode);sb.append(", rawId=").append(rawId);sb.append(", appSecret=").append(appSecret);sb.append(", logo=").append(logo);sb.append(", qrcode=").append(qrcode);sb.append(", serialVersionUID=").append(serialVersionUID);sb.append("]");return sb.toString();}
}