package com.ambrella.shoppinglist.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_items")
data class ShopItemEntity(
    @PrimaryKey(autoGenerate = true) val id:Int=0,
    @ColumnInfo(name="name") val name:String,
    @ColumnInfo(name="colum") val count: Int,
    @ColumnInfo(name="enabled") val enabled: Boolean
)
