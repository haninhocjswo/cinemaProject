package com.movie.cinema.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CommonUtils {

    public static String listToString(List<Map<String, Object>> paramList, String key) {
        StringBuffer sb = new StringBuffer();

        if(paramList.size() > 0) {
            for(int i = 0; i < paramList.size(); i++) {
                if(i != 0) {
                    sb.append(", ");
                }
                sb.append(paramList.get(i).get(key).toString());
            }
        }
        return sb.toString();
    }
}
