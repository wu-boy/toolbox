package org.wu.toolbox.web.okhttp;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用于从响应头中获取 Cookie
 * @author wusq
 * @date 2020/9/5
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

    private String encodeCookie(List<String> cookies) {
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (String cookie : cookies) {
            System.out.println("每个cookie=" + cookie);
            String[] arr = cookie.split(";");
            for (String s : arr) {
                set.add(s);
            }
        }
        for (String cookie : set) {
            sb.append(cookie).append(";");
        }
        sb.deleteCharAt(sb.lastIndexOf(";"));
        return sb.toString();
    }

}
