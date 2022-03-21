package com.movie.cinema.controller.admin;

import com.movie.cinema.model.Movie;
import com.movie.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/movie")
public class AdminMovieController {

    private MovieService movieService;

    @Autowired
    public AdminMovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/movieList")
    public ModelAndView movieList(@RequestParam Map<String, Object> paramMap, ModelAndView mav) {
        List<Map<String, Object>> movies = new ArrayList<>();

        movies.clear();
        movies.addAll(movieService.movieList(paramMap));

        mav.addObject("movies", movies);
        mav.setViewName("admin/movie/movieList");
        return mav;
    }

    @RequestMapping("/movieSave")
    public String movieSave() {
        movieService.movieSave();
        return "redirect:/admin/movie/movieList";
    }

}
