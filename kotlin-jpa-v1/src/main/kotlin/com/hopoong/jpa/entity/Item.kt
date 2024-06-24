package com.hopoong.jpa.entity

import com.hopoong.jpa.api.item.dto.UpdateItemDto
import com.hopoong.jpa.exception.BusinessException
import com.hopoong.jpa.response.CommonCode
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
    val id: Long? = null,

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


    fun updateItem(updateItemDto: UpdateItemDto) {
        name = updateItemDto.name
        price = updateItemDto.price
        stockQuantity = updateItemDto.stockQuantity
    }

    /*
     * 재고 수량 증가
     */
    fun addStock(count: Int) {
        stockQuantity += count
    }

    /*
     * 재고 수량 감소
     */
    fun removeStock(count: Int) {
        val restStock: Int = stockQuantity - count
        if (restStock < 0) {
            throw BusinessException(CommonCode.ORDER, "재고 수량을 확인해세요")
        }
        stockQuantity = restStock
    }


}