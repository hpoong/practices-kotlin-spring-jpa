package com.hopoong.jpa.api.order.controller

import com.hopoong.jpa.api.order.dto.OrderDto
import com.hopoong.jpa.api.order.repository.OrderRepository
import com.hopoong.jpa.entity.Order
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping




@RestController
class OrderSimpleRestController(
    private val orderRepository: OrderRepository
) {


    @GetMapping("/api/v1/simple-orders")
    fun orderV1(): MutableList<Order> {
        return orderRepository.findAllByString(OrderDto.OrderSearch())
    }


}