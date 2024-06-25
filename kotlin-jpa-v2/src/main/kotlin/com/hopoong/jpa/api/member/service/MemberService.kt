package com.hopoong.jpa.api.member.service

import com.hopoong.jpa.api.member.dto.RegisterMemberDTO
import com.hopoong.jpa.api.member.repository.MemberRepository
import com.hopoong.jpa.entity.Member
import com.hopoong.jpa.exception.BusinessException
import com.hopoong.jpa.response.CommonCode
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberService(
    private val memberRepository: MemberRepository
) {

    /*
     * 회원 가입
     */
    @Transactional
    fun join(member: Member): Long {
        validateDuplicateMember(member)
        memberRepository.save(member)
        return member.id!!
    }

    /*
     * 회원 전체 조회
     */
    fun findMembers(): MutableList<Member> {
        return memberRepository.findAll()
    }


    /*
     * 회원 중복체크
     */
    private fun validateDuplicateMember(member: Member) {
        val member: MutableList<Member> = memberRepository.findByName(member.name)
        if(!member.isEmpty())
            throw IllegalStateException("이미 존재하는 회원입니다.")
    }

    /*
     * 회원 수정
     */
    @Transactional
    fun update(id: Long, name: String): Member {
        val member = memberRepository.findOne(id).orElseThrow { BusinessException(CommonCode.MEMBER, "존재하지 않는 회원입니다.") }
        member.name = name
        return member
    }

}