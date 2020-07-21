package com.mini.base.utils;

import com.mini.base.constant.SmsConstant;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字串工具类
 *
 * @author kingapex 2010-1-6下午01:52:58
 */
public class StringUtil {

    private StringUtil() {
    }


    /**
     * 将一个Double转为int的String，将省略小数点后面的值
     *
     * @param d
     * @return
     */
    public static String doubleToIntString(Double d) {
        int value = d.intValue();
        return String.valueOf(value);
    }

    /**
     * 检查浮点数
     *
     * @param num
     * @param type "0+":非负浮点数 "+":正浮点数 "-0":非正浮点数 "-":负浮点数 "":浮点数
     * @return
     */
    public static boolean checkFloat(String num, String type) {
        String eL = "";
        if (type.equals("0+"))
            eL = "^\\d+(\\.\\d+)?$";// 非负浮点数
        else if (type.equals("+"))
            eL = "^((\\d+\\.\\d*[1-9]\\d*)|(\\d*[1-9]\\d*\\.\\d+)|(\\d*[1-9]\\d*))$";// 正浮点数
        else if (type.equals("-0"))
            eL = "^((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))$";// 非正浮点数
        else if (type.equals("-"))
            eL = "^(-((\\d+\\.\\d*[1-9]\\d*)|(\\d*[1-9]\\d*\\.\\d+)|(\\d*[1-9]\\d*)))$";// 负浮点数
        else
            eL = "^(-?\\d+)(\\.\\d+)?$";// 浮点数
        Pattern p = Pattern.compile(eL);
        Matcher m = p.matcher(num);
        boolean b = m.matches();
        return b;
    }

    /**
     * 检测某字串是否存在某数组中
     *
     * @param value
     * @param array
     * @return 存在返回真，不存在返回假
     */
    public static boolean isInArray(String value, String[] array) {
        if (array == null)
            return false;
        for (String v : array) {
            if (v.equals(value))
                return true;
        }
        return false;

    }

    public static boolean isInArray(int value, String[] array) {
        if (array == null)
            return false;
        for (String v : array) {
            if (Integer.valueOf(v).intValue() == value)
                return true;
        }
        return false;
    }

