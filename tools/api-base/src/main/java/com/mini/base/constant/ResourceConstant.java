package com.mini.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author:shixinfeng
 * @CreateDate: 2019/7/13 10:56
 * @Description:资源类型枚举
 */
@Getter
@AllArgsConstructor
public enum ResourceConstant {
    APARTMENT("APARTMENT_PIC","apartment", "public"),
    ROOM_TYPE("ROOMTYPE","roomType", "public"),
    TEMPLATE("TEMPLATE","template", "mgtest-file"),
    DEVICE_CODE("DEVICECODE","deviceCode", "mgtest-file"),
    WORK_ORDER("WORKORDER_PIC", "workOrder", "mgtest-img"),
    ESSAY("ESSAY", "essay", "mgtest-img"),
    CONTRACT("CONTRACT", "contract", "mgtest-file"),
    FDD_HTML_CONTRACT("FDDHTMLCONTRACT","fddHtmlContract","mgtest-file"),
    FDD_PDF_CONTRACT("FDDPDFCONTRACT","fddPdfContract","mgtest-file"),
    OTHER("OTHER", "other", "mgtest-img"),
    HEADPIC("HEADPIC", "headPic", "mgtest-img"),
    FDD_SIGN_PIC("FDD_SIGN_PIC","fddSignPic","mgtest-img"),
    CONTENT_PIC("CONTENT_PIC","contentPic","mgtest-img"),
    FDD_CONTRACT("FDD_CONTRACT","fddContract","mgtest-file"),
    ;

    public String bizType;

    public String path;

    public String bucketType;

    public static String getPathByBizType(String bizType) {
        for (ResourceConstant resourceConstant : ResourceConstant.values()) {
            if (resourceConstant.bizType.equals(bizType))
                return resourceConstant.path;
        }

        return "";
    }

    public static boolean isPrivateBucket(String bizType) {
        for (ResourceConstant e: ResourceConstant.values()){
            boolean compareBizTypeResult=e.bizType.equals(bizType);
            if (compareBizTypeResult){
                return  e.bucketType.equals("mgtest-file");
            }
        }
        return false;
//        if (TEMPLATE.bizType.equals(bizType)
//                || DEVICE_CODE.bizType.equals(bizType)
//                || CONTRACT.bizType.equals(bizType))
//            return true;
//
//        return false;
    }

    public static boolean isExistBizType(String bizType) {
        for (ResourceConstant resourceConstant : ResourceConstant.values()) {
            if (resourceConstant.bizType.equals(bizType))
                return true;
        }
        return false;
    }
}
