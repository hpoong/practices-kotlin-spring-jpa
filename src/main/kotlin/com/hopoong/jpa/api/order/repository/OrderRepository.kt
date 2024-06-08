package com.hopoong.jpa.api.order.repository

import com.hopoong.jpa.api.item.repository.ItemRepository
import com.hopoong.jpa.api.member.repository.MemberRepository
import com.hopoong.jpa.entity.*
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Repository
class OrderRepository() {


    @PersistenceContext
    private lateinit var em: EntityManager

    fun save(order: Order) {
        em.persist(order)
    }


}

