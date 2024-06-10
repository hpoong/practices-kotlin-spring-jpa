package com.hopoong.jpa.api.item.controller

import com.hopoong.jpa.api.item.dto.RegisterItemDto
import com.hopoong.jpa.api.item.dto.UpdateItemDto
import com.hopoong.jpa.api.item.service.ItemService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class ItemRestController(
    private val itemService: ItemService
) {


    @PostMapping(value = ["/items"])
    fun saveItem(@RequestBody registerItemDto: RegisterItemDto) {
        itemService.saveItem(registerItemDto)
    }

    @PutMapping(value = ["/items"])
    fun getMembers(@RequestBody updateItemDto: UpdateItemDto) {
        itemService.updateItem(updateItemDto.id, updateItemDto)
    }

}