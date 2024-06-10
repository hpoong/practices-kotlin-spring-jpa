package com.hopoong.jpa.api.item.dto

import com.hopoong.jpa.entity.Book
import com.hopoong.jpa.entity.Item

data class RegisterItemDto(
    var name: String,
    var price: Int,
    var stockQuantity: Int,
    var author: String,
    var isbn: String,
)

data class UpdateItemDto(
    var id: Long,
    var name: String,
    var price: Int,
    var stockQuantity: Int
)