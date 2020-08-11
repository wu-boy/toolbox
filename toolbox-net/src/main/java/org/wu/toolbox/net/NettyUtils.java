package org.wu.toolbox.net;

import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

/**
 * Netty工具类
 * @author wusq
 * @date 2020/1/18
 */
public class NettyUtils {

    public static final Charset DEFAULT_CHARSET = Charset.forName("GBK");

    /**
     * 读取字节数组
     * @param byteBuf
     * @param length
     * @return
     */
    public static byte[] readBytes(ByteBuf byteBuf, Integer length) {
        byte[] result = new byte[length];
        byteBuf.readBytes(result);
        return result;
    }

    /**
     * 读取字符串
     * @param byteBuf
     * @param length
     * @param charset
     * @return
     */
    public static String readString(ByteBuf byteBuf, Integer length, Charset charset) {
        return new String(readBytes(byteBuf, length), charset);
    }

    /**
     * 读取字符串-GBK编码
     * @param byteBuf
     * @param length
     * @return
     */
    public static String readStringGbk(ByteBuf byteBuf, Integer length) {
        return new String(readBytes(byteBuf, length), DEFAULT_CHARSET);
    }

}
