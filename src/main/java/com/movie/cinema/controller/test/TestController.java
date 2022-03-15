package com.movie.cinema.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String test() {
        List<Map<String, Object>> firstMapList = new ArrayList<>();
        List<Map<String, Object>> secondMapList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> secondmap = new HashMap<>();

        firstMapList.clear();
        secondMapList.clear();
        map.clear();
        secondmap.clear();

        map.put("aaa", 111);
        map.put("bbb", 222);
        map.put("ccc", 333);

        for(int i = 0; i < 5; i++) {
            firstMapList.add(map);
        }

        secondmap.clear();
        secondmap.put("가가가", "kkk");
        secondmap.put("나나나", "zzz");
        secondmap.put("다다다", "xxx");

        for(int k = 0; k < 3; k++) {
            secondMapList.add(secondmap);
        }

        firstMapList.addAll(secondMapList);

        for(int j = 0; j < firstMapList.size(); j++) {
            System.out.println(j + "번째 : " + firstMapList.get(j).entrySet());
        }

        return "test";
    }
}
