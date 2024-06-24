package com.hopoong.jpa.response

class ErrorResponse(
    var code: String,
    var message: String,
):CommonResponse(false) {

    constructor(code: CommonCode, message: String) : this(
        code = code.code,
        message = message
    )
}
