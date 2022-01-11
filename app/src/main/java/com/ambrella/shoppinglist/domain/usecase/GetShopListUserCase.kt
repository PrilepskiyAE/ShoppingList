package com.ambrella.shoppinglist.domain.usecase


import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository

object GetShopListUserCase {
    suspend fun getShopList(shopListRepository: ShopListRepository): List<Shopitem> {
        return shopListRepository.getShopList()
    }
}