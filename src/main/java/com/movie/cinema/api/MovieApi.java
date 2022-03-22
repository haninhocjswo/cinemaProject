package com.movie.cinema.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.mapping.ResultMap;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class MovieApi {

    private final String REQUEST_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
    private final String API_KEY = "5d088f8907f9b753aecb98b644021534";
    private final SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

    public String makeQueryString(Map<String, Object> requestMap) {
        final StringBuilder RESULTSTRING = new StringBuilder();

        requestMap.entrySet().forEach(( entry ) -> {
            if(RESULTSTRING.length() > 0) {
                RESULTSTRING.append("&");
            }
            RESULTSTRING.append(entry.getKey()).append("=").append(entry.getValue());
        });

        return RESULTSTRING.toString();
    }

    public List<Map<String, Object>> requestApi(String dt) {
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> requestMap = new HashMap<>();

        result.clear();
        requestMap.clear();

        try {
            Date day = df.parse(dt);
            String targetDt = df.format(day);

            requestMap.put("key", API_KEY);
            requestMap.put("targetDt", targetDt);
            System.out.println("wwwwwwwwww->");
            URL requestUrl = new URL(REQUEST_URL + "?" + makeQueryString(requestMap));
            HttpURLConnection conn = (HttpURLConnection) requestUrl.openConnection();

            conn.setRequestMethod("GET");
            conn.setDoInput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuffer response = new StringBuffer();
            String readLine = null;
            while((readLine = br.readLine()) != null) {
                response.append(readLine);
            }
            System.out.println("ssssssssssss--->" + response.toString());
            JSONObject responseBody = new JSONObject(response.toString());

            System.out.println("결과값 :: " + responseBody.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
