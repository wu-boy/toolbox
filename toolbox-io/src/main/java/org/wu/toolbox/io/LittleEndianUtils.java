package org.wu.toolbox.io;

import java.nio.ByteOrder;
import java.nio.charset.Charset;

/**
 * 小端模式工具类
 * Java基础类型与byte[]相互转换
 * 参考资料：https://www.cnblogs.com/dizhiyaochang/p/8145834.html
 * @author wusq
 * @date 2019/5/21
 */
public class LittleEndianUtils {

    private static final int FF = 0xFF;

    /**
     * byte[]转char
     * @param bytes
     * @return
     */
    public static char getChar(byte[] bytes) {
        return (char) ((FF & bytes[0]) | ((FF & bytes[1]) << 8));
    }

    /**
     * char转byte[]
     * @param data
     * @return
     */
    public static byte[] getCharBytes(char data) {
        byte[] bytes = new byte[2];
        bytes[0] = (byte) (data & FF);
        bytes[1] = (byte) ((data >> 8) & FF);
        return bytes;
    }

    /**
     * byte[]转double
     * @param bytes
     * @return
     */
    public static double getDouble(byte[] bytes) {
        long l = getLong(bytes);
        return Double.longBitsToDouble(l);
    }

    /**
     * double转byte[]
     * @param data
     * @return
     */
    public static byte[] getDoubleBytes(double data) {
        long intBits = Double.doubleToLongBits(data);
        byte[] bytes = getLongBytes(intBits);
        return bytes;
    }

    /**
     * byte[]转float
     * @param bytes
     * @return
     */
    public static float getFloat(byte[] bytes) {
        int l = getInt(bytes);
        return Float.intBitsToFloat(l);
    }

    /**
     * float转byte[]
     * @param data
     * @return
     */
    public static byte[] getFloatBytes(float data) {
        int intBits = Float.floatToIntBits(data);
        byte[] bytes = getIntBytes(intBits);
        return bytes;
    }

    /**
     * byte[]转int
     * @param bytes
     * @return
     */
    public static int getInt(byte[] bytes) {
        int result = (int) ((FF & bytes[0])
                | ((FF & bytes[1]) << 8)
                | ((FF & bytes[2]) << 16)
                | ((FF & bytes[3]) << 24));
        return result;
    }

    /**
     * int转byte[]
     * @param data
     * @return
     */
    public static byte[] getIntBytes(int data) {
        int length = 4;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) ((data >> (i*8)) & FF);
        }
        return bytes;
    }

    public static void getIntBytes(byte[] bytes, int bytesPos, int data) {
        for (int i = 0; i < 4; i++) {
            int index = bytesPos + i;
            bytes[index] = (byte) ((data >> (i*8)) & FF);
        }
    }

    /**
     * byte转为了相对应的无符号int
     * @param data
     * @return int
     */
    public static int getIntUnsigned(byte data){
        return data & FF;
    }

    /**
     * 待测试
     * @param data
     * @return
     */
    public static int getIntUnsigned(short data){
        return data & 0xFFFF;
    }

    /**
     * byte[]转long
     * @param bytes
     * @return
     */
    public static long getLong(byte[] bytes) {
        long result = (long)((long)(FF & bytes[0])
                | (long)((FF & bytes[1]) << 8)
                | (long)((FF & bytes[2]) << 16)
                | (long)((FF & bytes[3]) << 24)
                | (long)((FF & bytes[4]) << 32)
                | (long)((FF & bytes[5]) << 40)
                | (long)((FF & bytes[6]) << 48)
                | (long)((FF & bytes[7]) << 56));
        return result;
    }

    /**
     * long转byte[]
     * @param data
     * @return
     */
    public static byte[] getLongBytes(long data) {
        int length = 8;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) ((data >> (i*8)) & FF);
        }
        return bytes;
    }

    public static void getLongBytes(byte[] bytes, int bytesPos, long data) {
        for (int i = 0; i < 8; i++) {
            bytes[bytesPos + i] = (byte) ((data >> (i*8)) & FF);
        }
    }

    /**
     * byte[]转short
     * @param bytes
     * @return
     */
    public static short getShort(byte[] bytes) {
        short result = (short) ((FF & bytes[0]) | ((FF & bytes[1]) << 8));
        return result;
    }

    /**
     * short转byte[]
     * @param data
     * @return
     */
    public static byte[] getShortBytes(short data) {
        byte[] bytes = new byte[2];
        bytes[0] = (byte) (data & FF);
        bytes[1] = (byte) ((data >> 8) & FF);
        return bytes;
    }

    public static void getShortBytes(byte[] bytes, int bytesPos, short data) {
        bytes[bytesPos] = (byte) (data & FF);
        bytes[bytesPos + 1] = (byte) ((data >> 8) & FF);
    }

    /**
     * byte[]转string
     * @param bytes
     * @return
     */
    public static String getString(byte[] bytes) {
        return new String(bytes);
    }

    /**
     * byte[]转string
     * @param bytes
     * @return
     */
    public static String getString(byte[] bytes, String charsetName) {
        return new String(bytes, Charset.forName(charsetName));
    }

    /**
     * string转byte[]
     * @param data
     * @return
     */
    public static byte[] getStringBytes(String data) {
        byte[] bytes = null;
        if(data != null){
            bytes = data.getBytes();
        }else{
            bytes = new byte[0];
        }
        return bytes;
    }

    /**
     * string转byte[]
     * @param data
     * @return
     */
    public static byte[] getStringBytes(String data, String charsetName) {
        Charset charset = Charset.forName(charsetName);
        byte[] bytes = data.getBytes(charset);
        return bytes;
    }

    public static void main(String[] args) {

        // 测试当前大小端模式
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            System.out.println("BIG_ENDIAN");
        } else {
            System.out.println("LITTLE_ENDIAN");
        }

    }

}
