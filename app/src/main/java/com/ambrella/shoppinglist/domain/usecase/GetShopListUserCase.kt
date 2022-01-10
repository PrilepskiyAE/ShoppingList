package com.ambrella.shoppinglist.domain.usecase


import androidx.lifecycle.LiveData
import com.ambrella.shoppinglist.data.database.ShopItemEntity
import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository
import kotlinx.coroutines.flow.Flow

class GetShopListUserCase(private val shopListRepository: ShopListRepository) {
    fun getShopList(): Flow<List<ShopItemEntity>> {
        return shopListRepository.getShopList()
    }
}