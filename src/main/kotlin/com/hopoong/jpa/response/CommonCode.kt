package com.hopoong.jpa.response

import com.fasterxml.jackson.annotation.JsonFormat


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class CommonCode(
    val code: String,
    val type: String,
) {
    DEMO("C01", "Demo"),
    MEMBER("C03", "Member"),
    ITEM("C03", "Item"),
    SERVER("C09", "Server"),
    ;
}