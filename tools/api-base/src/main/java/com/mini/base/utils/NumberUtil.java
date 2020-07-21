package com.mini.base.utils;

import java.text.DecimalFormat;

public class NumberUtil {

    /**
     * 将阿拉伯数字转换为欢子
     *
     * @param number 数字
     * @return 汉字
     */
    public static String numberToChinese(Integer number) {
        String[] s1 = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] s2 = {"十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};

        String result = "";

        if (number == null) {
            return result;
        }

        String str = number + "";

        int n = str.length();
        for (int i = 0; i < n; i++) {

            int num = str.charAt(i) - '0';

            if (n > 1 && (num == 0)) {
                continue;
            }

            if (i != n - 1 && num != 0) {
                if (s1[num].equals("一") && n == 2) {
                    result += s2[n - 2 - i];
                } else {
                    result += s1[num] + s2[n - 2 - i];
                }
            } else {
                result += s1[num];
            }
        }

        return result;
    }

    private static DecimalFormat numberFormat = new DecimalFormat("#0.00");

    /**
     *
     * @param obj
     * @return
     */
    public static String getStringTowDecimal(Object obj) {
        String decodeStr = "";
        try {
            decodeStr = StringUtils.isEmpty(obj+"") ? "0" : obj.toString();
            decodeStr = numberFormat.format(Double.valueOf(decodeStr));
        } catch (Exception e) {
            decodeStr = (String) obj;
        }
        return decodeStr;
    }

    /**
     * 两位小数百分比
     * @param num
     * @return
     */
    public static String getStringPercentageTowDecimal(Number num) {
        Double dou = (Double) num * 100;
        return getStringTowDecimal(dou)+"%";
    }
}
