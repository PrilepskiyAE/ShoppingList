package com.ambrella.shoppinglist.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineDispatcher

@Database(entities = arrayOf(ShopItemEntity::class), version = 1, exportSchema = false)
abstract class RoomDatabaseShopItems:RoomDatabase() {
    abstract fun daoShopItems():ShopDao

    companion object{
        private var INSTANCE: RoomDatabaseShopItems?=null
        fun getInstance(
            context: Context,
            backgroundDispatcher: CoroutineDispatcher
        ):RoomDatabaseShopItems?{
            if (INSTANCE == null) {
                synchronized(RoomDatabaseShopItems::class){
                    INSTANCE= Room.databaseBuilder(context,RoomDatabaseShopItems::class.java,"Shop").build()
                }
            }
        return INSTANCE
        }
    }
}