package com.dxj.wecard.model;

import java.io.Serializable;

public class AreaKey implements Serializable {

	/**
	 * 上级id
	 * 
	 * @mbggenerated
	 */
	private Long pid;
	/**
	 * 省、市id
	 * 
	 * @mbggenerated
	 */
	private Long id;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return the value of area.pid
	 * @mbggenerated
	 */
	public Long getPid() {
		return pid;
	}

	/**
	 * @param pid
	 *            the value for area.pid
	 * @mbggenerated
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}

	/**
	 * @return the value of area.id
	 * @mbggenerated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the value for area.id
	 * @mbggenerated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @mbggenerated
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		AreaKey other = (AreaKey) that;
		return (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
				&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
	}

	/**
	 * @mbggenerated
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	/**
	 * @mbggenerated
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", pid=").append(pid);
		sb.append(", id=").append(id);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}