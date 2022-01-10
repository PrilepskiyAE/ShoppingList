package com.ambrella.shoppinglist.domain.usecase

import com.ambrella.shoppinglist.data.database.ShopItemEntity
import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository
import kotlinx.coroutines.flow.Flow

class GetShopItemUserCase(private val shopListRepository: ShopListRepository) {
    suspend fun getShopItem(shopItemId:Int): Shopitem {
      return  shopListRepository.getShopItem(shopItemId)
    }
}