package com.movie.cinema.controller.admin;

import com.movie.cinema.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

    private MemberService memberService;

    public AdminMemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("/memberList")
    public ModelAndView memberList(@RequestParam(required = true) Map<String, Object> map, ModelAndView mav) {
        List<Map<String, Object>> members = memberService.memberList(map);
        System.out.println("size : " + members.size());
        for(Map<String, Object> member : members) {
            System.out.println("sss : " + member.entrySet());
        }
        mav.addObject("members", members);
        mav.setViewName("admin/member/memberList");
        return mav;
    }
}
