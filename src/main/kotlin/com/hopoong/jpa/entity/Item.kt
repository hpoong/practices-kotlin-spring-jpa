package com.hopoong.jpa.entity

import com.hopoong.jpa.api.item.dto.UpdateItemDto
import org.hibernate.annotations.Comment
import javax.persistence.*


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Table(name = "hcc_item")
abstract class Item (


    // ************* Column

    @Comment("PK")
    @Id @GeneratedValue
    @Column(name = "hcc_item_id")
    val id: Long = 0L,

    @Comment("상품이름")
    var name: String,

    @Comment("상품가격")
    var price: Int,

    @Comment("재고수량")
    var stockQuantity: Int,



    // *************

    @Comment("상품 카테고리 Table")
    @ManyToMany(mappedBy = "items")
    var categories: MutableList<Category> = ArrayList()
) {

    fun change(updateItemDto: UpdateItemDto) {
        name = updateItemDto.name
        price = updateItemDto.price
        stockQuantity = updateItemDto.stockQuantity
    }

}