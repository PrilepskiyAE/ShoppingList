package com.ambrella.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.ambrella.shoppinglist.R
import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.presentation.ViewModel.ShopViewModel
import com.ambrella.shoppinglist.presentation.ViewModel.ShopViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ShopViewModel
    private lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var bt:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt=findViewById(R.id.button)
        viewModelFactory=ShopViewModelFactory(this)
        viewModel=ViewModelProvider(this,viewModelFactory).get(ShopViewModel::class.java)
        bt.setOnClickListener {
            viewModel.addShopItem(Shopitem("test",5,true))
        }

    }
}