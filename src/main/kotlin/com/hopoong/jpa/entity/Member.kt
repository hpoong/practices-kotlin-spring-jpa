package com.hopoong.jpa.entity

import com.hopoong.jpa.entity.embeddable.Address
import javax.persistence.*


@Entity
@Table(name = "hcc_member")
data class Member(

    @Id @GeneratedValue
    @Column(name = "hcc_member_id")
    val id: Long = 0L,

    @Column(name = "name", nullable = false)
    var name: String,

    @Embedded
    var address: Address,

    @OneToMany(mappedBy = "member")                         // Order Class 필드명
    var orders: MutableList<Order> = mutableListOf(),       // NullPointerException

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    var orderItems: MutableList<OrderItem> = mutableListOf(),
)
