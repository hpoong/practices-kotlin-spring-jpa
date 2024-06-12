package com.hopoong.jpa.api.order.repository

import com.hopoong.jpa.api.item.repository.ItemRepository
import com.hopoong.jpa.api.member.repository.MemberRepository
import com.hopoong.jpa.api.order.dto.OrderDto
import com.hopoong.jpa.entity.*
import com.hopoong.jpa.entity.Order
import com.hopoong.jpa.entity.enums.OrderStatus
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.criteria.*
import javax.transaction.Transactional
import org.springframework.util.StringUtils


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

    fun findAllByCriteria(orderSearchDto: OrderDto.OrderSearchDto): MutableList<Order>? {

        // 쿼리를 만들 준비
        val cb = em.criteriaBuilder

        // Order 엔티티를 대상으로 하는 쿼리
        val cq = cb.createQuery(Order::class.java)

        // Order 엔티티의 루트
        val o = cq.from(Order::class.java)

        // Order와 Member 조인
        val m = o.join<Member, Order>("member", JoinType.INNER)

        // 조건을 저장할 리스트
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

}

