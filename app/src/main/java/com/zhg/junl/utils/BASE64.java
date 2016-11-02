package com.zhg.junl.utils;

import java.io.UnsupportedEncodingException;

/**
 * 框架类(加密类) - BASE64加密类
 * ============================================================================
 * 版权所有 2012-20115 VOS所有，并保留所有权利。
 * ----------------------------------------------------------------------------
 * 提示：
 * ----------------------------------------------------------------------------
 * 官方网站：
 * ----------------------------------------------------------------------------
 * KEY:
 * ============================================================================
 */
public class BASE64 {
    /**
     * 将原始数据编码为base64编码
     */
    static public String encode(final String src,String chatset) {
        if (src ==null ||"".equals(src)) {
            return "";
        }
        byte[] data = null;
		try {
			data = src.getBytes(chatset);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
        final char[] out = new char[((data.length +2) /3) *4];
        for (int i = 0, index = 0; i <data.length; i += 3, index += 4) {
            boolean quad = false;
            boolean trip = false;
            int val = (0xFF &data[i]);
            val <<= 8;
            if ((i +1) <data.length) {
                val |= (0xFF &data[i +1]);
                trip = true;
            }
            val <<= 8;
            if ((i +2) <data.length) {
                val |= (0xFF &data[i +2]);
                quad = true;
            }
            out[index +3] = BASE64.alphabet[(quad ? (val &0x3F) : 64)];
            val >>= 6;
            out[index +2] = BASE64.alphabet[(trip ? (val &0x3F) : 64)];
            val >>= 6;
            out[index +1] = BASE64.alphabet[val &0x3F];
            val >>= 6;
            out[index +0] = BASE64.alphabet[val &0x3F];
        }
        return new String(out);
    }

    /**
     * 将base64编码的数据解码成原始数据
     */
    static public String decode(final String src) {
        if (src ==null ||"".equals(src)) {
            return "";
        }
        final char[] data = src.toCharArray();
        int len = ((data.length +3) /4) *3;
        if (data.length >0 &&data[data.length -1] =='=') {
            --len;
        }
        if (data.length >1 &&data[data.length -2] =='=') {
            --len;
        }
        final byte[] out = new byte[len];
        int shift = 0;
        int accum = 0;
        int index = 0;
        for (int ix = 0; ix <data.length; ix++) {
            final int value = BASE64.codes[data[ix] &0xFF];
            if (value >=0) {
                accum <<= 6;
                shift += 6;
                accum |= value;
                if (shift >=8) {
                    shift -= 8;
                    out[index++] = (byte) ((accum >>shift) &0xff);
                }
            }
        }
        if (index !=out.length) {
            throw new Error("miscalculated data length!");
        }
        return new String(out);
    }

    static private char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    static private byte[] codes = new byte[256];
    static {
        for (int i = 0; i <256; i++) {
            BASE64.codes[i] = -1;
        }
        for (int i = 'A'; i <='Z'; i++) {
            BASE64.codes[i] = (byte) (i -'A');
        }
        for (int i = 'a'; i <='z'; i++) {
            BASE64.codes[i] = (byte) (26 +i -'a');
        }
        for (int i = '0'; i <='9'; i++) {
            BASE64.codes[i] = (byte) (52 +i -'0');
        }
        BASE64.codes['+'] = 62;
        BASE64.codes['/'] = 63;
    }

    public static void main(final String[] args) throws Exception {
        // 加密成base64
        final String strSrc = "我是徐卫卫";
        final String strOut = BASE64.encode(strSrc,"UTF-8");
        System.out.println(strOut);
        final String strOut2 = new String(BASE64.decode(strOut));
        System.out.println(strOut2);
    }
}
