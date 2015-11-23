package com.dxj.wecard.model;

import java.io.Serializable;

public class Branch implements Serializable {

	/**
	 * 门店id=sid
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * 微信appid
	 * @mbggenerated
	 */
	private String appId;
	/**
	 * weixin返回的poi_id
	 * @mbggenerated
	 */
	private String poiId;
	/**
	 * 门店名称
	 * @mbggenerated
	 */
	private String name;
	/**
	 * 国家
	 * @mbggenerated
	 */
	private String country;
	/**
	 * 省
	 * @mbggenerated
	 */
	private String province;
	/**
	 * 城市
	 * @mbggenerated
	 */
	private String city;
	/**
	 * 区
	 * @mbggenerated
	 */
	private String district;
	/**
	 * 地址
	 * @mbggenerated
	 */
	private String address;
	/**
	 * 门店的电话
	 * @mbggenerated
	 */
	private String phone;
	/**
	 * 门店的类型
	 * @mbggenerated
	 */
	private String categories;
	/**
	 * 坐标类型，1 为火星坐标（目前只能选1）
	 * @mbggenerated
	 */
	private Integer offsetType;
	/**
	 * 地理位置的经度
	 * @mbggenerated
	 */
	private String longitude;
	/**
	 * 地理位置的纬度
	 * @mbggenerated
	 */
	private String latitude;
	/**
	 * 特色服务
	 * @mbggenerated
	 */
	private String special;
	/**
	 * 营业时间，24 小时制表示
	 * @mbggenerated
	 */
	private String openTime;
	/**
	 * 人均价格，大于0 的整数
	 * @mbggenerated
	 */
	private Integer avgPrice;
	/**
	 * 商户简介
	 * @mbggenerated
	 */
	private String introduction;
	/**
	 * 推荐品
	 * @mbggenerated
	 */
	private String recommend;
	/**
	 * 图片列表 url
	 * @mbggenerated
	 */
	private String photoList;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of branch.id
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id  the value for branch.id
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return  the value of branch.app_id
	 * @mbggenerated
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * @param appId  the value for branch.app_id
	 * @mbggenerated
	 */
	public void setAppId(String appId) {
		this.appId = appId == null ? null : appId.trim();
	}

	/**
	 * @return  the value of branch.poi_id
	 * @mbggenerated
	 */
	public String getPoiId() {
		return poiId;
	}

	/**
	 * @param poiId  the value for branch.poi_id
	 * @mbggenerated
	 */
	public void setPoiId(String poiId) {
		this.poiId = poiId == null ? null : poiId.trim();
	}

	/**
	 * @return  the value of branch.name
	 * @mbggenerated
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name  the value for branch.name
	 * @mbggenerated
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * @return  the value of branch.country
	 * @mbggenerated
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country  the value for branch.country
	 * @mbggenerated
	 */
	public void setCountry(String country) {
		this.country = country == null ? null : country.trim();
	}

	/**
	 * @return  the value of branch.province
	 * @mbggenerated
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province  the value for branch.province
	 * @mbggenerated
	 */
	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	/**
	 * @return  the value of branch.city
	 * @mbggenerated
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city  the value for branch.city
	 * @mbggenerated
	 */
	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	/**
	 * @return  the value of branch.district
	 * @mbggenerated
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district  the value for branch.district
	 * @mbggenerated
	 */
	public void setDistrict(String district) {
		this.district = district == null ? null : district.trim();
	}

	/**
	 * @return  the value of branch.address
	 * @mbggenerated
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address  the value for branch.address
	 * @mbggenerated
	 */
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/**
	 * @return  the value of branch.phone
	 * @mbggenerated
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone  the value for branch.phone
	 * @mbggenerated
	 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	/**
	 * @return  the value of branch.categories
	 * @mbggenerated
	 */
	public String getCategories() {
		return categories;
	}

	/**
	 * @param categories  the value for branch.categories
	 * @mbggenerated
	 */
	public void setCategories(String categories) {
		this.categories = categories == null ? null : categories.trim();
	}

