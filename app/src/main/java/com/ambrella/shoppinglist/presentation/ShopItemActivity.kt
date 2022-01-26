package com.ambrella.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ambrella.shoppinglist.R
import com.ambrella.shoppinglist.presentation.ViewModel.ShopInfoViewModel
import com.ambrella.shoppinglist.presentation.ViewModel.ShopViewModel

class ShopItemActivity : AppCompatActivity() {

    val viewModel: ShopInfoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_item)
    }
}