    /**
     * 将数组成str连接成字符串
     *
     * @param str
     * @param array
     * @return
     */
    public static String implode(String str, Object[] array) {
        if (str == null || array == null) {
            return "";
        }
        String result = "";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                result += array[i].toString();
            } else {
                result += array[i].toString() + str;
            }
        }
        return result;
    }

    /**
     * 字符串分割转换  a,b,c 转成 'a','b','c'
     *
     * @param str
     * @return
     */
    public static String spiltStr(String str) {
        StringBuffer sb = new StringBuffer();
        String[] temp = str.split(",");
        for (int i = 0; i < temp.length; i++) {
            if (!"".equals(temp[i]) && temp[i] != null)
                sb.append("'" + temp[i] + "',");
        }
        String result = sb.toString();
        String tp = result.substring(result.length() - 1, result.length());
        if (",".equals(tp)) {
            return result.substring(0, result.length() - 1);
        } else {
            return result;
        }
    }

    public static String implodeValue(String str, Object[] array) {
        if (str == null || array == null) {
            return "";
        }
        String result = "";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                result += "?";
            } else {
                result += "?" + str;
            }
        }
        return result;
    }

    /**
     * MD5加密方法
     *
     * @param str String
     * @return String
     */
    public static String md5(String str) {
        return md5(str, true);
    }

    public static String md5(String str, boolean zero) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
        byte[] resultByte = messageDigest.digest(str.getBytes());
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < resultByte.length; ++i) {
            int v = 0xFF & resultByte[i];
            if (v < 16 && zero)
                result.append("0");
            result.append(Integer.toHexString(v));
        }
        return result.toString();
    }


    public static void main(String[] args) {

        LinkedHashMap<SmsConstant.SmsParamKey, String> paramMap = new LinkedHashMap<>();
        paramMap.put(SmsConstant.SmsParamKey.No,"001");
        paramMap.put(SmsConstant.SmsParamKey.Address,"上海市");

        String[] arr = new String[paramMap.size()];

        int i = 0;
        for (Map.Entry<SmsConstant.SmsParamKey, String> entry : paramMap.entrySet()) {
            arr[i] = entry.getValue();
            i++;
        }


        String content = StringUtil.fillStringByArgs("您收到一个派单了，{0}工单的编号，{1}执行工单的地点或区域",arr);

        System.out.println(StringUtil.isNotEmpty(null));


/*
		String s = "搜索";
//		s = encode(s);
		s = "&1-"+encode(encode(s))+"&";
		System.out.println(s);
		System.out.println(StringUtils.remove(s, "&1-" + encode(encode("搜索"))));
//		s = encode(s);
//		System.out.println(s);
		System.out.println(decode(decode(s)));
*/
        //String s = null;
        //System.out.println(validMaxLen(s, 0));

//		//System.out.println(md5.getMD5("123456".getBytes()) );
        //System.out.println( md5("123456"));
    }


    /**
     * 验证Email地址是否有效
     *
     * @param sEmail
     * @return
     */
    public static boolean validEmail(String sEmail) {
        String pattern = "^([a-z0-9A-Z]+[-|\\.|_]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return sEmail.matches(pattern);
    }

    /**
     * 验证字符最大长度
     *
     * @param str
     * @return
     */
    public static boolean validMaxLen(String str, int length) {
        if (str == null || str.equals("")) {
            return false;
        }
        return str.length() <= length;
    }

    /**
     * 验证字符最小长度
     *
     * @param str
     * @return
     */
    public static boolean validMinLen(String str, int length) {
        if (str == null || str.equals("")) {
            return false;
        }
        return str.length() >= length;
    }

    /**
     * 验证一个字符串是否为空
     *
     * @param str
     * @return 如果为空返回真，如果不为空返回假
     */

    public static boolean isEmpty(String str) {
        return !isNotEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        if (str == null || "".equals(str.trim()))
            return false;

        String pattern = "\\S";
        Pattern p = Pattern.compile(pattern, 2 | Pattern.DOTALL);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 验证两个字符串是否相等且不能为空
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equals(String str1, String str2) {
        if (str1 == null || str1.equals("") || str2 == null || str2.equals("")) {
            return false;
        }
        return str1.equals(str2);
    }

    /**
     * 将字串转为数字
     *
     * @param str
     * @param checked 如果为treu格式不正确抛出异常
     * @return
     */
    public static int toInt(String str, boolean checked) {
        int value = 0;
        if (str == null || str.equals("")) {
            return 0;
        }
        try {
            value = Integer.parseInt(str);
        } catch (Exception ex) {
            if (checked) {
                throw new RuntimeException("整型数字格式不正确");
            } else {
                return 0;
            }
        }
        return value;
    }

    /**
     * 将一个字串转为int，如果无空，则返回默认值
     *
     * @param str          要转换的数字字串
     * @param defaultValue 默认值
     * @return
     */
    public static Integer toInt(String str, Integer defaultValue) {
        Integer value = defaultValue;
        if (str == null || str.equals("")) {
            return defaultValue;
        }
        try {
            value = Integer.parseInt(str);
        } catch (Exception ex) {
            return defaultValue;
        }
        return value;
    }

    /**
     * 将字符型转为Int型
     *
     * @param str
     * @return
     */
    @Deprecated
    public static int toInt(String str) {
        int value = 0;
        if (str == null || str.equals("")) {
            return 0;
        }
        try {
            value = Integer.parseInt(str);
        } catch (Exception ex) {
            value = 0;
            ex.printStackTrace();
        }
        return value;
    }

    /**
     * 将字串转为数字
     *
     * @param str
     * @param checked 如果为treu格式不正确抛出异常
     * @return
     */
    public static long toLong(String str, boolean checked) {
        long value = 0;
        if (str == null || str.equals("")) {
            return 0;
        }
        try {
            value = Long.parseLong(str);
        } catch (Exception ex) {
            if (checked) {
                throw new RuntimeException("整型数字格式不正确");
            } else {
                return 0;
            }
        }
        return value;
    }

    /**
     * 将一个字串转为int，如果无空，则返回默认值
     *
     * @param str          要转换的数字字串
     * @param defaultValue 默认值
     * @return
     */
    public static Long toLong(String str, Long defaultValue) {
        Long value = defaultValue;
        if (str == null || str.equals("")) {
            return defaultValue;
        }
        try {
            value = Long.parseLong(str);
        } catch (Exception ex) {
            return defaultValue;
        }
        return value;
    }

    /**
     * 将字符型转为Int型
     *
     * @param str
     * @return
     */
    @Deprecated
    public static long toLong(String str) {
        long value = 0;
        if (str == null || str.equals("")) {
            return 0;
        }
        try {
            value = Long.parseLong(str);
        } catch (Exception ex) {
            value = 0;
            ex.printStackTrace();
        }
        return value;
    }

    @Deprecated
    public static Double toDouble(String str) {
        Double value = 0d;
        if (str == null || str.equals("")) {
            return 0d;
        }
        try {
            value = Double.valueOf(str);
        } catch (Exception ex) {
            value = 0d;
            // ex.printStackTrace();
        }
        return value;
    }

    /**
     * 将一个字串转为double
     *
     * @param str
     * @param checked 如果为treu格式不正确抛出异常
     * @return
     */
    public static Double toDouble(String str, boolean checked) {
        Double value = 0d;
        if (str == null || str.equals("")) {
            return 0d;
        }
        try {
            value = Double.valueOf(str);
        } catch (Exception ex) {
            if (checked)
                throw new RuntimeException("数字格式不正确");
            else
                return 0D;
        }
        return value;
    }

    public static Double toDouble(String str, Double defaultValue) {
        Double value = defaultValue;
        if (str == null || str.equals("")) {
            return 0d;
        }
        try {
            value = Double.valueOf(str);
        } catch (Exception ex) {
            ex.printStackTrace();
            value = defaultValue;
        }
        return value;
    }


    /**
     * 把数组转换成String
     *
     * @param array
     * @return
     */
    public static String arrayToString(Object[] array, String split) {
        if (array == null) {
            return "";
        }
        String str = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) continue;

            if (i != array.length - 1) {
                str += array[i].toString() + split;
            } else {
                str += array[i].toString();
            }
        }
        return str;
    }

    /**
     * 将一个list转为以split分隔的string
     *
     * @param list
     * @param split
     * @return
     */
    public static String listToString(List list, String split) {
        if (list == null || list.isEmpty())
            return "";
        StringBuffer sb = new StringBuffer();
        for (Object obj : list) {
            if (sb.length() != 0) {
                sb.append(split);
            }
            sb.append(obj.toString());
        }
        return sb.toString();
    }

    /**
     * 得到WEB-INF的绝对路径
     *
     * @return
     */
    public static String getWebInfPath() {
        String filePath = Thread.currentThread().getContextClassLoader()
                .getResource("").toString();
        if (filePath.toLowerCase().indexOf("file:") > -1) {
            filePath = filePath.substring(6, filePath.length());
        }
        if (filePath.toLowerCase().indexOf("classes") > -1) {
            filePath = filePath.replaceAll("/classes", "");
        }
        if (System.getProperty("os.name").toLowerCase().indexOf("window") < 0) {
            filePath = "/" + filePath;
        }
        if (!filePath.endsWith("/"))
            filePath += "/";
        return filePath;
    }

    /**
     * 得到根目录绝对路径(不包含WEB-INF)
     *
     * @return
     */
    public static String getRootPath() {
        String filePath = StringUtil.class.getResource("").toString();

        int index = filePath.indexOf("WEB-INF");
        if (index == -1) {
            index = filePath.indexOf("build");
        }

        if (index == -1) {
            index = filePath.indexOf("bin");
        }

        filePath = filePath.substring(0, index);
        if (filePath.startsWith("jar")) {
            // 当class文件在jar文件中时，返回”jar:file:/F:/ …”样的路径
            filePath = filePath.substring(10);
        } else if (filePath.startsWith("file")) {
            // 当class文件在jar文件中时，返回”file:/F:/ …”样的路径
            filePath = filePath.substring(6);
        }


        if (System.getProperty("os.name").toLowerCase().indexOf("window") < 0) {
            filePath = "/" + filePath;
        }

        if (filePath.endsWith("/"))
            filePath = filePath.substring(0, filePath.length() - 1);
//		//System.out.println("getRoot path is "+filePath );
        return filePath;
    }

