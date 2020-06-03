package com.nan.weixin.util.function;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class AuthService {
    public static String getAuthImage() {
        // 官网获取的 API Key 更新为你注册的
        String clientId = "F9A3uizglAYUalquRHGTtggC";
        // 官网获取的 Secret Key 更新为你注册的
        String clientSecret = "Y0EohqCOpUnoFT0aB3Q9YlhqSDxg1H36";
        return getAuth(clientId, clientSecret);
    }
    public static String getAuthText() {
        // 官网获取的 API Key 更新为你注册的
        String clientId = "91UFyBz7GnrdmNYkh6Aqy5fU";
        // 官网获取的 Secret Key 更新为你注册的
        String clientSecret = "q83Ge6xson6QMLNqKcZtzjvVkbSTxZDx";
        return getAuth(clientId, clientSecret);
    }

    public static String getFixFace() {
        // 官网获取的 API Key 更新为你注册的
        String clientId = "VkPsVx50OZ02MmcfGM28CCCO";
        // 官网获取的 Secret Key 更新为你注册的
        String clientSecret = "IKvWj1lmaI5XfkH5O105moVipqW6sNzj";
        return getAuth(clientId, clientSecret);
    }
    public static String getAuth(String ak, String sk) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }

}
