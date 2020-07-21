package com.mini.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

/**
 * 订单相关常量类
 *
 * @author huqianbo
 * @date 2019/5/6 19:47
 */
public class BillConstant {
    /**
     * 房费账单营业项目
     */
    public static final List<String> ROOM_RATE_BILL_TRANS_CODE_LIST = Collections.unmodifiableList(new ArrayList<String>() {
        private static final long serialVersionUID = -4783352904410226862L;

        {
            add(FinanceConstant.BusinessSubjectCode.LONGROOMRATE.getCode()); //长租房租
            add(FinanceConstant.BusinessSubjectCode.LONGSERVE.getCode()); //长租服务费
            add(FinanceConstant.BusinessSubjectCode.SHORTROOMRATE.getCode()); //短租房租
            add(FinanceConstant.BusinessSubjectCode.SHORTSERVE.getCode()); //短租服务费
            add(FinanceConstant.BusinessSubjectCode.DEPOSI.getCode()); //押金
            add(FinanceConstant.BusinessSubjectCode.EARNEST.getCode()); //定金
            add(FinanceConstant.BusinessSubjectCode.MONTHLY_RENT.getCode()); //月租金
            add(FinanceConstant.BusinessSubjectCode.MISCELLANEOUS_DEPOSI.getCode()); //杂项押金
        }
    });

    /**
     * 生活账单营业项目
     */
    public static final List<String> LIVING_BILL_TRANS_CODE_LIST = new ArrayList<String>() {
        private static final long serialVersionUID = 8737086881357103842L;

        {
            //水电煤暖
            add(FinanceConstant.BusinessSubjectCode.COLD_WATER.getCode()); //冷水费
            add(FinanceConstant.BusinessSubjectCode.RECYCLED_WATER.getCode()); //中水费
            add(FinanceConstant.BusinessSubjectCode.HOT_WATER.getCode()); //热水费
            add(FinanceConstant.BusinessSubjectCode.ELECTRIC.getCode()); //电费
            add(FinanceConstant.BusinessSubjectCode.GAS.getCode()); //天然气费
        }
    };

    /**
     * 短租通用支付方式
     */
    public static final Map<String, String> SHORT_COMMON_PAYMENT_TYPE_MAP = new HashMap<>(16);


    /**
     * 短租全部支付方式
     */
    public static final Map<String, String> SHORT_ALL_PAYMENT_TYPE_MAP = new HashMap<>(16);

    /**
     * 通用全部支付方式
     */
    public static final Map<String, String> ALL_PAYMENT_TYPE_MAP = new HashMap<>(16);

    static {
        Arrays.stream(PaymentType.values()).forEach(paymentType -> BillConstant.ALL_PAYMENT_TYPE_MAP.put(paymentType.getCode(), paymentType.getName()));
        Arrays.stream(ShortCommonPaymentType.values()).forEach(paymentType -> BillConstant.SHORT_COMMON_PAYMENT_TYPE_MAP.put(paymentType.getCode(), paymentType.getName()));
        Arrays.stream(ShortAllPaymentType.values()).forEach(paymentType -> BillConstant.SHORT_ALL_PAYMENT_TYPE_MAP.put(paymentType.getCode(), paymentType.getName()));
    }

    private BillConstant() {
    }

    /**
     * 支付方式
     *
     * @author Caesar Liu
     * @date 2019/5/31 15:17
     */
    @Getter
    @AllArgsConstructor
    public enum PaymentType {
        // 支付宝
        ALIPAY("ALIPAY", "支付宝"),
        // 微信
        WECHAT("WECHAT", "微信"),
        CASH("CASH", "现金"),
        POS("POS", "POS机"),
        BANK_TRANSFER("BANK_TRANSFER", "银联转账"),
        AR_CREDIT("AR_CREDIT", "AR信用"),
        AR_PREPAY("AR_PREPAY", "AR预付"),
        BALANCE("BALANCE", "余额"),
        COUPON("9006", "优惠券"),
        BANK("BANK", "银行转账"),
        CBB_WX("CBB_WX", "建行支付"),
        // 坏账收款
        BAD_DEBT("BAD_DEBT", "坏账收款"),
        ;
        private final String code;

        private final String name;

        public static String getNameByCode(String code) {
            if (code == null) {
                return null;
            }
            for (PaymentType pt : PaymentType.values()) {
                if (code.equals(pt.getCode())) {
                    return pt.getName();
                }
            }
            return null;
        }
    }

    /**
     * 短租通用支付方式
     */
    @Getter
    @AllArgsConstructor
    public enum ShortCommonPaymentType {
        ALIPAY("ALIPAY", "支付宝"),
        WECHAT("WECHAT", "微信"),
        CASH("CASH", "现金"),
        POS("POS", "POS机"),
        BANK_TRANSFER("BANK_TRANSFER", "银联转账"),
        BANK("BANK", "银行转账"),
        ;
        private final String code;

        private final String name;

        public static String getNameByCode(String code) {
            if (code == null) {
                return null;
            }
            for (PaymentType pt : PaymentType.values()) {
                if (code.equals(pt.getCode())) {
                    return pt.getName();
                }
            }
            return null;
        }
    }

