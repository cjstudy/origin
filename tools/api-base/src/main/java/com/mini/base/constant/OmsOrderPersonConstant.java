package com.mini.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author:WN
 * @CreateDate: 2020/2/16 16:56
 * @Description:
 */
public class OmsOrderPersonConstant {

    /**
     * 入住人操作
     */
    @Getter
    @AllArgsConstructor
    public enum OmsOrderPersonType {

        LORD("0", "添加主入住人"),
        WITH("1", "添加同入住人"),
        OUT("2", "退租入住人"),
        DEL("3", "删除入住人");


        public String type;
        public String name;

        public static String getOmsOrderPersonType(String type) {
            if (type == null) {
                return null;
            }

            for (OmsOrderPersonType omsOrderPersonType : OmsOrderPersonType.values()) {
                if (omsOrderPersonType.type.equals(type)) {
                    return omsOrderPersonType.name;
                }
            }

            return null;
        }
    }

    @Getter
    @AllArgsConstructor
    public enum OmsOrderPersonCheckStatus {
        CKI("1", "已入住"),
        OUT("2", "已退租");

        public String type;
        public String name;
    }
}
