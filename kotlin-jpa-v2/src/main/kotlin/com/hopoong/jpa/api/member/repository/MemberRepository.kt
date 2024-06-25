package com.hopoong.jpa.api.member.repository

import com.hopoong.jpa.api.member.dto.RegisterMemberDTO
import com.hopoong.jpa.entity.Member
import com.hopoong.jpa.exception.BusinessException
import com.hopoong.jpa.response.CommonCode
import org.springframework.stereotype.Repository
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class MemberRepository {

    @PersistenceContext
    private lateinit var em: EntityManager

    fun findByName(name: String): MutableList<Member> {
        return em.createQuery("select m from Member m where m.name = :name", Member::class.java)
            .setParameter("name", name)
            .resultList
    }

    fun save(member: Member) {
        em.persist(member)
    }

//    fun findAll(): MutableList<RegisterMemberDTO> {
//        return em.
//            createQuery("select new RegisterMemberDTO(m.name, m.address) from Member m", RegisterMemberDTO::class.java)
//            .resultList
//    }

    fun findAll(): MutableList<Member> {
        return em.
        createQuery("select m from Member m", Member::class.java)
            .resultList
    }


//    fun findAll(): MutableList<Member> {
//        return em.createQuery("select m from Member m", Member::class.java).resultList
//    }

    fun findOne(id: Long): Optional<Member> {
        return Optional.ofNullable(em.find(Member::class.java, id))
    }
}

