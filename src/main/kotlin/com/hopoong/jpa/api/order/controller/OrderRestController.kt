package com.hopoong.jpa.api.order.controller

import com.hopoong.jpa.api.order.dto.OrderDto
import com.hopoong.jpa.api.order.service.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderRestController(
    private val orderService: OrderService,
) {

    @PostMapping(value = ["/orders"])
    fun saveOrder(@RequestBody registerDto: OrderDto.RegisterDto) {
        orderService.order(registerDto)
    }

    @PostMapping(value = ["/cancel/order"])
    fun cancelOrder(@RequestBody cancelDto: OrderDto.CancelDto) {
        orderService.cancelOrder(cancelDto)
    }

}