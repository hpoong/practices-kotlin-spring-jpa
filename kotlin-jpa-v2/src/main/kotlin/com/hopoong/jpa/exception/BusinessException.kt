package com.hopoong.jpa.exception

import com.hopoong.jpa.response.CommonCode

class BusinessException: IllegalStateException {

    val code: CommonCode
    override val message: String


    constructor(code: CommonCode, message: String) : super() {
        this.code = code
        this.message = message
    }
}