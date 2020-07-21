package com.mini.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author:WN
 * @CreateDate: 2019/5/9 10:56
 * @Description:规格枚举
 */
@Getter
@AllArgsConstructor
public enum SpecConstant {
    ROOMTYPE_SPEC_TAG(1,"房型规格"),
    BEDTYPE_SPEC_TAG(2,"床型规格"),
    ARTICLETYPE_SPEC_TAG(3,"物品规格")
    ;

    private int code;

    private String remark;


    public static final Integer PIC_ROOMTYPE_ADD = 1; //新增图片
    public static final Integer PIC_ROOMTYPE_UPDATE = 2; //修改图片
    public static final Integer PIC_ROOMTYPE_DELETE = -1; //删除图片


}
