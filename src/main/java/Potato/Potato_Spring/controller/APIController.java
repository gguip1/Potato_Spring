package Potato.Potato_Spring.controller;

import Potato.Potato_Spring.domain.Content;
import Potato.Potato_Spring.service.ContentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class APIController {

    private final ContentService contentService;

    public APIController(ContentService contentService) {
        this.contentService = contentService;
    }

    @RequestMapping(value = "/application/api/test", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Content> getTest(){
        List<Content> testContents = contentService.findContents();
        return testContents;
    }
}
