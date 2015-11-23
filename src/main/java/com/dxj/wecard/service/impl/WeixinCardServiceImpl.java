/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the
 * confidential and proprietary information of danxiangjie.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with danxiangjie.com.
 */
package com.dxj.wecard.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dxj.wecard.card.biz.CardBiz;
import com.dxj.wecard.card.dto.BaseInfoVO;
import com.dxj.wecard.card.dto.CardBatchgetSt;
import com.dxj.wecard.card.dto.CardCoupon;
import com.dxj.wecard.card.dto.CardVO;
import com.dxj.wecard.card.dto.CashVO;
import com.dxj.wecard.card.dto.DateInfoVO;
import com.dxj.wecard.card.dto.DiscountVO;
import com.dxj.wecard.card.dto.GeneralCouponVO;
import com.dxj.wecard.card.dto.GiftVO;
import com.dxj.wecard.card.dto.GrouponVO;
import com.dxj.wecard.card.dto.SkuVO;
import com.dxj.wecard.card.dto.WeixinCardVO;
import com.dxj.wecard.card.enums.CardCodeTypeEnum;
import com.dxj.wecard.card.enums.CardCouponTypeEnum;
import com.dxj.wecard.card.enums.CardStatusEnum;
import com.dxj.wecard.card.enums.YOrNEnum;
import com.dxj.wecard.dao.CardMapper;
import com.dxj.wecard.dao.CardMoreMapper;
import com.dxj.wecard.model.Card;
import com.dxj.wecard.model.CardMore;
import com.dxj.wecard.service.WeixinCardService;
import com.dxj.wecard.weixin.util.WeixinCardConstant;
import com.dxj.wecard.weixin.util.WeixinHttpsRequest;

import net.sf.json.JSONObject;

/**
 * 类WeixinCardServiceImpl.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年10月11日 下午10:08:10
 */
@Service("weixinCardService")
public class WeixinCardServiceImpl implements WeixinCardService{
    static final Logger                   log = LogManager.getLogger(WeixinCardServiceImpl.class);
    @Autowired
    private CardMapper cardmapper;
    
    @Autowired
    private CardMoreMapper cardMoreMapper;
    
