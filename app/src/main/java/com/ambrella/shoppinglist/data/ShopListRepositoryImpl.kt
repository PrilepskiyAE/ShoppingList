package com.ambrella.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.ambrella.shoppinglist.data.database.RoomDatabaseShopItems
import com.ambrella.shoppinglist.data.database.ShopDao
import com.ambrella.shoppinglist.data.database.ShopItemEntity
import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository
import javax.inject.Inject

class ShopListRepositoryImpl @Inject constructor(db:RoomDatabaseShopItems):ShopListRepository {
    private val shopDao:ShopDao = db.daoShopItems()
    private val mapper = ShopListMapper()

    override suspend fun addShopItem(shopitem: Shopitem) {
        shopDao.insertAll(mapper.mapEntityToDbModel(shopitem))
    }

    override suspend fun deleteShopItem(shopitem: Shopitem) {
        shopDao.delete(mapper.mapEntityToDbModel(shopitem))
    }


    override suspend fun getShopItem(shopItemID: Int): Shopitem {
        val el=shopDao.loadAllByIds(shopItemID)

        return  mapper.mapDbModelToEntity(el)
    }

     override  fun getShopList(): LiveData<List<Shopitem>> = Transformations.map(
         shopDao.getAll()
     ){
         mapper.mapListDbModelToListEntity(it)
     }



    override suspend fun updateShopItem(shopitem: Shopitem) {
        shopDao.insertAll(ShopItemEntity(id = shopitem.id, name = shopitem.name,
            count = shopitem.count,
            enabled = shopitem.enabled))

    }

   // private fun Boolean.toInt(): Int = if (this) 1 else 0
    //private fun Int.toBoolean(): Boolean = this==1
}





