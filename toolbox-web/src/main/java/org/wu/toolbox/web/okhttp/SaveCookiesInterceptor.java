package org.wu.toolbox.web.okhttp;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用于从响应头中获取 Cookie
 * @author wusq
 * @date 2020/9/25
 */
public class SaveCookiesInterceptor implements Interceptor {

    public static String COOKIE = null;

    @Override
    public Response intercept(Chain chain) throws IOException {
        // 获取请求及其响应
        Request request = chain.request();
        Response response = chain.proceed(request);
        if (!response.headers("set-cookie").isEmpty()) {
            // 获取响应头“set-cookie”值，即为服务器发送的 Cookie
            List<String> cookies = response.headers("set-cookie");
            // 将 Cookie 拼接成字符串
            COOKIE = encodeCookie(cookies);
            System.out.println("拼接后的cookie=" + COOKIE);
            // 保存 Cookie 字符串
            //saveCookie(request.url().host(), cookie);
        }
        return response;
    }

    /**
     * 重新处理cookie
     * @param cookies
     * @return
     */
    private String encodeCookie(List<String> cookies) {
        String result = null;
        if(cookies == null || cookies.isEmpty()){
            return result;
        }
        Set<String> set = new HashSet<>();
        for (String cookie : cookies) {
            String[] arr = cookie.split(";");
            for (String s : arr) {
                set.add(s);
            }
        }
        result = set.stream().collect(Collectors.joining(";"));
        return result;
    }

}
