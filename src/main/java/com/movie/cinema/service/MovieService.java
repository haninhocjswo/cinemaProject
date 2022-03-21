package com.movie.cinema.service;

import com.movie.cinema.api.MovieApi;
import com.movie.cinema.mapper.MovieMapper;
import com.movie.cinema.model.Movie;
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
        List<Map<String, Object>> savedMapList = new ArrayList<>();
        List<Map<String, Object>> directorList = new ArrayList<>();
        String directorStr = "";
        List<Map<String, Object>> productorList = new ArrayList<>();
        String productorStr = "";
        String year = "";
        Integer isExist = 0;
        double totalPageDouble = 0.0;
        int totalPage = 1;

        Map<String, Object> apiParamMap = movieApi.totalPage();
        year = String.valueOf(apiParamMap.get("year"));
        totalPageDouble = (Double) apiParamMap.get("totalPage");
        totalPage = (int) totalPageDouble;

        if(totalPage > 0) {
            for(int i = 1; i <= totalPage; i++) {
                savedMapList.clear();
                savedMapList.addAll(movieApi.requestApi(i, year));

                if(savedMapList.size() > 0) {
                    for(int k = 0; k < savedMapList.size(); k++) {
                        Movie movie = new Movie();
                        movie.setTitle(String.valueOf(savedMapList.get(k).get("movieNm")));
                        movie.setCode(String.valueOf(savedMapList.get(k).get("movieCd")));
                        movie.setGenre(String.valueOf(savedMapList.get(k).get("repGenreNm")));
                        movie.setProductor("");
                        movie.setState(String.valueOf(savedMapList.get(k).get("prdtStatNm")));
                        movie.setDirector("");
                        movie.setActors("");

                        directorList.clear();
                        directorList.addAll((List<Map<String, Object>>) savedMapList.get(k).get("directors"));
                        if(directorList.size() > 0) {
                            directorStr = "";
                            for(int j = 0; j < directorList.size(); j++) {
                                if(j == 0) {
                                    directorStr += directorList.get(j).toString();
                                } else {
                                    directorStr += ", " + directorList.get(j).toString();
                                }
                            }

                            movie.setDirector(directorStr);
                        }

                        productorList.clear();
                        productorList.addAll((List<Map<String, Object>>) savedMapList.get(k).get("companys"));
                        if(productorList.size() > 0) {
                            productorStr = "";
                            for(int l = 0; l < productorList.size(); l++) {
                                if(l == 0) {
                                    productorStr += productorList.get(l).get("companyNm").toString();
                                } else {
                                    productorStr += ", " + productorList.get(l).get("companyNm").toString();
                                }
                            }

                            movie.setProductor(productorStr);
                        }

                        //해당 영화 코드로 조회하여 영화가 존재하는지 확인
                        //영화가 존재하면 update 존재하지 않으면 insert
                        isExist = 0;
                        isExist = movieMapper.movieByCode(String.valueOf(savedMapList.get(k).get("movieCd")));

                        if(isExist > 0) {
                            //존재할 때 update
                            System.out.println("영화 수정 :: " + String.valueOf(savedMapList.get(k).get("movieCd")));
                            movieMapper.movieUpdate(movie);
                        } else {
                            //존재하지 않을 때 insert
                            System.out.println("영화 생성 :: " + String.valueOf(savedMapList.get(k).get("movieCd")));
                            movieMapper.movieSave(movie);
                        }
                    }
                }
            }
        }
    }

}
