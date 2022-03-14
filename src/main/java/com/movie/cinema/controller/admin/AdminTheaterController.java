package com.movie.cinema.controller.admin;

import com.movie.cinema.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/theater")
public class AdminTheaterController {

    private TheaterService theaterService;

    @Autowired
    public AdminTheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @RequestMapping("/theaterList")
    public ModelAndView theaterList(@RequestParam(required = false) Map<String, Object> paramMap, ModelAndView mav) {
        List<Map<String, Object>> theaters = new ArrayList<>();

        theaters.clear();
        theaters.addAll(theaterService.theaterList(paramMap));
        mav.addObject("theaters", theaters);
        mav.setViewName("admin/theater/theaterList");
        return mav;
    }

    @RequestMapping("/theaterDetail")
    public ModelAndView theaterDetail(Long idx, ModelAndView mav) {
        Map<String, Object> theater = new HashMap<>();

        theater.clear();
        theater.putAll(theaterService.theaterDetail(idx));
        mav.addObject("theater", theater);
        mav.setViewName("admin/theater/theaterDetail");
        return mav;
    }

    @RequestMapping("/theaterDel")
    public ModelAndView theaterDel(Long idx, ModelAndView mav) {
        mav.setViewName("redirect:/admin/theater/theaterList");
        return mav;
    }
}
