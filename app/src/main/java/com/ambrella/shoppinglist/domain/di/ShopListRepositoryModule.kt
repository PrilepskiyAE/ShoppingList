package com.ambrella.shoppinglist.domain.di

import com.ambrella.shoppinglist.data.ShopListRepositoryImpl
import com.ambrella.shoppinglist.data.database.RoomDatabaseShopItems
import com.ambrella.shoppinglist.domain.repository.ShopListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class ShopListRepositoryModule {
    @Provides
    fun provideRepositoryModule(db: RoomDatabaseShopItems): ShopListRepository = ShopListRepositoryImpl(db)
}