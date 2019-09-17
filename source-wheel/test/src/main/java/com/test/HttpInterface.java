package com.test;

import com.google.gson.Gson;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author koabs
 * @Date 2019/8/28.
 * @Describe
 */
public class HttpInterface {
    private static String baseUrl = "";

    private static Logger logger = LoggerFactory.getLogger(HttpInterface.class);

    private static CloseableHttpClient httpClient;

    private static Gson gson;
    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(100);
        cm.setDefaultMaxPerRoute(20);
        cm.setDefaultMaxPerRoute(50);
        httpClient = HttpClients.custom().setConnectionManager(cm).build();
        gson = new Gson();
    }

    public static String get(String url) {
        CloseableHttpResponse response = null;
        BufferedReader in = null;
        String result = "";
        try {
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).setConnectionRequestTimeout(30000).setSocketTimeout(30000).build();
            httpGet.setConfig(requestConfig);
            httpGet.setConfig(requestConfig);
            httpGet.addHeader("Content-type", "application/json; charset=utf-8");
            httpGet.setHeader("Accept", "application/json");
            response = httpClient.execute(httpGet);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();
            result = sb.toString();
        } catch (IOException e) {
            logger.error("get:",e);
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {
                logger.error("get:",e);
            }
        }
        logger.debug(url + ":" + result);
        return result;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static Map queryRegAmountByOrganId(String organId, String date) {
        String url = "/report-c/reportService/queryRegAmountByOrganId?date="+date+"&organId=" + organId;
        String result = get(getBaseUrl() + url);
        Map element = new HashMap();

        element = gson.fromJson(result,Map.class);

        if ("0".equalsIgnoreCase(String.valueOf(element.get("code")))) {
            element = (Map) element.get("data");
        } else {
            logger.error("调用接口出错：" + url);
        }
        return  element;
    }




    public static void main(String[] args) throws IOException {
        queryRegAmountByOrganId("671024","2019-08-01");
        System.out.printf("");
    }
}
