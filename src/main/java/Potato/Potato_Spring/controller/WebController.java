package Potato.Potato_Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(){
        return "web/index.html";
    }

    // 로그인
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

    // 가이드
    @GetMapping("/info")
    public String info(){return "web/guide/info.html";}

    @GetMapping("/partners")
    public String partners(){return "web/guide/partners.html";}

    @GetMapping("/waytocome")
    public String waytocome(){return "web/guide/waytocome.html";}

    // 참가 안내
    @GetMapping("/ongoing")
    public String ongoing(){return "web/participation/ongoing.html";}

    @GetMapping("/boothguide")
    public String boothguide(){return "web/participation/boothguide.html";}

    // 알림 마당
    @GetMapping("/faq")
    public String faq(){return "web/notice/FAQ.html";}

    @GetMapping("/gallery")
    public String gallery(){return "web/notice/gallery.html";}

    @GetMapping("/notice")
    public String notice(){return "web/notice/notice.html";}

    // 지난 박람회
    @GetMapping("/lastfair")
    public String lastfair(){return "web/lastfair/lastfair.html";}
}
