package Potato.Potato_Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(){
        return "web/index.html";
    }

    @GetMapping("/guide")
    public String guide(){return "web/guide.html";}

    @GetMapping("/info")
    public String info(){return "web/info.html";}

    @GetMapping("/redirectToIndex")
    public String redirectToIndex(){
        return "web/index";
    }
}
