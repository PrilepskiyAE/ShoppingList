package com.ambrella.shoppinglist.domain.usecase

import com.ambrella.shoppinglist.data.database.ShopItemEntity
import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository
import kotlinx.coroutines.flow.Flow

object GetShopItemUserCase {
    suspend fun getShopItem(shopItemName: String, shopListRepository: ShopListRepository): Shopitem {
      return  shopListRepository.getShopItem(shopItemName)
    }
}