package com.ambrella.shoppinglist.domain.usecase

import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository

class UpdateShopItemUserCase(private val shopListRepository: ShopListRepository) {
   fun updateShopItem(shopitem:Shopitem ){
    shopListRepository.updateShopItem(shopitem)
   }
}