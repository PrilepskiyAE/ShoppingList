package com.ambrella.shoppinglist.domain.repository

import com.ambrella.shoppinglist.data.database.ShopItemEntity
import com.ambrella.shoppinglist.domain.Shopitem
import kotlinx.coroutines.flow.Flow

interface ShopListRepository {
     suspend fun addShopItem(shopitem: Shopitem)
     suspend fun deleteShopItem(shopitem: Shopitem)
     suspend fun getShopItem(shopItemId:Int):Shopitem
     suspend fun getShopList(): List<Shopitem>
     suspend fun updateShopItem(shopitem:Shopitem )
}