    @Override
    @Transactional
    public boolean synchronCardInfo(String accessToken,String appid) {
        //查询微信服务器上卡券详情，存放到本地List
        List<CardCoupon> weixinCardList = new ArrayList<CardCoupon>();
        fetchWeixinCards(accessToken, appid, weixinCardList);
        List<Card> localCards=cardmapper.getWecardCardsByAppid(appid);
        try{
            if(weixinCardList!=null &&weixinCardList.size()>=0){
                Map<String, CardCoupon> cardsMaps= parseWeixinToMap(weixinCardList);
                Map<String, Card> localMaps= parselocalCardsToMap(localCards);
//                if(localCards==null && localCards.size()<=0)
                Iterator<CardCoupon> itor =weixinCardList.iterator();
                while(itor.hasNext()){
                    CardCoupon cardCo =itor.next();
                    //已经存在，就更新
                    updateLocalCards(localMaps, cardCo);
                    //如果本地不存在就删除
                    if(!localMaps.containsKey(cardCo.getCardId()) &&cardsMaps.containsKey(cardCo.getCardId())){
                        Card cd = parseCard(appid, cardCo);
                        cardmapper.insertSelective(cd);
                        if(cd.getId()!=0){
                            CardMore cdmore = paseCardMore(cardCo, cd.getId());
                            cardMoreMapper.insert(cdmore);
                        }
                    }
                    //
                    localMaps.remove(cardCo.getCardId());
                }
                //同步完后，发现本地的卡券多于微信服务器的。需要将本地的置为无效，以微信服务器为准
                if(localMaps.size()>0){
                    for (String key : localMaps.keySet()) {
                        Card cd =localMaps.get(key);
                        cd.setCardStatus(3);
                        cardmapper.updateByPrimaryKeySelective(cd);
                   }
                }
            }
            return true;
        }catch(Exception e){
            log.info(e);
        }
        return false;
        
    }
    @Override
    public CardCoupon fetchCardDetail(String cardMoreId) {
        if(StringUtils.isBlank(cardMoreId))return null;
        CardCoupon cc =new CardCoupon();
        Integer id=Integer.parseInt(cardMoreId);
        Card cd= cardmapper.selectByPrimaryKey(id);
        CardMore more =cardMoreMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(cd, cc);
        BeanUtils.copyProperties(more, cc);
        return cc;
    }
    @Override
    public boolean createCardCoupon(CardCoupon cardCoupon, String accessToken) {
        return cardSave(cardCoupon, accessToken);
    }
    @Override
    public List<JSONObject> fetchWeixinCards(String accessToken,String appid) {
        CardBatchgetSt card_batchget_st = new CardBatchgetSt();
        card_batchget_st.setOffset(0);
        card_batchget_st.setCount(50);
        //审核通过，已经投放，审核中
        String status = "[\"CARD_STATUS_VERIFY_OK\", \"CARD_STATUS_DISPATCH\",\"CARD_STATUS_NOT_VERIFY\"]";
        JSONArray status_list = JSONArray.parseArray(status);
        card_batchget_st.setStatus_list(status_list);
        net.sf.json.JSONArray card_id_list = CardBiz.getCardBatch(accessToken, card_batchget_st);           
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
    private boolean cardSave(CardCoupon cardCoupon,String accessToken){
        WeixinCardVO chaowifiCardVO = new WeixinCardVO();
        chaowifiCardVO.setCard_type(cardCoupon.getCardType());
        switch(cardCoupon.getCardType()){
            case "GENERAL_COUPON" :   //通用券
                chaowifiCardVO = generalCouponSave(cardCoupon, chaowifiCardVO);
                break;
            case "GROUPON" :  //团购券
                chaowifiCardVO = grouponSave(cardCoupon, chaowifiCardVO);
                break;
            case "DISCOUNT" : //折扣券
                chaowifiCardVO = discountSave(cardCoupon, chaowifiCardVO);
                break;
            case "GIFT" : //礼品券
                chaowifiCardVO = giftSave(cardCoupon, chaowifiCardVO);
                break;
            case "CASH" : //代金券
                chaowifiCardVO = cashSave(cardCoupon, chaowifiCardVO);
                break;
            default:
                chaowifiCardVO = generalCouponSave(cardCoupon, chaowifiCardVO);
                break;
        }
        CardVO cardVO = new CardVO();
        cardVO.setCard(chaowifiCardVO);
        String cardJson = JSON.toJSONString(cardVO);
        String url =WeixinCardConstant.CARD_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject= WeixinHttpsRequest.httpsRequest(url, "POST", cardJson);
        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {  
                log.info("创建卡券失败,errcode:{} errmsg:{}"+"\t"+ jsonObject.getInt("errcode")+"\t"+jsonObject.getString("errmsg"));  
            }else{
                log.info("创建卡券成功CardId: " +  jsonObject.getString("card_id"));
                return true;
            }
        }
        return false;
    }
    //通用券
    private WeixinCardVO generalCouponSave(CardCoupon cardCoupon, WeixinCardVO chaowifiCardVO){
        GeneralCouponVO generalCouponVO = new GeneralCouponVO();
        generalCouponVO.setBase_info(setBaseInfoVO(cardCoupon));
        generalCouponVO.setDefault_detail(cardCoupon.getDetail());
        chaowifiCardVO.setGeneral_coupon(generalCouponVO);
        return chaowifiCardVO;
    }
    //团购券
    private WeixinCardVO grouponSave(CardCoupon cardCoupon, WeixinCardVO chaowifiCardVO){
        GrouponVO grouponVO = new GrouponVO();
        grouponVO.setBase_info(setBaseInfoVO(cardCoupon));
        grouponVO.setDeal_detail(cardCoupon.getDetail());
        chaowifiCardVO.setGroupon(grouponVO);
        return chaowifiCardVO;
    }
    //折扣券
    private WeixinCardVO discountSave(CardCoupon cardCoupon, WeixinCardVO chaowifiCardVO){
        DiscountVO discountVO = new DiscountVO();
        discountVO.setDiscount(String.valueOf(100-Double.valueOf(cardCoupon.getDiscount())*10));//折扣额度转换
        discountVO.setBase_info(setBaseInfoVO(cardCoupon));
        chaowifiCardVO.setDiscount(discountVO);
        return chaowifiCardVO;
    }
    //礼品券
    private WeixinCardVO giftSave(CardCoupon cardCoupon, WeixinCardVO chaowifiCardVO){
        GiftVO giftVO = new GiftVO();
        giftVO.setGift(cardCoupon.getTitle());
        giftVO.setBase_info(setBaseInfoVO(cardCoupon));
        chaowifiCardVO.setGift(giftVO);
        return chaowifiCardVO;
    }
    //现金券
    private WeixinCardVO cashSave(CardCoupon cardCoupon, WeixinCardVO chaowifiCardVO){
        CashVO cashVO = new CashVO();
        if(cardCoupon.getLeastCost()!=null){
            cashVO.setLeast_cost(String.valueOf(Double.valueOf(cardCoupon.getLeastCost())*100));
        }
        cashVO.setReduce_cost(String.valueOf(Double.valueOf(cardCoupon.getReduceCost())*100));
        cashVO.setBase_info(setBaseInfoVO(cardCoupon));
        chaowifiCardVO.setCash(cashVO);
        return chaowifiCardVO;
    }
    
