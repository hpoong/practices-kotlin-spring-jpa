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
    var id: Long,

    @Comment("상품 FK")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hcc_item_id")
    var item: Item,

    @Comment("주문 FK")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hcc_order_id")
    var order: Order,

    @Comment("주문가격")
    var orderPrice: Int,

    @Comment("주문수량")
    var count: Int,
)