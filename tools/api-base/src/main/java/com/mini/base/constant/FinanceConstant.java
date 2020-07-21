package com.mini.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jack
 * @version 1.0
 * @date 2019/5/16 11:09
 * @desc 组织中心
 */
public interface FinanceConstant {

    String ORGANIZATION_CENTER = "总部";
    /**
     * 需要初始化的营业科目
     */
    List<String> initBusinessSubjectCodes = Arrays.asList(
            BusinessSubjectCode.EARNEST.code, BusinessSubjectCode.DEPOSI.code,
            BusinessSubjectCode.LONGSERVE.code, BusinessSubjectCode.LONGROOMRATE.code,
            BusinessSubjectCode.SHORTSERVE.code, BusinessSubjectCode.SHORTROOMRATE.code,
            BusinessSubjectCode.ARTICLESCOMPENSATION.code, BusinessSubjectCode.RENEGE.code,
            BusinessSubjectCode.COLD_WATER.code, BusinessSubjectCode.RECYCLED_WATER.code,
            BusinessSubjectCode.HOT_WATER.code, BusinessSubjectCode.ELECTRIC.code,
            BusinessSubjectCode.GAS.code, BusinessSubjectCode.GOODS_REPAIR_FEE.code,
            BusinessSubjectCode.GOODS_REPLACE_FEE.code, BusinessSubjectCode.TRANSFER.code,
            BusinessSubjectCode.HEATING_FEE.code, BusinessSubjectCode.LONGSERVE_INCOME.code,
            BusinessSubjectCode.LONGROOMRATE_INCOME.code, BusinessSubjectCode.SHORTSERVE_INCOME.code,
            BusinessSubjectCode.SHORTROOMRATE_INCOME.code, BusinessSubjectCode.MAINTENANCE_COSTS.code);

    /**
     * 营业科目Code
     */
    public enum BusinessSubjectCode {
        // 定金
        EARNEST("定金", "10001"),
        // 长租押金
        DEPOSI("长租押金", "10002"),
        LONGSERVE("长租服务费", "10003"),
        LONGROOMRATE("长租房租", "10004"),
        SHORTSERVE("短租服务费", "10005"),
        SHORTROOMRATE("短租房租", "10006"),
        LONGSERVE_INCOME("长租服务费收入", "10007"),
        LONGROOMRATE_INCOME("长租房租收入", "10008"),
        SHORTSERVE_INCOME("短租服务费收入", "10009"),
        SHORTROOMRATE_INCOME("短租房租收入", "10010"),
        MISCELLANEOUS_DEPOSI("杂项押金", "10011"),
        ORDER_ALLOWANCE("订单津贴", "10012"),
        MONTHLY_RENT("月租金", "10013"),
        COLD_WATER("冷水费", "20001"),
        RECYCLED_WATER("中水费", "20002"),
        HOT_WATER("热水费", "20003"),
        ELECTRIC("电费", "20004"),
        GAS("天然气费", "20005"),
        HEATING_FEE("供暖费", "20006"),
        ARTICLESCOMPENSATION("物品赔偿费", "30001"),
        RENEGE("违约金", "30002"),
        TRANSFER("中转", "30003"),
        MAINTENANCE_COSTS("维修费用", "30004"),
        GOODS_REPAIR_FEE("物品维修费", "40001"),
        GOODS_REPLACE_FEE("物品更换费", "40002");


        public String name;
        public String code;

        BusinessSubjectCode(String name, String code) {
            this.code = code;
            this.name = name;
        }

        public static String getNameByCode(String code) {
            if (code == null) {
                return null;
            }
            for (BusinessSubjectCode businessSubjectCode : BusinessSubjectCode.values()) {
                if (businessSubjectCode.code.equals(code)) {
                    return businessSubjectCode.name;
                }
            }
            return null;
        }

        /**
         * 判断是否为收入科目
         *
         * @author Caesar Liu
         * @date 2019-07-07 15:06
         */
        public static boolean isIncomeSubject(String subjectCode) {
            return !LONGROOMRATE.getCode().equals(subjectCode)
                    && !LONGSERVE.getCode().equals(subjectCode)
                    && !DEPOSI.getCode().equals(subjectCode)
                    && !EARNEST.getCode().equals(subjectCode);
        }

        //预付类营业科目集合
        public static List<String> getPrepayCodeList() {
            List<String> prepayCodeList = new ArrayList<>();
            prepayCodeList.add(EARNEST.code);
            prepayCodeList.add(DEPOSI.code);
            prepayCodeList.add(LONGSERVE.code);
            prepayCodeList.add(LONGROOMRATE.code);
            prepayCodeList.add(SHORTSERVE.code);
            prepayCodeList.add(SHORTROOMRATE.code);

            return prepayCodeList;
        }

        public static BusinessSubjectCode getBusinessSubjectByCode(String code) {
            for (BusinessSubjectCode subjectCode : BusinessSubjectCode.values()) {
                if (subjectCode.code.equals(code)) {
                    return subjectCode;
                }
            }
            return null;
        }

