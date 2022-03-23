package com.movie.cinema.service;

import com.movie.cinema.api.MovieApi;
import com.movie.cinema.mapper.MovieMapper;
import com.movie.cinema.model.Movie;
import com.movie.cinema.utils.CommonCode;
import com.movie.cinema.utils.CommonUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    private MovieMapper movieMapper;

    public MovieService(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    public List<Map<String, Object>> movieList(Map<String, Object> paramMap) {
        List<Map<String, Object>> list = new ArrayList<>();

        list.clear();
        list.addAll(movieMapper.movieList(paramMap));

        return list;
    }

    public void movieSave() {
        MovieApi movieApi = new MovieApi();
        List<Map<String, Object>> movieList = new ArrayList<>();
        int isExist = 0;

        movieList.clear();

        movieList.addAll(movieApi.requestApi("2022-02-22"));
        if(movieList.size() > 0) {
            for(Map<String, Object> movieMap : movieList) {
                System.out.println("코드 ::: " + String.valueOf(movieMap.get("movieCd")));
                isExist = 0;
                isExist = movieMapper.movieByCode(String.valueOf(movieMap.get("movieCd")));
                System.out.println("count :: " + isExist);
                if(isExist == 0) {
                    Movie movie = new Movie();
                    movie.setCode(String.valueOf(movieMap.get("movieCd")));
                    movie.setTitle(String.valueOf(movieMap.get("movieNm")));
                    movie.setGenre(CommonUtils.listToString((List<Map<String, Object>>) movieMap.get("genres"), "genreNm"));
                    movie.setProductor(CommonUtils.listToString((List<Map<String, Object>>) movieMap.get("companys"), "companyNm"));
                    movie.setDirector(CommonUtils.listToString((List<Map<String, Object>>) movieMap.get("directors"), "peopleNm"));
                    movie.setActors(CommonUtils.listToString((List<Map<String, Object>>) movieMap.get("actors"), "peopleNm"));
                    movie.setState(CommonCode.CINEMA_STATE_OPEN);

                    movieMapper.movieSave(movie);
                }
            }
        }
    }

}
