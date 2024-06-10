package com.hopoong.jpa.entity

import org.hibernate.annotations.Comment
import javax.persistence.*

@Entity
@Table(name = "hcc_orderitem")
class OrderItem(


    // ************* Column

    @Comment("PK")
    @Id @GeneratedValue
    @Column(name = "hcc_orderitem_id")
    var id: Long? = null,

    @Comment("상품 FK")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hcc_item_id")
    var item: Item,

    @Comment("주문 FK")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hcc_order_id")
    var order: Order? = null,

    @Comment("주문가격")
    var orderPrice: Int,

    @Comment("주문수량")
    var count: Int,
) {


    companion object {

        fun createOrderItem(item: Item, orderPrice: Int, count: Int): OrderItem {
            return OrderItem(item = item, orderPrice = orderPrice, count = count)
        }
    }

    fun cancel() {
        TODO("Not yet implemented")
    }

}