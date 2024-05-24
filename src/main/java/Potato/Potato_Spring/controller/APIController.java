package Potato.Potato_Spring.controller;

import Potato.Potato_Spring.domain.Content;
import Potato.Potato_Spring.domain.ContentGenres;
import Potato.Potato_Spring.domain.Count;
import Potato.Potato_Spring.domain.Genre;
import Potato.Potato_Spring.service.APIService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class APIController {

    private final APIService APIService;

    private static final List<String> CONTENT_TABLE_NAMES = Arrays.asList(
            "movie_test", "couplay", "kakaowebtoon", "kpnovel", "naverwebtoon", "netflix", "watcha"
    );

    private static final List<String> GENRE_TABLE_NAMES = Arrays.asList(
                "movie_test_genre", "couplay_genre", "kakaowebtoon_genre", "kpnovel_genre", "naverwebtoon_genre", "netflix_genre", "watcha_genre"
    );

    public APIController(APIService APIService) {
        this.APIService = APIService;
    }

    @RequestMapping(value = "/application/api/getContentById", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Content> getContentById(@RequestParam String tableName, @RequestParam int id){
        if(CONTENT_TABLE_NAMES.contains(tableName)){

            String query = "SELECT * FROM " + tableName + " WHERE id = " + id;

            return APIService.getContent(query);
        }
        return null;
    }

    @RequestMapping(value = "/application/api/getContentByIdCount", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Count> getContentByIdCount(@RequestParam String tableName, @RequestParam int id){
        if(CONTENT_TABLE_NAMES.contains(tableName)){

            String query = "SELECT COUNT(*) AS cnt FROM " + tableName + " WHERE id = " + id;

            return APIService.getCount(query);
        }
        return null;
    }

    @RequestMapping(value = "/application/api/getPaginatedContents", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Content> getPaginatedContents(@RequestParam("tableName") String tableName, @RequestParam("page") int page, @RequestParam("pagingUnit") int pagingUnit){
        if(CONTENT_TABLE_NAMES.contains(tableName)){

            String query = "SELECT * FROM " + tableName + " ORDER BY id ASC LIMIT " + pagingUnit + " OFFSET " + page * pagingUnit;

            return APIService.getContent(query);
        }
        return null;
    }

    @RequestMapping(value = "/application/api/getPaginatedContentsCount", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Count> getPaginatedContentsCount(@RequestParam("tableName") String tableName, @RequestParam("page") int page, @RequestParam("pagingUnit") int pagingUnit){
        if(CONTENT_TABLE_NAMES.contains(tableName)){

            String query = "SELECT COUNT(*) AS cnt FROM " + tableName + " ORDER BY id ASC LIMIT " + pagingUnit + " OFFSET " + page * pagingUnit;

            return APIService.getCount(query);
        }
        return null;
    }

    @RequestMapping(value = "/application/api/getContent", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Content> getContent(@RequestParam String tableName){
        if(CONTENT_TABLE_NAMES.contains(tableName)){

            String query = "SELECT * as cnt FROM " + tableName;

            return APIService.getContent(query);
        }
        return null;
    }

    @RequestMapping(value = "/application/api/getContentCount", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Count> getContentCount(@RequestParam String tableName){
        if(CONTENT_TABLE_NAMES.contains(tableName)){

            String query = "SELECT count(*) AS cnt as cnt FROM " + tableName;

            return APIService.getCount(query);
        }
        return null;
    }

    @RequestMapping(value = "/application/api/getAllGenres", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Genre> getAllGenres(){
        String query = "SELECT * FROM genre";
        return APIService.getGenre(query);
    }

    @RequestMapping(value = "/application/api/getContentByGenreId", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
        public List<ContentGenres> getContentByGenreId(@RequestParam String tableName, @RequestParam int genre_id){
        if(GENRE_TABLE_NAMES.contains(tableName)){
            String query = "SELECT * FROM " + tableName + " WHERE genre_id = " + genre_id;

            return APIService.getContentGenre(query);
        }
        return null;
    }

    @RequestMapping(value = "/application/api/getContentByGenreIdCount", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Count> getContentByGenreIdCount(@RequestParam String tableName, @RequestParam int genre_id){
        if(GENRE_TABLE_NAMES.contains(tableName)){
            String query = "SELECT COUNT(*) AS cnt FROM " + tableName + " WHERE genre_id = " + genre_id;

            return APIService.getCount(query);
        }
        return null;
    }

    @RequestMapping(value = "/application/api/getContentGenreById", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ContentGenres> getContentGenreById(@RequestParam String tableName, @RequestParam int id){
        if(GENRE_TABLE_NAMES.contains(tableName)){
            String query = "SELECT * FROM " + tableName + " WHERE id = " + id;

            return APIService.getContentGenre(query);
        }
        return null;
    }

    @RequestMapping(value = "/application/api/getContentGenreByIdCount", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Count> getContentGenreByIdCount(@RequestParam String tableName, @RequestParam int id){
        if(GENRE_TABLE_NAMES.contains(tableName)){
            String query = "SELECT COUNT(*) AS cnt FROM " + tableName + " WHERE id = " + id;

            return APIService.getCount(query);
        }
        return null;
    }

    @RequestMapping(value = "/application/api/getGenreNamesByContentId", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Genre> getGenreNamesByContentId(@RequestParam String tableName, @RequestParam int id){
        if(GENRE_TABLE_NAMES.contains(tableName)){
            String query = "SELECT * FROM genre WHERE genre_id in (SELECT genre_id FROM " + tableName + " WHERE id = " + id + ")";

            return APIService.getGenre(query);
        }
        return null;
    }

    @RequestMapping(value = "/application/api/getGenreNamesByContentIdCount", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Count> getGenreNamesByContentIdCount(@RequestParam String tableName, @RequestParam int id){
        if(GENRE_TABLE_NAMES.contains(tableName)){
            String query = "SELECT COUNT(*) AS cnt FROM genre WHERE genre_id in (SELECT genre_id FROM " + tableName + " WHERE id = " + id + ")";

            return APIService.getCount(query);
        }
        return null;
    }

    @RequestMapping(value = "/application/api/getContentsByGenreId", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Content> getContentsByGenreId(@RequestParam String tableName, @RequestParam int genre_id){
        if(CONTENT_TABLE_NAMES.contains(tableName)){
            String query = "SELECT * FROM " + tableName + " WHERE id in (SELECT id FROM " + tableName + "_genre WHERE genre_id = " + genre_id + ")";

            return APIService.getContent(query);
        }
        return null;
    }

    @RequestMapping(value = "/application/api/getContentsByGenreIdCount", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Count> getContentsByGenreIdCount(@RequestParam String tableName, @RequestParam int genre_id){
        if(CONTENT_TABLE_NAMES.contains(tableName)){
            String query = "SELECT * FROM " + tableName + " WHERE id in (SELECT id FROM " + tableName + "_genre WHERE genre_id = " + genre_id + ")";

            return APIService.getCount(query);
        }
        return null;
    }

}
