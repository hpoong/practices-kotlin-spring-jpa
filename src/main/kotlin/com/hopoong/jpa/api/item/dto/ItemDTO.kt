package com.hopoong.jpa.api.item.dto

import com.hopoong.jpa.entity.Book
import com.hopoong.jpa.entity.Item

data class RegisterItemDto(
    var name: String,
    var price: Int,
    var stockQuantity: Int,
    var author: String,
    var isbn: String,
) {

    fun toEntity(): Item {
        return Book(name = this.name, price = this.price, stockQuantity = this.stockQuantity, author = this.author, isbn = this.author)
    }
}

data class UpdateItemDto(
    var id: Long,
    var name: String,
    var price: Int,
    var stockQuantity: Int
)