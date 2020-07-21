package com.mini.base.constant;


public class SpecDetailConstant {
    public enum SpecDetail{
        ROOMTYPE_DETAIL(1, "房型"),
        BEDTYPE_DETAIL(2, "床型"),
        ARTICLE_DETAIL(3, "物品")
        ;

        public Integer type;
        public String name;

        SpecDetail(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public Integer type() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }
    }
}