    private BaseInfoVO setBaseInfoVO(CardCoupon cardCoupon){
        BaseInfoVO baseInfo = new BaseInfoVO();
        baseInfo.setLogo_url(cardCoupon.getMerchantLogo());
        baseInfo.setCode_type(cardCoupon.getCodeType());
        baseInfo.setBrand_name(cardCoupon.getMerchantName());
        baseInfo.setTitle(cardCoupon.getTitle());
        baseInfo.setSub_title(cardCoupon.getSubTitle());
        baseInfo.setColor(cardCoupon.getColor());
        baseInfo.setNotice(cardCoupon.getNotice());
        baseInfo.setDescription(cardCoupon.getDescription());
        //解决门店显示问题
        String storeList=cardCoupon.getLocationIdList();
        String[] stores =storeList.split(",");
        if(stores.length>0){
            Integer[] ids =new Integer[stores.length];
            for(int i=0;i<stores.length;i++){
                String str  =stores[i];
                Integer id=Integer.parseInt(str);
                ids[i] = id;
            }
            baseInfo.setLocation_id_list(ids);
        }
        if(cardCoupon.getIsShare()==1){
            baseInfo.setCan_share(true);
        }else{
            baseInfo.setCan_share(false);
        }
        if(cardCoupon.getIsGiveFriend()==1){
            baseInfo.setCan_give_friend(true);
        }else{
            baseInfo.setCan_give_friend(false);
        }
        baseInfo.setGet_limit(cardCoupon.getGetLimit());
        baseInfo.setService_phone(cardCoupon.getServicePhone());
        baseInfo.setSource(StringUtils.isNotBlank(cardCoupon.getSource())?cardCoupon.getSource():"");
        baseInfo.setCustom_url(StringUtils.isNotBlank(cardCoupon.getCustomUrl())?cardCoupon.getCustomUrl():"");
        baseInfo.setCustomUrlName(StringUtils.isNotBlank(cardCoupon.getCustomUrlName())?cardCoupon.getCustomUrlName():"");
        baseInfo.setCustomUrlSubTitle(StringUtils.isNotBlank(cardCoupon.getCustomUrlSubTitle())?cardCoupon.getCustomUrlSubTitle():"");
        baseInfo.setPromotionUrl(StringUtils.isNotBlank(cardCoupon.getPromotionUrl())?cardCoupon.getPromotionUrl():"");
        baseInfo.setPromotionUrlName(StringUtils.isNotBlank(cardCoupon.getPromotionUrlName())?cardCoupon.getPromotionUrlName():"");
        baseInfo.setPromotionUrlSubTitle(StringUtils.isNotBlank(cardCoupon.getPromotionUrlSubTitle())?cardCoupon.getPromotionUrlSubTitle():"");
        baseInfo.setBind_openid(false);
        
        
        baseInfo.setUse_custom_code(false);
        
        DateInfoVO dateInfo = new DateInfoVO();
        dateInfo.setType(Integer.valueOf(cardCoupon.getDateType()));
        if("1".equals(cardCoupon.getDateType())){
            dateInfo.setBegin_timestamp(cardCoupon.getBeginTime().getTime()/1000);
            dateInfo.setEnd_timestamp(cardCoupon.getEndTime().getTime()/1000);
        }else{
            dateInfo.setFixed_begin_term(Integer.valueOf(cardCoupon.getFixedBeginTerm()));
            dateInfo.setFixed_term(Integer.valueOf(cardCoupon.getFixedTerm()));
        }
        baseInfo.setDate_info(dateInfo);
        
        SkuVO sku = new SkuVO();
        sku.setQuantity(cardCoupon.getQuantity());
        baseInfo.setSku(sku);
        
        return baseInfo;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * @param appid
     * @param cardCo
     * @return
     * @author liulihai 2015年10月12日 下午1:52:13
     */
    private Card parseCard(String appid, CardCoupon cardCo) {
        try{
            Card cd =new Card();
            BeanUtils.copyProperties(cardCo, cd);
//            cd.setColor(cardCo.getColor());
//            cd.setTitle(cardCo.getTitle());
//            cd.setStatus(cardCo.getStatus());
//            cd.setCardType(cardCo.getCardType());
//            cd.setTotalQuantity(cardCo.getQuantity());
//            cd.setTotalQuantity(cardCo.getTotalQuantity());
//            cd.setQuantity(cardCo.getQuantity());
//            cd.setGetLimit(cardCo.getGetLimit());
//            cd.setIsGiveFriend(cardCo.getIsGiveFriend());
//            cd.setIsShare(cardCo.getIsShare());
            cd.setAppId(appid);
            cd.setCardStatus(2);
//            cd.setCardId(cardCo.getCardId());
            return cd;
        }catch(Exception e){
            log.info(e);
        }
        return null;
        
    }

    /**
     * @param cardCo
     * @param currentId
     * @return
     * @author liulihai 2015年10月12日 下午1:51:58
     */
    private CardMore paseCardMore(CardCoupon cardCo, int currentId) {
        CardMore cdmore =new CardMore();
        try{
            setCardMore(cardCo, cdmore);
            cdmore.setId(currentId);
        }catch(Exception e){
            log.info(e);
        }
        return cdmore;
    }

    /**
     * @param cardCo
     * @param cdmore
     * @author liulihai 2015年10月13日 上午10:13:40
     */
    private void setCardMore(CardCoupon cardCo, CardMore cdmore) {
        BeanUtils.copyProperties(cardCo, cdmore);
//        cdmore.setBeginTime(cardCo.getTimeBegin());
//        cdmore.setCustomUrl(cardCo.getCustomUrl());
//        cdmore.setCustomUrlName(cardCo.getUrlNameType()==null?"":cardCo.getUrlNameType().getDescription());
//        cdmore.setCustomUrlSubTitle(StringUtils.isNotBlank(cardCo.getCustom_url_sub_title())?cardCo.getCustom_url_sub_title():"");
//        cdmore.setPromotionUrl(StringUtils.isNotBlank(cardCo.getPromotion_url())?cardCo.getPromotion_url():"");
//        cdmore.setPromotionUrlName(StringUtils.isNotBlank(cardCo.getPromotion_url())?cardCo.getPromotion_url():"");
//        cdmore.setDescription(StringUtils.isNotBlank(cardCo.getDescription())?cardCo.getDescription():"");
//        cdmore.setDetail(StringUtils.isNotBlank(cardCo.getDealDetail())?cardCo.getDealDetail():"");
//        cdmore.setDiscount(StringUtils.isNotBlank(cardCo.getDiscount())?Integer.parseInt(cardCo.getDiscount()):0);
//        cdmore.setEndTime(cardCo.getTimeEnd());
//        cdmore.setFixedBeginTerm(StringUtils.isNotBlank(cardCo.getFixedDate())?Integer.parseInt(cardCo.getFixedDate()):0);
//        cdmore.setFixedTerm(StringUtils.isNotBlank(cardCo.getValidDate())?Integer.parseInt(cardCo.getValidDate()):0);
//        cdmore.setLeastCost(StringUtils.isNotBlank(cardCo.getConditions())?Integer.parseInt(cardCo.getConditions()):0);
//        cdmore.setNotice(StringUtils.isNotBlank(cardCo.getNotice())?cardCo.getNotice():"");
//        cdmore.setReduceCost(StringUtils.isNotBlank(cardCo.getReduction())?Integer.parseInt(cardCo.getReduction()):0);
//        cdmore.setServicePhone(StringUtils.isNotBlank(cardCo.getServicePhone())?cardCo.getServicePhone():"");
//        cdmore.setLocationIdList(StringUtils.isNotBlank(cardCo.getStoreList())?cardCo.getStoreList():"");
    }

    /**
     * @param localMaps
     * @param cardCo
     * @author liulihai 2015年10月12日 下午1:27:33
     */
    private void updateLocalCards(Map<String, Card> localMaps, CardCoupon cardCo) {
        if(localMaps.containsKey(cardCo.getCardId())){
            try{
                Card cd = updateCardTable(localMaps, cardCo);
                CardMore cdmore =cardMoreMapper.selectByPrimaryKey(cd.getId());
                if(cdmore!=null){
                    setCardMore(cardCo, cdmore);
                    cardMoreMapper.updateByPrimaryKeySelective(cdmore);
                }
            }catch(Exception e){
                log.info(e);
            }
           
        }
    }

    /**
     * @param localMaps
     * @param cardCo
     * @return
     * @author liulihai 2015年10月12日 下午1:26:09
     */
    private Card updateCardTable(Map<String, Card> localMaps, CardCoupon cardCo) {
        Card cd=localMaps.get(cardCo.getCardId());
        BeanUtils.copyProperties(cardCo, cd);
//        cd.setColor(cardCo.getColorStr());
//        cd.setTitle(cardCo.getTitle());
//        cd.setStatus(cardCo.getStatus());
//        cd.setCardType(cardCo.getCardType().getValue());
//        cd.setGetLimit(cardCo.getGetLimit());
//        cd.setTotalQuantity(cardCo.getTotalQuantity());
//        cd.setQuantity(cardCo.getQuantity());
//        cd.setIsGiveFriend(cardCo.getCanDonate().name().equals("Yes")?1:0);
//        cd.setIsShare(cardCo.getCanShare().name().equals("Yes")?1:0);
        cardmapper.updateByPrimaryKey(cd);
        return cd;
    }

    /**
     * 拉去当前appid微信服务器的卡券
     * @param accessToken
     * @param appid
     * @param weixinCardList
     * @author liulihai 2015年10月12日 上午10:54:21
     */
    private void fetchWeixinCards(String accessToken, String appid, List<CardCoupon> weixinCardList) {
        List<JSONObject> cardInfos =fetchWeixinCards(accessToken,appid);
        
        Iterator<JSONObject> itor =cardInfos.iterator();
        while(itor.hasNext()){
            JSONObject it=itor.next();
            CardCoupon cardCoupon = new CardCoupon();
            JSONObject base_info = JSONObject.fromObject("{}");
            Object cardStr = it.get("card");
            JSONObject card = JSONObject.fromObject(cardStr);
            String card_type = (String) card.get("card_type");
            //折扣券
            if (card_type.equals("DISCOUNT")) {
                cardCoupon.setCardType(CardCouponTypeEnum.DISCOUNT.getDescription());
                JSONObject discount_info = JSONObject.fromObject(card.get("discount"));
                Integer discount = ((Integer) discount_info.get("discount")) / 10;
                cardCoupon.setDiscount(discount);
                base_info = JSONObject.fromObject(discount_info.get("base_info"));
            //代金券
            } else if (card_type.equals("CASH")) {
                cardCoupon.setCardType(CardCouponTypeEnum.CASH.getDescription());
                JSONObject cash = JSONObject.fromObject(card.get("cash"));
                cardCoupon.setReduceCost(cash.get("reduce_cost")==null?null:(Integer)cash.get("reduce_cost"));
                if (cash.get("least_cost") != null) {
                    cardCoupon.setLeastCost(cash.get("least_cost")==null?null:(Integer)cash.get("least_cost"));
                }
                base_info = JSONObject.fromObject(cash.get("base_info"));
            //礼品券
            }  else if (card_type.equals("GIFT")) {
                cardCoupon.setCardType(CardCouponTypeEnum.GIFT.getDescription());
                JSONObject gift = JSONObject.fromObject(card.get("gift"));
                //(String)gift.get("gift");
                base_info = JSONObject.fromObject(gift.get("base_info"));
            //团购券
            }  else if (card_type.equals("GROUPON")) {
                cardCoupon.setCardType(CardCouponTypeEnum.GROUPON.getDescription());
                JSONObject groupon = JSONObject.fromObject(card.get("groupon"));
                cardCoupon.setDetail((String) groupon.get("deal_detail"));
                base_info = JSONObject.fromObject(groupon.get("base_info"));
            //优惠券。即“通用券”
            }  else if (card_type.equals("GENERAL_COUPON")) {
                cardCoupon.setCardType(CardCouponTypeEnum.GENERAL_COUPON.getDescription());
                JSONObject general_coupon = JSONObject.fromObject(card.get("general_coupon"));
                cardCoupon.setDetail((String) general_coupon.get("default_detail"));
                base_info = JSONObject.fromObject(general_coupon.get("base_info"));
            }
            JSONObject date_info = JSONObject.fromObject(base_info.get("date_info"));
            String dateType = (String) date_info.get("type");
            if (dateType.equals("DATE_TYPE_FIX_TERM")) {
                cardCoupon.setFixedBeginTerm(date_info.get("fixed_begin_term")==null?null:(Integer)(date_info.get("fixed_begin_term")));
                Integer fixed_term =(Integer) date_info.get("fixed_term");
                cardCoupon.setFixedTerm(fixed_term==null?null:fixed_term);
                long begin_timestamp = ((Integer) base_info.get("create_time")) * 1000l;
                long end_timestamp = begin_timestamp + 86400000l *fixed_term;
                cardCoupon.setBeginTime(new Date(begin_timestamp));
                cardCoupon.setEndTime(new Date(end_timestamp));
                //固定时间范围30天内
                cardCoupon.setDateType(1);
            } else if (dateType.equals("DATE_TYPE_FIX_TIME_RANGE")) {
                long begin_timestamp = ((Integer) date_info.get("begin_timestamp")) * 1000l;
                long end_timestamp = ((Integer) date_info.get("end_timestamp")) * 1000l;
                cardCoupon.setBeginTime(new Date(begin_timestamp));
                cardCoupon.setEndTime(new Date(end_timestamp));
                cardCoupon.setDateType(0);
                //固定时间区间
            }
            cardCoupon.setCardId((String) base_info.get("id"));
            cardCoupon.setMerchantLogo((String) base_info.get("logo_url"));
            String code_type = (String) base_info.get("code_type");
            if (code_type.equals("CODE_TYPE_TEXT")) {
                cardCoupon.setCodeType(CardCodeTypeEnum.CODE_TYPE_TEXT.getDescription());
            } else if (code_type.equals("CODE_TYPE_QRCODE")) {
                cardCoupon.setCodeType(CardCodeTypeEnum.CODE_TYPE_QRCODE.getDescription());
            } else if (code_type.equals("CODE_TYPE_BARCODE")) {
                cardCoupon.setCodeType(CardCodeTypeEnum.CODE_TYPE_BARCODE.getDescription());
            }
            cardCoupon.setMerchantName((String) base_info.get("brand_name"));
            cardCoupon.setTitle((String) base_info.get("title"));
            cardCoupon.setSubTitle((String) base_info.get("sub_title"));
            cardCoupon.setwClogo((String) base_info.get("logo_url"));
            cardCoupon.setwCname((String) base_info.get("brand_name"));
            String colorStr = (String) base_info.get("color");
            cardCoupon.setColorStr(parseColorMap(colorStr));//16进制
            cardCoupon.setColor(colorStr);//微信颜色值对应编号
            cardCoupon.setNotice((String) base_info.get("notice"));
            //去除微信返回的数据中的[] 为了对于我们系统使用的是String类型
            cardCoupon.setLocationIdList(base_info.getString("location_id_list").replaceAll("\\[", "").replaceAll("\\]", ""));
            cardCoupon.setServicePhone((String) base_info.get("service_phone"));
            cardCoupon.setDescription((String) base_info.get("description"));
            cardCoupon.setCustomUrlSubTitle(StringUtils.isNotBlank((String) base_info.get("custom_url_sub_title"))?(String) base_info.get("custom_url_sub_title"):"");
            cardCoupon.setPromotionUrl(StringUtils.isNotBlank((String) base_info.get("promotion_url"))?(String) base_info.get("promotion_url"):"");
            cardCoupon.setPromotionUrlName(StringUtils.isNotBlank((String) base_info.get("promotion_url_name"))?(String) base_info.get("promotion_url_name"):"");
            cardCoupon.setGetLimit(Integer.valueOf((base_info.get("get_limit").toString())));
            Boolean can_share = (Boolean) base_info.get("can_share");
            if (can_share) {
                //1 能分享
                cardCoupon.setIsShare(1);
            } else {
                //0 不能分享
                cardCoupon.setIsShare(0);
            }
            Boolean can_give_friend = (Boolean) base_info.get("can_give_friend");
            if (can_give_friend) {
                cardCoupon.setIsGiveFriend(1);
            } else {
                cardCoupon.setIsGiveFriend(0);
            }
            
            Integer quantity = (Integer) JSONObject.fromObject(base_info.get("sku")).get("quantity");
            cardCoupon.setQuantity(quantity);
            Integer total_quantity = (Integer) JSONObject.fromObject(base_info.get("sku")).get("total_quantity");
            cardCoupon.setTotalQuantity(total_quantity);
            Integer get = total_quantity - quantity;
            String status = (String) base_info.get("status");
            if (status.equals("CARD_STATUS_VERIFY_OK")) {
                cardCoupon.setStatus(CardStatusEnum.WAIT_THROW.getDescription());
                if (get>0) {
                    cardCoupon.setStatus(CardStatusEnum.ON_THROW.getDescription());
                }
            } else if (status.equals("CARD_STATUS_USER_DISPATCH") || status.equals("CARD_STATUS_DISPATCH")) {
                cardCoupon.setStatus(CardStatusEnum.ON_THROW.getDescription());
            }else if(status.equals("CARD_STATUS_NOT_VERIFY")){
                cardCoupon.setStatus(CardStatusEnum.ON_CHECK.getDescription());
            }
            cardCoupon.setGet(get);
            cardCoupon.setAppId(appid);
            weixinCardList.add(cardCoupon);
        }
    }
    private Map<String,CardCoupon> parseWeixinToMap(List<CardCoupon> mineCardList){
      Map<String,CardCoupon> map =new HashMap<String, CardCoupon>();
      Iterator<CardCoupon> ite = mineCardList.iterator();
      while(ite.hasNext()){
          CardCoupon cop =ite.next();
          map.put(cop.getCardId(), cop);
      }
      return map;
    }
    private Map<String,Card> parselocalCardsToMap(List<Card> localCards){
        Map<String,Card> map =new HashMap<String, Card>();
        Iterator<Card> ite = localCards.iterator();
        while(ite.hasNext()){
            Card cop =ite.next();
            map.put(cop.getCardId(), cop);
        }
        return map;
      }
    private String parseColorMap(String color){
        Map<String, String> colorMap = new HashMap<String, String>();
        Map<String, String> colorCode = new HashMap<String, String>();
        colorMap.put("#63b359", "Color010");
        colorMap.put("#2c9f67", "Color020");
        colorMap.put("#509fc9", "Color030");
        colorMap.put("#5885cf", "Color040");
        colorMap.put("#9062c0", "Color050");
        colorMap.put("#d09a45", "Color060");
        colorMap.put("#e4b138", "Color070");
        colorMap.put("#ee903c", "Color080");
        colorMap.put("#f08500", "Color081");
        colorMap.put("#a9d92d", "Color082");
        colorMap.put("#dd6549", "Color090");
        colorMap.put("#cc463d", "Color100");
        colorMap.put("#cf3e36", "Color101");
        colorMap.put("#5E6671", "Color102");
//        /*反过来*/
//        colorCode.put("Color010", "#55BD47");
//        colorCode.put("Color020", "#10AD61");
//        colorCode.put("Color030", "#35A4DE");
//        colorCode.put("Color040", "#3D78DA");
//        colorCode.put("Color050", "#9058CB");
//        colorCode.put("Color060", "#DE9C33");
//        colorCode.put("Color070", "#EBAC16");
//        colorCode.put("Color080", "#F9861F");
//        colorCode.put("Color081", "#F08500");
//        colorCode.put("Color090", "#E75735");
//        colorCode.put("Color100", "#D54036");
//        colorCode.put("Color101", "#CF3E36");
        return colorMap.get(color);
    }

}
