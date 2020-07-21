package com.mini.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jack
 * @version 1.0
 * @date 2019/6/3 15:06
 */
public interface SystemConstant {
    /**
     * 系统配置 待催租
     */
    String SYSTEM_CONFIG_TYPE_URGE = "URGE";
    String SYSTEM_CONFIG_CODE_RENTPROMOTION = "RentPromotion";
    String SYSTEM_CONFIG_CODE_INTERVAL = "Interval";

    /**
     * 系统配置 将到期
     */
    String SYSTEM_CONFIG_EXPIRE_TYPE = "EXPIRE";

    String SYSTEM_CONFIG_CODE_WILLEXPIRE = "WillExpire";


    /**
     * 系统配置 待换房
     */
    String SYSTEM_CONFIG_EXCHANGE_TYPE = "EXCHANGE";

    String SYSTEM_CONFIG_CODE_EXCHANGEHOUSES = "ExchangeHouses";

    /**
     * 用户初始密码
     */
    String SYSTEM_CONFIG_TYPE_USER = "USER";
    //用户初始密码
    String SYSTEM_CONFIG_CODE_INITIALPASSWORD = "InitialPassword";

    /**
     * 设备
     */
    String SYSTEM_CONFIG_TYPE_DEVICE = "DEVICE";
    //门锁临时密码有效时间(分钟)
    String SYSTEM_CONFIG_CODE_LOCKPASSWORDTIME = "LockPasswordTime";

    /**
     * 订单
     */
    String SYSTEM_CONFIG_TYPE_ORDER = "ORDER";
    //门锁临时密码有效时间(分钟)
    String SYSTEM_CONFIG_CODE_RESERVATIONDAY = "ReservationDay";


    enum SysConfigCode {
        LOGINERRORCOUNT("LoginErrorCount", "登录失败次数"),
        LOGINLOCKTIME("LoginLockTime", "登录锁定时间(分钟)"),
        CREATETENANTKEY("CreateTenantKey", "新建租户验证key"),
        MAXMONTH("MaxMonth", "可选最大月数"),
        BookingWay("BookingWay", "预订方式"),
        RepeatBooking("RepeatBooking", "允许会员重复预订"),
        CancelOrderMinute("CancelOrderMinute", "自动取消订单时间（分钟）"),
        ReservationFlag("ReservationFlag", "是否能预订"),
        SmsSwitch("SmsSwitch", "短信开关"),

        ;

        public String code;
        public String name;

        SysConfigCode(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public static SystemCode getSystemCodeByCode(String code) {
            for (SystemCode systemCode : SystemCode.values()) {
                if (systemCode.code.equals(code)) {
                    return systemCode;
                }
            }
            return null;
        }
    }

    /**
     * 系统code
     */
    @Getter
    @AllArgsConstructor
    enum SystemCode {
        // 长租
        PMS_LONG("PMS_LONG", "长租"),
        // 短租
        PMS_SHORT("PMS_SHORT", "短租"),
        // 工单
        WORK_ORDER("WORK_ORDER", "工单"),
        // 通用
        COMMON("COMMON", "通用"),
        // 员工端
        PMS_STAFF("PMS_STAFF", "员工端"),
        ;

        public String code;
        public String name;

        public static SystemCode getSystemCodeByCode(String code) {
            for (SystemCode systemCode : SystemCode.values()) {
                if (systemCode.code.equals(code)) {
                    return systemCode;
                }
            }
            return null;
        }

        public static List<SystemCode> getSystemCodeList() {
            return Arrays.asList(SystemCode.values());
        }
    }

    /**
     * 短租夜审TYPE
     */
    String S_NIGHT_TYPE = "SNIGHT";

    /**
     * 短租夜审CODE
     */
    enum SNightSysConfigCode {
        S_NIGHT_START_TIME("SNightStartTime", "短租夜审开始时间"),
        S_NIGHT_END_TIME("SNightEndTime", "短租夜审结束时间"),
        S_FORCE_NIGHT_START_TIME("SForceNightStartTime", "短租强制夜审开始时间"),
        S_FORCE_NIGHT("SForceNight", "短租强制夜审间隔天数"),
        ;
        public String code;
        public String name;

        SNightSysConfigCode(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }
}
