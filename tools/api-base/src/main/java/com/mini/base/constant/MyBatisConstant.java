package com.mini.base.constant;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * myBatis相关常量
 * @author Caesar Liu
 * @date 2019/5/6 19:47
 */
public class MyBatisConstant {


    //过滤不需要查询租户id的表
    @Getter
    public enum FilterTenantIdTable {
        SERIAL_NUM("serial_num"),
        AREA("area"),
        SYSTEM("system"),
        MENU("menu"),
        ACTION("action"),
        ;

        public String name;

        FilterTenantIdTable(String name) {
            this.name = name;
        }

        public static List<String> getTableNames() {
            List<String> tableNames = Arrays.stream(FilterTenantIdTable.values()).map(FilterTenantIdTable::getName).collect(Collectors.toList());
            return tableNames;
        }

    }


    public static void main(String[] args) {
        System.out.println(FilterTenantIdTable.getTableNames());
    }




}
