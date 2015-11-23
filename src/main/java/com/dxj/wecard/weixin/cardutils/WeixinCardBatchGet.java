package com.dxj.wecard.weixin.cardutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dxj.wecard.card.dto.CardBatchgetSt;
import com.dxj.wecard.weixin.util.WeixinCardConstant;
import com.dxj.wecard.weixin.util.WeixinHttpsRequest;

import net.sf.json.JSONObject;
       

/**
 * 获取微信后台商家的卡券批量信息
 * @email yuqiquan@chaowifi.com
 * @company danxiangjie
 * @author sonania
 * @Date  2015-8-11 下午5:48:01
 */
public class WeixinCardBatchGet {  
    static final Logger  log = LogManager.getLogger(WeixinCardBatchGet.class);
	/*
	 * 获取卡券详情
	 * */
	public static List<JSONObject> getCardInfo(String accessToken) {
		CardBatchgetSt card_batchget_st = new CardBatchgetSt();
		card_batchget_st.setOffset(0);
		card_batchget_st.setCount(50);
		//审核通过，已经投放，审核中
		String status = "[\"CARD_STATUS_VERIFY_OK\", \"CARD_STATUS_DISPATCH\",\"CARD_STATUS_NOT_VERIFY\"]";
		JSONArray status_list = JSONArray.parseArray(status);
		card_batchget_st.setStatus_list(status_list);
		net.sf.json.JSONArray card_id_list = getCardBatch(accessToken, card_batchget_st);			
		log.info("result===="+ card_id_list);
		if (card_id_list != null && accessToken != null) {
			List<JSONObject> cardList = new ArrayList<JSONObject>();
			for (Object card_id : card_id_list.toArray()) {
				Map<String, Object> card_id_json = new HashMap<String, Object>();
				card_id_json.put("card_id", card_id);
				String url = WeixinCardConstant.card_get_url.replaceAll("ACCESS_TOKEN", accessToken);
				//微信返回的卡券详情
				net.sf.json.JSONObject response = WeixinHttpsRequest.httpsRequest(url, "POST", JSON.toJSONString(card_id_json));
				cardList.add(response);
				log.info("response======="+response.toString());
				System.out.println(response.toString());
			}
			return cardList;
		} else {
			log.info("获取卡券详情信息失败！");
			return null;
		}
	}
	
	/*
	 * 批量查询卡列表
	 * */
	public static net.sf.json.JSONArray getCardBatch(String token, CardBatchgetSt card_batchget_st)	{
		String url = WeixinCardConstant.card_batchget_url.replaceAll("ACCESS_TOKEN", token);
		net.sf.json.JSONObject response = WeixinHttpsRequest.httpsRequest(url, "POST", JSON.toJSONString(card_batchget_st));
		log.info("response===="+ response);
		if (response.getInt("errcode") == 0) {
			return response.getJSONArray("card_id_list");
		}
		return null;
	}

	public static void getCardModifystock(String token, String card_id, int now_stock_value, int new_stock_value)	{
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
		net.sf.json.JSONObject response = WeixinHttpsRequest.httpsRequest(url, "POST",	JSON.toJSONString(stock_value));
		log.info("response=======" + response.toString());
	}
}