	/**
	 * @return  the value of branch.offset_type
	 * @mbggenerated
	 */
	public Integer getOffsetType() {
		return offsetType;
	}

	/**
	 * @param offsetType  the value for branch.offset_type
	 * @mbggenerated
	 */
	public void setOffsetType(Integer offsetType) {
		this.offsetType = offsetType;
	}

	/**
	 * @return  the value of branch.longitude
	 * @mbggenerated
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude  the value for branch.longitude
	 * @mbggenerated
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude == null ? null : longitude.trim();
	}

	/**
	 * @return  the value of branch.latitude
	 * @mbggenerated
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude  the value for branch.latitude
	 * @mbggenerated
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude == null ? null : latitude.trim();
	}

	/**
	 * @return  the value of branch.special
	 * @mbggenerated
	 */
	public String getSpecial() {
		return special;
	}

	/**
	 * @param special  the value for branch.special
	 * @mbggenerated
	 */
	public void setSpecial(String special) {
		this.special = special == null ? null : special.trim();
	}

	/**
	 * @return  the value of branch.open_time
	 * @mbggenerated
	 */
	public String getOpenTime() {
		return openTime;
	}

	/**
	 * @param openTime  the value for branch.open_time
	 * @mbggenerated
	 */
	public void setOpenTime(String openTime) {
		this.openTime = openTime == null ? null : openTime.trim();
	}

	/**
	 * @return  the value of branch.avg_price
	 * @mbggenerated
	 */
	public Integer getAvgPrice() {
		return avgPrice;
	}

	/**
	 * @param avgPrice  the value for branch.avg_price
	 * @mbggenerated
	 */
	public void setAvgPrice(Integer avgPrice) {
		this.avgPrice = avgPrice;
	}

	/**
	 * @return  the value of branch.introduction
	 * @mbggenerated
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * @param introduction  the value for branch.introduction
	 * @mbggenerated
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction == null ? null : introduction.trim();
	}

	/**
	 * @return  the value of branch.recommend
	 * @mbggenerated
	 */
	public String getRecommend() {
		return recommend;
	}

	/**
	 * @param recommend  the value for branch.recommend
	 * @mbggenerated
	 */
	public void setRecommend(String recommend) {
		this.recommend = recommend == null ? null : recommend.trim();
	}

	/**
	 * @return  the value of branch.photo_list
	 * @mbggenerated
	 */
	public String getPhotoList() {
		return photoList;
	}

	/**
	 * @param photoList  the value for branch.photo_list
	 * @mbggenerated
	 */
	public void setPhotoList(String photoList) {
		this.photoList = photoList == null ? null : photoList.trim();
	}

	/**
	 * @mbggenerated
	 */@Override public boolean equals(Object that){if (this == that){return true;}if (that == null){return false;}if (getClass() != that.getClass()){return false;}Branch other=(Branch)that;return (this.getId() == null?other.getId() == null:this.getId().equals(other.getId())) && (this.getAppId() == null?other.getAppId() == null:this.getAppId().equals(other.getAppId())) && (this.getPoiId() == null?other.getPoiId() == null:this.getPoiId().equals(other.getPoiId())) && (this.getName() == null?other.getName() == null:this.getName().equals(other.getName())) && (this.getCountry() == null?other.getCountry() == null:this.getCountry().equals(other.getCountry())) && (this.getProvince() == null?other.getProvince() == null:this.getProvince().equals(other.getProvince())) && (this.getCity() == null?other.getCity() == null:this.getCity().equals(other.getCity())) && (this.getDistrict() == null?other.getDistrict() == null:this.getDistrict().equals(other.getDistrict())) && (this.getAddress() == null?other.getAddress() == null:this.getAddress().equals(other.getAddress())) && (this.getPhone() == null?other.getPhone() == null:this.getPhone().equals(other.getPhone())) && (this.getCategories() == null?other.getCategories() == null:this.getCategories().equals(other.getCategories())) && (this.getOffsetType() == null?other.getOffsetType() == null:this.getOffsetType().equals(other.getOffsetType())) && (this.getLongitude() == null?other.getLongitude() == null:this.getLongitude().equals(other.getLongitude())) && (this.getLatitude() == null?other.getLatitude() == null:this.getLatitude().equals(other.getLatitude())) && (this.getSpecial() == null?other.getSpecial() == null:this.getSpecial().equals(other.getSpecial())) && (this.getOpenTime() == null?other.getOpenTime() == null:this.getOpenTime().equals(other.getOpenTime())) && (this.getAvgPrice() == null?other.getAvgPrice() == null:this.getAvgPrice().equals(other.getAvgPrice())) && (this.getIntroduction() == null?other.getIntroduction() == null:this.getIntroduction().equals(other.getIntroduction())) && (this.getRecommend() == null?other.getRecommend() == null:this.getRecommend().equals(other.getRecommend())) && (this.getPhotoList() == null?other.getPhotoList() == null:this.getPhotoList().equals(other.getPhotoList()));}