    /**
     * 短租全部支付方式
     */
    @Getter
    @AllArgsConstructor
    public enum ShortAllPaymentType {
        ALIPAY("ALIPAY", "支付宝"),
        WECHAT("WECHAT", "微信"),
        CASH("CASH", "现金"),
        POS("POS", "POS机"),
        BANK_TRANSFER("BANK_TRANSFER", "银联转账"),
        BANK("BANK", "银行转账"),
        AR_CREDIT("AR_CREDIT", "AR信用"),
        AR_PREPAY("AR_PREPAY", "AR预付"),
        ;
        private final String code;

        private final String name;

        public static String getNameByCode(String code) {
            if (code == null) {
                return null;
            }
            for (PaymentType pt : PaymentType.values()) {
                if (code.equals(pt.getCode())) {
                    return pt.getName();
                }
            }
            return null;
        }
    }

    /**
     * 账单状态
     */
    @Getter
    @AllArgsConstructor
    public enum BillStatus {
        // 待支付
        UNPAID(0, "待支付"),
        // 已支付
        PAID(1, "已支付"),
        // 已作废
        INVALID(2, "已作废"),
        ;

        public Integer type;
        public String name;

    }

    /**
     * 账单类型
     */
    @Getter
    @AllArgsConstructor
    public enum BillAccountType {
        GATHERING(1, "收款"),
        INCOME(2, "收入"),
        DEPOSI(3, "押金"),
        ;
        private final Integer type;

        private final String remark;
    }


    //账单承担类型
    public enum BearType {
        MEMBER(1, "个人"),
        ENTERPRISE(2, "企业");

        public Integer type;
        public String name;

        BearType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public Integer getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }

    //账单类型
    public enum BillType {
        ROOMRATE(1, "房费账单"),
        LIVING(2, "生活账单"),
        OTHER(3, "其他账单");

        public Integer type;
        public String name;

        BillType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public Integer getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }

    //支付单状态
    public enum PayOrderStatus {
        UNPAY(0, "待支付"),
        PAYED(1, "已支付"),
        PAYING(2, "支付中"),
        ;

        public Integer type;
        public String name;

        PayOrderStatus(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public Integer getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 坏账收款状态
     */
    @Getter
    @AllArgsConstructor
    public enum bdStatus {
        // 未收款
        UNPAID(1, "未收款"),
        // "已收款"
        PAID(2, "已收款"),
        ;
        private Integer type;
        private String name;
    }

    /**
     * 坏账来源类型
     */
    @Getter
    @AllArgsConstructor
    public enum bdBizType {
        // 退租
        RETURN_RENT(1, "退租"),
        ;
        private Integer type;
        private String name;
    }

    /**
     * 预付款类型(1:个人,2:企业)
     */
    @Getter
    @AllArgsConstructor
    public enum advancePaymentType {
        // 个人
        MEMBER(1, "个人"),
        // 企业
        ENTERPRISE(2, "企业");

        private Integer type;
        private String name;
    }

    /**
     * 预付款操作类型(1:入账,2:退款,3:入账,4:退款)
     */
    @Getter
    @AllArgsConstructor
    public enum advanceOperationType {
        // 账单收款
        ACCOUNT_ENTRY(1, "账单收款"),
        // 账单退款
        ACCOUNT_REFUND(2, "账单退款"),
        // 预付款入账
        HAND_ENTRY(3, "预付款入账"),
        // 预付款退款
        HAND_REFUND(4, "预付款退款"),
        ;

        private Integer type;
        private String name;
    }

    /**
     * 账单承担类型
     */
    @Getter
    @AllArgsConstructor
    public enum OmsBearType {
        // 个人
        MEMBER(1, "个人"),
        // 企业
        ENTERPRISE(2, "企业");

        private Integer type;
        private String name;
    }

    //账单类型
    public enum OmsBillType {
        MONTHLYRENT(1, "monthRent", "月租金"),
        DEPOSI(2, "10002", "押金"),
        MISCELLANEOUSDEPOSI(3, "10011", "杂项押金"),
        LIVINGBILL(4, "liveFee", "生活账单");

        public Integer type;
        public String code;
        public String name;

        OmsBillType(Integer type, String code, String name) {
            this.type = type;
            this.code = code;
            this.name = name;
        }

        public Integer getType() {
            return type;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static String getCodeByType(Integer type) {
            if (type == null) {
                return null;
            }
            for (OmsBillType pt : OmsBillType.values()) {
                if (type.equals(pt.getType())) {
                    return pt.getCode();
                }
            }
            return null;
        }
    }

    /**
     * 账单来源
     */
    @Getter
    @AllArgsConstructor
    public enum OmsSource {
        // 账单
        MONTHLY_REVIEW(1, "月审"),
        PUSH(2, "水电账单推送"),
        MANUAL(3, "手动"),
        ;
        private Integer type;
        private String name;
    }

    /**
     * 核销类型(1:核销,2:反核销)
     */
    @Getter
    @AllArgsConstructor
    public enum verificationType {
        // 核销
        ACCOUNT_ENTRY(1, "核销"),
        // 反核销
        ACCOUNT_REFUND(2, "反核销"),
        ;

        private Integer type;
        private String name;
    }

}
