package com.hopoong.jpa.api.item.repository

import com.hopoong.jpa.api.member.dto.MemberAllDTO
import com.hopoong.jpa.entity.Item
import com.hopoong.jpa.entity.Member
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class ItemRepository {


    @PersistenceContext
    private lateinit var em: EntityManager

    fun save(item: Item) {
        when (item.id) {
            null -> em.persist(item)
            else -> em.merge(item)
        }
    }

    fun findAll(): MutableList<Item> {
        return em.createQuery("select i from Item i", Item::class.java)
            .getResultList()
    }

    fun findOne(id: Long): Item {
        return em.find(Item::class.java, id)
    }

}

