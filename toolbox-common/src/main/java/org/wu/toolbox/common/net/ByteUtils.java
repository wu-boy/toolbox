package org.wu.toolbox.common.net;

import org.apache.commons.lang3.StringUtils;

/**
 * 字节工具类
 * @author wusq
 * @date 2019/6/19
 */
public class ByteUtils {

    /**
     * 字节数组转十六进制字符串
     * @param bytes 字节数组
     * @return 十六进制字符串
     */
    public static String bytesToHexStr(byte[] bytes){
        String result = null;
        if(bytes == null || bytes.length < 1){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        for(byte o:bytes){
            int i = o & 0xFF;
            String hex = Integer.toHexString(i);
            if(hex.length() < 2){
                sb.append(0);
            }
            sb.append(hex);
        }
        result = sb.toString();
        return result;
    }

    /**
     * 十六进制字符串转字节数组
     * @param hexString 十六进制字符串
     * @return 字节数组
     */
    public static byte[] hexStrToBytes(String hexString) {
        byte[] result = null;
        if(StringUtils.isBlank(hexString)){
            return result;
        }
        result = new byte[hexString.length() / 2];
        for(int i = 0; i < hexString.length() / 2; i++) {
            String subStr = hexString.substring(i * 2, i * 2 + 2);
            result[i] = (byte) Integer.parseInt(subStr, 16);
        }
        return result;
    }

    /**
     * BCD码字节数组转字符串
     * @param bytes BCD码字节数组
     * @return 字符串
     */
    public static String bcdToStr(byte[] bytes) {
        StringBuffer temp = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
            temp.append((byte) (bytes[i] & 0x0f));
        }
        return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp
                .toString().substring(1) : temp.toString();
    }

    /**
     * 字符串转BCD码字节数组
     * @param asc 字符串
     * @return BCD码字节数组
     */
    public static byte[] strToBcd(String asc) {
        int len = asc.length();
        int mod = len % 2;
        if (mod != 0) {
            asc = "0" + asc;
            len = asc.length();
        }
        byte abt[] = new byte[len];
        if (len >= 2) {
            len = len / 2;
        }
        byte bbt[] = new byte[len];
        abt = asc.getBytes();
        int j, k;
        for (int p = 0; p < asc.length() / 2; p++) {
            if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
                j = abt[2 * p] - '0';
            } else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
                j = abt[2 * p] - 'a' + 0x0a;
            } else {
                j = abt[2 * p] - 'A' + 0x0a;
            }
            if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
                k = abt[2 * p + 1] - '0';
            } else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
                k = abt[2 * p + 1] - 'a' + 0x0a;
            } else {
                k = abt[2 * p + 1] - 'A' + 0x0a;
            }
            int a = (j << 4) + k;
            byte b = (byte) a;
            bbt[p] = b;
        }
        return bbt;
    }

    public static void main(String[] args) {

        String str = "20190405120827";
        byte[] bytes = strToBcd(str);
        System.out.println(bytes.length);
        String time = bcdToStr(bytes);
        System.out.println(time);

        /*String str = "20190405120827";
        byte[] bytes = hexStrToBytes(str);
        System.out.println(bytes.length);
        String time = bytesToHexStr(bytes);
        System.out.println(time);*/
    }

}
