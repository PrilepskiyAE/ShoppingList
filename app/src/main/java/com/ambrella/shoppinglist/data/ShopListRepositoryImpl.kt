package com.ambrella.shoppinglist.data

import com.ambrella.shoppinglist.data.database.RoomDatabaseShopItems
import com.ambrella.shoppinglist.data.database.ShopDao
import com.ambrella.shoppinglist.data.database.ShopItemEntity
import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository
import javax.inject.Inject

class ShopListRepositoryImpl @Inject constructor(db:RoomDatabaseShopItems):ShopListRepository {
    private val shopDao:ShopDao = db.daoShopItems()

    override suspend fun addShopItem(shopitem: Shopitem) {
        shopDao.insertAll(ShopItemEntity(name = shopitem.name, count = shopitem.count, enabled = shopitem.enabled.toInt()))
    }

    override suspend fun deleteShopItem(shopitem: Shopitem) {
        shopDao.delete(ShopItemEntity(name = shopitem.name, count = shopitem.count, enabled = shopitem.enabled.toInt()))
    }


    override suspend fun getShopItem(shopItemName: String): Shopitem {
        val el=shopDao.loadSpecificByName(shopItemName)

        return  Shopitem(name = el.name, count = el.count, enabled = el.enabled.toBoolean())
    }

     override suspend fun getShopList(): List<Shopitem> {
         val list:List<ShopItemEntity> = shopDao.getAll()
         val result= mutableListOf<Shopitem>()
         list.forEach {
             result.add(Shopitem(name = it.name, count = it.count, enabled = it.enabled.toBoolean()))
         }

      return result
    }

    override suspend fun updateShopItem(shopitem: Shopitem) {
        shopDao.update(ShopItemEntity(name = shopitem.name, count = shopitem.count, enabled = shopitem.enabled.toInt()))
    }

    private fun Boolean.toInt(): Int = if (this) 1 else 0
    private fun Int.toBoolean(): Boolean = this==1
}





