package com.mini.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统编号
 *
 * @author huqianbo
 * @date 2019/5/6 19:47
 */
@Getter
@AllArgsConstructor
public enum SerialNumConstant {
    // 公寓编号
    APARTMENT_CODE("ApartmentCode", "公寓编号"),
    ORDER_NO("OrderNo", "订单编号"),
    BILL_NO("BillNo", "账单编号"),
    CONTRACT_NO("ContractNo", "合同编号"),
    RETURN_RENT_NO("ReturnRentNo", "退租单编号"),
    REFUND_NO("RefundNo", "退款编号"),
    ENTERPRISR_CONTRACT_NO("EnterpriseContractNo", "企业合约编号"),
    BILL_ACCOUNT_NO("BillAccountNo", "账务编号"),
    RESERVATION_NO("ReservationNo", "预约单编号"),
    CLEAN_WORK_ORDER_NO("CleanWorkOrderNo", "保洁工单编号"),
    WORK_ORDER_PLAN("WorkOrderPlanNo", "工单计划编号"),
    RECEIVABLE_CHANGE_PRICE("ReceivableChangePrice", "应收账调额操作编号"),
    CASH_PAYMENT_NO("CashPaymentNo", "现付账编号"),
    CASH_IN_AND_OUT_NO("CashInAndOutNo", "余额入账退款单号"),
    ACCOUNT_RECEIVABLE_NO("AccountReceivableNo", "挂账编号"),
    MEMBER_NO("MemberNo", "会员编号"),
    FDD_CONTRACT_TEMPLATE_NO("FddContractTemplateNo", "法大大合同模板编号"),
    PAY_NO("PayNo", "支付单编号"),
    // 预付款编号
    PAYMENT_NO("PaymentNo", "预付款编号"),

    SORDER_CODE("SOrderCode", "短租预订单编号"),
    SORDERROOM_CODE("SOrderRoomCode", "短租订单编号"),
    SORDER_RECEPTION_CODE("SOrderReceptionCode", "短租接待单编号"),
    SACCOUNT_NO("SAccountNo", "短租账务编号"),
    SHAND_OVER_CODE("SHandOverCode", "交班班次号"),

    ;

    private String code;

    private String remark;

}
