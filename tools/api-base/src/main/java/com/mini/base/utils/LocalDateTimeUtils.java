package com.mini.base.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class LocalDateTimeUtils {
    //获取当前时间的LocalDateTime对象
    //LocalDateTime.now();

    //根据年月日构建LocalDateTime
    //LocalDateTime.of();

    //比较日期先后
    //LocalDateTime.now().isBefore(),
    //LocalDateTime.now().isAfter(),

    // String转换为LocalDateTime
    public static LocalDateTime convertStringToLDT(String date, String pattern) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(date, df);
    }

    //Date转换为LocalDateTime
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    //LocalDateTime转换为Date
    public static Date convertLDTToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }


    //获取指定日期的毫秒
    public static Long getMilliByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    //获取指定日期的秒
    public static Long getSecondsByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    //获取默认的指定格式
    public static String formatDate(LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern(DateUtil.PATTERN_DATE));
    }

    //获取指定时间的指定格式
    public static String formatTime(LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern(DateUtil.PATTERN_DATETIME));
    }

    //获取指定时间的指定格式
    public static String formatTime(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    //获取当前时间的指定格式
    public static String formatNow(String pattern) {
        return  formatTime(LocalDateTime.now(), pattern);
    }

    //日期加上一个数,根据field不同加不同值,field为ChronoUnit.*
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    //日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*
    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field){
        return time.minus(number,field);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     * @param startTime
     * @param endTime
     * @param field  单位(年月日时分秒)
     * @return
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) return period.getYears();
        if (field == ChronoUnit.MONTHS) return period.getYears() * 12 + period.getMonths();
        return field.between(startTime, endTime);
    }

    //获取一天的开始时间，2017,7,22 00:00
    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    //获取一天的结束时间，2017,7,22 23:59:59.999999999
    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999999);
    }

    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(2019, 10, 13, 11, 11);
        LocalDateTime end = LocalDateTime.of(2019, 11, 13, 13, 13);
        System.out.println("年:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.YEARS));
        System.out.println("月:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.MONTHS));
        System.out.println("日:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.DAYS));
        System.out.println("半日:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.HALF_DAYS));
        System.out.println("小时:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.HOURS));
        System.out.println("分钟:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.MINUTES));
        System.out.println("秒:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.SECONDS));
        System.out.println("毫秒:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.MILLIS));



        //LocalDateTime ss = convertStringToLDT("2019-05-22", DateUtil.PATTERN_DATE);
        LocalDateTime ss1 = convertStringToLDT("2019-05-22 12:55:10", DateUtil.PATTERN_DATETIME);

        //增加3天
        System.out.println(LocalDateTimeUtils.formatTime(LocalDateTimeUtils.plus(LocalDateTime.now(),
                3,
                ChronoUnit.DAYS), DateUtil.PATTERN_DATE));

    }

}
