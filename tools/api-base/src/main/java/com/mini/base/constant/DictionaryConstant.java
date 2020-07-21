package com.mini.base.constant;

import com.mini.base.api.IResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 字典常量
 * @author Caesar Liu
 * @date 2019/5/6 19:47
 */
public interface DictionaryConstant {

    /**
     * 字典code定义
     * @author Caesar Liu
     * @date 2019/5/10 15:16
     */
    @Getter
    @AllArgsConstructor
    enum DictionaryCode {
        PAYMENT_TYPES("PAYMENT_TYPES", "支付方式"),
        APARTMENT_TAG("APARTMENT_TAG", "公寓标签"),
        APARTMENT_FACILITIY("APARTMENT_FACILITIY", "公寓设施"),
        APARTMENT_SERVICE("APARTMENT_SERVICE", "公寓服务"),
        ROOMTYPE_TAG("ROOMTYPE_TAG", "房型标签"),
        ROOMTYPE_ARTICLE_TAG("ROOMTYPE_ARTICLE_TAG", "房型字典物品标签"),
        BEDTYPE_TAG("BEDTYPE_TAG", "床型标签"),
        ARTICLETYPE_TAG("ARTICLETYPE_TAG", "物品类型标签"),
        FURNITURE_TAG("FURNITURE_TAG", "家具类型标签"),
        ELECTRIC_TAG("ELECTRIC_TAG", "电器类型标签"),
        OTHER_TYPE_TAG("OTHER_TYPE_TAG", "其他物品类型标签"),
        ROOM_FACE("ROOM_FACE", "房屋朝向"),
        CHANNEL_TAG("CHANNEL_TAG", "渠道标签"),
        CONTACT_RELATIONSHIP("CONTACT_RELATIONSHIP","紧急联系人关系"),
        CARD_TYPES("CARD_TYPES","证件类型"),
        CANCEL_REASON("CANCEL_REASON","取消原因"),
        ESSAY_TAG("ESSAY_TAG","文章标签"),
        AD_TAG("AD_TAG","广告标签");

        public String code;

        public String remark;
    }

    /**
     * 字典响应码（10开头）
     * @author Caesar Liu
     * @date 2019/5/10 15:18
     */
    @Getter
    @AllArgsConstructor
    enum ResultCode implements IResultCode {
        DICTIONARY_CODE_EXISTS(1001, "词条code已存在"),
        DICTIONARY_NAME_EXISTS(1002, "词条名称已存在"),
        ;
        private int code;

        private String message;
    }
}
