package Potato.Potato_Spring.controller;

import Potato.Potato_Spring.domain.Content;
import Potato.Potato_Spring.domain.ContentGenres;
import Potato.Potato_Spring.domain.Count;
import Potato.Potato_Spring.domain.Genre;
import Potato.Potato_Spring.service.APIService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class APIController {

    private final APIService APIService;

    public APIController(APIService APIService) {
        this.APIService = APIService;
    }

    @RequestMapping(value = "/application/api/contents", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Content> contents(@RequestParam("tableName") String tableName, @RequestParam("page") int page, @RequestParam("pagingUnit") int pagingUnit){
        if(tableName.equals("movie_test") || tableName.equals("couplay") || tableName.equals("kakaowebtoon") || tableName.equals("kpnovel") || tableName.equals("naverwebtoon") || tableName.equals("netflix") || tableName.equals("watcha")){
            return APIService.findAllByPage(tableName,page,pagingUnit);
        }
        return null;
    }

    @RequestMapping(value = "/application/api/contentsCount", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Count> contentsCount(@RequestParam String tableName){
        if(tableName.equals("movie_test") || tableName.equals("couplay") || tableName.equals("kakaowebtoon") || tableName.equals("kpnovel") || tableName.equals("naverwebtoon") || tableName.equals("netflix") || tableName.equals("watcha")){
            return APIService.countAll(tableName);
        }
        return null;
    }

    @RequestMapping(value = "/application/api/genre", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Genre> genres(){
        return APIService.findGenres();
    }

    @RequestMapping(value = "/application/api/contentGenres", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ContentGenres> contentGenres(@RequestParam String tableName, @RequestParam int genre_id){
        if(tableName.equals("movie_test_genre") || tableName.equals("couplay_genre") || tableName.equals("kakaowebtoon_genre") || tableName.equals("kpnovel_genre") || tableName.equals("naverwebtoon_genre") || tableName.equals("netflix_genre") || tableName.equals("watcha_genre")){
            return APIService.findContenteGenres(tableName, genre_id);
        }
        return null;
    }
}
