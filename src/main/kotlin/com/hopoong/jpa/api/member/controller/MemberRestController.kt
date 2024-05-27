package com.hopoong.jpa.api.member.controller

import com.hopoong.jpa.api.member.service.MemberService
import org.springframework.web.bind.annotation.RestController


@RestController
class MemberRestController(
    private val memberService: MemberService
) {



}