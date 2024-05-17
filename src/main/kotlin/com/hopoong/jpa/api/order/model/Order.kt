package com.hopoong.jpa.api.order.model

import javax.persistence.*

@Entity
@Table(name = "hcc_order")
data class Order(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hcc_order_id")
    val id: Long = 0L,
)