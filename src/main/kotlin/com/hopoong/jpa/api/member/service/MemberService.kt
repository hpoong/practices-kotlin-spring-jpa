package com.hopoong.jpa.api.member.service

import com.hopoong.jpa.api.member.dto.RegisterMemberDTO
import com.hopoong.jpa.api.member.repository.MemberRepository
import com.hopoong.jpa.entity.Member
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
    fun join(memberDto: RegisterMemberDTO): Long? {
        var member = memberDto.toEntity()
        validateDuplicateMember(member)
        memberRepository.save(member)
        return member.id
    }

    /*
     * 회원 전체 조회
     */
    fun findAll(): MutableList<RegisterMemberDTO> {
        return memberRepository.findAll()
    }

    /*
     * 특정 회원 조회
     */
    fun findOne(id: Long): Member {
        return memberRepository.findOne(id)
    }

    /*
     * 회원 중복체크
     */
    private fun validateDuplicateMember(member: Member) {
        val member: MutableList<Member> = memberRepository.findByName(member.name)
        if(!member.isEmpty())
            throw IllegalStateException("이미 존재하는 회원입니다.")
    }
}