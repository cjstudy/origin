package com.mini.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author:shixinfeng
 * @CreateDate: 2019/5/11 11:56
 * @Description:规格枚举
 */
@Getter
@AllArgsConstructor
public enum TemplateConstant {
    E_CONTRACT("e_contract","电子合同"),
    BUSINESS_SUBJECT("business_subject","营业科目"),
    ARTICLE("article","物品"),
    ROOM("room","房间"),
    TAX("tax_template","税率模板"),
    ALLOWANCE("allowance_template","津贴模板"),
    METER_READING("meter_reading_template","设备抄表模板"),
    DEVICE_INPUT("device_input","设备导入模板"),
    ;

    private String code;

    private String description;

    public static String getDescriptionByCode(String code) {
        if (code == null) {
            return null;
        }
        for (TemplateConstant templateConstant : TemplateConstant.values()) {
            if (templateConstant.code.equals(code)) {
                return templateConstant.description;
            }
        }
        return null;
    }
}
