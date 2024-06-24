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
            var orderItem = OrderItem(item = item, orderPrice = orderPrice, count = count)
            
            // 재고 수량 변경
            item.removeStock(count)
            return orderItem;
        }
    }

    /*
     * 주문 취소
     */
    fun cancel() {
        item.addStock(count) // 취소시 재고 수량 변경
    }

}