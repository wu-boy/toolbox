package org.wu.toolbox.web.okhttp;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.util.TextUtils;

import java.io.IOException;

/**
 * 用于加载本地保存的 Cookie 信息并将其附加到请求头中
 * @author wusq
 * @date 2020/9/5
 */
public class LoadCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        // 获取请求构造器
        Request.Builder builder = request.newBuilder();
        // 读取本地 Cookie 信息
        String cookie = SaveCookiesInterceptor.COOKIE;
        if (!TextUtils.isEmpty(cookie)) {
            //将 Cookie 添加到请求头中
            builder.addHeader("Cookie", cookie);
        }
        // 重新构造请求并进行处理
        return chain.proceed(builder.build());
    }

}
