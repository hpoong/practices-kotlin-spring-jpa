package com.hopoong.jpa.entity.embeddable

import org.hibernate.annotations.Comment
import javax.persistence.Embeddable


@Embeddable
data class Address(

    @Comment("주소")
    var city: String,

    @Comment("도로명")
    var street: String,

    @Comment("우편번호")
    var zipcode: String,
)