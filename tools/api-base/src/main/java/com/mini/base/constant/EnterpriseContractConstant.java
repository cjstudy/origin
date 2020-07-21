package com.mini.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 合约模块常量
 * @author Caesar Liu
 * @date 2019/6/20 11:24
 */
public interface EnterpriseContractConstant {

    /**
     * 合约状态
     * @author Caesar Liu
     * @date 2019/6/20 11:25
     */
    @Getter
    @AllArgsConstructor
    enum ContractStatus {
        TERMINAL("TER", "终止"),
        ;
        private String status;

        private String remark;
    }
}
