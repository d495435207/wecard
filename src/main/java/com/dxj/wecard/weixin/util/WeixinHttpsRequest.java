/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the
 * confidential and proprietary information of danxiangjie.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with danxiangjie.com.
 */
package com.dxj.wecard.weixin.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.sf.json.JSONObject;

/**
 * 类WeixinHttpsRequest.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年10月8日 上午10:03:07
 */
public class WeixinHttpsRequest {
    static final Logger logger = LogManager.getLogger(WeixinHttpsRequest.class);
    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        try {
            // 创建SSLContext 对象，并且使用我们指定的任务管理初始化
            TrustManager[] tm = { new TrustAnyTrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext 对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            logger.info("请求URL:   " + requestUrl);
            logger.info("urlInfo:   " + url.getPath());
            
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            
//          conn.setDoOutput(true);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方法
            conn.setRequestMethod(requestMethod);
            if (!StringUtils.isBlank(outputStr)) {
                logger.error("请求参数 " + outputStr);
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();
            }
            logger.info("请求到输入流");
            // 从输入流读取数据
            InputStream is = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            logger.info("请求返回值" + buffer);
            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            is.close();
            conn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        }catch (Exception e) {
            logger.error(e);
        }
        return jsonObject;
    }
}
