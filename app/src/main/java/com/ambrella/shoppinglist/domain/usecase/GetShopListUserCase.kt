package com.ambrella.shoppinglist.domain.usecase


import androidx.lifecycle.LiveData
import com.ambrella.shoppinglist.data.database.ShopItemEntity
import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository
import kotlinx.coroutines.flow.Flow

class GetShopListUserCase(private val shopListRepository: ShopListRepository) {
    suspend fun getShopList(): List<Shopitem> {
        return shopListRepository.getShopList()
    }
}