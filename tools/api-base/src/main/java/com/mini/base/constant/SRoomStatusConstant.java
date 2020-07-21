package com.mini.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author:WN
 * @CreateDate: 2019/9/5 18:58
 * @Description:
 */
public class SRoomStatusConstant {

    /**
     * 房间标签
     */
    @Getter
    @AllArgsConstructor
    public enum SRoomStatus {
        LR(1, "锁房"),
        DR(2, "脏房"),
        SR(3, "保密房"),
        DD(4, "免打扰"),
        ED(5, "预计离店"),
        OT(6, "欠费"),
        ;
        public Integer status;
        public String name;
    }

    /**
     * 租控图-房间详情操作类型
     */
    @Getter
    @AllArgsConstructor
    public enum SRoomOperationType {
        //房态
        ZY(1, "置自用"),
        WX(2, "置维修"),
        WXWC(3, "维修完成"),
        JSZY(4, "结束自用"),
        QJWC(5, "清洁完成"),
        //标签
        SF(1, "锁房"),
        QXSF(2, "取消锁房"),
        BM(3, "保密"),
        MDR(4, "免打扰"),
        QXBM(5, "取消保密"),
        QXMDR(6, "取消免打扰"),
        QF(7, "欠费"),
        QXQF(8, "取消欠费"),
        ;
        public Integer type;
        public String name;

    }

    /**
     * 请求类型:租控图房间信息设置请求对象请求类型
     */
    @Getter
    @AllArgsConstructor
    public enum RoomRequestType {
        // 请求类型-c:房态
        C("c", "房态"),
        // 请求类型-t:标签
        T("t", "标签"),
        ;
        private String type;
        private String name;
    }

}
