package com.movie.cinema.controller.admin;

import com.movie.cinema.service.CinemaService;
import com.movie.cinema.service.TheaterService;
import com.movie.cinema.utils.CommonCode;
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

    private CinemaService cinemaService;

    public AdminTheaterController(TheaterService theaterService, CinemaService cinemaService) {
        this.theaterService = theaterService;
        this.cinemaService = cinemaService;
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
        Map<String, Object> paramMap = new HashMap<>();
        Map<String, Object> theater = new HashMap<>();
        List<Map<String, Object>> cinemas = new ArrayList<>();

        paramMap.clear();
        cinemas.clear();
        theater.clear();

        paramMap.put("state", CommonCode.CINEMA_STATE_OPEN);
        cinemas.addAll(cinemaService.cinemaList(paramMap));
        theater.putAll(theaterService.theaterDetail(idx));
        mav.addObject("cinemas", cinemas);
        mav.addObject("theater", theater);
        mav.setViewName("admin/theater/theaterDetail");
        return mav;
    }

    @RequestMapping("/theaterUpdate")
    public ModelAndView theaterUpdate(@RequestParam(required = false) Map<String, Object> paramMap, ModelAndView mav) {
        theaterService.theaterUpdate(paramMap);
        mav.setViewName("redirect:/admin/theater/theaterList");
        return mav;
    }

    @RequestMapping("/theaterDel")
    public ModelAndView theaterDel(Long idx, ModelAndView mav) {
        theaterService.theaterDel(idx);
        mav.setViewName("redirect:/admin/theater/theaterList");
        return mav;
    }
}
