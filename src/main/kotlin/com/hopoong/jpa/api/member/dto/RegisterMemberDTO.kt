package com.hopoong.jpa.api.member.dto

import com.hopoong.jpa.entity.Member
import com.hopoong.jpa.entity.embeddable.Address

data class RegisterMemberDTO(
    val name: String,
    val address: Address
) {

    fun toEntity(): Member {
        return Member(
            name = this.name,
            address = this.address
        )
    }
}