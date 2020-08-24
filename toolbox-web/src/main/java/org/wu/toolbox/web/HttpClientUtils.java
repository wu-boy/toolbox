package org.wu.toolbox.web;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;

/**
 * HttpClient工具类和Demo
 * @author wusq
 * @date 2020/8/24
 */
public class HttpClientUtils {

    public static void close(CloseableHttpClient httpclient, CloseableHttpResponse httpResponse){
        try {
            if(httpclient != null){
                httpclient.close();
            }
            if(httpResponse != null){
                httpResponse.close();
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // 带参数的Get请求测试
        getWithParameter();
    }

    /**
     * 带参数的GET请求例子
     * 参考资料：https://www.jianshu.com/p/375be5929bed
     */
    static void getWithParameter(){

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //response 对象
        CloseableHttpResponse httpResponse = null;

        try {

            // 定义请求的参数
            URI uri = new URIBuilder("http://网址").setParameter("subid", "13671").build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);

            // 执行http get请求
            httpResponse = httpclient.execute(httpGet);

            int statusCode = httpResponse.getStatusLine().getStatusCode();

            System.out.println("返回的状态码=" + statusCode);
            if(statusCode != 200){
                return;
            }

            HttpEntity httpEntity = httpResponse.getEntity();
            String content = EntityUtils.toString(httpEntity, Consts.UTF_8);
            System.out.println("返回的数据=====================");
            System.out.println(content);
            System.out.println("返回的数据=====================");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(httpclient, httpResponse);
        }
    }
}
