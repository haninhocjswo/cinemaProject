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
        MovieApi movieApi = new MovieApi();
        Map<String, Object> map = new HashMap<>();

        map.clear();
        map.putAll(movieApi.totalPage());


        ModelAndView mav = new ModelAndView();

        mav.setViewName("test");
        mav.addObject("message", "zzzzz");

        return "test";
    }
}
