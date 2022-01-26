package com.ambrella.shoppinglist.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ShopDao {
    @Query("SELECT * FROM shop_items")
   suspend fun getAll(): List<ShopItemEntity>

    @Query("SELECT * FROM shop_items WHERE id IN (:itemIds)")
   suspend fun loadAllByIds(itemIds: Int): ShopItemEntity

    @Query("SELECT * FROM shop_items WHERE name LIKE (:itemName) LIMIT 1")
    suspend fun loadSpecificByName(itemName: String): ShopItemEntity

    @Insert
  suspend  fun insertAll( item: ShopItemEntity)

    @Delete
 suspend  fun delete(item: ShopItemEntity)

    @Update
  suspend  fun update(item: ShopItemEntity)
}