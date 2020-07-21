package com.mini.base.constant;

/**
 * 现付账
 *
 * @author shixinfeng
 * @date 2019/6/29 16:35
 */
public class CashPaymentConstant {

    // 现付账状态
    public enum CPStatus {
        PAY_OVER(1, "已收款"),
        REFUND_WAIT(2, "待退款"),
        REFUND_OVER(3, "已退款"),
        ;

        public Integer status;
        public String name;

        CPStatus(Integer status, String name) {
            this.status = status;
            this.name = name;
        }

        public Integer getStatus() {
            return this.status;
        }

        public String getName() {
            return this.name;
        }

        public static String getCPStatusNameByStatus(Integer status) {
            for (CPStatus cpStatus : CPStatus.values()) {
                if (cpStatus.status == status)
                    return cpStatus.name;
            }

            return "";
        }
    }

    // 退款类型
    public enum RefundType {
        OFFLINE(1, "线下退款"),
        ONLINE(2, "线上退款"),
        ;

        public Integer type;
        public String name;

        RefundType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public Integer getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }
    }

    // 日志类型
    public enum LogType {
        PAY_RECORD(1, "收款记录"),
        REFUND_APPLY(2, "申请退款"),
        REFUND_CANCEL(3, "取消退款"),
        REFUND_OVER(4, "完成退款"),
        ;

        public Integer type;
        public String name;

        LogType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public static String getLogNameByType(Integer type) {
            for (LogType logType : LogType.values()) {
                if (logType.type == type)
                    return logType.name;
            }

            return "";
        }
    }
}
