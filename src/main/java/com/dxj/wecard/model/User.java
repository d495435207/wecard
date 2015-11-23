package com.dxj.wecard.model;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

public class User implements Serializable {
	/**
	 * 用户名=手机号
	 * @mbggenerated
	 */
	private String id;
	/**
	 * 登陆密码
	 * @mbggenerated
	 */
	private String password;
	/**
	 * 承销商系统访问ip
	 * @mbggenerated
	 */
	private String ip;
	/**
	 * 是否管理员，0为非管理员，1为管理员
	 * @mbggenerated
	 */
	private Integer isAdmin;
	/**
	 * 开户时间
	 * @mbggenerated
	 */
	private Date atTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of user.id
	 * @mbggenerated
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id  the value for user.id
	 * @mbggenerated
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * @return  the value of user.password
	 * @mbggenerated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password  the value for user.password
	 * @mbggenerated
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * @return  the value of user.ip
	 * @mbggenerated
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip  the value for user.ip
	 * @mbggenerated
	 */
	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	/**
	 * @return  the value of user.is_admin
	 * @mbggenerated
	 */
	public Integer getIsAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin  the value for user.is_admin
	 * @mbggenerated
	 */
	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * @return  the value of user.at_time
	 * @mbggenerated
	 */
	public Date getAtTime() {
		return atTime;
	}

	/**
	 * @param atTime  the value for user.at_time
	 * @mbggenerated
	 */
	public void setAtTime(Date atTime) {
		this.atTime = atTime;
	}

	/**
	 * @mbggenerated
	 */@Override public boolean equals(Object that){if (this == that){return true;}if (that == null){return false;}if (getClass() != that.getClass()){return false;}User other=(User)that;return (this.getId() == null?other.getId() == null:this.getId().equals(other.getId())) && (this.getPassword() == null?other.getPassword() == null:this.getPassword().equals(other.getPassword())) && (this.getIp() == null?other.getIp() == null:this.getIp().equals(other.getIp())) && (this.getIsAdmin() == null?other.getIsAdmin() == null:this.getIsAdmin().equals(other.getIsAdmin())) && (this.getAtTime() == null?other.getAtTime() == null:this.getAtTime().equals(other.getAtTime()));}

	/**
	 * @mbggenerated
	 */@Override public int hashCode(){final int prime=31;int result=1;result=prime * result + ((getId() == null)?0:getId().hashCode());result=prime * result + ((getPassword() == null)?0:getPassword().hashCode());result=prime * result + ((getIp() == null)?0:getIp().hashCode());result=prime * result + ((getIsAdmin() == null)?0:getIsAdmin().hashCode());result=prime * result + ((getAtTime() == null)?0:getAtTime().hashCode());return result;}

	/**
	 * @mbggenerated
	 */@Override public String toString(){StringBuilder sb=new StringBuilder();sb.append(getClass().getSimpleName());sb.append(" [");sb.append("Hash = ").append(hashCode());sb.append(", id=").append(id);sb.append(", password=").append(password);sb.append(", ip=").append(ip);sb.append(", isAdmin=").append(isAdmin);sb.append(", atTime=").append(atTime);sb.append(", serialVersionUID=").append(serialVersionUID);sb.append("]");return sb.toString();}

	private List<User> users;

	public List<User> getAll() {
		return users;
	}
}