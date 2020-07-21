package com.mini.base.constant;

/**
 * @Author:WN
 * @CreateDate: 2019/9/5 18:53
 * @Description:
 */
public class SRoomControlConstant {
    /**
     * 房控状态
     */
    public enum SRoomControlStatus {
        ED(1, "空脏"),
        EC(2, "空净"),
        CI(3, "入住"),
        OU(4, "自用"),
        RP(5, "维修"),
        ;

        public Integer status;
        public String name;

        SRoomControlStatus(int status, String name) {
            this.status = status;
            this.name = name;
        }
    }
}
