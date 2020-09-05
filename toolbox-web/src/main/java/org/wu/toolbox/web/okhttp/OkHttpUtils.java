package org.wu.toolbox.web.okhttp;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OkHttp工具类
 * @author wusq
 * @date 2020/9/5
 */
public class OkHttpUtils {

    public static void main(String[] args) throws Exception{
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SaveCookiesInterceptor())
                .addInterceptor(new LoadCookiesInterceptor())
                .build();

        String url = "http://xxxxxxx";
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }
}
