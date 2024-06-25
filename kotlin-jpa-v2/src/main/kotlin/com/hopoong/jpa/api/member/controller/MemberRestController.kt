package com.hopoong.jpa.api.member.controller

import com.hopoong.jpa.api.member.dto.MemberDto
import com.hopoong.jpa.api.member.service.MemberService
import com.hopoong.jpa.entity.Member
import com.hopoong.jpa.response.CommonCode
import com.hopoong.jpa.response.CommonResponse
import com.hopoong.jpa.response.SuccessResponses
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import org.springframework.web.bind.annotation.PathVariable

import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.GetMapping
import java.util.function.Function
import java.util.stream.Collectors


@RestController
class MemberRestController(
    private val memberService: MemberService
) {

    // ********************* 회원 등록
    @PostMapping(value = ["/v1/members"])
    fun join(@RequestBody member: @Valid Member): Long {
        return memberService.join(member)
    }

    @PostMapping(value = ["/v2/members"])
    fun findAll(@Valid @RequestBody request: MemberDto.Request.CreateMemberRequest): CommonResponse {
        val member = Member(name = request.name)
        val id = memberService.join(member)
        return SuccessResponses(code = CommonCode.MEMBER, data = MemberDto.Response.CreateMemberResponse(id))
    }

    // ********************* 회원 수정
    @PutMapping("/api/v2/members/{id}")
    fun updateMemberV2(@PathVariable("id") id: Long, @Valid @RequestBody request: MemberDto.Request.UpdateMemberRequest): CommonResponse {
        val findMember = memberService.update(id, request.name)
        return SuccessResponses(code = CommonCode.MEMBER, data = MemberDto.Response.UpdateMemberResponse(findMember.id!!, findMember.name))
    }

    // ********************* 회원 조회
    @GetMapping("/api/v1/members")
    fun membersV1(): CommonResponse {
        return SuccessResponses(code = CommonCode.MEMBER, data = memberService.findMembers())
    }

    @GetMapping("/api/v2/members")
    fun membersV2(): CommonResponse {
        var findMembers = memberService.findMembers()
        val collect: List<MemberDto> = findMembers.stream()
            .map(Function { m: Member -> MemberDto(m.name) })
            .collect(Collectors.toList())

        return SuccessResponses(code = CommonCode.MEMBER, data = collect)
    }





//
//
//    // ********************* 회원 등록 DTO
//    data class CreateMemberRequest(
//        @field:NotEmpty(message = "필수값.")
//        var name: String
//    )
//
//    data class CreateMemberResponse(
//        var id: Long
//    )
//
//    // ********************* 수정
//    data class UpdateMemberRequest(
//        @field:NotEmpty(message = "필수값.")
//        var name: String
//    )
//
//    class UpdateMemberResponse (
//        var id: Long,
//        var name: String
//    )



}