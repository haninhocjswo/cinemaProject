package com.movie.cinema.controller.admin;

import com.movie.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/cinema")
public class AdminCinemaController {

    private CinemaService cinemaService;

    @Autowired
    public AdminCinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @RequestMapping("/cinemaList")
    public ModelAndView cinemaList(@RequestParam(required = false) Map<String, Object> map, ModelAndView mav) {
        List<Map<String, Object>> cinemas = cinemaService.cinemaList(map);

        mav.addObject("cinemas", cinemas);
        mav.setViewName("admin/cinema/cinemaList");
        return mav;
    }

    @RequestMapping("/cinemaDetail")
    public ModelAndView cinemaDetail(Long idx, ModelAndView mav) {
        Map<String, Object> cinema = new HashMap<>();

        cinema.clear();

        cinema.putAll(cinemaService.cinemaDetail(idx));
        mav.addObject("cinema", cinema);
        mav.setViewName("admin/cinema/cinemaDetail");
        return mav;
    }

    @RequestMapping("/cinemaUpdate")
    public ModelAndView cinemaUpdate(@RequestParam(required = false) Map<String, Object> map, ModelAndView mav) {
        cinemaService.cinemaUpdate(map);
        mav.setViewName("redirect:/admin/cinema/cinemaList");
        return mav;
    }

    @RequestMapping("/cinemaDel")
    public ModelAndView cinemaDel(Long idx, ModelAndView mav) {
        cinemaService.cinemaDel(idx);
        mav.setViewName("redirect:/admin/cinema/cinemaList");
        return mav;
    }
}
