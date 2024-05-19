package com.hopoong.jpa.entity

import com.hopoong.jpa.entity.embeddable.Address
import org.hibernate.annotations.Comment
import javax.persistence.*


@Entity
@Table(name = "hcc_member")
data class Member(

    // ************* Column

    @Comment("PK")
    @Id @GeneratedValue
    @Column(name = "hcc_member_id")
    val id: Long = 0L,

    @Comment("이름")
    @Column(name = "name", nullable = false)
    var name: String,

    @Embedded
    var address: Address,




    // *************


    @Comment("회원 Table")
    @OneToMany(mappedBy = "member")                         // Order Class 필드명
    var orders: MutableList<Order> = mutableListOf(),       // NullPointerException

    @Comment("주문 Table")
    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    var orderItems: MutableList<OrderItem> = mutableListOf(),
)
