package com.hopoong.jpa.api.item.service

import com.hopoong.jpa.api.item.dto.UpdateItemDto
import com.hopoong.jpa.api.item.repository.ItemRepository
import com.hopoong.jpa.entity.Item
import com.hopoong.jpa.exception.BusinessException
import com.hopoong.jpa.response.CommonCode
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true)
class ItemService(
    private val itemRepository: ItemRepository
) {


    /*
     * 상품 등록, 수정
     */
    fun saveItem(item: Item) {
        itemRepository.save(item)
    }

    /*
     * 상품 등록 수정
     */
    @Transactional
    fun updateItem(itemId: Long, updateItemDto: UpdateItemDto) {

        // findItem은 영속성 엔티티이므로 set만 해주면 jpa가 commit 시점에 db에 쿼리 날려줌(변경 감지)
        val findItem = itemRepository.findOne(itemId)

        Optional.ofNullable(findItem)
            .ifPresentOrElse({ data -> data.change(updateItemDto) }) { throw BusinessException(CommonCode.ITEM, "회원이 없습니다") }
    }

    /*
     * 상품 목록 전체 조회
     */
    fun findAll(): MutableList<Item> {
        return itemRepository.findAll()
    }

    /*
     * 상품 조회
     */
    fun findOne(id: Long): Item? {
        return itemRepository.findOne(id)
    }

}