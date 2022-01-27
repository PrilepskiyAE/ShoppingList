package com.ambrella.shoppinglist.presentation.ViewModel

import android.widget.Toast
import androidx.lifecycle.*
import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.domain.repository.ShopListRepository
import com.ambrella.shoppinglist.domain.usecase.AddShopItemUserCase
import com.ambrella.shoppinglist.domain.usecase.GetShopItemUserCase
import com.ambrella.shoppinglist.domain.usecase.UpdateShopItemUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ShopInfoViewModel@Inject constructor(private val repository: ShopListRepository): ViewModel() {


    private val getShopitemUseCase = GetShopItemUserCase(repository)
    private val addShopitemUseCase = AddShopItemUserCase(repository)
    private val updateShopItemUserCase=UpdateShopItemUserCase(repository)

    private  var _errorInputNameLiveData=MutableLiveData<Boolean>()
    val errorInputNameLiveData = _errorInputNameLiveData as LiveData<Boolean>

    private  var _errorInputCountLiveData=MutableLiveData<Boolean>()
    val errorInputCountLiveData = _errorInputCountLiveData as LiveData<Boolean>

    private  var _shopitemLiveData=MutableLiveData<Shopitem>()
    val shopitemLiveData = _shopitemLiveData as LiveData<Shopitem>


    fun getShopItem(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getShopitemUseCase.getShopItem(name)
        }
    }

    fun addShopItem(inputName:String?,inputCount:String? )
    {
        viewModelScope.launch(Dispatchers.IO){
            val name =parseName(inputName)
            val count =  parseCount(inputCount)
            if (validateInput(name, count))
                addShopitemUseCase.addShopItem(Shopitem(name = name, count =count, enabled = true))

    }
    }

    fun updateShopItem(inputName:String?,inputCount:String?){
        viewModelScope.launch(Dispatchers.IO){
            val name =parseName(inputName)
            val count =  parseCount(inputCount)

            if (validateInput(name, count))
                updateShopItemUserCase.updateShopItem(Shopitem(name = name, count =count, enabled = true))

        }

        }


    private fun parseName(inputName: String?):String{
        return inputName?.trim() ?: ""
    }
    private fun parseCount(inputCount:String?):Int{
        return try {
            inputCount?.trim()?.toInt() ?: 0
        } catch (e:Exception){
            0
        }


    }
    private fun validateInput(name: String, count:Int):Boolean {
       var result=true
        if (name.isBlank()){
            _errorInputNameLiveData.value=true
            result = false
        }
        if (count<=0){
            _errorInputCountLiveData.value=true
            result=false
        }
    return result
    }

     fun resetErrorInputName()
{
    _errorInputNameLiveData.value=false
}

    fun resetErrorInputCount()
    {
        _errorInputCountLiveData.value=false
    }
}
