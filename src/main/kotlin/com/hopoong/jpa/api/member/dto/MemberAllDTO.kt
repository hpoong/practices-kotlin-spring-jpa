package com.hopoong.jpa.api.member.dto

import com.hopoong.jpa.entity.embeddable.Address

data class MemberAllDTO(
    val name: String,
    val address: Address
)
