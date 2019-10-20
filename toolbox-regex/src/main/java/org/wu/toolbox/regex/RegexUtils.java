package org.wu.toolbox.regex;

import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 * @author wusq
 * @date 2019/6/26
 */
public class RegexUtils {

    /**
     * 手机号
     */
    //public static String CELLPHONE = "^(0|86|17951)?(13[0-9]|15[012356789]|166|17[3678]|18[0-9]|14[57])[0-9]{8}$";
    public static String CELLPHONE = "1\\d{10}";

    /**
     * 邮箱
     */
    public static String EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

    public static void main(String[] args) {
        boolean match = Pattern.matches(EMAIL, "809791965@qq.com");
        System.out.println(match);
    }
}
