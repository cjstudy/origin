package com.mini.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 账务常量定义
 *
 * @author Caesar Liu
 * @date 2019/6/5 10:55
 */
public interface BillAccountConstant {

    /**
     * 账务类型
     *
     * @author Caesar Liu
     * @date 2019/6/16 17:00
     */
    @Getter
    @AllArgsConstructor
    enum Type {
        // 收入(收款)
        INCOME(1, "收入"),
        // 消费(收入)
        CONSUME(2, "消费"),
        ;

        private Integer type;

        private String remark;

    }

    /**
     * 业务码定义
     *
     * @author Caesar Liu
     * @date 2019/6/5 10:58
     */
    @Getter
    @AllArgsConstructor
    enum BizCode {
        // 夜审
        DAY_STAT("DAY_STAT", "夜审"),
        MONTH_STAT("MONTH_STAT", "月审"),
        PMS_GATHER("PMS_GATHER", "PMS收款"),
        EARNEST_DEDUCTION("EARNEST_DEDUCTION", "定金自动抵扣"),
        H5_GATHER("H5_GATHER", "H5收款"),
        RETURN_RENT("RETURN_RENT", "退租"),
        RENEWAL("RENEWAL", "续租"),
        TART("TART", "挞定"),
        CANCEL_CHECKIN("CANCEL_CHECKIN", "取消入住"),
        ;
        private String code;

        private String remark;
    }

    /**
     * 账务状态
     *
     * @author Caesar Liu
     * @date 2019/6/5 11:00
     */
    @Getter
    @AllArgsConstructor
    enum AccountStatus {
        NORMAL("NORMAL", "正常"),
        REPEAL("REPEAL", "已撤销"),
        OFFSET("OFFSET", "已冲账"),
        ;
        private String status;

        private String remark;
    }

    /**
     * 账务状态
     * @author Caesar Liu
     * @date 2019/6/5 11:00
     */
    @Getter
    @AllArgsConstructor
    enum OmsAccountStatus {
        NORMAL(1, "正常"),
        REPEAL(2, "已撤销"),
        OFFSET(3, "已冲账"),
        ;
        private Integer status;

        private String remark;
    }

    /**
     * 月审类型
     */
    @Getter
    @AllArgsConstructor
    enum MonthApproveType {
        TIMER(1, "定时月审"),
        REPEAL(2, "手工月审"),
        CHANGE(3, "换房月审"),
        REFUND(4, "退房月审"),
        RENEWAL(5, "续租月审"),
        ;
        public Integer type;

        public String remark;
    }
}
