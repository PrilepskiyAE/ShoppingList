package com.ambrella.shoppinglist.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ShopDao {
    @Query("SELECT * FROM shop_items")
   fun getAll(): Flow<List<ShopItemEntity>>

    @Query("SELECT * FROM shop_items WHERE id IN (:itemIds)")
   fun loadAllByIds(itemIds: Int): Flow<ShopItemEntity>

    @Insert
  suspend  fun insertAll( item: ShopItemEntity)

    @Delete
 suspend  fun delete(item: ShopItemEntity)

    @Update
  suspend  fun update(item: ShopItemEntity)
}