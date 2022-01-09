package com.ambrella.shoppinglist.domain.usecase

import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository

class DeleteShopItemUserCase(private val shopListRepository: ShopListRepository) {

        fun deleteShopItem(shopitem: Shopitem){
            shopListRepository.deleteShopItem(shopitem)
        }

}