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
    private final String REQUEST_DETAIL_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json";
    private final String API_KEY = "5d088f8907f9b753aecb98b644021534";
    private final SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

    /*
        Map에 담긴 키값들을 쿼리스트링으로 변환
     */
    public String makeQueryString(Map<String, Object> requestMap) {
        final StringBuilder resultString = new StringBuilder();

        requestMap.entrySet().forEach(( entry ) -> {
            if(resultString.length() > 0) {
                resultString.append("&");
            }
            resultString.append(entry.getKey()).append("=").append(entry.getValue());
        });

        return resultString.toString();
    }

    /*
        JSONOBJEC -> Map<String, Object> 으로 변환
     */
    public static Map<String, Object> jsonToMap(JSONObject jsonObject) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.clear();

        try {
            return new ObjectMapper().readValue(jsonObject.toString(), Map.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
        날짜를 입력하면 해당 날짜에 박스오피스 영화 조회해줌
        영화가 db에 존재하면 아무것도 안하고 존재하지 않는다면 생성
     */
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

            JSONObject responseBody = new JSONObject(response.toString());
            JSONArray boxOfficeList = responseBody.getJSONObject("boxOfficeResult").getJSONArray("dailyBoxOfficeList");

            result.clear();
            for(Object boxOffice : boxOfficeList) {
                Map<String, Object> movie = new HashMap<>();
                movie.putAll(requestMovieDetail(jsonToMap((JSONObject) boxOffice).get("movieCd").toString()));
                result.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public Map<String, Object> requestMovieDetail(String code) {
        Map<String, Object> paramMap = new HashMap<>();
        Map<String, Object> movieInfo = new HashMap<>();

        paramMap.clear();
        movieInfo.clear();

        paramMap.put("key", API_KEY);
        paramMap.put("movieCd", code);

        try {
            URL requestUrl = new URL(REQUEST_DETAIL_URL + "?" + makeQueryString(paramMap));
            HttpURLConnection conn = (HttpURLConnection) requestUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String readLine = null;
            StringBuffer response = new StringBuffer();
            while((readLine = br.readLine()) != null) {
                response.append(readLine);
            }

            JSONObject responseJson = new JSONObject(response.toString());
            movieInfo.clear();
            movieInfo.putAll((Map<String, Object>) jsonToMap((JSONObject) responseJson.get("movieInfoResult")).get("movieInfo"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return movieInfo;
    }
}
