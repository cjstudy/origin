package com.mini.base.utils;

import org.apache.commons.lang.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成器
 * @author Caesar Liu
 * @date 2019/6/25 17:32
 */
public final class Generator {

    // 时间部分
    private static final SimpleDateFormat TIME_PART_FMT = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 产生账务编号
     * @author Caesar Liu
     * @date 2019/6/25 17:33
     */
    public static String genAccountNo() {
         return "AN" + TIME_PART_FMT.format(new Date()) + RandomStringUtils.randomNumeric(4);
    }
}
