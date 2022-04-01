package com.movie.cinema.controller.test;

import com.movie.cinema.api.MovieApi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();

        mapList.clear();
        map1.clear();
        map2.clear();
        map3.clear();

        map1.put("alphabet", "a");
        map2.put("alphabet", "b");
        map2.put("alphabet", "c");

        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);

        return "test";
    }
}
