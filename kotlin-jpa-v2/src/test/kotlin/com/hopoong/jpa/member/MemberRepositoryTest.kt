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

) {

    @PersistenceContext
    private lateinit var em: EntityManager

}