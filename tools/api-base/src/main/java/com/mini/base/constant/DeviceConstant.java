package com.mini.base.constant;

import com.mini.base.api.IResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 设备相关常量类
 *
 * @author huqianbo
 * @date 2019/6/18 18:05
 */
public class DeviceConstant {

    // 抄表类型
    public enum ReadType {
        CHECKIN(1, "入住抄表"),
        TEMPORARY(2, "临时抄表"),
        MONTH(3, "月度抄表"),
        EXCHANGE(4, "换房抄表"),
        MANUAL(5, "手工抄表"),
        CHECKOUT(9, "退租抄表"),
        ;

        public int type;
        public String name;

        ReadType(int type, String name) {
            this.type = type;
            this.name = name;
        }

    }

    // 设备类型
    @Getter
    @AllArgsConstructor
    public enum DeviceTypeEnum {
        ELECTRIC("10", "电表","度"),
        COLD_WATER("20", "冷水表","m³"),
        HOT_WATER("30", "热水表","m³"),
        RECLAIMED_WATER("40", "中水表","m³"),
        COAL_GAS("50", "煤气表","m³"),
        DOOR_LOCK("60", "门锁",""),
        ;

        public String code;
        public String name;
        public String unit;

        public static boolean containsCode(String code) {
            for (DeviceTypeEnum e : DeviceTypeEnum.values()) {
                if (StringUtils.equals(e.getCode(), code)) {
                    return true;
                }
            }

            return false;
        }

        public static String getNameByCode(String code) {
            for (DeviceTypeEnum e : DeviceTypeEnum.values()) {
                if (StringUtils.equals(e.getCode(), code)) {
                    return e.getName();
                }
            }

            return null;
        }

        public static String getUnitByCode(String code) {
            for (DeviceTypeEnum e : DeviceTypeEnum.values()) {
                if (StringUtils.equals(e.getCode(), code)) {
                    return e.getUnit();
                }
            }

            return null;
        }

        public static List<String> getDeviceTypeCodes(List<String> excludeCodeList) {
            List<String> typeCodes = Arrays.stream(DeviceTypeEnum.values()).map(DeviceTypeEnum::getCode).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(excludeCodeList)){
                typeCodes.removeAll(excludeCodeList);
            }
            return typeCodes;
        }
    }

    // 供应商
    public enum VendorCode {
        JOYMETER("joymeter", "超仪"),
        DDING("dding", "云丁");

        public String type;
        public String name;

        VendorCode(String type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    // 设备抄表范围
    public enum ReadingRange {
        DEVICE(1, "根据设备"),
        ROOM(2, "根据房间"),
        APARTMENT(3, "根据公寓"),
        QUERY(4, "组合条件");

        public Integer type;
        public String name;

        ReadingRange(Integer type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    // 设备异常类型
    public enum ErrorType {
        READING_FAIL(1, "抄表失败"),
        VALUE_ANOMALY(2, "读数异常"),
        DEVICE_OFFLINE(3, "设备离线"),
        PWD_OPER_FAIL(4, "操作密码失败");

        public Integer type;
        public String name;

        ErrorType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public static String getNameByType(Integer type) {
            for (ErrorType e : ErrorType.values()) {
                if (e.type == type) {
                    return e.name;
                }
            }

            return null;
        }
    }

    // 门锁设备状态
    public enum DeviceStatus {
        NORMAL(0, "正常"),
        FREEZE(-1, "冻结");

        public Integer type;
        public String name;

        DeviceStatus(Integer type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    // 门锁设备状态
    public enum DoorLockStatus {
        ON(1, "在线"),
        OFF(2, "离线");

        public Integer type;
        public String name;

        DoorLockStatus(Integer type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    /**
     * 字典响应码（18开头）
     */
    @Getter
    @AllArgsConstructor
    public enum ResultCode implements IResultCode {
        READING_FAIL(1800, "接口返回失败", ErrorType.READING_FAIL),
        DEVICE_OFF_LINE(1801, "设备未安装或处于离线状态", ErrorType.DEVICE_OFFLINE),
        PWD_ADD_FAIL(1802, "添加密码接口返回失败", ErrorType.PWD_OPER_FAIL),
        PWD_UPDATE_FAIL(1803, "修改密码接口返回失败", ErrorType.PWD_OPER_FAIL),
        PWD_DELETE_FAIL(1804, "删除密码接口返回失败", ErrorType.PWD_OPER_FAIL),
        PWD_ENDIS_FAIL(1804, "启禁用密码接口返回失败", ErrorType.PWD_OPER_FAIL);

        private int code;

        private String message;

        private ErrorType errorType;

        public static ErrorType getErrorTypeByCode(Integer code) {
            for (ResultCode e : ResultCode.values()) {
                if (e.code == code) {
                    return e.errorType;
                }
            }
            return null;
        }
    }

    //密码类型
    public enum DevicePasswordType {
        PERMANENT_PASSWORD(1, "永久密码"),
        TEMPORARY_PASSWORD(2, "临时密码"),
        TENANT_PASSWORD(3, "租客密码"),
        ;
        public Integer type;
        public String name;

        DevicePasswordType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    //门锁操作类型类型
    public enum LockOperaterType {
        PERMANENT_PASSWORD(1, "永久密码"),
        TEMPORARY_PASSWORD(2, "临时密码"),
        RESET_PASSWORD(3, "重置密码"),
        FREEZE_LOCK(4, "冻结"),
        UNFREEZE_LOCK(5, "解冻"),
        ;

        public Integer type;
        public String name;

        LockOperaterType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public static String getLockOperaterTypeName(Integer type) {
            for (LockOperaterType e : LockOperaterType.values()) {
                if (e.type == type) {
                    return e.name;
                }
            }
            return null;
        }
    }

    //门锁操作类型类型
    public enum LockOperaterResult {

        SUCCESS(1, "成功"),
        FAIL(2, "失败"),
        ;

        public Integer type;
        public String name;

        LockOperaterResult(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public static String getLockOperaterResultName(Integer type) {
            for (LockOperaterResult e : LockOperaterResult.values()) {
                if (e.type == type) {
                    return e.name;
                }
            }
            return null;
        }
    }

}
