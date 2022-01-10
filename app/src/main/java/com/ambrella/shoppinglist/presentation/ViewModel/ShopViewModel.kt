package com.ambrella.shoppinglist.presentation.ViewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ambrella.shoppinglist.data.ShopListRepositoryImp
import com.ambrella.shoppinglist.data.database.RoomDatabaseShopItems
import com.ambrella.shoppinglist.data.database.ShopItemEntity
import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository
import com.ambrella.shoppinglist.domain.usecase.AddShopItemUserCase
import com.ambrella.shoppinglist.domain.usecase.DeleteShopItemUserCase
import com.ambrella.shoppinglist.domain.usecase.UpdateShopItemUserCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.lang.RuntimeException

class ShopViewModel(context: Context): ViewModel() {

    private val repository: ShopListRepository
    init {
        repository=ShopListRepositoryImp(context, Dispatchers.IO, RoomDatabaseShopItems.getInstance(context, Dispatchers.IO) ?: throw RuntimeException("DB ERROR"))
    }
     fun addShopItem(shopitem: Shopitem){
         viewModelScope.launch {
             AddShopItemUserCase(repository).addShopItem(shopitem)
         }
     }
     fun deleteShopItem(shopitem: Shopitem){
         viewModelScope.launch {
             DeleteShopItemUserCase(repository).deleteShopItem(shopitem)
         }
     }

    fun getShopItem(shopItemId:Int): Flow<ShopItemEntity>
    {
        TODO()
    }

    fun getShopList(): Flow<List<ShopItemEntity>>
    {
        TODO()
    }

     fun updateShopItem(shopitem: Shopitem)
     {
         viewModelScope.launch {
             UpdateShopItemUserCase(repository).updateShopItem(shopitem)
         }
     }
}