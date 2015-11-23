/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the
 * confidential and proprietary information of danxiangjie.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with danxiangjie.com.
 */
package com.dxj.wecard.card.biz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.dxj.wecard.card.dto.StoreBaseInfo;
import com.dxj.wecard.card.dto.StoresVo;
import com.dxj.wecard.weixin.util.WeixinConstant;
import com.dxj.wecard.weixin.util.WeixinHttpsRequest;
import com.google.gson.Gson;

import net.sf.json.JSONObject;

/**
 * 类StoreBiz.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年10月15日 下午3:27:55
 */
public class StoreBiz {
    static final Logger log = LogManager.getLogger(StoreBiz.class);
    public static void main(String[] args) {
        getStores("rqNcRnEh72dv6Gb0m6J-tk_XLCyLT-y7u8KE60OKxsChVHo9wxw63ExcUtVQz82KbSvbx6Epn0y1AgB9kW7GGNUtWq1FzU9wx5dBtDVYZmk");
    }
    public static StoreBaseInfo getStores(String accessToken) {
        String url = WeixinConstant.GETPOILIST.replace("ACCESSTOKEN", accessToken);

        String data = "{\"begin\": 0,\"limit\": 50}";
        // String proxy = JSONObject.fromObject(poxy).toString();
        try {
            JSONObject jsonobject = WeixinHttpsRequest.httpsRequest(url, "POST", data);
            if (jsonobject != null) {
                int errorCode = jsonobject.getInt("errcode");
//               String str = jsonobject.getString("business_list").toString();
               StoresVo bc = new Gson().fromJson(jsonobject.toString(), StoresVo.class);
                
                System.out.println(JSON.toJSONString(bc));
                if (errorCode == 0) {
//                    return bc;
                } else {
                    log.error("获取门店失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
