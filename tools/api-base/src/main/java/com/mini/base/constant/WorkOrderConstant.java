package com.mini.base.constant;

import lombok.Getter;

/**
 * @author Jack
 * @version 1.0
 * @date 2019/6/12 19:52
 */
public interface WorkOrderConstant {

    @Getter
    enum WorkOrderType {
        //工单类型
        CLEAN("1", "保洁工单"),
        REPAIR("2", "维修工单"),
        COMPLAINT("3", "投诉工单");

        private String type;
        private String name;

        WorkOrderType(String type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    @Getter
    enum ItemType {
        //子类型
        NORMAL_CLEAN(1000, "常规保洁"),
        DEEP_CLEAN(1001, "深度保洁"),
        C3_REPAIR(2000, "家电维修"),
        WINDOW_REPAIR(2001, "门窗维修"),
        NEIGHBOUR_PROBLEM(3000, "邻里纠纷"),
        SERVICE_PROBLEM(3001, "服务问题");

        private Integer type;
        private String name;

        ItemType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    @Getter
    enum WorkOrderStatus {
        //状态
        TO_DEAL(0, "待受理"),
        DEALED(1, "已受理"),
        DEALING(2, "服务中"),
        TO_CHECK(3, "待检查"),
        FINISH(4, "已完成"),
        CANCELED(5, "已取消");


        private Integer status;

        private String name;

        WorkOrderStatus(Integer status, String name) {
            this.status = status;
            this.name = name;
        }
    }

    @Getter
    enum CleanOrderCycle {
        //周期
        WEEK_SINGLE(1, "单周"),
        WEEK_DOUBLE(2, "双周"),
        MONTH_SINGLE(3, "单月"),
        MONTH_DOUBLE(4, "双月");

        private Integer cycle;
        private String name;

        CleanOrderCycle(Integer cycle, String name) {
            this.cycle = cycle;
            this.name = name;
        }
    }

}
