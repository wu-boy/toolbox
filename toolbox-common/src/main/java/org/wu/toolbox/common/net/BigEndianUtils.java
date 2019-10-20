package org.wu.toolbox.common.net;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/**
 * 大端模式工具类
 * Java基础类型与byte[]相互转换
 * 参考资料：https://www.cnblogs.com/dizhiyaochang/p/8145834.html
 * @author wusq
 * @date 2019/9/19
 */
public class BigEndianUtils {

    /**
     * byte[]转char
     * @param bytes
     * @return
     */
    public static char getChar(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.put(bytes);
        char result = buffer.getChar(0);
        return result;
    }

    /**
     * Char转byte[]
     * @param data
     * @return
     */
    public static byte[] getCharBytes(char data) {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putChar(data);
        byte[] bytes = buffer.array();
        return bytes;
    }

    /**
     * byte[]转double
     * @param bytes
     * @return
     */
    public static double getDouble(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.put(bytes);
        double result = buffer.getDouble(0);
        return result;
    }

    /**
     * double转byte[]
     * @param data
     * @return
     */
    public static byte[] getDoubleBytes(double data) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putDouble(data);
        byte[] bytes = buffer.array();
        return bytes;
    }

    /**
     * byte[]转float
     * @param bytes
     * @return
     */
    public static float getFloat(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.put(bytes);
        float result = buffer.getFloat(0);
        return result;
    }

    /**
     * float转byte[]
     * @param data
     * @return
     */
    public static byte[] getFloatBytes(float data) {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putFloat(data);
        byte[] bytes = buffer.array();
        return bytes;
    }

    /**
     * byte[]转int
     * @param bytes
     * @return
     */
    public static int getInt(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.put(bytes);
        int result = buffer.getInt(0);
        return result;
    }

    /**
     * int转byte[]
     * @param data
     * @return
     */
    public static byte[] getIntBytes(int data) {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putInt(data);
        byte[] bytes = buffer.array();
        return bytes;
    }

    public static void getIntBytes(byte[] bytes, int bytesPos, int data) {
        byte[] array = getIntBytes(data);
        bytes[bytesPos] = array[0];
        bytes[bytesPos + 1] = array[1];
        bytes[bytesPos + 2] = array[2];
        bytes[bytesPos + 3] = array[3];
    }

    /**
     * byte[]转long
     * @param bytes
     * @return
     */
    public static long getLong(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.put(bytes);
        long result = buffer.getLong(0);
        return result;
    }

    /**
     * long转byte[]
     * @param data
     * @return
     */
    public static byte[] getLongBytes(long data) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putLong(data);
        byte[] bytes = buffer.array();
        return bytes;
    }

    public static void getLongBytes(byte[] bytes, int bytesPos, long data) {
        byte[] array = getLongBytes(data);
        bytes[bytesPos] = array[0];
        bytes[bytesPos + 1] = array[1];
        bytes[bytesPos + 2] = array[2];
        bytes[bytesPos + 3] = array[3];
        bytes[bytesPos + 4] = array[4];
        bytes[bytesPos + 5] = array[5];
        bytes[bytesPos + 6] = array[6];
        bytes[bytesPos + 7] = array[7];
    }

    /**
     * byte[]转short
     * @param bytes
     * @return
     */
    public static short getShort(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.put(bytes);
        short result = buffer.getShort(0);
        return result;
    }

    /**
     * Short转byte[]
     * @param data
     * @return
     */
    public static byte[] getShortBytes(short data) {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putShort(data);
        byte[] bytes = buffer.array();
        return bytes;
    }

    public static void getShortBytes(byte[] bytes, int bytesPos, short data) {
        byte[] array = getShortBytes(data);
        bytes[bytesPos] = array[0];
        bytes[bytesPos + 1] = array[1];
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
     * @param charsetName
     * @return
     */
    public static String getString(byte[] bytes, String charsetName) {
        return new String(bytes, Charset.forName(charsetName));
    }

    /**
     * String转byte[]
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
     * String转byte[]
     * @param data
     * @param charsetName
     * @return
     */
    public static byte[] getStringBytes(String data, String charsetName) {
        Charset charset = Charset.forName(charsetName);
        byte[] bytes = data.getBytes(charset);
        return bytes;
    }

}
