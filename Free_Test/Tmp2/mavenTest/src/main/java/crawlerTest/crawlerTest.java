package crawlerTest;

import java.util.Map;
import java.util.ArrayList;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class crawlerTest {

    public static void testHttp(String url) throws ClientProtocolException, IOException{
        /* 使用 HttpClient 物件... */
        CloseableHttpClient httpClient = HttpClients.createDefault(); // 建立 HttpClient Instance
        var httpGet = new HttpGet(url); // the request url
        // HttpGet httpGet = new HttpGet(url); // the request url
        CloseableHttpResponse response = httpClient.execute(httpGet); // 發出 request, return response
        /* check status code == 200 to make sure we get good response */
        if (response.getStatusLine().getStatusCode() == 200){
            var httpEntity = response.getEntity();
            System.out.println(EntityUtils.toString(httpEntity, "utf8"));
        }
    }
    
    public static void testHttpGetLength(String url){
        // CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            response = HttpClients.createDefault().execute(new HttpGet(url));
            if (response.getStatusLine().getStatusCode() == 200){
                System.out.println(EntityUtils.toString(response.getEntity(), "utf8").length());
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testHttpGetWithParameter(String url, Map<String, String> urlParameter){
        CloseableHttpResponse response = null;
        try {
            var uriBuilder = new URIBuilder(url);
            for (var key : urlParameter.keySet()){
                uriBuilder.setParameter(key, urlParameter.get(key));
            }
            var httpGet = new HttpGet(uriBuilder.build());
            System.out.println("Getting website : " + httpGet);
            response = HttpClients.createDefault().execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200){
                System.out.println(EntityUtils.toString(response.getEntity(), "utf8").length());
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        } catch (URISyntaxException urlE) {
            urlE.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void testHttpPostWithParameter(String url, Map<String, String> urlParameter){
        CloseableHttpResponse response = null;
        try {
            // var uriBuilder = new URIBuilder(url);
            // for (var key : urlParameter.keySet()){
                //     uriBuilder.setParameter(key, urlParameter.get(key));
                // }
                var params = new  ArrayList<NameValuePair>();
                for (var key : urlParameter.keySet()){
                    params.add(new BasicNameValuePair(key, urlParameter.get(key)));
                }
                var formatEntity = new UrlEncodedFormEntity(params, "utf8");
                var httpPost = (new HttpPost(url));
                httpPost.setEntity(formatEntity);
                System.out.println("Getting website : " + httpPost);
                response = HttpClients.createDefault().execute(httpPost);
                if (response.getStatusLine().getStatusCode() == 200){
                    System.out.println(EntityUtils.toString(response.getEntity(), "utf8").length());
                }
        } catch (IOException ioe){
            ioe.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }    
    }
    
    public static void testHttpClientPool(String [] urls){
        /* new 連接池管理器 */
        var pool = new PoolingHttpClientConnectionManager();
        /* 設置總最大連接數 */
        pool.setMaxTotal(urls.length);
        /* 設置單一主機之最大連接數，若訪問多個主機時，可以確保所有主機都被平均訪問 */
        pool.setDefaultMaxPerRoute((urls.length / 10 > 1) ? urls.length / 10 : 1);
        /* 用連接池發起請求 */
        for (var url : urls){
            doGet(pool, url);
        }
    }

    private static void doGet(PoolingHttpClientConnectionManager pool, String url) {
        /* 從連接池中獲取 HttpClient Instance */
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(pool).build();
        CloseableHttpResponse response = null;
        try {
            var httpGet = new HttpGet(url); // the request url
            response = httpClient.execute(httpGet); // 發出 request, return response
            var httpEntity = response.getEntity();
            if (response.getStatusLine().getStatusCode() == 200){
                System.out.println(EntityUtils.toString(httpEntity, "utf8").length());
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        } finally {
            if (response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            /* 不能關閉 HttpClient, s那是由連接池管理 */
            // if (httpClient != null){
            //     try {
            //         httpClient.close();
            //     } catch (IOException e) {
            //         e.printStackTrace();
            //     }
            // }
        }
    }
                
    public static void testHttpConfig(String url){
        var httpClient = HttpClients.createDefault();
        var httpGet = new HttpGet(url);
        RequestConfig config = RequestConfig.custom()
            .setConnectTimeout(1000) // set 最長連線時間，單位：毫秒
            .setConnectionRequestTimeout(500) // set 獲取連線最長時間，單位：毫秒
            .setSocketTimeout(10 * 1000) // set 數據傳輸的最常時間，單位：毫秒
            .build();
        httpGet.setConfig(config); // 設置 Request 訊息
        
        try (var response = httpClient.execute(httpGet)){
            var httpEntity = response.getEntity();
            if (response.getStatusLine().getStatusCode() == 200){
                System.out.println(EntityUtils.toString(httpEntity, "utf8").length());
            }
        } catch (IOException ios){
            ios.printStackTrace();
        } finally {
            if (httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}