	/**
	 * @mbggenerated
	 */@Override public int hashCode(){final int prime=31;int result=1;result=prime * result + ((getId() == null)?0:getId().hashCode());result=prime * result + ((getAppId() == null)?0:getAppId().hashCode());result=prime * result + ((getPoiId() == null)?0:getPoiId().hashCode());result=prime * result + ((getName() == null)?0:getName().hashCode());result=prime * result + ((getCountry() == null)?0:getCountry().hashCode());result=prime * result + ((getProvince() == null)?0:getProvince().hashCode());result=prime * result + ((getCity() == null)?0:getCity().hashCode());result=prime * result + ((getDistrict() == null)?0:getDistrict().hashCode());result=prime * result + ((getAddress() == null)?0:getAddress().hashCode());result=prime * result + ((getPhone() == null)?0:getPhone().hashCode());result=prime * result + ((getCategories() == null)?0:getCategories().hashCode());result=prime * result + ((getOffsetType() == null)?0:getOffsetType().hashCode());result=prime * result + ((getLongitude() == null)?0:getLongitude().hashCode());result=prime * result + ((getLatitude() == null)?0:getLatitude().hashCode());result=prime * result + ((getSpecial() == null)?0:getSpecial().hashCode());result=prime * result + ((getOpenTime() == null)?0:getOpenTime().hashCode());result=prime * result + ((getAvgPrice() == null)?0:getAvgPrice().hashCode());result=prime * result + ((getIntroduction() == null)?0:getIntroduction().hashCode());result=prime * result + ((getRecommend() == null)?0:getRecommend().hashCode());result=prime * result + ((getPhotoList() == null)?0:getPhotoList().hashCode());return result;}

	/**
	 * @mbggenerated
	 */@Override public String toString(){StringBuilder sb=new StringBuilder();sb.append(getClass().getSimpleName());sb.append(" [");sb.append("Hash = ").append(hashCode());sb.append(", id=").append(id);sb.append(", appId=").append(appId);sb.append(", poiId=").append(poiId);sb.append(", name=").append(name);sb.append(", country=").append(country);sb.append(", province=").append(province);sb.append(", city=").append(city);sb.append(", district=").append(district);sb.append(", address=").append(address);sb.append(", phone=").append(phone);sb.append(", categories=").append(categories);sb.append(", offsetType=").append(offsetType);sb.append(", longitude=").append(longitude);sb.append(", latitude=").append(latitude);sb.append(", special=").append(special);sb.append(", openTime=").append(openTime);sb.append(", avgPrice=").append(avgPrice);sb.append(", introduction=").append(introduction);sb.append(", recommend=").append(recommend);sb.append(", photoList=").append(photoList);sb.append(", serialVersionUID=").append(serialVersionUID);sb.append("]");return sb.toString();}
}