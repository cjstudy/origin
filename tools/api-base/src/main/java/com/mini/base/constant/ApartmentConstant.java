package com.mini.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 公寓相关常量类
 *
 * @author Caesar Liu
 * @date 2019/5/6 19:47
 */
public class ApartmentConstant {

    //图片设置操作类型
    public static final Integer PIC_OPERATIONTYPE_ADD = 1; //新增分类及图片
    public static final Integer PIC_OPERATIONTYPE_UPDATEPIC = 2; //新增图片或修改图片描述排序
    public static final Integer PIC_OPERATIONTYPE_UPDATENAME = 3; //修改分类名称
    public static final Integer PIC_OPERATIONTYPE_DELGROUP = 4; //删除分类
    public static final Integer PIC_OPERATIONTYPE_DELPIC = 5; //删除图片

    //全景看房类型
    public enum PanoramaType {
        PIC(1, "本地上传"),
        URL(2, "第三方url");

        public Integer type;
        public String name;

        PanoramaType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public Integer getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }
    }

    //房间出租类型
    public enum RoomRentType {
        CENTRALIZED(1L, "整租"),
        DECENTRALIZED(2L, "散租");

        public Long type;
        public String name;

        RoomRentType(Long type, String name) {
            this.type = type;
            this.name = name;
        }

        public Long getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }
    }

    //交租方式浮动类型
    public @Getter
    enum CalculationType {
        ADD(0, "加"),
        REDUCE(1, "减"),
        FLOAT(2, "浮动");

        public Integer type;
        public String name;

        CalculationType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public Integer getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }
    }

    /**
     * 房间状态
     */
    public @Getter
    enum RoomStatus {

        /**
         * 状态
         */
        AVAILABLE(1, "空置"),
        RESERVED(2, "预定"),
        CKI(3, "入住"),
        LOCKED(4, "锁房"),
        REPAIR(5, "维修"),
        DIRTY(6, "脏房");

        RoomStatus(Integer status, String name) {
            this.status = status;
            this.name = name;
        }

        /**
         * 状态
         */
        private Integer status;
        /**
         * 名称
         */
        private String name;
    }

    /**
     * 房控状态
     */
    public @Getter
    enum RoomControlStatus {

        /**
         * 状态
         */
        AVAILABLE(1, "空置"),
        RESERVED(2, "预定"),
        CKI(3, "入住"),
        LOCKED(4, "锁房"),
        REPAIR(5, "维修");

        RoomControlStatus(Integer status, String name) {
            this.status = status;
            this.name = name;
        }

        /**
         * 状态
         */
        private Integer status;
        /**
         * 名称
         */
        private String name;
    }

    /**
     * 房间标签
     */
    public @Getter
    enum RoomTag {

        /**
         * 标签
         */
        DTZ(1, "待退租"),
        DXZ(2, "待续租"),
        DHF(3, "待换房"),
        JDQ(4, "将到期"),
        ZF(5, "脏房"),
        CZ(6, "催租订单"),
        SBYC(7, "设备异常");

        RoomTag(Integer tag, String name) {
            this.tag = tag;
            this.name = name;
        }

        /**
         * 标签
         */
        private Integer tag;
        /**
         * 名称
         */
        private String name;
    }

    /**
     * 房型类型
     */
    public @Getter
    enum RoomType {
        /**
         * 短租
         */
        SHORT(0L, "短租"),
        LONG(1L, "长租");

        RoomType(Long type, String name) {
            this.type = type;
            this.name = name;
        }

        /**
         * 类型
         */
        private Long type;
        /**
         * 名称
         */
        private String name;
    }

    //公约类型
    public enum TreatyType {
        CHECKIN(0, "入住公约"),
        RELET(1, "续住公约"),
        RESERVE(2, "预订协议"),
        ;

        public Integer type;
        public String name;

        TreatyType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    /**
     * 上架
     */
    public static final Integer ON_SALE = 1;

    /**
     * 下架
     */
    public static final Integer SALE_OUT = 0;


    @AllArgsConstructor
    @Getter
    public enum StrategyType {
        RESERVATION_STRATEGY(1, "保留策略"),
        CANCEL_STRATEGY(2, "取消策略"),
        MARKET_CODE(3, "市场码"),
        SOURCE_CODE(4, "来源码"),
        INCLUDE_CODE(5, "包价码"),
        RENT_BIG_CATEGORY(6, "房价大类");

        /**
         * 类型值
         */
        Integer strategyTypeValue;
        /**
         * 类型名称
         */
        String strategyTypeName;

    }

    @AllArgsConstructor
    @Getter
    public enum ReservationType {
        TOTALPAY("totalPay", "全额预付"),
        SPOTPAY("spotPay", "现付");

        String type;

        String name;

    }

    @AllArgsConstructor
    @Getter
    public enum BizType {

        APARTMENT(1, "公寓"),
        ORGANIZATION(2, "组织");

        Integer type;

        String desc;
    }

    @AllArgsConstructor
    @Getter
    public enum FormulaOperator {
        ADD("add", "+", "加"),
        REDUCE("reduce", "-", "减"),
        MULTIPLY("multiply", "*", "乘");

        String operator;

        String symbol;

        String desc;
    }

    @AllArgsConstructor
    @Getter
    public enum Currency {
        RMB("RMB", "人民币"),
        DOLLAR("Dollar", "美元");

        String type;

        String name;
    }

    @AllArgsConstructor
    @Getter
    public enum RoomVolumeStatus {
        CANSALE(0, "可售"),
        FULL(1, "满房"),
        CLOSE(2, "关房");

        Integer value;

        String name;

    }

    @AllArgsConstructor
    @Getter
    public enum RateCodeBizType {
        APT(1, "公寓"),
        ORG(2, "组织");

        Integer type;

        String name;

    }

    public static List<String> weekMap = Arrays.asList("星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日");

}
