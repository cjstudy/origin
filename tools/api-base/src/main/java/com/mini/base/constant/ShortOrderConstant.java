package com.mini.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 短租订单相关常量类
 *
 * @author LIUDONGFANG
 * @version 1.0
 * @date 2019/9/3
 */
public class ShortOrderConstant {

    /**
     * 预订单状态
     */
    @Getter
    @AllArgsConstructor
    public enum SOrderStatus {
        RES("RES", "预订中"),
        DON("DON", "已完成"),
        CAN("CAN", "已取消"),
        ;

        public String type;
        public String name;

        public static String getSOrderStatusByType(String type) {
            if (type == null) {
                return null;
            }
            for (SOrderStatus orderStatus : SOrderStatus.values()) {
                if (orderStatus.type.equals(type)) {
                    return orderStatus.name;
                }
            }
            return null;
        }
    }

    /**
     * 订单状态
     */
    @Getter
    @AllArgsConstructor
    public enum SOrderRoomStatus {
        UCK("UCK", "待入住"),
        CKI("CKI", "已登记入住"),
        CAN("CAN", "已取消"),
        IVD("IVD", "已失效"),
        ;

        public String type;
        public String name;

        public static String getSOrderRoomStatusByType(String type) {
            if (type == null) {
                return null;
            }
            for (SOrderRoomStatus orderRoomStatus : SOrderRoomStatus.values()) {
                if (orderRoomStatus.type.equals(type)) {
                    return orderRoomStatus.name;
                }
            }
            return null;
        }
    }

    /**
     * 接待单状态
     */
    @Getter
    @AllArgsConstructor
    public enum SOrderReceptionStatus {
        CKI("CKI", "入住中"),
        OUT("OUT", "已退房"),
        ;

        public String type;
        public String name;

        public static String getSOrderReceptionStatusByType(String type) {
            if (type == null) {
                return null;
            }
            for (SOrderReceptionStatus orderReceptionStatus : SOrderReceptionStatus.values()) {
                if (orderReceptionStatus.type.equals(type)) {
                    return orderReceptionStatus.name;
                }
            }
            return null;
        }
    }

    /**
     * 预订方式
     */
    @Getter
    @AllArgsConstructor
    public enum BookingType {
        SPOT(1, "现付预订"),
        PREPAY(2, "预付预订"),
        ;

        public Integer type;
        public String name;

        public static String getBookingTypeByType(Integer type) {
            if (type == null) {
                return null;
            }
            for (BookingType bookingType : BookingType.values()) {
                if (bookingType.type.equals(type)) {
                    return bookingType.name;
                }
            }
            return null;
        }
    }

    /**
     * 客户来源类型
     */
    @Getter
    @AllArgsConstructor
    public enum CustomerType {
        NORMAL(1, "普通客户"),
        AGREEMENT(2, "协议客户"),
        ;

        public Integer type;
        public String name;

        public static String getCustomerTypeByType(Integer type) {
            if (type == null) {
                return null;
            }
            for (CustomerType customerType : CustomerType.values()) {
                if (customerType.type.equals(type)) {
                    return customerType.name;
                }
            }
            return null;
        }
    }

    /**
     * 更换房价码
     */
    @Getter
    @AllArgsConstructor
    public enum ChangeRateCode {
        NOT_REPLACED(0, "未更换"),
        FREE_UPGRADE(1, "免费升级"),
        NOT_UPGRADE(2, "不升级"),
        ;

        public Integer type;
        public String name;

        public static String getChangeRateCodeByType(Integer type) {
            if (type == null) {
                return null;
            }
            for (ChangeRateCode changeRateCode : ChangeRateCode.values()) {
                if (changeRateCode.type.equals(type)) {
                    return changeRateCode.name;
                }
            }
            return null;
        }
    }

    /**
     * 更换房价码
     */
    @Getter
    @AllArgsConstructor
    public enum OrderLogType {
        CREATE("CREATE", "创建订单"),
        CHECK_IN("CHECK_IN", "登记入住"),
        CANCEL("CANCEL", "取消订单"),
        INVALID("INVALID", "失效订单"),
        CHECK_OUT("CHECK_OUT", "退房"),
        CHANGE_ROOM("CHANGE_ROOM", "换房"),
        EXTENSION("EXTENSION", "续住"),
        ;

        public String type;
        public String name;

