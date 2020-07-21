package com.mini.base.utils;

import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * MD5加密工具
 * huqianbo
 *
 */
public class MD5Util {

    private static final String DEFAULT_SALT = "apms@h-world.com";

    public static String encode(String password,String saltValue) {
        if (StringUtils.isNotBlank(saltValue)){
            password = password + saltValue;
        }

        password = password + DEFAULT_SALT;

        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char[] charArray = password.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }

            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
	 * 生成MD5的时候有字符集的区别，此方法为UTF-8
	 * @param input 需要转换的byte数组
	 * @return 转换后的字符串
	 */
	public static String encodeUTF8(String input) {
		if (input == null) {
			return "";
		}
		byte[] inputs = null;
		MessageDigest md5 = null;
		try { //MD5生产前面之前进行字符的编码格式化
			inputs = input.getBytes("UTF-8");
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		md5.update(inputs);
		String result = byteArr2HexStr(md5.digest());
		return result;
	}

	/**
	 * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
	 * hexStr2ByteArr(String strIn) 互为可逆的转换过程
	 *
	 * @param arrB
	 *            需要转换的byte数组
	 * @return 转换后的字符串
	 * @throws Exception
	 *             本方法不处理任何异常，所有异常全部抛出
	 */
	public static String byteArr2HexStr(byte[] arrB) {
		if (arrB == null) {
		    return null;
		}
		int iLen = arrB.length;
		// 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// 把负数转换为正数
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// 小于0F的数需要在前面补0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toHexString(intTmp));
		}
		return sb.toString();
	}

	/**
	 *
	 * @param pwd
	 *            需要加密的字符串
	 * @param isUpper
	 *            字母大小写(false为默认小写，true为大写)
	 * @param bit
	 *            加密的类型（16,32,64）
	 * @return
	 */
	public static String getMD5(String pwd, boolean isUpper, Integer bit) {
		String md5 = new String();
		try {
			// 创建加密对象
			MessageDigest md = MessageDigest.getInstance("md5");
			if (bit == 64) {
				BASE64Encoder bw = new BASE64Encoder();
				String bsB64 = bw.encode(md.digest(pwd.getBytes("utf-8")));
				md5 = bsB64;
			} else {
				// 计算MD5函数
				md.update(pwd.getBytes());
				byte b[] = md.digest();
				int i;
				StringBuffer sb = new StringBuffer("");
				for (int offset = 0; offset < b.length; offset++) {
					i = b[offset];
					if (i < 0)
						i += 256;
					if (i < 16)
						sb.append("0");
					sb.append(Integer.toHexString(i));
				}
				md5 = sb.toString();
				if(bit == 16) {
					//截取32位md5为16位
					String md16 = md5.substring(8, 24).toString();
					md5 = md16;
					if (isUpper)
						md5 = md5.toUpperCase();
					return md5;
				}
			}
			//转换成大写
			if (isUpper)
				md5 = md5.toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("md5加密抛出异常！");
		}

		return md5;
	}

    public static void main(String[] args) {
    	String orderNo = "L2019071017350001";
        String orderRoomNo = "";
        if (StringUtil.isNotEmpty(orderNo)){
            orderRoomNo = orderNo.substring(0,1) + "O" + orderNo.substring(1,orderNo.length()) + "1";
        }
        System.out.println(MD5Util.encode("123456","admin"));
    }
}
