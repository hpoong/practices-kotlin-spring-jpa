package com.hopoong.jpa.api.item.controller

import com.hopoong.jpa.api.item.dto.UpdateItemDto
import com.hopoong.jpa.api.item.service.ItemService
import com.hopoong.jpa.api.member.dto.MemberAllDTO
import com.hopoong.jpa.api.member.service.MemberService
import com.hopoong.jpa.entity.Member
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class ItemRestController(
    private val itemService: ItemService
) {


    @PostMapping(value = ["/items"])
    fun getMembers(@RequestBody params: UpdateItemDto) {
        itemService.updateItem(params.id, params)
    }

}