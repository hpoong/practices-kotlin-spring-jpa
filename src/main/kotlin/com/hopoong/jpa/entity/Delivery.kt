package com.hopoong.jpa.entity

import com.hopoong.jpa.entity.embeddable.Address
import com.hopoong.jpa.entity.status.DeliveryStatus
import javax.persistence.*

@Entity
@Table(name = "hcc_delivery")
class Delivery(

    @Id @GeneratedValue
    @Column(name = "hcc_delivery_id")
    var id: Long,

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    var order: Order,

    @Embedded
    var address: Address,

    @Enumerated(EnumType.STRING)
    var status: DeliveryStatus,
)