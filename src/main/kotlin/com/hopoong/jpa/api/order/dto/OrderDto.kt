package com.hopoong.jpa.api.order.dto

class OrderDto {

    data class RegisterDto(
        var memberId: Long,
        var itemId: Long,
        var count: Int
    )



    data class CancelDto(
        var orderId: Long
    )
}

