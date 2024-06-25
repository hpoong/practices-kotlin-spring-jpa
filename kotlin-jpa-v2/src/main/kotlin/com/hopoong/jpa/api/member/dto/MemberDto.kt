package com.hopoong.jpa.api.member.dto

import javax.validation.constraints.NotEmpty

class MemberDto(
     var name: String
) {

    class Request {

        data class CreateMemberRequest(
            @field:NotEmpty(message = "필수값.")
            var name: String
        )

        data class UpdateMemberRequest(
            @field:NotEmpty(message = "필수값.")
            var name: String
        )
    }


    class Response {

        data class CreateMemberResponse(
            var id: Long
        )


        class UpdateMemberResponse (
            var id: Long,
            var name: String
        )

    }

}