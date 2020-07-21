package com.mini.base.constant;

import com.mini.base.api.IResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 订单相关常量类
 *
 * @author huqianbo
 * @date 2019/5/6 19:47
 */
public class OrderConstant {

    //房间价格调价选项
    public static final Integer ROOM_PRICE_ADJUST_ROOMRATE = 1; //月租金调整
    public static final Integer ROOM_PRICE_ADJUST_SERVICE = 2; //服务费调整
    public static final Integer ROOM_PRICE_ADJUST_DEPOSIT = 3; //押金调整
    public static final Integer ROOM_PRICE_ADJUST_ENTERPRISER = 4; //企业协议合同
    public static final Integer ROOM_PRICE_ADJUST_RENT = 5; //房租调整

    /**
     * 允许预期退租 0-允许
     */
    public static final String ALLOW_STOP_RENT_OVERDUE_ENABLE = "0";

    /**
     * 订单状态
     */
    @Getter
    @AllArgsConstructor
    public enum OrderStatus {
        // 待签约
        USG("USG", "待签约"),
        // 待支付(定金)
        UPE("UPE", "待支付(定金)"),
        UPF("UPF", "待支付(尾款)"),
        UPD("UPD", "待支付(首期账单)"),
        PDE("PDE", "已付定金"),
        UCK("UCK", "待入住"),
        CKI("CKI", "已入住"),
        OUT("OUT", "已退租"),
        CAN("CAN", "已取消"),
        TB("TB", "已挞定");

        public String type;
        public String name;

        public static String getOrderStatusByType(String type) {
            if (type == null) {
                return null;
            }
            for (OrderStatus orderStatus : OrderStatus.values()) {
                if (orderStatus.type.equals(type)) {
                    return orderStatus.name;
                }
            }
            return null;
        }
    }

    //订单状态
    public enum OrderRoomStatus {
        USG("USG", "待签约"),
        UPE("UPE", "待支付(定金)"),
        UPF("UPF", "待支付(尾款)"),
        UPD("UPD", "待支付(首期账单)"),
        PDE("PDE", "已付定金"),
        UCK("UCK", "待入住"),
        CKI("CKI", "已入住"),
        OUT("OUT", "已退租"),
        CAN("CAN", "已取消"),
        TB("TB", "已挞定"),
        CRD("CRD", "已换房"),
        ETD("ETD", "已续租");

        public String type;
        public String name;

        OrderRoomStatus(String type, String name) {
            this.type = type;
            this.name = name;
        }

