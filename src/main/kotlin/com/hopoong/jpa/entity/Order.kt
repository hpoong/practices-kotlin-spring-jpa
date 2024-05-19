package com.hopoong.jpa.entity

import com.hopoong.jpa.entity.status.OrderStatus
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "hcc_orders")
data class Order(

    @Id @GeneratedValue
    @Column(name = "hcc_orders_id")
    val id: Long = 0L,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hcc_member_id")
    var member: Member,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    var orderItems: MutableList<OrderItem> = mutableListOf(),

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "hcc_delivery_id")
    var delivery: Delivery,

    var orderDate: LocalDateTime,

    @Enumerated(EnumType.STRING)
    var status: OrderStatus,
)
