package com.hopoong.jpa.api.order.service

import com.hopoong.jpa.api.item.repository.ItemRepository
import com.hopoong.jpa.api.member.repository.MemberRepository
import com.hopoong.jpa.api.order.repository.OrderRepository
import com.hopoong.jpa.entity.*
import com.hopoong.jpa.exception.BusinessException
import com.hopoong.jpa.response.CommonCode
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Transactional(readOnly = true)
@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val memberRepository: MemberRepository,
    private val itemRepository: ItemRepository,
) {

    /*
     * 주문
     */
    @Transactional
    fun order(memberId: Long, itemId: Long, count: Int) {

        // 엔티티 조회
        var member: Member = memberRepository.findOne(memberId)
        var item: Item = itemRepository.findOne(itemId)

        // 배송정보 생성
        var delivery = Delivery(address = member.address)

        //주문상품 생성
        val orderItem: OrderItem = OrderItem.createOrderItem(item, item.price, count)

        //주문 생성
        val order: Order = Order.createOrder(member, delivery, orderItem)

        orderRepository.save(order)
    }


    /*
     * 주문 취소
     */
    @Transactional
    fun cancelOrder(orderId: Long) {

        // 주문 엔티티 조회
        var order = orderRepository.findOne(orderId)

        Optional.ofNullable(order)
            .ifPresentOrElse({ data -> data.cancel() })
                { throw BusinessException(CommonCode.ORDER, "주문 번호를 확인해주세요") }
    }


}

