package com.mini.base.constant;

import lombok.Getter;

/**
 * 设备相关常量类
 *
 * @author huqianbo
 * @date 2019/6/18 18:05
 */
public class SmsConstant {
    // 短信平台
    public enum SmsPlatform {
        HWORLD("HWorld", "盟广"),
        ALIYUN("Aliyun", "阿里云"),
        ;

        public String code;
        public String name;

        SmsPlatform(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public static SmsPlatform getSmsPlatformByCode(String code) {
            for (SmsPlatform spf : SmsPlatform.values()) {
                if (code.equals(spf.code))
                    return spf;
            }
            return null;
        }

    }

    // 短信模板type
    public enum SmsType {
        RentPromotion("RentPromotion", "房租服务费账单缴费提醒"),
        LockTenantPassword("LockTenantPassword", "入住人智能门锁密码"),
        LockTemporaryPassword("LockTemporaryPassword", "临时智能门锁密码"),
        WorkOrderDelegate("WorkOrderDelegate", "派单通知"),
        WorkOrderUnFinished("WorkOrderUnFinished", "工单未完成提醒"),
        Register("Register", "注册"),
        ForgetPassword("ForgetPassword", "忘记密码"),
        UpdatePhoneNumber("UpdatePhoneNumber", "修改手机号"),
        BindingMobilePhone("BindingMobilePhone", "绑定手机号验证码"),
        LockDynamicPassword("LockDynamicPassword", "动态门锁密码"),
        DynamicLogin("DynamicLogin", "动态登录的验证码"),
        ReservationLookRoom("ReservationLookRoom", "预约看房成功的短信通知"),
        ReservationRoom("ReservationRoom", "预定房间成功的短信通知"),
        ElectronicContract("ElectronicContract", "电子合同验证模板"),
        OrderPersonRetreat("OrderPersonRetreat", "同住人退住短信通知"),
        OrderPersonNotice("OrderPersonNotice", "同住人短信通知模板"),
        BillGeneration("BillGeneration", "账单通知缴费提醒"),
        BillPayment("BillPayment", "账单缴费提醒"),
        BillPaymentBigClass("BillPaymentBigClass","大类账单缴费提醒"),
        BillPaymentSmallClass("BillPaymentSmallClass","小类账单缴费提醒"),
        ResetPassword("ResetPassword","重置密码发送新密码"),
        CreateUser("CreateUser","创建用户发送短信"),
        dynamicLogin("dynamicLogin","创建用户发送短信"),
        ;

        public String type;
        public String name;

        SmsType(String type, String name) {
            this.type = type;
            this.name = name;
        }

    }

    // 短信参数key
    @Getter
    public enum SmsParamKey {
        No("no","编号"),
        code("code", "验证码"),
        ApartmentName("apartmentName", "公寓名称"),
        RoomTypeName("roomTypeName", "房型名称"),
        RoomNo("roomNo", "房间号"),
        Address("address", "地址"),
        Phone("phone", "电话"),
        DoorLockPassword("doorLockPassword", "门锁密码"),
        CustomerName("customerName","客户姓名"),
        DeadLine("deadLine","截止日"),
        UserName("userName", "用户名"),
        Password("password", "用户or会员密码"),
        Amount("amount", "金额"),
        StarTimeStr("starTimeStr", "开始时间"),
        EndTimeStr("endTimeStr", "结束时间"),
        Remark("remark","备注"),
        Time("time","操作时间"),
        ;

        public String key;
        public String name;

        SmsParamKey(String key,String name) {
            this.key = key;
            this.name = name;
        }

    }

    //短信验证码业务场景
    public enum ValidCodeBizScene {
        Register("Register", "注册", SmsType.Register),
        ForgetPassword("ForgetPassword", "找回密码", SmsType.ForgetPassword),
        UpdatePhoneNumber("UpdatePhoneNumber", "修改手机号", SmsType.UpdatePhoneNumber),
        BindingMobilePhone("BindingMobilePhone", "绑定手机号", SmsType.BindingMobilePhone),
        DynamicLogin("DynamicLogin", "动态登录的验证码", SmsType.DynamicLogin),
        ElectronicContract("ElectronicContract", "电子合同验证模板", SmsType.ElectronicContract),
        ;

        public String code;
        public String name;
        public SmsType smsType;

        ValidCodeBizScene(String code, String name, SmsType smsType) {
            this.code = code;
            this.name = name;
            this.smsType = smsType;
        }

        public static ValidCodeBizScene getValidCodeBizSceneByCode(String code) {
            for (ValidCodeBizScene bizScene : ValidCodeBizScene.values()) {
                if (code.equals(bizScene.code))
                    return bizScene;
            }
            return null;
        }
    }
}
