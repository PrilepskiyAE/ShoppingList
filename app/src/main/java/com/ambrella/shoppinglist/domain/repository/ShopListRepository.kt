package com.ambrella.shoppinglist.domain.repository

import androidx.lifecycle.LiveData
import com.ambrella.shoppinglist.domain.Shopitem

interface ShopListRepository {
     suspend fun addShopItem(shopitem: Shopitem)
     suspend fun deleteShopItem(shopitem: Shopitem)
     suspend fun getShopItem(shopItemID: Int):Shopitem
     fun getShopList(): LiveData<List<Shopitem>>
     suspend fun updateShopItem(shopitem:Shopitem )
}