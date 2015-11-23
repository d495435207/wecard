/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the
 * confidential and proprietary information of danxiangjie.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with danxiangjie.com.
 */
package com.dxj.wecard.weixin.component.model;


/**
 * 封装微信公众号消息
 * 类BussInessInfo.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年10月8日 下午2:35:55
 */
public class BussInessInfo {
    private Integer open_pay;
    private Integer open_shake;
    private Integer open_scan;
    private Integer open_card;
    private Integer open_store;
    
    public Integer getOpen_pay() {
        return open_pay;
    }
    
    public void setOpen_pay(Integer open_pay) {
        this.open_pay = open_pay;
    }
    
    public Integer getOpen_shake() {
        return open_shake;
    }
    
    public void setOpen_shake(Integer open_shake) {
        this.open_shake = open_shake;
    }
    
    public Integer getOpen_scan() {
        return open_scan;
    }
    
    public void setOpen_scan(Integer open_scan) {
        this.open_scan = open_scan;
    }
    
    public Integer getOpen_card() {
        return open_card;
    }
    
    public void setOpen_card(Integer open_card) {
        this.open_card = open_card;
    }
    
    public Integer getOpen_store() {
        return open_store;
    }
    
    public void setOpen_store(Integer open_store) {
        this.open_store = open_store;
    }
    
}
