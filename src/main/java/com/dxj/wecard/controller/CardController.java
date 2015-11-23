/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the
 * confidential and proprietary information of danxiangjie.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with danxiangjie.com.
 */
package com.dxj.wecard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dxj.wecard.card.dto.CardCoupon;
import com.dxj.wecard.model.WeixinApp;
import com.dxj.wecard.service.WeixinCardService;
import com.dxj.wecard.service.WeixinComponentService;
import com.dxj.wecard.util.Utils;

/**
 * 类CardController.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年10月12日 下午2:15:42
 */
@Controller
@RequestMapping("/card")
public class CardController extends BaseController{
    static final Logger logger = LogManager.getLogger(CardController.class);
    
    @Autowired
    private WeixinCardService weixinCardService;
    @Autowired
    private WeixinComponentService weixincomponentservice;
    
    
    @RequestMapping(value = "/syncCard", method = { RequestMethod.POST })
    @ResponseBody
    public String syncCard(HttpServletRequest request, HttpServletResponse response) {
        WeixinApp weixin=getCurrentWeixinApp();
        String accesstoken= weixincomponentservice.getAuthorizerdAccessToken(weixin.getId());
        boolean flag=weixinCardService.synchronCardInfo(accesstoken, weixin.getId());
        if(flag)
           return Utils.getJsonResult("success", "1000", "同步卡券成功","publisher/couponManage.do");
        else
          return Utils.getJsonResult("failure", "1001", "同步卡券失败","publisher/couponManage.do");
    }
    @RequestMapping(value = "/cardDetail", method = { RequestMethod.POST })
    @ResponseBody
    public String cardDetail(String cardId) {
        if(StringUtils.isBlank(cardId))return Utils.getJsonResult("failure", "10001", "卡券Id错误");
        CardCoupon cc =weixinCardService.fetchCardDetail(cardId);
        if(cc==null)
        return Utils.getJsonResult("failure", "10001", "查询失败");
        else
        return JSON.toJSONString(cc);
    }
}
