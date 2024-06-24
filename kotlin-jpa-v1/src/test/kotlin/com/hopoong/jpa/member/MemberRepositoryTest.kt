package com.hopoong.jpa.member

import com.hopoong.jpa.api.member.dto.RegisterMemberDTO
import com.hopoong.jpa.api.member.service.MemberService
import com.hopoong.jpa.entity.embeddable.Address
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@SpringBootTest
class MemberRepositoryTest(
    @Autowired private val memberService: MemberService,
) {

    @PersistenceContext
    private lateinit var em: EntityManager

    @Test
    @Transactional
    @Rollback(false)
    fun testMember() {

//        // given
//        val member = Member(name = "memberA")
//
//        // when
//        val savedId = memberRepository.saveEmTest(member)
//        val findMember: Member = memberRepository.findEmTest(savedId)
//
//        // then
//        Assertions.assertThat(findMember.id).isEqualTo(member.id)
//        Assertions.assertThat(findMember.name).isEqualTo(member.name)
//        Assertions.assertThat(findMember).isEqualTo(member)
    }


    @Test
    @Transactional
    @Rollback(false)
    fun join() {

        // given
        val memberDto = RegisterMemberDTO(name = "memberA", address = Address(city = "도시", street = "거리", zipcode = "우편번호"))

        //when
        val saveId: Long? = memberService.join(memberDto)

        //then
        em.flush()
    }




}