        public static boolean isAdvancedPayCode(String code) {
            if (code.equals(EARNEST.code)
                    || code.equals(DEPOSI.code)
                    || code.equals(LONGSERVE.code)
                    || code.equals(LONGROOMRATE.code)
                    || code.equals(SHORTSERVE.code)
                    || code.equals(SHORTROOMRATE.code)) {
                return true;
            }

            return false;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 房费账单营业科目code  所有的房费账单营业科目code必须都加进去
     */
    List<String> RoomFeeCodes = Arrays.asList(BusinessSubjectCode.EARNEST.code, BusinessSubjectCode.DEPOSI.code, BusinessSubjectCode.LONGSERVE.code, BusinessSubjectCode.LONGROOMRATE.code, BusinessSubjectCode.SHORTSERVE.code, BusinessSubjectCode.SHORTROOMRATE.code,
            BusinessSubjectCode.LONGSERVE_INCOME.code, BusinessSubjectCode.LONGROOMRATE_INCOME.code, BusinessSubjectCode.SHORTSERVE_INCOME.code, BusinessSubjectCode.SHORTROOMRATE_INCOME.code);

    /**
     * 生活费账单营业科目code  所有的生活费账单营业科目code必须都加进去
     */
    List<String> LiveFeeCodes = Arrays.asList(BusinessSubjectCode.COLD_WATER.code, BusinessSubjectCode.RECYCLED_WATER.code, BusinessSubjectCode.HOT_WATER.code, BusinessSubjectCode.ELECTRIC.code, BusinessSubjectCode.GAS.code, BusinessSubjectCode.HEATING_FEE.code);

    /**
     * 其他账单营业科目code  只定义部分   新建的营业科目如果不是生活费和房费   默认为其他账单
     */
    List<String> OtherFee = Arrays.asList(BusinessSubjectCode.ARTICLESCOMPENSATION.code, BusinessSubjectCode.RENEGE.code, BusinessSubjectCode.TRANSFER.code, BusinessSubjectCode.MAINTENANCE_COSTS.code);

    /**
     * 维修账单营业科目
     */
    List<String> repairFee = Arrays.asList(BusinessSubjectCode.GOODS_REPAIR_FEE.code, BusinessSubjectCode.GOODS_REPLACE_FEE.code, BusinessSubjectCode.MAINTENANCE_COSTS.code);

    /**
     * 营业科目类型Code    如果都不包涵  默认放到其他账单
     */
    public enum BusinessSubjectTypeCode {
        ROOM_FEE("房费账单", "roomFee"),
        LIVE_FEE("生活费账单", "liveFee"),
        OTHER_FEE("其他账单", "otherFee"),
        REPAIR_FEE("维修费账单", "repairFee");

        public String name;
        public String code;

        BusinessSubjectTypeCode(String name, String code) {
            this.code = code;
            this.name = name;
        }

        public static String getNameByCode(String code) {
            if (code == null) {
                return null;
            }
            for (BusinessSubjectCode businessSubjectCode : BusinessSubjectCode.values()) {
                if (businessSubjectCode.code.equals(code)) {
                    return businessSubjectCode.name;
                }
            }
            return null;
        }

        public static BusinessSubjectCode getBusinessSubjectByCode(String code) {
            for (BusinessSubjectCode subjectCode : BusinessSubjectCode.values()) {
                if (subjectCode.code.equals(code)) {
                    return subjectCode;
                }
            }
            return null;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

    @Getter
    @AllArgsConstructor
    enum InitialTax {
        INITIAL_TAX("0000", "初始税率0");

        String code;
        String tax;

    }

    /**
     * 税率类型枚举
     */
    @Getter
    enum TaxType {

        /**
         * 单价
         */
        TYPE_SINGLE("单价", 1),
        /**
         * 固定价
         */
        TYPE_FIXED("固定价", 2),
        /**
         * 非固定价
         */
        TYPE_NOT_FIXED("非固定价", 3),
        /**
         * 月租金比例
         */
        MONTH_RENT_RATE("月租金比例", 4);

        TaxType(String desc, Integer value) {
            this.desc = desc;
            this.value = value;
        }

        /**
         * 税率方式描述
         */
        private String desc;
        /**
         * 税率方式值
         */
        private Integer value;
    }

    @Getter
    @AllArgsConstructor
    enum BillAccountType {
        PRE_SALE(1, "预收"),
        ACCOUNT_IN(2, "收入"),
        REFUND(3, "退款"),
        OTHER(4, "其他");

        private Integer type;

        private String name;

    }

    @Getter
    @AllArgsConstructor
    public enum PaymentMethod {
        CASH(BillConstant.PaymentType.CASH.getCode(), BillConstant.PaymentType.CASH.getName()),
        ALIPAY(BillConstant.PaymentType.ALIPAY.getCode(), BillConstant.PaymentType.ALIPAY.getName()),
        WECHAT(BillConstant.PaymentType.WECHAT.getCode(), BillConstant.PaymentType.WECHAT.getName()),
        POS(BillConstant.PaymentType.POS.getCode(), BillConstant.PaymentType.POS.getName()),
        BANK_TRANSFER(BillConstant.PaymentType.BANK_TRANSFER.getCode(), BillConstant.PaymentType.BANK_TRANSFER.getName()),
        ;
        private String code;

        private String name;

        public static String getNameByCode(String code) {
            if (code == null) {
                return null;
            }
            for (BillConstant.PaymentType pt : BillConstant.PaymentType.values()) {
                if (code.equals(pt.getCode())) {
                    return pt.getName();
                }
            }
            return null;
        }
    }

    // 应收账核销状态
    public enum VerificationBillStatus {
        TO_VERIFICATION(1, "待核销"),
        HAVE_VERIFICATION(2, "已核销"),
        BAD_DEBTS(3, "坏账"),
        INVALID(4, "已作废"),
        ;

        public Integer status;
        public String name;

        VerificationBillStatus(Integer status, String name) {
            this.status = status;
            this.name = name;
        }

        public Integer getStatus() {
            return status;
        }

        public String getName() {
            return name;
        }

        public static String getVerificationBillStatusNameByStatus(Integer status) {
            for (VerificationBillStatus cpStatus : VerificationBillStatus.values()) {
                if (cpStatus.status == status) {
                    return cpStatus.name;
                }
            }
            return "";
        }
    }

    // 应收账核销操作类型
    public enum VerificationBillOperType {
        BFHE(1, "部分核销"),
        BJHZ(2, "标记坏账"),
        PLHX(3, "批量核销"),
        PLHZ(4, "批量坏账"),
        CXHX(5, "撤销操作"),
        QXHZ(6, "取消坏账"),
        YZFZD(7, "账单撤销"),
        YZFTZ(8, "账务调账"),
        CXHZ(9, "撤销取消坏账"),
        ;

        public Integer type;
        public String name;

        VerificationBillOperType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public Integer getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public static String getVerificationBillOperTypeNameByType(Integer type) {
            for (VerificationBillOperType cpStatus : VerificationBillOperType.values()) {
                if (cpStatus.type == type) {
                    return cpStatus.name;
                }
            }
            return "";
        }
    }

    @Getter
    @AllArgsConstructor
    enum ReceivableType {
        CREDIT(1, "信用"),
        PRE(2, "预付");

        private Integer type;

        private String name;

    }

    // 额度调整类型
    public enum RCLType {
        LIMIT_PRICE(1, "最高额度"),
        AVAILABLE_PRICE(2, "可用额度"),
        ;

        public Integer type;
        public String name;

        RCLType(Integer type, String name) {
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

    //应收账公司   应收范围
    public enum receivableRange {
        LONG_RENT(1, "长租"),
        SHORT_RENT(2, "短租"),
        LONG_SHORT_RENT(3, "长租+短租"),
        ;

        public Integer type;
        public String name;

        receivableRange(Integer type, String name) {
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

    // 应收账可用额度调整记录类型  长短租
    public enum rentType {
        LONG_RENT(0, "长租"),
        SHORT_RENT(1, "短租"),
        ;

        public Integer type;
        public String name;

        rentType(Integer type, String name) {
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

    // 应收账可用额度调整类型
    public enum AvailablePriceAdjustType {
        ORDER_AR(1, "订单挂账"),
        ORDER_REFUND(2, "订单退租"),
        HX_AR(3, "核销应收账"),

        BJHZ_AR(4, "标记坏账"),
        CXHX_AR(5, "撤销核销"),
        QXHZ_AR(6, "取消坏账"),
        CXQX_AR(7, "撤销取消坏账"),
        ZDCX_AR(8, "账单撤销"),
        ZWTZ_AR(9, "账务调账"),
        EDBG_AR(10, "额度变更"),
        HYZZ_AR(11, "合约终止"),
        ;

        public Integer type;
        public String name;

        AvailablePriceAdjustType(Integer type, String name) {
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

    // 应收账状态 0-正常 1-冻结
    public enum ReceivableStatus {
        OK(0, "正常"),
        FROZEN(1, "冻结"),
        ;

        public Integer type;
        public String name;

        ReceivableStatus(Integer type, String name) {
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


    // 营业科目出租类型
    public enum SubjectRentType {
        COMMON(0, "长短租"),
        LONG(1, "长租"),
        SHORT(2, "短租"),
        ;

        public Integer type;
        public String name;

        SubjectRentType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public static String getSubjectRentTypeByType(Integer type) {
            if (type == null) {
                return null;
            }
            for (SubjectRentType subjectRentType : SubjectRentType.values()) {
                if (type.equals(subjectRentType.type)) {
                    return subjectRentType.name;
                }
            }
            return null;
        }
    }

}
