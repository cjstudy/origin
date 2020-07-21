package com.mini.base.utils;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Base64Utils {

    private static final String DEFAULT_ENCODING_TABLES = "058+/AB12CDEFGHI3XYZabc4JKLMNO6PQpqrstuRSTU9VWdefg7hijklmnovwxyz=";
    //private static String encodingTables = "";
    private static String encodingTables = DEFAULT_ENCODING_TABLES.substring(0 % DEFAULT_ENCODING_TABLES.length()) + DEFAULT_ENCODING_TABLES.substring(0, 0 % DEFAULT_ENCODING_TABLES.length());

    /*public Base64Utils(int offset) {
        int move = offset % DEFAULT_ENCODING_TABLES.length();
        this.encodingTables = DEFAULT_ENCODING_TABLES.substring(move) + DEFAULT_ENCODING_TABLES.substring(0, move);
    }*/

    /**
     * encode
     * <p>
     * coverts a byte array to a string populated with base64 digits. It steps
     * through the byte array calling a helper methode for each block of three
     * input bytes
     *
     * @param raw The byte array to encode
     * @return A string in base64 encoding
     */
    public static String encode(byte[] raw) {
        StringBuffer encoded = new StringBuffer();
        for (int i = 0; i < raw.length; i += 3) {
            encoded.append(encodeBlock(raw, i));
        }
        return encoded.toString();
    }

    /**
     * encodeBlock
     * <p>
     * creates 4 base64 digits from three bytes of input data. we use an
     * integer, block, to hold the 24 bits of input data.
     *
     * @return An array of 4 characters
     */
    protected static char[] encodeBlock(byte[] raw, int offset) {
        int block = 0;
        // how much space left in input byte array
        int slack = raw.length - offset - 1;
        // if there are fewer than 3 bytes in this block, calculate end
        int end = (slack >= 2) ? 2 : slack;
        // convert signed quantities into unsigned
        for (int i = 0; i <= end; i++) {
            byte b = raw[offset + i];
            int neuter = (b < 0) ? b + 256 : b;
            block += neuter << (8 * (2 - i));
        }
        // extract the base64 digets, which are six bit quantities.
        char[] base64 = new char[4];
        for (int i = 0; i < 4; i++) {
            int sixbit = (block >>> (6 * (3 - i))) & 0x3f;
            base64[i] = getChar(sixbit);
        }
        // pad return block if needed
        if (slack < 1)
            base64[2] = '=';
        if (slack < 2)
            base64[3] = '=';
        // always returns an array of 4 characters
        return base64;
    }

    /**
     * decode
     * <p>
     * convert a base64 string into an array of bytes.
     *
     * @param base64 A String of base64 digits to decode.
     * @return A byte array containing the decoded value of the base64 input
     * string
     */
    public static byte[] decode(String base64) {
        // how many padding digits?
        int pad = 0;
        for (int i = base64.length() - 1; base64.charAt(i) == '='; i--)
            pad++;
        // we know know the lenght of the target byte array.
        int length = base64.length() * 6 / 8 - pad;
        byte[] raw = new byte[length];
        int rawIndex = 0;
        // loop through the base64 value. A correctly formed
        // base64 string always has a multiple of 4 characters.
        for (int i = 0; i < base64.length(); i += 4) {
            int block = (getValue(base64.charAt(i)) << 18) + (getValue(base64.charAt(i + 1)) << 12) + (getValue(base64.charAt(i + 2)) << 6)
                    + (getValue(base64.charAt(i + 3)));
            // based on the block, the byte array is filled with the
            // appropriate 8 bit values
            for (int j = 0; j < 3 && rawIndex + j < raw.length; j++)
                raw[rawIndex + j] = (byte) ((block >> (8 * (2 - j))) & 0xff);
            rawIndex += 3;
        }
        return raw;
    }

    /**
     * getChar
     * <p>
     * encapsulates the translation from six bit quantity to base64 digit
     */
    protected static char getChar(int sixBit) {
        return encodingTables.charAt(sixBit);
    }

    /**
     * getValue
     * <p>
     * translates from base64 digits to their 6 bit value
     */
    protected static int getValue(char c) {
        if (c == '=')
            return 0;
        return encodingTables.indexOf(c);
    }

    public static void main(String[] args) {
        String data = "a123456admin";
        //Base64Utils b = new Base64Utils(0);
        String result = Base64Utils.encode(data.getBytes());
        System.out.println(data);
        System.out.println(new String(result));
        System.out.println(new String(Base64Utils.decode(result)));
        System.out.println(new String(Base64Utils.decode("JZ/7Fh3jGuAsMctd")));
    }


}
