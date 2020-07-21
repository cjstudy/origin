package com.mini.base.constant;

public class OrderBizApplyConstant {
    //申请单来源
    public enum OrderBizApplySource {
        B(1, "B","B端"),
        C(2, "C","C端");

        public int source;
        public String code;
        public String name;

        OrderBizApplySource(int source, String code,String name) {
            this.source = source;
            this.code = code;
            this.name = name;
        }
    }
}
