package com.ambrella.shoppinglist.domain.usecase

import com.ambrella.shoppinglist.data.database.ShopItemEntity
import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository
import kotlinx.coroutines.flow.Flow

class GetShopItemUserCase(private val shopListRepository: ShopListRepository) {
    fun getShopItem(shopItemId:Int): Flow<ShopItemEntity> {
      return  shopListRepository.getShopItem(shopItemId)
    }
}