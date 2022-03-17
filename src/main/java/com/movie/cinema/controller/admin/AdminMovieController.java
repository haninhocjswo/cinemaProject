package com.movie.cinema.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/admin/movie")
public class AdminMovieController {

    @RequestMapping("/movieList")
    public ModelAndView movieList(@RequestParam Map<String, Object> paramMap, ModelAndView mav) {
        return mav;
    }
}
