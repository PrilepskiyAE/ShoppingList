package com.ambrella.shoppinglist.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ambrella.shoppinglist.R
import com.ambrella.shoppinglist.presentation.ViewModel.ShopViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var bt:Button
    val viewModel: ShopViewModel by viewModels()

//    var observerAction: (name: String?, allItems: List<Shopitem>?) -> Unit = { s: String?, list: List<Shopitem>? ->
//
//    }
//
//    val standardObserverAction: (name: String?, allItems: List<Shopitem>?) -> Unit = { s: String?, list: List<Shopitem>? ->
//
//    }
//
//    val specificItemAction: (name: String?, allItems: List<Shopitem>?) -> Unit = { s: String?, list: List<Shopitem>? ->
//        val item = list?.filter {
//            it.name == s
//        }
//
//        Log.d("TAG", ": $item")
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        bt=findViewById(R.id.button)

        viewModel.shopItems.observe(this) {
            Log.d("TAG", "onCreate: $it")
        }

        bt.setOnClickListener {
//            viewModel.addShopItem(Shopitem("test",5,true))
//            observerAction = specificItemAction

            viewModel.getShopList()
        }

    }

//    override fun onChanged(t: List<Shopitem>?) {
//        standardObserverAction(null, null)
//    }
}