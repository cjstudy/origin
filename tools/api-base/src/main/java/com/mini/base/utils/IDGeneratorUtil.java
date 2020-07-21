package com.mini.base.utils;

import java.util.UUID;

/**
 * java实现随机生成UUID
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class IDGeneratorUtil {

    private static long num = 0;

    /**
     * 随机生成UUID
     *
     * @return
     */
    public static synchronized String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        return uuidStr;
    }

    /**
     * 根据字符串生成固定UUID
     *
     * @param name
     * @return
     */
    public static synchronized String getUUID(String name) {
        UUID uuid = UUID.nameUUIDFromBytes(name.getBytes());
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        return uuidStr;
    }

    /**
     * 根据日期生成长整型id
     *
     * @param args
     */
//    public static synchronized long getLongId() {
//        String date = DateUtil.getDate2FormatString(new Date(), "yyyyMMddHHmmssS");
//        System.out.println("原始id=" + date);
//        if (num >= 99) num = 0l;
//        ++num;
//        if (num < 10) {
//            date = date + 00 + num;
//        } else {
//            date += num;
//        }
//        return Long.valueOf(date);
//    }

}
