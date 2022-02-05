package com.ambrella.shoppinglist.data.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShopDao {
    @Query("SELECT * FROM shop_items")
    fun getAll(): LiveData<List<ShopItemEntity>>

    @Query("SELECT * FROM shop_items WHERE id IN (:itemIds)")
    suspend fun loadAllByIds(itemIds: Int): ShopItemEntity

    @Query("SELECT * FROM shop_items WHERE name LIKE (:itemName) LIMIT 1")
    suspend fun loadSpecificByName(itemName: String): ShopItemEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(item: ShopItemEntity)

    @Delete
    suspend fun delete(item: ShopItemEntity)
/*
    @Update
    suspend fun update(item: ShopItemEntity)

 */
}