//	public static String getRootPath(String resource) {
//		HttpServletRequest qo = ThreadContextHolder.getHttpRequest() ;
//		try {
//
//			return WebUtils.getRealPath(qo.getSession().getServletContext(), resource);
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//			return "";
//		}
//
//	}

    /**
     * 格式化页码
     *
     * @param page
     * @return
     */
    public static int formatPage(String page) {
        int iPage = 1;
        if (page == null || page.equals("")) {
            return iPage;
        }
        try {
            iPage = Integer.parseInt(page);
        } catch (Exception ex) {
            iPage = 1;
        }
        return iPage;
    }

    /**
     * 将计量单位字节转换为相应单位
     *
     * @param fileSize
     * @return
     */
    public static String getFileSize(String fileSize) {
        String temp = "";
        DecimalFormat df = new DecimalFormat("0.00");
        double dbFileSize = Double.parseDouble(fileSize);
        if (dbFileSize >= 1024) {
            if (dbFileSize >= 1048576) {
                if (dbFileSize >= 1073741824) {
                    temp = df.format(dbFileSize / 1024 / 1024 / 1024) + " GB";
                } else {
                    temp = df.format(dbFileSize / 1024 / 1024) + " MB";
                }
            } else {
                temp = df.format(dbFileSize / 1024) + " KB";
            }
        } else {
            temp = df.format(dbFileSize / 1024) + " KB";
        }
        return temp;
    }

    /**
     * 得到一个32位随机字符
     *
     * @return
     */
    public static String getEntry() {
        Random random = new Random(100);
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(new String(
                "yyyyMMddHHmmssS"));
        return md5(formatter.format(now) + random.nextDouble());
    }

    /**
     * 将中文汉字转成UTF8编码
     *
     * @param str
     * @return
     */
    public static String toUTF8(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        try {
            return new String(str.getBytes("ISO8859-1"), "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static String to(String str, String charset) {
        if (str == null || str.equals("")) {
            return "";
        }
        try {
            return new String(str.getBytes("ISO8859-1"), charset);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static String getRandStr(int n) {
        Random random = new Random();
        String sRand = "";
        for (int i = 0; i < n; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
        }
        return sRand;
    }

    /**
     * 得到一个数字的大写(一到十之内)
     *
     * @param num
     * @return
     */
    public static String getChineseNum(int num) {
        String[] chineseNum = new String[]{"一", "二", "三", "四", "五", "六", "七",
                "八", "九", "十"};
        return chineseNum[num];
    }

    public static String replaceEnter(String str) {
        if (str == null)
            return null;
        return str.replaceAll("\r", "").replaceAll("\n", "");
    }

    public static String replaceAll(String source, String target, String content) {
        StringBuffer buffer = new StringBuffer(source);
        int start = buffer.indexOf(target);
        if (start > 0) {
            source = buffer.replace(start, start + target.length(), content)
                    .toString();
        }
        return source;
    }

    /**
     * 去除HTML 元素
     *
     * @param element
     * @return
     */
    public static String getTxtWithoutHTMLElement(String element) {
        if (null == element || "".equals(element.trim())) {
            return element;
        }

        Pattern pattern = Pattern.compile("<[^<|^>]*>");
        Matcher matcher = pattern.matcher(element);
        StringBuffer txt = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group();
            if (group.matches("<[\\s]*>")) {
                matcher.appendReplacement(txt, group);
            } else {
                matcher.appendReplacement(txt, "");
            }
        }
        matcher.appendTail(txt);
        String temp = txt.toString().replaceAll("\n", "");
        temp = temp.replaceAll(" ", "");
        return temp;
    }

    /**
     * clear trim to String
     *
     * @return
     */
    public static String toTrim(String strtrim) {
        if (null != strtrim && !strtrim.equals("")) {
            return strtrim.trim();
        }
        return "";
    }

    /**
     * 转义字串的$
     *
     * @param str
     * @return
     */
    public static String filterDollarStr(String str) {
        String sReturn = "";
        if (!toTrim(str).equals("")) {
            if (str.indexOf('$', 0) > -1) {
                while (str.length() > 0) {
                    if (str.indexOf('$', 0) > -1) {
                        sReturn += str.subSequence(0, str.indexOf('$', 0));
                        sReturn += "\\$";
                        str = str.substring(str.indexOf('$', 0) + 1,
                                str.length());
                    } else {
                        sReturn += str;
                        str = "";
                    }
                }

            } else {
                sReturn = str;
            }
        }
        return sReturn;
    }

    public static String compressHtml(String html) {
        if (html == null)
            return null;

        html = html.replaceAll("[\\t\\n\\f\\r]", "");
        return html;
    }

    public static String toCurrency(Double d) {
        if (d != null) {
            DecimalFormat df = new DecimalFormat("￥#,###.00");
            return df.format(d);
        }
        return "";
    }

    public static String toString(Integer i) {
        if (i != null) {
            return String.valueOf(i);
        }
        return "";
    }

    public static String toString(Double d) {
        if (null != d) {
            return String.valueOf(d);
        }
        return "";
    }

    //六位数字
    public static String getRandom() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        int result = 0;
        for (int i = 0; i < 6; i++) {

            if (i == 0 && array[i] == 0) array[i] = 3;
            result = result * 10 + array[i];
        }
        return "" + result;
    }

    /**
     * 处理树型码 获取本级别最大的code 如:301000 返回301999
     *
     * @param code
     * @return
     */
    public static int getMaxLevelCode(int code) {
        String codeStr = "" + code;
        StringBuffer str = new StringBuffer();
        boolean flag = true;
        for (int i = codeStr.length() - 1; i >= 0; i--) {
            char c = codeStr.charAt(i);
            if (c == '0' && flag) {
                str.insert(0, '9');
            } else {
                str.insert(0, c);
                flag = false;
            }
        }
        return Integer.valueOf(str.toString());
    }

    /**
     * 去掉sql的注释
     */
    public static String delSqlComment(String content) {
        String pattern = "/\\*(.|[\r\n])*?\\*/";
        Pattern p = Pattern.compile(pattern, 2 | Pattern.DOTALL);
        Matcher m = p.matcher(content);
        if (m.find()) {
            content = m.replaceAll("");
        }
        return content;
    }

    public static String inputStream2String(InputStream is) {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        try {
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static String decode(String keyword) {
        if (StringUtils.isBlank(keyword)) return null;
        try {
            keyword = URLDecoder.decode(keyword, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }

        return keyword;
    }

    public static String encode(String keyword) {
        if (StringUtils.isBlank(keyword)) return null;
        try {
            keyword = URLEncoder.encode(keyword, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return keyword;
    }

    /**
     * 进行解析
     *
     * @param regex
     * @param rpstr
     * @param source
     * @return
     */
    public static String doFilter(String regex, String rpstr, String source) {
        Pattern p = Pattern.compile(regex, 2 | Pattern.DOTALL);
        Matcher m = p.matcher(source);
        return m.replaceAll(rpstr);
    }

    /**
     * 脚本过滤
     *
     * @param source
     * @return
     */
    public static String formatScript(String source) {
        source = source.replaceAll("javascript", "&#106avascript");
        source = source.replaceAll("jscript:", "&#106script:");
        source = source.replaceAll("js:", "&#106s:");
        source = source.replaceAll("value", "&#118alue");
        source = source.replaceAll("about:", "about&#58");
        source = source.replaceAll("file:", "file&#58");
        source = source.replaceAll("document.cookie", "documents&#46cookie");
        source = source.replaceAll("vbscript:", "&#118bscript:");
        source = source.replaceAll("vbs:", "&#118bs:");
        source = doFilter("(on(mouse|exit|error|click|key))", "&#111n$2",
                source);
        return source;
    }

    /**
     * 格式化HTML代码
     *
     * @param htmlContent
     * @return
     */
    public static String htmlDecode(String htmlContent) {
        htmlContent = formatScript(htmlContent);
        htmlContent = htmlContent.replaceAll(" ", "&nbsp;")
                .replaceAll("<", "&lt;").replaceAll(">", "&gt;")
                .replaceAll("\n\r", "<br>").replaceAll("\r\n", "<br>")
                .replaceAll("\r", "<br>");
        return htmlContent;
    }

    /**
     * 动态添加表前缀，对没有前缀的表增加前缀
     *
     * @param table
     * @param prefix
     * @return
     */
    public static String addPrefix(String table, String prefix) {
        String result = "";
        if (table.length() > prefix.length()) {
            if (table.substring(0, prefix.length()).toLowerCase()
                    .equals(prefix.toLowerCase()))
                result = table;
            else
                result = prefix + table;
        } else
            result = prefix + table;

        return result;
    }

    public static String addSuffix(String table, String suffix) {
        String result = "";
        if (table.length() > suffix.length()) {
            int start = table.length() - suffix.length();
            int end = start + suffix.length();
            if (table.substring(start, end).toLowerCase()
                    .equals(suffix.toLowerCase()))
                result = table;
            else
                result = table + suffix;
        } else
            result = table + suffix;

        return result;
    }


    /**
     * 得到异常的字串
     *
     * @param aThrowable
     * @return
     */
    public static String getStackTrace(Throwable aThrowable) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        aThrowable.printStackTrace(printWriter);
        return result.toString();

    }

    /**
     * 验证手机号
     *
     * @param str
     * @return
     */
    public static boolean isPhone(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^((1[0-9]{2})+\\d{8})$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }


    /**
     * 验证电话号
     *
     * @param str
     * @return
     */
    public static boolean isMobile(String str) {
        Pattern p1 = null, p2 = null;
        Matcher m = null;
        boolean b = false;
        p1 = Pattern.compile("0\\d{2,3}-\\d{7,8}");       // 验证带区号的        whj  2015-05-22修改对带区号的固定电话的验证，验证格式为“0467-8888888”
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");     // 验证没有区号的
        if (str.length() > 9) {
            m = p1.matcher(str);
            b = m.matches();
        } else {
            m = p2.matcher(str);
            b = m.matches();
        }
        return b;
    }

    /**
     * 根据传过来的字符串，和长度自动补全字符长度
     *
     * @param source
     * @return
     */
    public static String afterCompleteString(String source, int length) {
        if (null == source) source = "";
        if (length < 0) length = 0;
        String retString = source;

        if (source.length() > length) {
            return retString.substring(0, length);
        } else {
            StringBuffer s = new StringBuffer(retString);
            for (int i = 0; i < length - source.length(); i++) {
                s.append("0");
            }
            return s.toString();
        }

    }

    public static String fillStringByArgs(String str, String[] arr) {
        Matcher m = Pattern.compile("\\{(\\d)\\}").matcher(str);
        while (m.find()) {
            int i = Integer.parseInt(m.group(1));
            if (i < arr.length) {
                str = str.replace(m.group(), arr[i]);
            }
        }
        return str;
    }

}
