package com.ambrella.shoppinglist.data

import android.content.Context
import com.ambrella.shoppinglist.data.database.RoomDatabaseShopItems
import com.ambrella.shoppinglist.data.database.ShopDao
import com.ambrella.shoppinglist.data.database.ShopItemEntity
import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.withContext

class ShopListRepositoryImp(context: Context, private val backgroundDispatcher: CoroutineDispatcher,private val db:RoomDatabaseShopItems):ShopListRepository {
private val shopDao:ShopDao = db.daoShopItems()


    override suspend fun addShopItem(shopitem: Shopitem) {
       withContext(backgroundDispatcher) {
           shopDao.insertAll(ShopItemEntity(name = shopitem.name, count = shopitem.count, enabled = shopitem.enabled.toInt()))
       }
    }

    override suspend fun deleteShopItem(shopitem: Shopitem) {
        withContext(backgroundDispatcher) {
        shopDao.delete(ShopItemEntity(name = shopitem.name, count = shopitem.count, enabled = shopitem.enabled.toInt()))
        }
    }


    override  fun getShopItem(shopItemId: Int): Flow<ShopItemEntity> {


        return shopDao.loadAllByIds(shopItemId)
    }

     override fun getShopList(): Flow<List<ShopItemEntity>> {

      return shopDao.getAll()
    }

    override suspend fun updateShopItem(shopitem: Shopitem) {
        withContext(backgroundDispatcher){
        shopDao.update(ShopItemEntity(name = shopitem.name, count = shopitem.count, enabled = shopitem.enabled.toInt()))
    }
}

private fun Boolean.toInt(): Int = if (this) 1 else 0
}
