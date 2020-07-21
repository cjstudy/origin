package com.mini.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author wmw
 * @Description  资产类型
 * @Date 14:45 2019/5/13
 * @version 1.0
**/
@Getter
@AllArgsConstructor
public enum AssetsConstant {
    Warehousing(0,"入库"),
    Repair(1,"报修"),
    AssetRegistration(2,"资产登记"),
    Exit(3,"出库"),
    Damage(4,"报损");

    private Integer type;

    private String remark;
}
