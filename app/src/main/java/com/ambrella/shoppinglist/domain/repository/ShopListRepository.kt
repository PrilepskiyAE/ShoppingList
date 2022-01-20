package com.ambrella.shoppinglist.domain.repository

import com.ambrella.shoppinglist.domain.Shopitem

interface ShopListRepository {
     suspend fun addShopItem(shopitem: Shopitem)
     suspend fun deleteShopItem(shopitem: Shopitem)
     suspend fun getShopItem(shopItemName: String):Shopitem
     suspend fun getShopList(): List<Shopitem>
     suspend fun updateShopItem(shopitem:Shopitem )
}