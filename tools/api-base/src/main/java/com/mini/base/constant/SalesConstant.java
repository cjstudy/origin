package com.mini.base.constant;

import java.util.Arrays;
import java.util.List;

/**
 * 出售相关常量类
 * @author dongfnag.liu
 * @date 2019/06/12 19:47
 */
public interface SalesConstant {
    /**
     * 需要初始化的推荐
     */
    List<Integer> initRecomment = Arrays.asList(Recomment.APARTMENT_SHOW.type, Recomment.SHOP_SHOW.type);

    List<String> initRecommentName = Arrays.asList(Recomment.APARTMENT_SHOW.name, Recomment.SHOP_SHOW.name);

    //文章状态
    public enum ArticleStatus {
        RELEASED(0, "发布"),
        UN_RELEASED(1, "未发布");

        public Integer type;
        public String name;

        ArticleStatus(Integer type, String name) {
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

    //广告类型
    public enum AdType {
        CENTER_AD(0, "中心广告"),
        CITY_AD(1, "城市广告");

        public Integer type;
        public String name;

        AdType(Integer type, String name) {
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

    //广告内容类型
    public enum AdItemType {
        LINK(0, "链接"),
        APARTMENT(1, "公寓"),
        ROOM(2, "房间"),
        ESSAY(3, "文章"),
        ROOM_TYPE(4, "房型"),
        AIMLESS(5, "无目标");

        public Integer type;
        public String name;

        AdItemType(Integer type, String name) {
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

    //推荐
    public enum Recomment {
        APARTMENT_SHOW(0, "首页-公寓展示"),
        SHOP_SHOW(1, "首页-房间展示");

        public Integer type;
        public String name;

        Recomment(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public Integer getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }
        public static String getNameByType(Integer type) {
            if (type == null) {
                return null;
            }
            for (Recomment recomment : Recomment.values()) {
                if (recomment.type.equals(type)) {
                    return recomment.name;
                }
            }
            return null;
        }
    }
}
