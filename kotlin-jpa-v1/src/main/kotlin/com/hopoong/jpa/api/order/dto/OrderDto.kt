package com.hopoong.jpa.api.order.dto

import com.hopoong.jpa.entity.enums.OrderStatus

class OrderDto {

    data class RegisterDto(
        var memberId: Long,
        var itemId: Long,
        var count: Int
    )



    data class CancelDto(
        var orderId: Long
    )

    data class OrderSearchDto(
        var memberName: String,
        var orderStatus: OrderStatus
    )

}

