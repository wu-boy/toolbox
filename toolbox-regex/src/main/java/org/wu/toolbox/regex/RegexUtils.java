package org.wu.toolbox.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 * @author wusq
 * @date 2021/1/21
 */
public class RegexUtils {

    /**
     * 手机号
     */
    //public static String MOBILE = "^(0|86|17951)?(13[0-9]|15[012356789]|166|17[3678]|18[0-9]|14[57])[0-9]{8}$";
    public static String MOBILE = "1\\d{10}";

    /**
     * 邮箱
     */
    public static String EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";


    /**
     * 用户名，4至20位，以字母开头，字母，数字，减号，下划线
     */
    public static String USERNAME = "[a-zA-Z][-_a-zA-Z0-9]{3,19}";

    /**
     * 密码，8到16位，字母，数字，下划线，减号
     */
    public static String PASSWORD = "[-_a-zA-Z0-9]{8,16}";

    /**
     * 正则匹配字符串
     * @param source 字符串
     * @param patternText 正则表达式
     * @return
     */
    public static String match(String source, String patternText){
        String result = null;
        Pattern pattern = Pattern.compile(patternText);
        Matcher matcher = pattern.matcher(source);
        if(matcher.find()){
            result = matcher.group();
        }
        return result;
    }

    public static void main(String[] args) {
        boolean match = Pattern.matches(USERNAME, "W123sq");
        System.out.println(match);
    }
}
