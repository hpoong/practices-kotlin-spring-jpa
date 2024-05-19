package com.hopoong.jpa.entity

import javax.persistence.*

@Entity
@Table(name = "hcc_orderitem")
class OrderItem(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hcc_orderitem_id")
    val id: Long = 0L,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hcc_order_id")
    var order: Order
)