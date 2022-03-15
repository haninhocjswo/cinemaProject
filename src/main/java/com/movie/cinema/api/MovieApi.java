package com.movie.cinema.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class MovieApi {

    private final String REQUEST_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json";
    private final String API_KEY = "5d088f8907f9b753aecb98b644021534";

    private final SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

    //url 파라미터문자 생성
    public String makeQueryString(Map<String, Object> paramMap) {
        final StringBuilder sb =new StringBuilder();

        paramMap.entrySet().forEach((entry) -> {
            if(sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        });

        return sb.toString();
    }

    public void requestApi() {
        String curPage = "1";
        String itemPerPage = "20";
        String openStartDt = "2022";
        String openEndDdt = "2022";

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.clear();
        requestMap.put("key", API_KEY);
        requestMap.put("curPage", curPage);
        requestMap.put("itemPerPage", itemPerPage);
        requestMap.put("openStartDt", openStartDt);
        requestMap.put("openEndDdt", openEndDdt);

        try {
            URL requestUrl = new URL(REQUEST_URL + "?" + makeQueryString(requestMap));
            HttpURLConnection conn = (HttpURLConnection) requestUrl.openConnection();

            conn.setRequestMethod("GET");
            conn.setDoInput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String readLine = null;
            StringBuffer response = new StringBuffer();
            while ((readLine = br.readLine()) != null) {
                response.append(readLine);
            }

            JSONObject responseBody = new JSONObject(response.toString());
            List<Map<String, Object>> responseMapList = new ArrayList<>();
            Map<String, Object> responseMap = new HashMap<>();

            responseMapList.clear();
            responseMap.clear();

            JSONArray jsonMovieList = responseBody.getJSONArray("movieList");


        } catch (Exception e) {
            e.printStackTrace();
        }
/*
        key	문자열(필수)	발급받은키 값을 입력합니다.
        curPage	문자열	현재 페이지를 지정합니다.(default : “1”)
        itemPerPage	문자열	결과 ROW 의 개수를 지정합니다.(default : “10”)
        movieNm	문자열	영화명으로 조회합니다. (UTF-8 인코딩)
        directorNm	문자열	감독명으로 조회합니다. (UTF-8 인코딩)
        openStartDt	문자열	YYYY형식의 조회시작 개봉연도를 입력합니다.
        openEndDt	문자열	YYYY형식의 조회종료 개봉연도를 입력합니다.
        prdtStartYear	문자열
        YYYY형식의 조회시작 제작연도를 입력합니다.

        prdtEndYear	문자열
        YYYY형식의 조회종료 제작연도를 입력합니다.

        repNationCd	문자열	N개의 국적으로 조회할 수 있으며, 국적코드는 공통코드 조회 서비스에서 “2204” 로서 조회된 국적코드입니다. (default : 전체)
        movieTypeCd	문자열
        N개의 영화유형코드로 조회할 수 있으며, 영화유형코드는 공통코드 조회 서비스에서 “2201”로서 조회된 영화유형코드입니다.

        (default: 전체)*/
    }
}
