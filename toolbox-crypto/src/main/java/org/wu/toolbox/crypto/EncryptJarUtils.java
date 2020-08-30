package org.wu.toolbox.crypto;

import io.xjar.XConstants;
import io.xjar.XKit;
import io.xjar.boot.XBoot;
import io.xjar.key.XKey;

/**
 * jar包加密工具类
 * @author wusq
 * @date 2020/8/30
 */
public class EncryptJarUtils {

    public static void main(String[] args) throws Exception{
        String password = "nmw123";
        XKey xKey = XKit.key(password);
        XBoot.encrypt("D:\\test\\log\\anfu-car.1.0.0.jar", "D:\\test\\log\\anfu-car.encrypt.1.0.0.jar", xKey, XConstants.MODE_DANGER);
        System.out.println("Successfully generated encrypted jar");
    }
}
