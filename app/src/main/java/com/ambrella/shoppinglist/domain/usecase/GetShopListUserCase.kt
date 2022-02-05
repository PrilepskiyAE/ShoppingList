package com.ambrella.shoppinglist.domain.usecase


import androidx.lifecycle.LiveData
import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository

class GetShopListUserCase(private val shopListRepository: ShopListRepository) {
   fun getShopList():LiveData<List<Shopitem>> {
        return shopListRepository.getShopList()
    }
}