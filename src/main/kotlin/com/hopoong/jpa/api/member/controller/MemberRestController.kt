package com.hopoong.jpa.api.member.controller

import com.hopoong.jpa.api.member.dto.RegisterMemberDTO
import com.hopoong.jpa.api.member.service.MemberService
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class MemberRestController(
    private val memberService: MemberService
) {

    @PostMapping(value = ["/members"])
    fun join(@RequestBody registerMemberDTO: RegisterMemberDTO) {
        return memberService.join(registerMemberDTO)
    }

    @GetMapping(value = ["/members"])
    fun findAll(model: Model): MutableList<RegisterMemberDTO> {
        return memberService.findAll()
    }

}