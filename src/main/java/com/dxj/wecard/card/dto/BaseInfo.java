package com.dxj.wecard.card.dto;

public class BaseInfo {
	private String logo_url;
	private String code_type;//code码展示类型
	private String brand_name;//s商户名字,字数上限为12 个汉字。（填写直接提供服务的商户名，第三方商户名填写在source 字段）是title券名，字
	private String title;//券名
	private String sub_title;//券名的副标题，字数上限为18 汉字。
	private String color;
	private String notice;//使用提醒，字数上限为9 个汉字   例：请出示二维码核销卡券
	private String description;//使用说明。长文本描1000字
	private DateInfo date_info;//使用日期，有效期的信息
	private Integer[] location_id_list;
	private boolean use_custom_code;//是否自定义code 码。填写true或false，不填代表默认为false。该字段需单独申请权限，详情见三、开发者必读。
	private boolean bind_openid;//绑定用户
	
	private boolean can_share;//能分享
	
	private boolean can_give_friend;//卡券是否可转赠
	
	private Integer get_limit;
	private String service_phone;//客服电话
	
	private String source;//第三方来源名
	
	/**
	 * URL_NAME_TYPE_TAKE_AWAY 外卖
	 * URL_NAME_TYPE_RESERVATION 在线预订
	 * URL_NAME_TYPE_USE_IMMEDIATELY 立即使用
	 * URL_NAME_TYPE_APPOINTMENT 在线预约
	 * URL_NAME_TYPE_EXCHANGE 在线兑换
	 * URL_NAME_TYPE_VIP_SERVICE	会员服务(仅会员卡类型可用)
	 * 
	 */
//	private String url_name_type;//商户自定义cell 名称， 与custom_url 字段共同使用，目前支持类型参考下表。
	private String custom_url;//商户自定义cell 跳转外链的地址链接,跳转页面内容需与自定义cell 名称保持一致。
	private Sku sku;//卡券库存的数量
	
	private String custom_url_name;
	
	private String custom_url_sub_title;
	
	private String promotion_url_name;
	
	private String promotion_url;
	
	private String promotion_url_sub_title;
	
	
	
	
	
	
//	private String id;
//	private String status;
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
	public String getLogo_url() {
		return logo_url;
	}
	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}
	public String getCode_type() {
		return code_type;
	}
	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSub_title() {
		return sub_title;
	}
	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public DateInfo getDate_info() {
		return date_info;
	}
	public void setDate_info(DateInfo date_info) {
		this.date_info = date_info;
	}
	public Integer[] getLocation_id_list() {
		return location_id_list;
	}
	public void setLocation_id_list(Integer[] location_id_list) {
		this.location_id_list = location_id_list;
	}
	public boolean isUse_custom_code() {
		return use_custom_code;
	}
	public void setUse_custom_code(boolean use_custom_code) {
		this.use_custom_code = use_custom_code;
	}
	public boolean isBind_openid() {
		return bind_openid;
	}
	public void setBind_openid(boolean bind_openid) {
		this.bind_openid = bind_openid;
	}
	public boolean isCan_share() {
		return can_share;
	}
	public void setCan_share(boolean can_share) {
		this.can_share = can_share;
	}
	public boolean isCan_give_friend() {
		return can_give_friend;
	}
	public void setCan_give_friend(boolean can_give_friend) {
		this.can_give_friend = can_give_friend;
	}
	public Integer getGet_limit() {
		return get_limit;
	}
	public void setGet_limit(Integer get_limit) {
		this.get_limit = get_limit;
	}
	public String getService_phone() {
		return service_phone;
	}
	public void setService_phone(String service_phone) {
		this.service_phone = service_phone;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	public String getCustom_url_name() {
		return custom_url_name;
	}
	public void setCustom_url_name(String custom_url_name) {
		this.custom_url_name = custom_url_name;
	}
	public String getCustom_url_sub_title() {
		return custom_url_sub_title;
	}
	public void setCustom_url_sub_title(String custom_url_sub_title) {
		this.custom_url_sub_title = custom_url_sub_title;
	}
	public String getPromotion_url_name() {
		return promotion_url_name;
	}
	public void setPromotion_url_name(String promotion_url_name) {
		this.promotion_url_name = promotion_url_name;
	}
	public String getPromotion_url() {
		return promotion_url;
	}
	public void setPromotion_url(String promotion_url) {
		this.promotion_url = promotion_url;
	}
	public String getCustom_url() {
		return custom_url;
	}
	public void setCustom_url(String custom_url) {
		this.custom_url = custom_url;
	}
	public Sku getSku() {
		return sku;
	}
	public void setSku(Sku sku) {
		this.sku = sku;
	}
	public String getPromotion_url_sub_title() {
		return promotion_url_sub_title;
	}
	public void setPromotion_url_sub_title(String promotion_url_sub_title) {
		this.promotion_url_sub_title = promotion_url_sub_title;
	}
	
}
