/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the
 * confidential and proprietary information of danxiangjie.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with danxiangjie.com.
 */
package com.dxj.wecard.card.biz;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.dxj.wecard.card.dto.CardBatchgetSt;
import com.dxj.wecard.card.dto.StoresVo;
import com.dxj.wecard.weixin.util.WeixinCardConstant;
import com.dxj.wecard.weixin.util.WeixinConstant;
import com.dxj.wecard.weixin.util.WeixinHttpsRequest;
import com.google.gson.Gson;

import net.sf.json.JSONObject;

/**
 * 类CardBiz.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年10月13日 上午10:51:12
 */
public class  CardBiz{
    static final Logger log = LogManager.getLogger(CardBiz.class);
    
    
    public static StoresVo getStores(String accessToken) {
        String url = WeixinConstant.BATCHPOIGET.replace("ACCESSTOKEN", accessToken);

        String data = "{\"offset\": 0,\"count\": 50}";
        // String proxy = JSONObject.fromObject(poxy).toString();
        try {
            JSONObject jsonobject = WeixinHttpsRequest.httpsRequest(url, "POST", data);
            if (jsonobject != null) {
                int errorCode = jsonobject.getInt("errcode");
                StoresVo bc = new Gson().fromJson(jsonobject.toString(), StoresVo.class);
                System.out.println(JSONObject.fromObject(bc).toString());
                // ComplexBusIness
                // iness=jsonobject.getJSONObject("location_list");
                if (errorCode == 0) {
                    log.info("获得门店成功");
                    return bc;
                } else {
                    log.error("获取门店失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /*
     * 批量查询卡列表
     * */
    public static net.sf.json.JSONArray getCardBatch(String token, CardBatchgetSt card_batchget_st)   {
        String url = WeixinCardConstant.card_batchget_url.replaceAll("ACCESS_TOKEN", token);
        net.sf.json.JSONObject response = WeixinHttpsRequest.httpsRequest(url, "POST", JSON.toJSONString(card_batchget_st));
        log.info("response===="+ response);
        if (response.getInt("errcode") == 0) {
            return response.getJSONArray("card_id_list");
        }
        return null;
    }

    public static void getCardModifystock(String token, String card_id, int now_stock_value, int new_stock_value)   {
        Map<String, Object> stock_value = new HashMap<String, Object>();
        stock_value.put("card_id", card_id);
        if (new_stock_value > now_stock_value) {
            stock_value.put("increase_stock_value", new_stock_value);
        } else {
            stock_value.put("reduce_stock_value", new_stock_value);
            String url = WeixinCardConstant.card_modifystock_url.replaceAll("ACCESS_TOKEN", token);
            net.sf.json.JSONObject response = WeixinHttpsRequest.httpsRequest(url, "POST", JSON.toJSONString(stock_value));
            log.info("response=======" + response.toString());
        }
    }
    
    public static void getCardDelete(String token, String card_id) {
        Map<String, Object> stock_value = new HashMap<String, Object>();
        stock_value.put("card_id", card_id);
        String url = WeixinCardConstant.card_delete_url.replaceAll("ACCESS_TOKEN", token);
        net.sf.json.JSONObject response = WeixinHttpsRequest.httpsRequest(url, "POST",  JSON.toJSONString(stock_value));
        log.info("response=======" + response.toString());
    }
}
