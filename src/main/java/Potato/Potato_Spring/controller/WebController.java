package Potato.Potato_Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(){
        return "web/index.html";
    }

    @GetMapping("/login")
    public String login(){
        return "web/login/login.html";
    }

    @GetMapping("/mypage")
    public String mypage(){
        return "web/login/mypage.html";
    }

    @GetMapping("/signup")
    public String signup(){
        return "web/login/signup.html";
    }

    @GetMapping("/guide")
    public String guide(){return "web/guide.html";}

    @GetMapping("/info")
    public String info(){return "web/info.html";}

    @GetMapping("/ongoing")
    public String ongoing(){return "web/participation/ongoing.html";}

    @GetMapping("/boothguide")
    public String boothguide(){return "web/participation/boothguide.html";}

    @GetMapping("/faq")
    public String faq(){return "web/notification/faq.html";}

    @GetMapping("/gallery")
    public String gallery(){return "web/notification/gallery.html";}

    @GetMapping("/notice")
    public String notice(){return "web/notification/notice.html";}
}
