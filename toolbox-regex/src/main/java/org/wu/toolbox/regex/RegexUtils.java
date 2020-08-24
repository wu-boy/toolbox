package org.wu.toolbox.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 * @author wusq
 * @date 2020/8/24
 */
public class RegexUtils {

    // 参考资料：正则表达式30分钟入门教程https://deerchao.cn/tutorials/regex/regex.htm

    /**
     * 手机号
     */
    //public static String CELLPHONE = "^(0|86|17951)?(13[0-9]|15[012356789]|166|17[3678]|18[0-9]|14[57])[0-9]{8}$";
    public static String CELLPHONE = "1\\d{10}";

    /**
     * 邮箱
     */
    public static String EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

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
        boolean match = Pattern.matches(EMAIL, "809791965@qq.com");
        System.out.println(match);
    }
}
