/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ParamsFilterUtil.java
 * Author:   HUQIANBO
 * Date:     2016-04-29 11:01:47
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO>  <2016-04-29 11:01:47> <version>   <desc>
 *
 */

package com.mini.base.utils;


import org.apache.commons.lang.StringUtils;

public class ParamsFilterUtil {

	/**
	 *  将容易引起xss漏洞和sql注入的字符直接替换
	 *
	 * @param value
	 * @return
	 */
	public static String cleanXSS(String value) {
		if(StringUtils.isEmpty(value)) return null;
		// You'll need to remove the spaces from the html entities below
		value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
		value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
				"\"\"");
		value = value.replaceAll("-xie-", "/").trim();
		value = value.replaceAll("%", "").trim();
		value = value.replaceAll("\'", "").trim();
		value = value.replaceAll("script", "");
		return value.trim();
	}

	/**
	 *  将容易引起xss漏洞和sql注入的字符直接替换
	 *
	 * @param value
	 * @return
	 */
	public static String cleanXSSEasy(String value) {
		if(StringUtils.isEmpty(value)) return null;
		// You'll need to remove the spaces from the html entities below
		value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("-xie-", "/").trim();
		value = value.replaceAll("%", "").trim();
		value = value.replaceAll("\'", "").trim();
		value = value.replaceAll("script", "");
		return value.trim();
	}

    //sql关键词效验，防止sql注入
    public static boolean sqlValidate(String str) {
        if(StringUtils.isEmpty(str)) return false;
        str = str.toLowerCase();//统一转为小写
        String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|" +
                "char|declare|sitename|net user|xp_cmdshell|;|or|-|+|,|like'|and|exec|execute|insert|create|drop|" +
                "table|from|grant|use|group_concat|column_name|" +
                "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|" +
                "chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#";//过滤掉的sql关键字，可以手动添加
        String[] badStrs = badStr.split("\\|");
        for (int i = 0; i < badStrs.length; i++) {
            if (str.indexOf(badStrs[i]) >= 0) {
                return true;
            }
        }
        return false;
    }

    //sql关键词过滤，防止sql注入
    public static String cleanSql(String str) {
        if(StringUtils.isEmpty(str)) return str;
        String str2 = str.toLowerCase();//统一转为小写
        String[] sqlStr1 = {"and", "exec", "execute", "insert", "select", "delete", "update", "count",
                "drop", "chr", "mid", "master", "truncate", "char", "declare", "sitename", "net user",
                "xp_cmdshell", "like", "and", "exec", "execute", "insert", "create", "drop", "table", "from",
                "grant", "use", "group_concat", "column_name", "information_schema.columns", "table_schema",
                "union", "where", "select", "delete", "update", "order", "by", "count", "chr", "mid", "master",
                "truncate", "char", "declare", "or"};//词语
        String[] sqlStr2 = {"*", "'", ";", "or", "-", "--", "+", "//", "/", "%", "#"};//特殊字符

        for (int i = 0; i < sqlStr1.length; i++) {
            if (str2.indexOf(sqlStr1[i]) >= 0) {
                str = str.replaceAll("(?i)" + sqlStr1[i], "");//正则替换词语，无视大小写
            }
        }
        for (int i = 0; i < sqlStr2.length; i++) {
            if (str2.indexOf(sqlStr2[i]) >= 0) {
                str = str.replaceAll(sqlStr2[i], "");
            }
        }

        return str;
    }

    public static void main(String[] args) {
        boolean a = sqlValidate("a1nd1 1= 1");
        System.out.println(a);
    }

}
