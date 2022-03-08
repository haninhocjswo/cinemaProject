package com.movie.cinema.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

    @RequestMapping(value = {"", "/"})
    public ModelAndView adminHome(ModelAndView mav) {
        mav.setViewName("redirect:/admin/main");
        return mav;
    }

    @RequestMapping("/main")
    public String adminMain() {
        return "admin/index";
    }
}
