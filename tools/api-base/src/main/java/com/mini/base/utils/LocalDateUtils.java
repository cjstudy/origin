package com.mini.base.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LocalDateUtils {

    public static final int WEEK = 1;
    public static final int DOUBLE_WEEK = 2;
    public static final int MONTH = 3;

    //获取当前时间的LocalDate对象
    //LocalDate.now();

    //根据年月日构建LocalDate
    //LocalDate.of();

    //比较日期先后
    //LocalDate.now().isBefore(),
    //LocalDate.now().isAfter(),

    // String转换为LocalDate
    public static LocalDate parse(String date, String pattern) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(date, df);
    }

    //Date转换为LocalDate
    public static LocalDate parse(Date date) {
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.toLocalDate();
    }

    //localDateTime转换为LocalDate
    public static LocalDate parse(LocalDateTime time) {
        return time.toLocalDate();
    }

    //LocalDate转换为Date
    public static Date convertToDate(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }


    //获取默认的指定格式
    public static String formatDate(LocalDate time) {
        return time.format(DateTimeFormatter.ofPattern(DateUtil.PATTERN_DATE));
    }

    //获取指定时间的指定格式
    public static String formatTime(LocalDate time) {
        return time.format(DateTimeFormatter.ofPattern(DateUtil.PATTERN_DATETIME));
    }

    //获取指定时间的指定格式
    public static String formatTime(LocalDate time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    //获取当前时间的指定格式
    public static String formatNow(String pattern) {
        return formatTime(LocalDate.now(), pattern);
    }

    //日期加上一个数,根据field不同加不同值,field为ChronoUnit.*
    public static LocalDate plus(LocalDate time, long number, ChronoUnit field) {
        return time.plus(number, field);
    }

    //日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*
    public static LocalDate minu(LocalDate time, long number, ChronoUnit field) {
        return time.minus(number, field);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     *
     * @param startTime
     * @param endTime
     * @param field     单位(年月日)
     * @return
     */
    public static long betweenTwoDate(LocalDate startTime, LocalDate endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) return period.getYears();
        if (field == ChronoUnit.MONTHS) return period.getYears() * 12 + period.getMonths();
        return field.between(startTime, endTime);
    }

    /**
     * 将一段日期按单周、双周、月等分组
     *
     * @param start
     * @param end
     * @param type
     * @return
     * @author Jack
     */
    public static List<String> splitDateByCycle(LocalDate start, LocalDate end, int type) {
        switch (type) {
            case WEEK:
                return dateGroupByWeek(start, end, 6);
            case DOUBLE_WEEK:
                return dateGroupByWeek(start, end, 13);
            case MONTH:
                return dateGroupByMonth(start, end);
            default:
                return null;
        }
    }

    /**
     * 按单周或双周分组
     *
     * @param startDate
     * @param endDate
     * @param periodDays
     * @return
     * @author Jack
     */
    private static List<String> dateGroupByWeek(LocalDate startDate, LocalDate endDate, int periodDays) {

        checkDate(startDate, endDate);

        List<String> result = new ArrayList<>();


        int dayOfWeek = startDate.getDayOfWeek().getValue();

        LocalDate currentWeekEnd = startDate.plusDays(periodDays - dayOfWeek);

        //结束时间未到周末
        if (currentWeekEnd.isAfter(endDate)) {
            result.add(startDate.toString() + "至" + endDate.toString());
        } else {
            //结束时间在周末之后
            while (currentWeekEnd.isBefore(endDate) || currentWeekEnd.isEqual(endDate)) {
                result.add(startDate.toString() + "至" + currentWeekEnd.toString());
                //更新新的一周的开始时间
                startDate = currentWeekEnd.plusDays(1);
                dayOfWeek = startDate.getDayOfWeek().getValue();
                currentWeekEnd = startDate.plusDays(periodDays - dayOfWeek);
            }
        }

        if (currentWeekEnd.isAfter(endDate) && (startDate.isBefore(endDate) || startDate.isEqual(endDate))) {
            result.add(startDate.toString() + "至" + endDate.toString());
        }

        return result;
    }

    /**
     * 按月分组
     *
     * @param startDate
     * @param endDate
     * @return
     * @author Jack
     */
    private static List<String> dateGroupByMonth(LocalDate startDate, LocalDate endDate) {

        checkDate(startDate, endDate);
        List<String> result = new ArrayList<>();

        LocalDate currentMonthEnd = startDate.with(TemporalAdjusters.lastDayOfMonth());
        //结束时间当月月底之前
        if (currentMonthEnd.isAfter(endDate)) {
            result.add(startDate.toString() + "至" + endDate.toString());
        } else {
            while (currentMonthEnd.isBefore(endDate) || currentMonthEnd.isEqual(endDate)) {
                result.add(startDate.toString() + "至" + currentMonthEnd.toString());
                //更新新的一个月的开始时间
                startDate = currentMonthEnd.plusDays(1);
                currentMonthEnd = startDate.with(TemporalAdjusters.lastDayOfMonth());
            }
        }

        if (currentMonthEnd.isAfter(endDate) && (startDate.isBefore(endDate) || startDate.isEqual(endDate))) {
            result.add(startDate.toString() + "至" + endDate.toString());
        }
        return result;
    }

    /**
     * 检查时间的合法性
     *
     * @param startDate
     * @param endDate
     * @author Jack
     */
    private static void checkDate(LocalDate startDate, LocalDate endDate) {
        if (endDate.isBefore(startDate) || endDate.isEqual(startDate)) {
            throw new IllegalArgumentException("结束时间必须大于开始时间");
        }
    }


    /**
     * 获取两个日期的差  相差几年几个月几天
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static String betweenTwoDate(LocalDate startTime, LocalDate endTime) {
        LocalDate plusDays = endTime.plusDays(1);

        int fromYear = startTime.until(plusDays).getYears();
        int fromMonth = startTime.until(plusDays).getMonths();
        int fromDay = startTime.until(plusDays).getDays();

        StringBuffer between = new StringBuffer();
        if (fromYear > 0) {
            between.append(fromYear + "年");
        }
        if (fromMonth > 0) {
            between.append(fromMonth + "月");
        }
        if (fromDay > 0) {
            between.append(fromDay + "天");
        }
        return between.toString();
    }


    /**
     * 获取两个日期的差  相差几年几个月几天
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static String betweenDate(LocalDate startTime, LocalDate endTime) {
        LocalDate plusDays = endTime.plusDays(1);
        long between = plusDays.toEpochDay() - startTime.toEpochDay();
        return between == 0 ? "" : between + "天";
    }

    /**
     * 获取时间段内的指定星期的日期集合
     *
     * @param startDate
     * @param endDate
     * @param effectiveWeeks
     * @return
     */
    public static List<LocalDate> getTotalDate(LocalDate startDate, LocalDate endDate, String effectiveWeeks) {
        long days = endDate.toEpochDay() - startDate.toEpochDay();

        List<LocalDate> result = new ArrayList<>();
        if (effectiveWeeks == null) {
            for (int i = 0; i <= days; i++) {
                LocalDate currentDate = startDate.plusDays(i);
                result.add(currentDate);
            }
        } else {
            List<String> totalWeeks = Arrays.asList(effectiveWeeks.split(","));
            for (int i = 0; i <= days; i++) {
                LocalDate currentDate = startDate.plusDays(i);
                int dayOfWeek = currentDate.getDayOfWeek().getValue();
                if (totalWeeks.contains(dayOfWeek + "")) {
                    result.add(currentDate);
                }
            }
        }

        return result;
    }

    /**
     * 将日期 转为年月日 如"2012年10月1日"
     *
     * @param date
     * @return
     */
    public static String convert(LocalDate date) {
        if(date == null){
            return "";
        }
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        return year+"年"+month+"月"+day+"日";
    }

    /**
     * 计算两个日期的相差月份  向上取整
     * @param startDate
     * @param endDate
     * @return
     */
    public static int betweenMonth(LocalDate startDate, LocalDate endDate) {
        if(startDate.getYear() == endDate.getYear() && startDate.getMonthValue() == endDate.getMonthValue()){
            return 1;
        }
        startDate = startDate.plusDays(-1);
        int months = startDate.until(endDate).getMonths();
        int compare = startDate.plusMonths(months).compareTo(endDate);
        if(compare == 0){
            return months;
        }
        else if(compare < 0){
            return months+1;
        }
        else{
            return months-1;
        }
    }

}