        public static String getOrderLogTypeByType(String type) {
            if (type == null) {
                return null;
            }
            for (OrderLogType orderLogType : OrderLogType.values()) {
                if (orderLogType.type.equals(type)) {
                    return orderLogType.name;
                }
            }
            return null;
        }
    }

    /**
     * 账务类型
     *
     * @author LIUDONGFANG
     * @date 2019/9/3
     */
    @Getter
    @AllArgsConstructor
    public enum SBillAccountType {
        CONSUMPTION(0, "消费"),
        RECEIVABLE(1, "收款"),
        ;

        private Integer type;

        private String name;
    }

    /**
     * 付款方式
     */
    @Getter
    @AllArgsConstructor
    public enum paymentMethod {
        SPOT_PAYMENT(0, "现付"),
        AFTER_PAYMENT(1, "后付"),
        ;

        private Integer type;

        private String name;
    }

    /**
     * 账务状态
     */
    @Getter
    @AllArgsConstructor
    public enum BaStatus {
        UNFINISHED(0, "未结账"),
        FINISHED(1, "已结账"),
        ;

        private Integer type;

        private String name;
    }


    /**
     * 付款方式
     */
    @Getter
    @AllArgsConstructor
    public enum bizType {
        ACCOUNT_ENTRY(0, "入账"),
        RUSH_ACCOUNTS(1, "冲账"),
        TRANSFER_ACCOUNTS(2, "转账"),
        HANG_UP_RECEIVABLES(3, "挂应收"),
        REFUND(4, "退款"),
        STAYS_ACCOUNT(5, "挂账"),
        SETTLE_ACCOUNTS(6, "结账"),
        NIGHT_VERIFY(7, "夜审"),
        ;

        private Integer type;

        private String name;
    }

    /**
     * 订单账务状态
     */
    @Getter
    @AllArgsConstructor
    public enum billStatus {
        UNFINISHED(0, "未结账"),
        FINISHED(1, "已结账"),
        REGISTERED(2, "已挂账"),
        ;

        private Integer type;

        private String name;

        public static String getBillStatusByType(Integer type) {
            if (type == null) {
                return null;
            }
            for (billStatus status : billStatus.values()) {
                if (status.type.equals(type)) {
                    return status.name;
                }
            }
            return null;
        }
    }

    /**
     * 房量操作类型
     */
    @Getter
    @AllArgsConstructor
    public enum RoomVolumeOperationType {
        SUBTRACT(0, "减房量"),
        ADD(1, "加房量"),
        ;

        public Integer type;

        public String name;
    }

    /**
     * 是否免打扰(0:取消免打扰,1:免打扰)
     */
    @Getter
    @AllArgsConstructor
    public enum disturbStatus {
        // 取消免打扰
        NORMAL(0, "取消免打扰"),
        // 免打扰
        NOT_DISTURB(1, "免打扰"),
        ;
        private Integer type;
        private String name;

        public Integer getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 是否保密(0:取消保密,1:保密)
     */
    @Getter
    @AllArgsConstructor
    public enum confidentialStatus {
        // 取消保密
        NORMAL(0, "取消保密"),
        // 保密
        CONFIDENTIAL(1, "保密"),
        ;
        private Integer type;
        private String name;
    }

    /**
     * 获取房型房价码业务类型
     */
    @Getter
    @AllArgsConstructor
    public enum RoomTypeRateCodeBizType {
        CREATE(1, "下单"),
        CHECKIN(2, "入住"),
        CHANGRROOM(3, "换房"),
        RELET(4, "续住"),
        ;
        public Integer type;
        public String name;
    }

    /**
     * 取消类型
     */
    @Getter
    @AllArgsConstructor
    public enum CancelType {
        GUEST(1, "客人取消"),
        TIMEOUT(2, "超时取消"),
        NIGHT(3, "夜审取消"),
        ;

        public Integer type;
        public String name;

        public static String getCancelTypeByType(Integer type) {
            if (type == null) {
                return null;
            }
            for (CancelType cancelType : CancelType.values()) {
                if (cancelType.type.equals(type)) {
                    return cancelType.name;
                }
            }
            return null;
        }
    }

    /**
     * 操作类型
     */
    @Getter
    @AllArgsConstructor
    public enum operationType {
        // 结账
        SETTLE_ACCOUNTS("SETTLE_ACCOUNTS", "结账"),
        // 退房
        CHECK_OUT("CHECK_OUT", "退房"),
        ;
        private String type;
        private String name;
    }

}
