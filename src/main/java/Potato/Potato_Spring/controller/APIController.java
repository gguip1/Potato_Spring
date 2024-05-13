package Potato.Potato_Spring.controller;

import Potato.Potato_Spring.domain.Content;
import Potato.Potato_Spring.service.ContentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class APIController {

    private final ContentService contentService;

    public APIController(ContentService contentService) {
        this.contentService = contentService;
    }

//    @RequestMapping(value = "/application/api/test", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<Content> getTest(){
//        List<Content> testContents = contentService.findContents();
//        return testContents;
//    }

    @RequestMapping(value = "/application/api/contents", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Content> contents(@RequestParam("tableName") String tableName, @RequestParam("page") int page, @RequestParam("pagingUnit") int pagingUnit){
        List<Content> resultContents = contentService.findAllByPage(tableName,page,pagingUnit);
        return resultContents;
    }

    @RequestMapping(value = "/application/api/contentsCount", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public long contentsCount(@RequestParam String tableName){
        long testContents = contentService.countAll(tableName);
        return testContents;
    }
}
