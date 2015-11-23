/*
 * Copyright 2013-2015 danxiangjie.com All right reserved. This software is the
 * confidential and proprietary information of danxiangjie.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with danxiangjie.com.
 */
package com.dxj.wecard.weixin.util;


/**
 * 类WeixinCardConstant.java的实现描述：TODO 类实现描述 
 * @author liulihai 2015年10月11日 下午9:58:24
 */
public class WeixinCardConstant {
    
    /**
     * 获取JS API 临时票据，有效期 7200s
     */
    public static final String API_TICKET_URL            = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
    //卡券领取api ticket
    public static final String API_TICKET_URL_CARD       = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=wx_card";
     
    /**
     * 获取卡券二维码ticket
     */
    public static final String CARD_TICKET_QR_CODE_URl   = "https://api.weixin.qq.com/card/qrcode/create?access_token=ACCESS_TOKEN";
    
    /**
     * 获取卡券二维码
     */
    public static String SHOW_QR_CODE_URl                = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";

    /**
     * 获取卡券颜色
     */
    public static final String CARD_COLOR_URL            = "https://api.weixin.qq.com/card/getcolors?access_token=ACCESS_TOKEN";
    
    /**
     * 更新库存
     */
    public static final String MODIFY_CARD_STOCK_URL             = "https://api.weixin.qq.com/card/modifystock?access_token=ACCESS_TOKEN";
    
    /**
     * 创建卡券
     */
    public static final String CARD_CREATE_URL           = "https://api.weixin.qq.com/card/create?access_token=ACCESS_TOKEN";

    
    /**
     * 删除卡券
     */
    public static final String CARD_DELETE_URL           = "https://api.weixin.qq.com/card/delete?access_token=ACCESS_TOKEN";
    
    /**
     * 获取门店列表
     */
    public static final String STORE_LIST_URL            = "https://api.weixin.qq.com/card/location/batchget?access_token=ACCESS_TOKEN";
    
    /**
     * 设置卡券失效
     */
    public static final String CARD_UNAVAILABLE_URL      = "https://api.weixin.qq.com/card/code/unavailable?access_token=ACCESS_TOKEN";
    
    /**
     * 上传商家logo
     */
    public static final String UPLOAD_IMG_URL            = "https://api.weixin.qq.com/cgi-bin/media/uploadimg";
    
    
    
    
    
    
    //微信卡券-投放卡券-群发卡券
    public static String card_mpnews_gethtml = "https://api.weixin.qq.com/card/mpnews/gethtml?access_token=ACCESS_TOKEN";
    
    //微信卡券-投放卡券-投放渠道数据统计
    public static String card_testwhitelist_set = "https://api.weixin.qq.com/card/testwhitelist/set?access_token=ACCESS_TOKEN";
    
    //微信卡券-核销卡券-线下核销-线下核销,核销Code接口
    public static String card_code_consume  = "https://api.weixin.qq.com/card/code/consume?access_token=ACCESS_TOKEN";
    
    //微信卡券-核销卡券-线上核销-Code解码接口
    public static String card_code_decrypt  = "https://api.weixin.qq.com/card/code/decrypt?access_token=ACCESS_TOKEN";
    
    //微信卡券-管理卡券-查询code
    public static String card_code_get = "https://api.weixin.qq.com/card/code/get?access_token=ACCESS_TOKEN";
    
    //微信卡券-管理卡券-获取用户已领取卡券接口
    public static String card_user_getcardlist  = "https://api.weixin.qq.com/card/user/getcardlist?access_token=ACCESS_TOKEN";
    
    //微信卡券-管理卡券-查看卡券详情
    public static String card_get_url = "https://api.weixin.qq.com/card/get?access_token=ACCESS_TOKEN";
    
    //微信卡券-管理卡券-批量查询卡列表
    public static String card_batchget_url  = "https://api.weixin.qq.com/card/batchget?access_token=ACCESS_TOKEN";
    
    //微信卡券-管理卡券-更改卡券信息接口
    public static String card_update_url    = "https://api.weixin.qq.com/card/update?access_token=ACCESS_TOKEN";
    
    //微信卡券-管理卡券-修改库存接口
    public static String card_modifystock_url   = "https://api.weixin.qq.com/card/modifystock?access_token=ACCESS_TOKEN";
    
    //微信卡券-管理卡券-更改Code接口
    public static String card_code_update   = "https://api.weixin.qq.com/card/code/update?access_token=ACCESS_TOKEN";
    
    //微信卡券-管理卡券-删除卡券接口
    public static String card_delete_url = "https://api.weixin.qq.com/card/delete?access_token=ACCESS_TOKEN";
    
    //微信卡券-管理卡券-设置卡券失效接口
    public static String card_code_unavailable = "https://api.weixin.qq.com/card/code/unavailable?access_token=ACCESS_TOKEN";
    
    //微信卡券-统计卡券数据-拉取卡券概况数据接口
    public static String card_datacube_getcardbizuininfo = "https://api.weixin.qq.com/datacube/getcardbizuininfo?access_token=ACCESS_TOKEN";
    
    //微信卡券-统计卡券数据-获取免费券数据接口
    public static String card_datacube_getcardcardinfo = "https://api.weixin.qq.com/datacube/getcardcardinfo?access_token=ACCESS_TOKEN";
    
    //微信卡券-统计卡券数据-拉取会员卡数据接口
    public static String card_datacube_getcardmembercardinfo = "https://api.weixin.qq.com/datacube/getcardmembercardinfo?access_token=ACCESS_TOKEN";
}
