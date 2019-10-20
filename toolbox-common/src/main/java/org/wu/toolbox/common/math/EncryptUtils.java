package org.wu.toolbox.common.math;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.ByteSource;

/**
 * 加解密工具类
 * @author wusq
 * @date 2019/8/22
 */
public class EncryptUtils {

    /**
     * 默认加密次数
     */
    public static final Integer DEFAULT_ITERATION = 1;

    /**
     * MD5算法
     */
    public static final String ALGORITHM_MD5 = "MD5";

    /**
     * SHA256算法
     */
    public static final String ALGORITHM_SHA256 = "SHA-256";

    /**
     * 散列
     * @param algorithmName 算法
     * @param iteration 迭代次数
     * @param salt 盐
     * @param password 密码
     * @return
     */
    private static String hash(String algorithmName, Integer iteration, String salt, String password){
        HashRequest.Builder builder = new HashRequest.Builder();
        builder.setAlgorithmName(algorithmName);
        if(iteration == null){
            iteration = DEFAULT_ITERATION;
        }
        builder.setIterations(iteration);
        builder.setSource(ByteSource.Util.bytes(password));
        if(StringUtils.isNotBlank(salt)){
            builder.setSalt(ByteSource.Util.bytes(salt));
        }
        return new DefaultHashService().computeHash(builder.build()).toHex();
    }

    /**
     * MD5加密
     * @param password 密码
     * @return
     */
    public static String md5(String password){
        return hash(ALGORITHM_MD5, null, null, password);
    }

    /**
     * MD5加密
     * @param iteration 迭代次数
     * @param password 密码
     * @return
     */
    public static String md5(Integer iteration, String password){
        return hash(ALGORITHM_MD5, iteration, null, password);
    }

    /**
     * MD5加盐加密，实际效果为md5(salt+password)
     * @param salt 盐
     * @param password 密码
     * @return
     */
    public static String md5(String salt, String password){
        return hash(ALGORITHM_MD5, null, salt, password);
    }

    /**
     * MD5加盐加密，实际效果为md5(salt+password)
     * @param iteration 迭代次数
     * @param salt 盐
     * @param password 密码
     * @return
     */
    public static String md5(Integer iteration, String salt, String password){
        return hash(ALGORITHM_MD5, iteration, salt, password);
    }

    /**
     * SHA-256加密
     * @param password
     * @return
     */
    public static String sha256(String password){
        return hash(ALGORITHM_SHA256, null, null, password);
    }

    public static void main(String[] args) {
        String password = "12345678";
        String salt = "aaa";
        System.out.println(md5(salt + password));
        System.out.println(md5(salt, password));
    }

}
