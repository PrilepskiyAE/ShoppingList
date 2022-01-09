package com.ambrella.shoppinglist.domain.repository

import com.ambrella.shoppinglist.domain.Shopitem

interface ShopListRepository {
     fun addShopItem(shopitem: Shopitem)
     fun deleteShopItem(shopitem: Shopitem)
     fun getShopItem(shopItemId:Int):Shopitem
     fun getShopList():List<Shopitem>
     fun updateShopItem(shopitem:Shopitem )
}