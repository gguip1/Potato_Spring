package Potato.Potato_Spring.controller;

import Potato.Potato_Spring.domain.Member;
import Potato.Potato_Spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

//    @PostMapping("/web/login/signup")
//    public String signup(){
//        Member member = new Member();
//        member.setName(form.getName());
//    }
}
