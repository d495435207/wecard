package com.dxj.wecard.card.enums;

/** 卡券消券code展示类型
 * @author haiqing
 *
 */
public enum CardCodeTypeEnum {
	/**
	 * 文本
	 */
	CODE_TYPE_TEXT("CODE_TYPE_TEXT", "文本"),
	/**
	 * 条形码
	 */
	CODE_TYPE_BARCODE("CODE_TYPE_BARCODE", "条形码（一维码）"),
	/**
	 * 二维码
	 */
	CODE_TYPE_QRCODE("CODE_TYPE_QRCODE", "二维码"),
	/**
	 * 二维码无 code 显示
	 */
	CODE_TYPE_ONLY_QRCODE("CODE_TYPE_ONLY_QRCODE", "二维码无 code 显示"),
	/**
	 * 一维码无 code 显示
	 */
	CODE_TYPE_ONLY_BARCODE("CODE_TYPE_ONLY_BARCODE", "一维码无 code 显示");
	
	private String value;
	private String description;
	
	CardCodeTypeEnum(String value, String description){
        this.value = value;
        this.description = description;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

    @Override
    public String toString() {
        return value;
    }

}
