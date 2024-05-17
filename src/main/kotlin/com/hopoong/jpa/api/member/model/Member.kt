package com.hopoong.jpa.api.member.model

import com.hopoong.jpa.api.order.model.Order
import javax.persistence.*


@Entity
@Table(name = "hcc_member")
data class Member(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hcc_member_id")
    val id: Long = 0L,

    @Column(name = "name", nullable = false)
    val name: String,

//    @Column(name = "address", nullable = false)
//    val address: Address,

    @OneToMany(mappedBy = "member")
    val orders: MutableList<Order>,
)