        public static String getOrderRoomStatusByType(String type) {
            if (type == null) {
                return null;
            }
            for (OrderRoomStatus orderRoomStatus : OrderRoomStatus.values()) {
                if (orderRoomStatus.type.equals(type)) {
                    return orderRoomStatus.name;
                }
            }
            return null;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 入住人状态
     *
     * @author Caesar Liu
     * @date 2019/6/5 17:11
     */
    @Getter
    @AllArgsConstructor
    public enum OrderPersonStatus {
        UCK("UCK", "待入住"),
        CKI("CKI", "已入住"),
        OUT("OUT", "已退租"),
        // 已取消
        CANCEL("CANCEL", "已取消"),
        ;

        private String status;

        private String remark;

        public static String getOrderPersonStatusByRemark(String status) {
            if (status == null) {
                return null;
            }
            for (OrderPersonStatus orderPersonStatus : OrderPersonStatus.values()) {
                if (orderPersonStatus.status.equals(status)) {
                    return orderPersonStatus.remark;
                }
            }
            return null;
        }
    }

    //预订方式
    public enum BookingWay {
        FULL(1, "全额首款"),
        EARNEST(2, "定金预订");

        public Integer type;
        public String name;

        BookingWay(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public Integer getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public static String getBookingWayNameByType(Integer type) {
            if (type == null) {
                return null;
            }
            for (BookingWay bookingWay : BookingWay.values()) {
                if (bookingWay.type.equals(type)) {
                    return bookingWay.name;
                }
            }
            return null;
        }
    }

    //订单类型
    public enum OrderType {
        MEMBER(1, "个人订单"),
        ENTERPRISE(2, "企业订单"),
        CONTRACT(3, "企业合约");

        public Integer type;
        public String name;

        OrderType(Integer type, String name) {
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

    //交割单状态
    public enum ItemsStatus {
        UNCONFIRMED("0", "未确认"),
        CONFIRMED("1", "已确认"),
        DONE("2", "已完成");

        public String type;
        public String name;

        ItemsStatus(String type, String name) {
            this.type = type;
            this.name = name;
        }

        public static String getItemsStatusByType(String type) {
            if (type == null) {
                return null;
            }
            for (ItemsStatus itemsStatus : ItemsStatus.values()) {
                if (itemsStatus.type.equals(type)) {
                    return itemsStatus.name;
                }
            }
            return null;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }

    //交割单物品状态
    public enum OrderArticleStatus {
        DELIVERY(1, "已交割"),
        RETURN(2, "已退还"),
        DAMAGE(3, "报损"),
        COMPENSATE(4, "损坏赔偿");

        public Integer type;
        public String name;

        OrderArticleStatus(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public static String getOrderArticleStatusByType(Integer type) {
            if (type == null) {
                return null;
            }
            for (OrderArticleStatus orderArticleStatus : OrderArticleStatus.values()) {
                if (orderArticleStatus.type.equals(type)) {
                    return orderArticleStatus.name;
                }
            }
            return null;
        }

        public Integer getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }

    //交割单物品状态
    public enum OrderArticleReturnType {
        COMPENSATE(1, "损坏赔偿"),
        DAMAGE(2, "报损"),
        INTACT(3, "完好退还");


        public Integer type;
        public String name;

        OrderArticleReturnType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public static String getOrderArticleReturnTypeByType(Integer type) {
            if (type == null) {
                return null;
            }
            for (OrderArticleReturnType orderArticleReturnType : OrderArticleReturnType.values()) {
                if (orderArticleReturnType.type.equals(type)) {
                    return orderArticleReturnType.name;
                }
            }
            return null;
        }

        public Integer getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }

    //订单日志
    public enum OrderLogType {
        CREATE("create", "创建订单"),
        UPDATE("update", "修改订单"),
        CANCEL("cancel", "取消订单"),
        TB("tb", "挞定订单"),
        CANCELCHECKIN("cancelCheckIn", "取消入住"),
        CANCELCHECKINBYRELET("cancelCheckInByRelet", "取消入住(续租)"),
        CHECKIN("checkIn", "办理入住"),
        UPDATEDELIVERY("updateDelivery", "变更交割单"),
        CONFIRMDELIVERY("confirmDelivery", "确认变更交割单"),
        CANCELDELIVERY("cancelDelivery", "取消变更交割单"),
        SIGN("sign", "签约合同"),
        BILLPAY("billPay", "账单收款"),
        REFUND("refund", "办理退租"),
        BILL_REPEAL("billRepeal", "账单撤销"),
        BILL_ACCOUNT_OFFSET("billAccountOffset", "账务冲账"),
        RENEWAL("renewal", "办理续租"),
        UPDRENEWAL("updateRenewal", "确认续租"),
        CHANGE_ROOM("changeRoom", "取消换房"),
        CANCEL_CHANGE_ROOM("cancelChangeRoom", "取消换房"),
        CREATECONTRACTORDER("createContractOrder", "创建企业合约子订单"),
        ;

        public String type;
        public String description;

        OrderLogType(String type, String description) {
            this.type = type;
            this.description = description;
        }

        public String getType() {
            return type;
        }

        public String getDescription() {
            return description;
        }
    }

    //订单入住人类型
    public enum OrderPersonCheckInType {
        MAIN(0, "主入住人"),
        COHABIT(1, "同住人");

        public Integer type;
        public String name;

        OrderPersonCheckInType(Integer type, String name) {
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


    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(new Date(19, 7, 11));
        System.out.println(new Date(19, 10, 10));
    }

    //交割单操作类型
    public enum DeliveryOperatorType {
        UPDATE(1, "变更"),
        CONFIRM(2, "确认变更"),
        CANCEL(-1, "取消变更");

        public Integer type;
        public String name;

        DeliveryOperatorType(Integer type, String name) {
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

    //渠道来源
    public enum OrderChannel {
        DEFAULT("APMS", "APMS"),
        H5("H5", "H5"),
        ;

        public String type;
        public String name;

        OrderChannel(String type, String name) {
            this.type = type;
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }

    // 退款类型
    public enum RefundType {
        TB(1, "挞定退款"),
        CANCELCHECKIN(2, "取消入住退款"),
        RETURNRENT(3, "退租退款"),
        TERMINATION_CONTRACT(4, "企业合约中止退款");

        public Integer type;
        public String name;

        RefundType(Integer type, String name) {
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

    // 退款状态
    public enum RefundStatus {
        NOREFUND(0, "未退款"),
        REFUNDED(1, "已退款");

        public Integer status;
        public String name;

        RefundStatus(Integer status, String name) {
            this.status = status;
            this.name = name;
        }

        public Integer getStatus() {
            return status;
        }

        public String getName() {
            return name;
        }
    }

    // 退款方式
    public enum RefundMethod {
        CASH(BillConstant.PaymentType.CASH.getCode(), "现金退款"),
        WECHAT(BillConstant.PaymentType.WECHAT.getCode(), "微信退款"),
        ALIPAY(BillConstant.PaymentType.ALIPAY.getCode(), "支付宝退款"),
        BANK_TRANSFER(BillConstant.PaymentType.BANK_TRANSFER.getCode(), "银行转账"),
        ;

        public String code;
        public String name;

        RefundMethod(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static String getRefundMethodName(String code) {
            for (RefundMethod refundMethod : RefundMethod.values()) {
                if (refundMethod.code.equals(code)) {
                    return refundMethod.name;
                }
            }
            return "";
        }
    }

    // 退租类型
    public enum ReturnRentType {
        BREAK_RETURN_RENT(0, "中途退租"),
        FINISH_RETURN_RENT(1, "到期退租"),
        CANCEL_RETURN_RENT(2, "取消退租");

        public Integer status;
        public String name;

        ReturnRentType(Integer status, String name) {
            this.status = status;
            this.name = name;
        }

        public Integer getStatus() {
            return status;
        }

        public String getName() {
            return name;
        }
    }

    // 退租状态
    public enum ReturnRentStatus {
        CREATED(1, "已创建"),
        WAITCONFIRMED(-2, "确认物品和物业中"),
        CONFIRMED(2, "已确认物品和物业"),
        CHEECKED(3, "已核对账单"),
        REFUNDED(4, "已退租");

        public Integer status;
        public String name;

        ReturnRentStatus(Integer status, String name) {
            this.status = status;
            this.name = name;
        }

        public Integer getStatus() {
            return status;
        }

        public String getName() {
            return name;
        }
    }

    // 罚没组名
    public enum ConfiscateType {
        CONFISCATE("CONFISCATE", "罚没项"),
        REMAIN("REMAIN", "剩余款项");

        public String type;
        public String name;

        ConfiscateType(String type, String name) {
            this.type = type;
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }

    // 罚没类型
    public enum PenaltyType {
        PENALTY_EARNEST(ConfiscateType.CONFISCATE.type, FinanceConstant.BusinessSubjectCode.EARNEST.code, "罚没定金"),
        PENALTY_DEPOSI(ConfiscateType.CONFISCATE.type, FinanceConstant.BusinessSubjectCode.DEPOSI.code, "罚没押金"),
        PENALTY_ROOMRATE(ConfiscateType.CONFISCATE.type, FinanceConstant.BusinessSubjectCode.LONGROOMRATE.code, "罚没房租"),
        PENALTY_SERVICE(ConfiscateType.CONFISCATE.type, FinanceConstant.BusinessSubjectCode.LONGSERVE.code, "罚没服务费"),
        REMAIN_DEPOSI(ConfiscateType.REMAIN.type, FinanceConstant.BusinessSubjectCode.DEPOSI.code, "剩余押金"),
        REMAIN_ROOMRATE(ConfiscateType.REMAIN.type, FinanceConstant.BusinessSubjectCode.LONGROOMRATE.code, "剩余房租"),
        REMAIN_SERVICE(ConfiscateType.REMAIN.type, FinanceConstant.BusinessSubjectCode.LONGSERVE.code, "剩余服务费");

        public String group;
        public String code;
        public String name;

        PenaltyType(String group, String code, String name) {
            this.group = group;
            this.code = code;
            this.name = name;
        }

        public static String getNameByGroupCode(String group, String code) {
            if (code == null) {
                return null;
            }
            for (PenaltyType penaltyType : PenaltyType.values()) {
                if (penaltyType.group.equals(group) && penaltyType.code.equals(code)) {
                    return penaltyType.name;
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

    /**
     * 字典响应码（12开头）
     *
     * @author Caesar Liu
     * @date 2019/5/10 15:18
     */
    @Getter
    @AllArgsConstructor
    public enum ResultCode implements IResultCode {
        ROOM_CONTROL(1201, "房控被占");

        private int code;

        private String message;
    }

    //订单取消类型
    public enum OrderCancelType {
        CANCEL(1, "取消"),
        TB(2, "挞定"),
        CANCELCHECKIN(3, "取消入住"),
        CANCELCHECKINBYRELET(4, "取消入住(续租)");

        public Integer type;
        public String name;

        OrderCancelType(Integer type, String name) {
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


    //合同形式
    public enum EnterpriseContractType {
        CHARTERED_ROOM(1, "买断包房");

        public Integer type;
        public String name;

        EnterpriseContractType(Integer type, String name) {
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

    @Getter
    @AllArgsConstructor
    public enum OrderReservationStatus {
        NEW(0, "待看房"),
        PROCESS(1, "待处理"),
        FINISH(2, "已结束"),
        CANCEL(3, "已取消"),
        ;

        private int status;
        private String remark;

        public static boolean containsStatus(int status) {
            for (OrderReservationStatus e : OrderReservationStatus.values()) {
                if (e.getStatus() == status) {
                    return true;
                }
            }

            return false;
        }

        public static String getStatusName(int status) {
            for (OrderReservationStatus e : OrderReservationStatus.values()) {
                if (e.getStatus() == status) {
                    return e.getRemark();
                }
            }

            return null;
        }
    }

    @Getter
    @AllArgsConstructor
    public enum OrderReservationConvertStatus {
        NOT(0, "未确认"),
        YES(1, "已确认"),
        ;

        private int status;
        private String remark;
    }

    /**
     * 单据类型
     */
   /* @Getter
    @AllArgsConstructor
    public enum OrderBillStatusType {
        RENEWAL(1, "续租"),
        RETURNRENT(2, "换房"),
        ;

        private int type;
        private String name;
    }*/

    /**
     * 单据表 类型状态
     */
    //类型
    public static final Integer ORDERBILLSTATUS_TYPE_RELET = 1; //续租
    public static final Integer ORDERBILLSTATUS_TYPE_CHANGEROOM = 2; //换房
    //状态
    public static final Integer ORDERBILLSTATUS_STATUS_WAIT = 1; //待操作
    public static final Integer ORDERBILLSTATUS_STATUS_COMPLETED = 2; //已完成

    //类型状态
    @Getter
    @AllArgsConstructor
    public enum OrderBillStatusTypeStatus {
        RENEWALUCK(1, 1, 1, "办理续租"),
        RENEWALCKI(2, 1, 2, "确认续租"),

        // 换房
        CHANGEROOM(1, 2, 1, "换房选择新房间"),
        CHANGEROOM_GOODS_CONFIRM(2, 2, 1, "换房物品确认和结算"),
        CHANGEROOM_OLDROOM_CHECK(3, 2, 1, "旧房核对账务账单"),
        CHANGEROOM_NEWORDER_GRATHER(4, 2, 1, "新房收款"),
        CHANGEROOM_COMPLETE(5, 2, 2, "办理换房完成"),
        ;

        private Integer step;
        private Integer type;
        private Integer typeStatus;
        private String name;
    }

    //预订方式
    public enum OrderReadingStatus {
        NO(0, "未抄表"),
        YES(1, "已抄表");

        public Integer type;
        public String name;

        OrderReadingStatus(Integer type, String name) {
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

    //预订方式
    @Getter
    @AllArgsConstructor
    public enum OrderBizApplyType {
        CHECKOUT(1, "退租"),
        RELET(2, "续租"),
        CHANGE(3, "换房");
        public Integer type;
        public String name;
    }

    // 流程状态
    public enum ProcessStatus {
        NORMAL(0, "正常"),
        RELETING(1, "续租中"),
        CHANGEING(2, "换房中"),
        RETURNING(3, "退租中"),
        WAITRETURN(4, "待退"),
        WAITRELET(5, "待续"),
        WAITCHANGE(6, "待换"),
        ;

        public Integer status;
        public String name;

        ProcessStatus(Integer status, String name) {
            this.status = status;
            this.name = name;
        }

        public Integer getStatus() {
            return status;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 续租步骤
     */
   /* @Getter
    @AllArgsConstructor
    public enum OrderBillStatusStep{
        HANDLE(1,"办理续租"),
        CONFIRM(2,"确认续租"),
        ;

        private int status;
        private String statusName;
    }*/
    //供应商
    public enum Supplier {
        FADADA("1", "法大大");
        public String code;
        public String desc;

        Supplier(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }

    /**
     * 收款单确认状态
     */
    @Getter
    @AllArgsConstructor
    public enum PaymentConfirmStatus {
        CONFIRMED(1, "已确认"),
        NOTCONFIRMED(2, "未确认");

        private int status;
        private String statusName;
    }

    /**
     * 入住人操作类型
     */
    @Getter
    @AllArgsConstructor
    public enum personOperationType {
        // 删除
        DELETE(-1, "删除"),
        // 新增
        INSERT(1, "新增"),
        // 修改
        UPDATE(2, "修改"),
        // 退住
        CHECKOUT(4, "退住"),
        // 全部退住
        ALL_CHECKOUT(5, "全部退住");
        private Integer type;
        private String name;
    }

    /**
     * 入住人操作类型List
     */
    public static final List<Integer> PERSON_OPERATION_TYPE_LIST;

    /**
     * 退换续房间申请状态Map
     */
    public static final Map<String, String> APPLY_STATUS_MAP = new HashMap<>(16);

    /**
     * 退租类型Map
     */
    public static final Map<Integer, String> STOP_RENT_BIZ_TYPE_MAP = new HashMap<>(16);

    /**
     * 退换续申请操作类型Map
     */
    public static final Map<Integer, String> THX_APPLY_TYPE_MAP = new HashMap<>(16);

    static {
        PERSON_OPERATION_TYPE_LIST = Arrays.stream(personOperationType.values()).map(personOperationType::getType).collect(Collectors.toList());
        Arrays.stream(ApplyStatus.values()).forEach(sub -> APPLY_STATUS_MAP.put(sub.getValue(), sub.getName()));
        Arrays.stream(StopRentBizType.values()).forEach(sub -> STOP_RENT_BIZ_TYPE_MAP.put(sub.getValue(), sub.getName()));
        Arrays.stream(ThxApplyType.values()).forEach(sub -> THX_APPLY_TYPE_MAP.put(sub.getValue(), sub.getName()));
    }

    /**
     * 退换续申请状态
     */
    @Getter
    @AllArgsConstructor
    public enum ApplyStatus {
        // 已撤回
        CANCEL("已撤回", "-1"),
        // 待确认
        TO_CONFIRM("待确认", "0"),
        // 已确认
        CONFIRMED("已确认", "1"),
        // 已完成
        DEAL("已完成", "2"),
        ;
        private String name;
        private String value;
    }

    /**
     * 退租业务类型
     */
    @Getter
    @AllArgsConstructor
    public enum StopRentBizType {
        // 中途退租
        STOP_INVALID("中途退租", 0),
        // 到期退租
        STOP_ON_TIME("到期退租", 1),
        // 逾期退租
        STOP_OVERTIME("逾期退租", 2);
        private String name;
        private Integer value;
    }

    /**
     * 退换续申请操作类型：1退租、2续租、3换房
     */
    @Getter
    @AllArgsConstructor
    public enum ThxApplyType {
        // 退租
        RENT("退租", 1),
        // 续租
        RENEWAL("续租", 2),
        // 换房
        CHANGE("换房", 3),
        ;
        private String name;
        private Integer value;
    }

    // 审批列表
    public enum OmsOrderType {
        NEW_ORDER(1, "新签订单"),
        ADD_ORDER(2, "续租订单"),
        OUT_ORDER(3, "退租订单"),
        ;

        public Integer type;
        public String name;

        OmsOrderType(Integer type, String name) {
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


    //订单状态
    public enum OmsOrderStatus {
        DRA("DRA", "草稿中"),
        EXA("EXA", "待审核"),
        USG("USG", "待签约"),
        UPD("UPD", "待支付"),
        UCK("UCK", "待入住"),
        CKI("CKI", "已入住"),
        REH("REH", "退租中"),
        OUT("OUT", "已退租"),
        HFR("HFR", "已续租"),
        CAN("CAN", "已取消");

        public String type;
        public String name;

        OmsOrderStatus(String type, String name) {
            this.type = type;
            this.name = name;
        }

        public static String getOrderStatusByType(String type) {
            if (type == null) {
                return null;
            }
            for (OrderStatus orderStatus : OrderStatus.values()) {
                if (orderStatus.type.equals(type)) {
                    return orderStatus.name;
                }
            }
            return null;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }
}
