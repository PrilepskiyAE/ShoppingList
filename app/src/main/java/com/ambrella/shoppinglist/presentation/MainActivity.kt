package com.ambrella.shoppinglist.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.ambrella.shoppinglist.R
import com.ambrella.shoppinglist.databinding.ActivityMainBinding
import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.presentation.ViewModel.ShopViewModel
import com.ambrella.shoppinglist.presentation.adapter.ShopAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: ShopViewModel by viewModels()

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        //setupRecyclerView()
         var adapter: ShopAdapter= ShopAdapter()
        binding.rView.adapter=adapter

        viewModel.shopItems.observe(this) {

            adapter.shoplist=it


        }
        viewModel.getShopList()
        var test=0
        binding.flButton.setOnClickListener {

              viewModel.addShopItem(Shopitem("test+${test++}",3,true))
        }
        adapter.onClick=object : ShopAdapter.OnClick{
            override fun onClickItem(shopitem: Shopitem) {
                Toast.makeText(this@MainActivity, "One Click", Toast.LENGTH_SHORT).show()

            }

            override fun onClickLongItem(shopitem: Shopitem): Boolean {
                viewModel.updateShopItem(Shopitem(shopitem.name,shopitem.count,false))
                Toast.makeText(this@MainActivity, "One long Click", Toast.LENGTH_SHORT).show()
                return true
            }
        }

    }



}