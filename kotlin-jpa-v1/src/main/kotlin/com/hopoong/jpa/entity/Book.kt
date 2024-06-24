package com.hopoong.jpa.entity

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("B")
class Book(
    name: String,           // 이름
    price: Int,             // 가격
    stockQuantity: Int,     // 재고수량
    author: String,         // 저자
    isbn: String,           // 도서번호
): Item(
    name = name,
    price = price,
    stockQuantity = stockQuantity,
)
