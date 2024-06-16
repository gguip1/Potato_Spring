package Potato.Potato_Spring.controller;

import Potato.Potato_Spring.domain.Exhibition;
import Potato.Potato_Spring.dto.MemberDTO;
import Potato.Potato_Spring.service.ExhibitionService;
import Potato.Potato_Spring.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebController {
    private final LocalDate now = LocalDate.now();

    private final ExhibitionService exhibitionService;
    private final MemberService memberService;

    // 세션 관리 메서드 추가
    private HttpSession getSession(HttpServletRequest request) {
        return request.getSession();
    }

    @ModelAttribute
    public void header(Model model, HttpServletRequest request){
        HttpSession session = getSession(request);
        Object user = session.getAttribute("id");

        model.addAttribute("isLoggedIn", user != null);
    }

    @GetMapping("/")
    public String index(Model model){
        String query = "SELECT * FROM exhibition WHERE end_date >= CURRENT_DATE() ORDER BY start_date DESC LIMIT 8";
        List<Exhibition> items = exhibitionService.getExhibition(query);

        model.addAttribute("items", items);
        return "web/index.html";
    }

    @GetMapping("/login")
    public String login(){
        return "web/login/login.html";
    }

    @PostMapping("/login")
    public String login_(@ModelAttribute MemberDTO memberDTO, HttpServletRequest request){
        MemberDTO loginResult = memberService.login(memberDTO);

        if (loginResult != null){
            HttpSession session = getSession(request);
            session.setAttribute("id", loginResult);
            return "redirect:/";
        } else {
            return "web/login/login.html";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = getSession(request);
        if (session != null) {
            session.invalidate();
            System.out.println("Session invalidated successfully");
        } else {
            System.out.println("No session found to invalidate");
        }
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String signup(){
        return "web/login/signup.html";
    }

    @PostMapping("/signup")
    public String save(@ModelAttribute MemberDTO memberDTO){
        memberService.save(memberDTO);
        return "web/login/login.html";
    }

    @GetMapping("/mypage")
    public String mypage(){
        return "web/login/mypage.html";
    }

    @GetMapping("/info")
    public String info(){
        return "web/guide/info.html";
    }

    @GetMapping("/partners")
    public String partners(){
        return "web/guide/partners.html";
    }

    @GetMapping("/waytocome")
    public String waytocome(){
        return "web/guide/waytocome.html";
    }

    @GetMapping("/ongoing")
    public String ongoing(Model model){
        String query = "SELECT * FROM exhibition";
        List<Exhibition> items = exhibitionService.getExhibition(query);

        int itCount = 0;
        int jobCount = 0;
        int festivalCount = 0;

        for (Exhibition item : items) {
            int eDateResult = now.compareTo(item.getEnd_date().toLocalDate());
            int sDateResult = now.compareTo(item.getStart_date().toLocalDate());

            if (eDateResult > 0){
                item.setType_("End");
            }
//            else if (sDateResult < 0){
//                item.setType_("Not_Start");
//            }

            switch (item.getType_()){
                case "IT": itCount++; break;
                case "Job": jobCount++; break;
                case "Festival": festivalCount++; break;
                default: break;
            }
        }

        model.addAttribute("items", items);
        model.addAttribute("ALL", items.size());
        model.addAttribute("IT_Count", itCount);
        model.addAttribute("Job_Count", jobCount);
        model.addAttribute("Festival_Count", festivalCount);
        return "web/participation/ongoing.html";
    }

    @GetMapping("/boothguide")
    public String boothguide(){
        return "web/participation/boothguide.html";
    }

    @GetMapping("/faq")
    public String faq(){
        return "web/notice/FAQ.html";
    }

    @GetMapping("/gallery")
    public String gallery(){
        return "web/notice/gallery.html";
    }

    @GetMapping("/notice")
    public String notice(){
        return "web/notice/notice.html";
    }

    @GetMapping("/lastfair")
    public String lastfair(){
        return "web/lastfair/lastfair.html";
    }
}
