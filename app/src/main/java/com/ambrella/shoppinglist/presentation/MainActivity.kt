package com.ambrella.shoppinglist.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
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
   private lateinit var adapter: ShopAdapter
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        setupRecyclerView()
        var test=0
        viewModel.shopItems.observe(this) {
            Log.d("TAG", "onCreate: $it")
            adapter.shoplist=it
            viewModel.getShopList()
        }
        viewModel.getShopList()

        binding.flButton.setOnClickListener {
//            viewModel.addShopItem(Shopitem("test",5,true))
//            observerAction = specificItemAction
              viewModel.addShopItem(Shopitem("test+${test++}",3,true))
//            viewModel.getShopList()
        }

    }

    private fun setupRecyclerView(){
    val rvShopList=findViewById<RecyclerView>(R.id.rView)
       adapter= ShopAdapter()
        rvShopList.adapter=adapter
    }

}