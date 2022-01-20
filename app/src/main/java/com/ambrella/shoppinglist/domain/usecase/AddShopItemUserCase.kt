package com.ambrella.shoppinglist.domain.usecase

import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository

class AddShopItemUserCase(private val shopListRepository: ShopListRepository) {
  suspend fun addShopItem(shopitem: Shopitem){
       shopListRepository.addShopItem(shopitem)
   }
}