package com.ambrella.shoppinglist.domain.di

import android.content.Context
import androidx.room.Room
import com.ambrella.shoppinglist.data.database.RoomDatabaseShopItems
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class ShopItemsDBModule {
    @Provides
    fun provideDB(@ApplicationContext context: Context): RoomDatabaseShopItems = Room.databaseBuilder(context, RoomDatabaseShopItems::class.java,"Shop").build()
}