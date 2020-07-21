package com.mini.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 合同相关常量类
 *
 * @author huqianbo
 * @date 2019/5/6 19:47
 */
public class ContractConstant {

    /**
     * 合同签约方式
     */
    @Getter
    @AllArgsConstructor
    public enum SigningWay {
        // 纸质合同
        PAPER(0, "纸质合同"),
        // 电子合同
        ELECTRONIC(1, "电子合同");

        public Integer type;
        public String name;

        public static String getSigningWayByType(Integer type) {
            if (type == null) {
                return null;
            }
            for (SigningWay signingWay : SigningWay.values()) {
                if (signingWay.type.equals(type)) {
                    return signingWay.name;
                }
            }
            return null;
        }
    }

    /**
     * 合同状态
     */
    @Getter
    @AllArgsConstructor
    public enum ContractStatus {
        // 未签约
        UNSIGN("0", "未签约"),
        EXECUTED("1", "已生效"),
        EXPIRED("2", "已失效"),
        INVALID("-1", "已作废"),
        Wait("3", "待生效"),
        ;

        public String type;
        public String name;

        public static String getContractStatusByType(String type) {
            if (type == null) {
                return null;
            }
            for (SigningWay signingWay : SigningWay.values()) {
                if (signingWay.type.equals(type)) {
                    return signingWay.name;
                }
            }
            return null;
        }
    }


}
