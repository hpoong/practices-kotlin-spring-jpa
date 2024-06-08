package com.hopoong.jpa.entity

import org.hibernate.annotations.Comment
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("B")
class Book(
    name: String,
    price: Int,
    stockQuantity: Int,
    author: String,
    isbn: String,
): Item(
    name = name,
    price = price,
    stockQuantity = stockQuantity,
)
