package Potato.Potato_Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/")
    public String save()
}
