package com.hopoong.jpa.api.item.dto

import com.hopoong.jpa.entity.Item

open class UpdateItemDto (
    var id: Long,
    var name: String,
    var price: Int,
    var stockQuantity: Int,
) {
//    fun ofEntity(): Item = Item(name=this.name, price=this.price, stockQuantity=this.stockQuantity)
}