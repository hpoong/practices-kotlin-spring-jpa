package com.hopoong.jpa.response

import com.fasterxml.jackson.annotation.JsonFormat


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class CommonCode(
    val code: String,
    val type: String,
) {
    DEMO("C01", "Demo"),
    MEMBER("C02", "Member"),
    ITEM("C03", "Item"),
    ORDER("C04", "Order"),
    SERVER("C09", "Server"),
    ;
}