package com.movie.cinema.controller.admin;

import com.movie.cinema.service.MemberService;
import com.movie.cinema.utils.CommonCode;
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
    public ModelAndView memberList(@RequestParam(required = false) Map<String, Object> map, ModelAndView mav) {
        List<Map<String, Object>> members = memberService.memberList(map);

        mav.addObject("members", members);
        mav.setViewName("admin/member/memberList");
        return mav;
    }

    @RequestMapping("/memberDetail")
    public ModelAndView memberDetail(@RequestParam Long idx, ModelAndView mav) {
        Map<String, Object> member = memberService.memberDetail(idx);

        mav.setViewName("admin/member/memberDetail");
        mav.addObject("member", member);
        return mav;
    }

    @RequestMapping("/memberUpdate")
    public ModelAndView memberUpdate(ModelAndView mav, @RequestParam(required = true) Map<String, Object> memberForm)  {
        memberService.memberUpdate(memberForm);
        mav.setViewName("redirect:/admin/member/memberList");
        return mav;
    }

    @RequestMapping("/memberDel")
    public ModelAndView memberDel(Long idx, ModelAndView mav) {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.clear();

        resultMap.put("idx", idx);
        resultMap.put("state", CommonCode.MEMBER_STATE_DEL);
        memberService.memberDel(resultMap);
        mav.setViewName("redirect:/admin/member/memberList");
        return mav;
    }
}
