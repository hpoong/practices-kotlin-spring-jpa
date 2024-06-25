package com.hopoong.jpa.api.order.repository

import com.hopoong.jpa.api.order.dto.OrderDto
import com.hopoong.jpa.entity.*
import com.hopoong.jpa.entity.Order
import com.hopoong.jpa.entity.enums.OrderStatus
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.criteria.*


@Repository
class OrderRepository() {


    @PersistenceContext
    private lateinit var em: EntityManager

    fun save(order: Order) {
        em.persist(order)
    }

    fun findOne(orderId: Long): Order? {
        return em.find(Order::class.java, orderId)
    }

    fun findAllByCriteria(orderSearchDto: OrderDto.OrderSearch): MutableList<Order>? {

        val cb = em.criteriaBuilder
        val cq = cb.createQuery(Order::class.java)
        val o = cq.from(Order::class.java)
        val m = o.join<Member, Order>("member", JoinType.INNER)

        val criteria = mutableListOf<Predicate>()

        // 주문 상태 검색
        if (orderSearchDto.orderStatus != null) {
            val status = cb.equal(o.get<OrderStatus>("status"), orderSearchDto.orderStatus)
            criteria.add(status)
        }

        // 회원 이름 검색
        if (orderSearchDto.memberName?.isNotEmpty() == true) {
            val name = cb.like(m.get<String>("name"), "%${orderSearchDto.memberName}%")
            criteria.add(name)
        }

        cq.where(cb.and(*criteria.toTypedArray()))
        val query = em.createQuery(cq).setMaxResults(1000) // 최대 1000건
        return query.resultList
    }

    fun findAllByString(orderSearch: OrderDto.OrderSearch): MutableList<Order> {
        var jpql = "select o from Order o join o.member m"
        var isFirstCondition = true

        //주문 상태 검색
        if (orderSearch.orderStatus != null) {
            if (isFirstCondition) {
                jpql += " where"
                isFirstCondition = false
            } else {
                jpql += " and"
            }
            jpql += " o.status = :status"
        }

        var result: MutableList<Order> = mutableListOf()
        return result
    }

}

