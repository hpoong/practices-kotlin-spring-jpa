package com.hopoong.jpa.api.member.repository

import com.hopoong.jpa.entity.Member
import org.springframework.stereotype.Repository
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

    fun findAll(): MutableList<Member> {
        return em.createQuery("select m from Member m", Member::class.java).resultList
    }

    fun findOne(id: Long): Member {
        return em.find(Member::class.java, id)
    }
}