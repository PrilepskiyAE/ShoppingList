package com.ambrella.shoppinglist.data.database

import androidx.room.*

@Dao
interface ShopDao {
    @Query("SELECT * FROM shop_items")
    fun getAll(): List<ShopItemEntity>

    @Query("SELECT * FROM shop_items WHERE id IN (:itemIds)")
    fun loadAllByIds(itemIds: IntArray): List<ShopItemEntity>

    @Insert
    fun insertAll( item: ShopItemEntity)

    @Delete
    fun delete(item: ShopItemEntity)

    @Update
    fun update(item: ShopItemEntity)
}