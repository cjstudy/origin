package com.mini.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 出租类型
 * @author Caesar Liu
 * @date 2019/5/9 10:00
 */
@Getter
@AllArgsConstructor
public enum RentTypeConstant {
    WHOLE(1L, "整租"),
    SCATTERED(2L, "散租")
    ;
    private Long type;

    private String remark;

}
