package Potato.Potato_Spring.controller;

import Potato.Potato_Spring.domain.Content;
import Potato.Potato_Spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContentController {
    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService){
        this.contentService = contentService;
    }

    @GetMapping("members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(ContentForm form){
        Content content = new Content();
        content.setTitle(form.getTitle());
        content.setImg(form.getImg());
        content.setDescription(form.getDescription());
        content.setDirector(form.getDirector());
        content.setActor(form.getActor());

        contentService.join(content);

        return "redirect:/";
    }

    @GetMapping("/contents")
    public String list(Model model){
        List<Content> contents = contentService.findContents();
        model.addAttribute("contents", contents);
        System.out.println(contents.get(0).getId());
        System.out.println(contents.get(0).getTitle());
        System.out.println(contents.get(0).getImg());
        System.out.println(contents.get(0).getDescription());
        System.out.println(contents.get(0).getDirector());
        System.out.println(contents.get(0).getActor());
        return "contents/movie_test";
    }
}
