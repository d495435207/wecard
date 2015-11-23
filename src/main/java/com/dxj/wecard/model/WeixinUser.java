package com.dxj.wecard.model;

import java.io.Serializable;
import java.util.Date;

public class WeixinUser extends WeixinUserKey implements Serializable {

	/**
	 * 微信昵称
	 * @mbggenerated
	 */
	private String nickName;
	/**
	 * 微信备注名
	 * @mbggenerated
	 */
	private String remark;
	/**
	 * 头像 url
	 * @mbggenerated
	 */
	private String headImg;
	/**
	 * 用户分组id
	 * @mbggenerated
	 */
	private String groupId;
	/**
	 * 用户关注时间
	 * @mbggenerated
	 */
	private Date subscribeTime;
	/**
	 * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	 * @mbggenerated
	 */
	private Integer sex;
	/**
	 * 城市
	 * @mbggenerated
	 */
	private String city;
	/**
	 * 国家
	 * @mbggenerated
	 */
	private String country;
	/**
	 * 省份
	 * @mbggenerated
	 */
	private String province;
	/**
	 * 用户的语言，简体中文为zh_CN
	 * @mbggenerated
	 */
	private String language;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of weixin_user.nick_name
	 * @mbggenerated
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName  the value for weixin_user.nick_name
	 * @mbggenerated
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName == null ? null : nickName.trim();
	}

	/**
	 * @return  the value of weixin_user.remark
	 * @mbggenerated
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark  the value for weixin_user.remark
	 * @mbggenerated
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * @return  the value of weixin_user.head_img
	 * @mbggenerated
	 */
	public String getHeadImg() {
		return headImg;
	}

	/**
	 * @param headImg  the value for weixin_user.head_img
	 * @mbggenerated
	 */
	public void setHeadImg(String headImg) {
		this.headImg = headImg == null ? null : headImg.trim();
	}

	/**
	 * @return  the value of weixin_user.group_id
	 * @mbggenerated
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId  the value for weixin_user.group_id
	 * @mbggenerated
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId == null ? null : groupId.trim();
	}

	/**
	 * @return  the value of weixin_user.subscribe_time
	 * @mbggenerated
	 */
	public Date getSubscribeTime() {
		return subscribeTime;
	}

	/**
	 * @param subscribeTime  the value for weixin_user.subscribe_time
	 * @mbggenerated
	 */
	public void setSubscribeTime(Date subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	/**
	 * @return  the value of weixin_user.sex
	 * @mbggenerated
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * @param sex  the value for weixin_user.sex
	 * @mbggenerated
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * @return  the value of weixin_user.city
	 * @mbggenerated
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city  the value for weixin_user.city
	 * @mbggenerated
	 */
	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	/**
	 * @return  the value of weixin_user.country
	 * @mbggenerated
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country  the value for weixin_user.country
	 * @mbggenerated
	 */
	public void setCountry(String country) {
		this.country = country == null ? null : country.trim();
	}

	/**
	 * @return  the value of weixin_user.province
	 * @mbggenerated
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province  the value for weixin_user.province
	 * @mbggenerated
	 */
	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	/**
	 * @return  the value of weixin_user.language
	 * @mbggenerated
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language  the value for weixin_user.language
	 * @mbggenerated
	 */
	public void setLanguage(String language) {
		this.language = language == null ? null : language.trim();
	}

	/**
	 * @mbggenerated
	 */@Override public boolean equals(Object that){if (this == that){return true;}if (that == null){return false;}if (getClass() != that.getClass()){return false;}WeixinUser other=(WeixinUser)that;return (this.getAppId() == null?other.getAppId() == null:this.getAppId().equals(other.getAppId())) && (this.getOpenId() == null?other.getOpenId() == null:this.getOpenId().equals(other.getOpenId())) && (this.getNickName() == null?other.getNickName() == null:this.getNickName().equals(other.getNickName())) && (this.getRemark() == null?other.getRemark() == null:this.getRemark().equals(other.getRemark())) && (this.getHeadImg() == null?other.getHeadImg() == null:this.getHeadImg().equals(other.getHeadImg())) && (this.getGroupId() == null?other.getGroupId() == null:this.getGroupId().equals(other.getGroupId())) && (this.getSubscribeTime() == null?other.getSubscribeTime() == null:this.getSubscribeTime().equals(other.getSubscribeTime())) && (this.getSex() == null?other.getSex() == null:this.getSex().equals(other.getSex())) && (this.getCity() == null?other.getCity() == null:this.getCity().equals(other.getCity())) && (this.getCountry() == null?other.getCountry() == null:this.getCountry().equals(other.getCountry())) && (this.getProvince() == null?other.getProvince() == null:this.getProvince().equals(other.getProvince())) && (this.getLanguage() == null?other.getLanguage() == null:this.getLanguage().equals(other.getLanguage()));}

	/**
	 * @mbggenerated
	 */@Override public int hashCode(){final int prime=31;int result=1;result=prime * result + ((getAppId() == null)?0:getAppId().hashCode());result=prime * result + ((getOpenId() == null)?0:getOpenId().hashCode());result=prime * result + ((getNickName() == null)?0:getNickName().hashCode());result=prime * result + ((getRemark() == null)?0:getRemark().hashCode());result=prime * result + ((getHeadImg() == null)?0:getHeadImg().hashCode());result=prime * result + ((getGroupId() == null)?0:getGroupId().hashCode());result=prime * result + ((getSubscribeTime() == null)?0:getSubscribeTime().hashCode());result=prime * result + ((getSex() == null)?0:getSex().hashCode());result=prime * result + ((getCity() == null)?0:getCity().hashCode());result=prime * result + ((getCountry() == null)?0:getCountry().hashCode());result=prime * result + ((getProvince() == null)?0:getProvince().hashCode());result=prime * result + ((getLanguage() == null)?0:getLanguage().hashCode());return result;}

	/**
	 * @mbggenerated
	 */@Override public String toString(){StringBuilder sb=new StringBuilder();sb.append(getClass().getSimpleName());sb.append(" [");sb.append("Hash = ").append(hashCode());sb.append(", nickName=").append(nickName);sb.append(", remark=").append(remark);sb.append(", headImg=").append(headImg);sb.append(", groupId=").append(groupId);sb.append(", subscribeTime=").append(subscribeTime);sb.append(", sex=").append(sex);sb.append(", city=").append(city);sb.append(", country=").append(country);sb.append(", province=").append(province);sb.append(", language=").append(language);sb.append(", serialVersionUID=").append(serialVersionUID);sb.append("]");return sb.toString();}
}