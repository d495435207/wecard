package com.dxj.wecard.card.dto;

import com.dxj.wecard.card.enums.CardCodeTypeEnum;
import com.dxj.wecard.card.enums.CardUrlNameTypeEnum;

public class BaseInfoVO {
	private String logo_url;	//卡券商家logo
	private String code_type;	//卡券类型
	private String brand_name;	//商户名字,字数上限为12个汉字
	private String title;	//券标题
	private String sub_title;	//副标题
	private String color;	//券颜色
	private String notice;	//操作提示
	private String description;	//使用须知
	private DateInfoVO date_info;	//使用日期，有效期的信息
	private SkuVO sku;	//商品信息
	private Integer[] location_id_list;	//门店
	private boolean use_custom_code;	//是否自定义 code 码。填写 true或 false，默认false
	private boolean bind_openid;	//是否指定用户领取，填写 true 或 false，默认false
	private boolean can_share;	//可分享
	private boolean can_give_friend;	//可转赠
	private Integer get_limit;	//领券限制，每人最大领取次数
	private String service_phone;	//客服电话
	private String source;	//第三方来源名
	private String custom_url;	//商户自定义 cell 跳转外链的地址链接,跳转页面内容需与自定义	cell 名称保持一致
	
	private String customUrlName;  //商 户 自 定 义 cell 名 称 ， 与    custom_url 字段共同使用
    
    private String customUrlSubTitle;
    
    private String promotionUrlName;
    
    private String promotionUrl;
    
    private String promotionUrlSubTitle;
	
	
	
	
	public String getLogo_url() {
		return logo_url;
	}
	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
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
	public DateInfoVO getDate_info() {
		return date_info;
	}
	public void setDate_info(DateInfoVO date_info) {
		this.date_info = date_info;
	}
	public SkuVO getSku() {
		return sku;
	}
	public void setSku(SkuVO sku) {
		this.sku = sku;
	}
	public boolean getUse_custom_code() {
		return use_custom_code;
	}
	public void setUse_custom_code(boolean use_custom_code) {
		this.use_custom_code = use_custom_code;
	}
	public boolean getBind_openid() {
		return bind_openid;
	}
	public void setBind_openid(boolean bind_openid) {
		this.bind_openid = bind_openid;
	}
	public boolean getCan_share() {
		return can_share;
	}
	public void setCan_share(boolean can_share) {
		this.can_share = can_share;
	}
	public boolean getCan_give_friend() {
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
	public String getCustom_url() {
		return custom_url;
	}
	public void setCustom_url(String custom_url) {
		this.custom_url = custom_url;
	}
    
    public Integer[] getLocation_id_list() {
        return location_id_list;
    }
    
    public void setLocation_id_list(Integer[] location_id_list) {
        this.location_id_list = location_id_list;
    }
    
    public String getCustomUrlName() {
        return customUrlName;
    }
    
    public void setCustomUrlName(String customUrlName) {
        this.customUrlName = customUrlName;
    }
    
    public String getCustomUrlSubTitle() {
        return customUrlSubTitle;
    }
    
    public void setCustomUrlSubTitle(String customUrlSubTitle) {
        this.customUrlSubTitle = customUrlSubTitle;
    }
    
    public String getPromotionUrlName() {
        return promotionUrlName;
    }
    
    public void setPromotionUrlName(String promotionUrlName) {
        this.promotionUrlName = promotionUrlName;
    }
    
    public String getPromotionUrl() {
        return promotionUrl;
    }
    
    public void setPromotionUrl(String promotionUrl) {
        this.promotionUrl = promotionUrl;
    }
    
    public String getPromotionUrlSubTitle() {
        return promotionUrlSubTitle;
    }
    
    public void setPromotionUrlSubTitle(String promotionUrlSubTitle) {
        this.promotionUrlSubTitle = promotionUrlSubTitle;
    }
    
    public String getCode_type() {
        return code_type;
    }
    
    public void setCode_type(String code_type) {
        this.code_type = code_type;
    }
	
}
