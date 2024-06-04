package com.hopoong.jpa.entity

import com.hopoong.jpa.entity.embeddable.Address
import com.hopoong.jpa.entity.status.DeliveryStatus
import org.hibernate.annotations.Comment
import javax.persistence.*

@Entity
@Table(name = "hcc_delivery")
class Delivery(

    // ************* Column

    @Comment("PK")
    @Id @GeneratedValue
    @Column(name = "hcc_delivery_id")
    var id: Long? = null,

    @Comment("배송정보")
    @Embedded
    var address: Address,

    @Comment("배송상태")
    @Enumerated(EnumType.STRING)
    var status: DeliveryStatus? = null,


    // *************

    @Comment("주문 Table")
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    var order: Order? = null,
)