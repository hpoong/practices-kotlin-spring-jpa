package com.hopoong.jpa.response

import com.fasterxml.jackson.annotation.JsonFormat


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class CommonCode(
    val code: String,
    val type: String,
) {
    DEMO("C01", "Demo"),
    SERVER("C09", "Server"),
    ;
}