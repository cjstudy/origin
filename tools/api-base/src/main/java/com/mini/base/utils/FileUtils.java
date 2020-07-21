package com.mini.base.utils;

import java.io.*;

/**
 * @author Jack
 * @version 1.0
 * @date 2019/8/15 10:54
 */
public class FileUtils {

    /**
     * 字符串转文件
     *
     * @param res
     * @param prefix
     * @param suffix
     * @return
     */
    public static File string2File(String res, String prefix, String suffix) {
        boolean flag = true;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        File distFile = null;
        try {
            distFile = File.createTempFile(prefix, suffix);
            System.out.println(distFile.getAbsolutePath());
            bufferedReader = new BufferedReader(new StringReader(res));
            bufferedWriter = new BufferedWriter(new FileWriter(distFile));
            //字符缓冲区
            char[] buf = new char[1024];
            int len;
            while ((len = bufferedReader.read(buf)) != -1) {
                bufferedWriter.write(buf, 0, len);
            }
            bufferedWriter.flush();
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
            return distFile;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return distFile;
    }
}
