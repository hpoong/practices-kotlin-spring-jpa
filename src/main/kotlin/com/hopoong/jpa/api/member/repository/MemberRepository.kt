package com.hopoong.jpa.api.member.repository

import com.hopoong.jpa.api.member.model.Member
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class MemberRepository {

    @PersistenceContext
    private lateinit var em: EntityManager

    fun saveEmTest(member: Member): Long {
        em.persist(member)
        return member.id
    }

    fun findEmTest(id: Long?): Member {
        return em.find(Member::class.java, id)
    }
}