package com.hopoong.jpa.member

import com.hopoong.jpa.api.member.model.Member
import com.hopoong.jpa.api.member.repository.MemberRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional


@SpringBootTest
class MemberRepositoryTest(
    @Autowired private val memberRepository: MemberRepository
) {


    @Test
    @Transactional
    @Rollback(false)
    fun testMember() {

        // given
        val member = Member(name = "memberA")

        // when
        val savedId = memberRepository.saveEmTest(member)
        val findMember: Member = memberRepository.findEmTest(savedId)

        // then
        Assertions.assertThat(findMember.id).isEqualTo(member.id)
        Assertions.assertThat(findMember.name).isEqualTo(member.name)
        Assertions.assertThat(findMember).isEqualTo(member)
    }

}