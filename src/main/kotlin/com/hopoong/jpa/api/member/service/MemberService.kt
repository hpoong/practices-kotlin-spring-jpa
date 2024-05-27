package com.hopoong.jpa.api.member.service

import com.hopoong.jpa.api.member.repository.MemberRepository
import com.hopoong.jpa.entity.Member
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

    fun join(member: Member): Long {
        validateDuplicateMember(member)
        memberRepository.save(member)
        return member.id
    }

    fun findAll(): MutableList<Member> {
        return memberRepository.findAll()
    }

    fun findOne(id: Long): Member {
        return memberRepository.findOne(id)
    }

    private fun validateDuplicateMember(member: Member) {
        val test: MutableList<Member> = memberRepository.findByName(member.name)
        if(!test.isEmpty())
            throw IllegalStateException("이미 존재하는 회원입니다.")
    }

}