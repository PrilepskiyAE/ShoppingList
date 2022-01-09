package com.ambrella.shoppinglist.domain.usecase

import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository

class GetShopItemUserCase(private val shopListRepository: ShopListRepository) {
  suspend  fun getShopItem(shopItemId:Int): Shopitem {
      return  shopListRepository.getShopItem(shopItemId)
    }
}