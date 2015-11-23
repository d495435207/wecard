/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the
 * confidential and proprietary information of danxiangjie.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with danxiangjie.com.
 */
package com.dxj.wecard.service;

import java.util.List;

import com.dxj.wecard.card.dto.CardCoupon;

import net.sf.json.JSONObject;

/**
 * 类WeixinCardService.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年10月11日 下午10:04:16
 */
public interface WeixinCardService {
    /**
     * 微卡券，同步卡券操作
     * @param accessToken   授权公众号accessToken
     * @param appid         公众号appid
     * @return
     * @author liulihai 2015年10月13日 上午10:55:41
     */
    public boolean synchronCardInfo(String accessToken,String appid);
    
    public boolean createCardCoupon(CardCoupon cardCoupon,String accessToken);
    
    public CardCoupon fetchCardDetail(String cardMoreId);
    /**
     * 获取微信服务器原数据，供给yun平台调取数据使用
     * @param accessToken
     * @param appid
     * @return
     * @author liulihai 2015年10月13日 上午10:56:39
     */
    public List<JSONObject> fetchWeixinCards(String accessToken,String appid);
    
    
}
