package com.ambrella.shoppinglist.presentation.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ambrella.shoppinglist.data.ShopListRepositoryImpl
import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository
import com.ambrella.shoppinglist.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(private val repository: ShopListRepository): ViewModel() {

    private val _shopItems = MutableLiveData<List<Shopitem>>(emptyList())
    val shopItems = _shopItems as LiveData<List<Shopitem>>
    private val getShopListUseCase = GetShopListUserCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUserCase(repository)
    private val editShopItemUseCase = UpdateShopItemUserCase(repository)

    val shopList = getShopListUseCase.getShopList()

     fun deleteShopItem(shopitem: Shopitem) {
         viewModelScope.launch {
             deleteShopItemUseCase.deleteShopItem(shopitem)

         }
     }

     fun updateShopItem(shopitem: Shopitem)
     {
         viewModelScope.launch {
             val newItem = shopitem.copy(enabled = !shopitem.enabled)
             editShopItemUseCase.updateShopItem(newItem)
         }
     }
}