package com.hopoong.jpa.api.order.dto

import com.hopoong.jpa.entity.enums.OrderStatus

class OrderDto {



    data class OrderSearch(
        var memberName: String? = null,
        var orderStatus: OrderStatus? = null
    )

}

