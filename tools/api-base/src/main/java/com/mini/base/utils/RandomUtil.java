package com.mini.base.utils;

import java.util.Random;

public class RandomUtil {

    /**
     * @Title: getRandomPwd
     * @Description:获取制定长度的密码，包含大小写字母、数字和特殊字符，四种的任意三种
     * @param len
     * @return String
     * @throws
     */
    public static String getRandomPwd(int len) {
        String result = null;
        while(len==len){
            result = makeRandomPwd(len);
            if (result.matches(".*[a-z]{1,}.*") && result.matches(".*[A-Z]{1,}.*") && result.matches(".*\\d{1,}.*") && result.matches(".*[~!@#$.]{1,}.*")) {
                return result;
            }
            result = makeRandomPwd(len);
        }
        return null;
        //return "长度不得少于32位!";
    }

    /**
     * @Title: makeRandomPwd
     * @Description:随机密码生成
     * @param len
     * @return String
     * @throws
     */
    public static String makeRandomPwd(int len) {
        char charr[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~!@#$.".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int x = 0; x < len; ++x) {
            sb.append(charr[r.nextInt(charr.length)]);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String password = getRandomPwd(8);
        System.out.println(password);
    }

}
