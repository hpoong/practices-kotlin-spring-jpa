package com.hopoong.jpa.api.member.controller

import com.hopoong.jpa.api.member.dto.MemberAllDTO
import com.hopoong.jpa.api.member.service.MemberService
import com.hopoong.jpa.entity.Member
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class MemberRestController(
    private val memberService: MemberService
) {


    @GetMapping(value = ["/members"])
    fun getMembers(model: Model): MutableList<MemberAllDTO> {
        return memberService.findAll()
    }

}