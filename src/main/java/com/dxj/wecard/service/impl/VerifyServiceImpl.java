package com.dxj.wecard.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dxj.wecard.bean.BizQuery;
import com.dxj.wecard.bean.Query;
import com.dxj.wecard.card.dto.CardPartnerVo;
import com.dxj.wecard.dao.CardMapper;
import com.dxj.wecard.dao.VerifyMapper;
import com.dxj.wecard.model.Verify;
import com.dxj.wecard.service.VerifyService;
import com.dxj.wecard.weixin.util.WeixinConstant;

@Service("verifyService")
public class VerifyServiceImpl implements VerifyService {

    @Autowired
    private VerifyMapper verifyMapper;
    
    @Autowired
    private CardMapper   cardMapper;
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public List<BizQuery> getVerifiesTopCnt() {
        Query top = new BizQuery();
        top.setStart(0);
        top.setSize(6);
        return verifyMapper.getVerifiesCnt(top);
    }

    @Override
    public int getCardsVerifyNumByApp(Query record) {
        return verifyMapper.getCardsVerifyNumByApp(record);
    }

    @Override
    public List<BizQuery> getCardsVerifyByApp(Query record) {
        return verifyMapper.getCardsVerifyByApp(record);
    }

    @Override
    public int getVerifiesNumCnt(Query record) {
        return verifyMapper.getVerifiesNumCnt(record);
    }

    @Override
    public List<BizQuery> getVerifiesCnt(Query record) {
        return verifyMapper.getVerifiesCnt(record);
    }

    @Override
    public int userConsumeCard(Map<String, String> requestMap) {
        String appid = requestMap.get("appid");
        // 核销用户openId
        String userOpenId = requestMap.get("FromUserName");
        // 核销时间
        String createTime = requestMap.get("CreateTime");
        // 卡券ID
        String cardId = requestMap.get("CardId");
        // 核销门店
        String locationName = requestMap.get("LocationName");
        // 代理商Id
        // 卡券code
        String userCardCode = requestMap.get("UserCardCode");

        String consumeSource = requestMap.get("ConsumeSource");
        
        String staffOpenId = requestMap.get("StaffOpenId");
        
        String userDelCard = requestMap.get("Event");
        //
        CardPartnerVo vo = getCardPartnerVo(appid, cardId);
        Verify vf = new Verify();
        vf.setCardId(vo.getId());
        vf.setAtTime(new Timestamp(Long.parseLong(createTime) * 1000));
        vf.setBranchName(locationName);
        if (WeixinConstant.USEDELCARD.equals(userDelCard)) {
            vf.setIsDel(1);
        } else {
            vf.setIsDel(0);
        }
        vf.setCode(userCardCode);
        vf.setOpenId(userOpenId);
        vf.setSource(consumeSource);
        vf.setStaffOpenId(staffOpenId);
        int number=verifyMapper.insert(vf);
        return number;
    }

    private CardPartnerVo getCardPartnerVo(String appid, String cardId) {
        String key = this.getClass().getSimpleName() + "." + appid + "." + cardId;
        String value = (String) redisTemplate.opsForValue().get(key);
        CardPartnerVo vo = null;
        if (StringUtils.isNotBlank(value)) {
            vo = JSON.parseObject(value, CardPartnerVo.class);
            return vo;
        } else {
            Map<String, Object> parames = new HashMap<String, Object>();
            parames.put("appId", appid);
            parames.put("cardId", cardId);
            vo = cardMapper.getCardPanterVo(parames);
            redisTemplate.opsForValue().set(key, JSON.toJSONString(vo), 60 * 2, TimeUnit.SECONDS);
        }
        return vo;
    }
}
