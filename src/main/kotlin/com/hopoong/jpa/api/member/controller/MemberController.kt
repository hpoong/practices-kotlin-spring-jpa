package com.hopoong.jpa.api.member.controller

import com.hopoong.jpa.api.member.dto.MemberForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class MemberController {

    @GetMapping(value = ["/members/new"])
    fun createForm(model: Model): String? {
        model.addAttribute("memberForm", MemberForm(null, null, null, null))
        return "members/createMemberForm"
    }

//    @GetMapping(value = ["/members/new"])
//    fun createForm(model: Model): String? {
//        model.addAttribute("memberForm", MemberForm(null, null, null, null))
//        return "members/createMemberForm"
//    }
}