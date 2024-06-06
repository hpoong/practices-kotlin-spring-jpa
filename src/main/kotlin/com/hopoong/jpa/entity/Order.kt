package com.hopoong.jpa.entity

import com.hopoong.jpa.entity.status.OrderStatus
import org.hibernate.annotations.Comment
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "hcc_orders")
data class Order(

    // ************* Column

    @Comment("PK")
    @Id @GeneratedValue
    @Column(name = "hcc_orders_id")
    val id: Long? = null,

    @Comment("회원 FK")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hcc_member_id")
    var member: Member,

    @Comment("배송 FK")
    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "hcc_delivery_id")
    var delivery: Delivery,

    @Comment("주문시간")
    var orderDate: LocalDateTime,

    @Comment("주문상태")
    @Enumerated(EnumType.STRING)
    var status: OrderStatus,



    // *************


    @Comment("주문 상세 Table")
    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    var orderItems: MutableList<OrderItem> = mutableListOf(),
) {

    companion object {



        /*
         * 주문을 생성하고 주문 상세에 넣는다.
         */
        fun createOrder(member: Member, delivery: Delivery, vararg orderItems: OrderItem): Order {
            var order = Order(member = member, delivery = delivery, status = OrderStatus.ORDER, orderDate = LocalDateTime.now())

            for (orderItem in orderItems) {
                order.addOrderItem(orderItem)
            }

            return order
        }
    }

    fun addOrderItem(orderItem: OrderItem) {
        orderItems.add(orderItem)
        orderItem.order = this
    }


}
