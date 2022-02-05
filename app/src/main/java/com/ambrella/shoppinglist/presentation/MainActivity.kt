package com.ambrella.shoppinglist.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.ambrella.shoppinglist.R
import com.ambrella.shoppinglist.databinding.ActivityMainBinding
import com.ambrella.shoppinglist.domain.Shopitem
import com.ambrella.shoppinglist.presentation.ViewModel.ShopViewModel
import com.ambrella.shoppinglist.presentation.adapter.ShopAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: ShopViewModel by viewModels()
    val list= mutableListOf<Int>()
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

         val adapter= ShopAdapter()
        binding.rView.adapter=adapter

        viewModel.shopList.observe(this) {

         //adapter.shoplist=it
           adapter.submitList(it)


        }

        binding.flButton.setOnClickListener {

            //  viewModel.addShopItem(Shopitem(name = "test+${test++}", count = 3, enabled = true))
            val intent= Intent(this@MainActivity,ShopItemActivity::class.java)
            startActivity(intent)
        }
        adapter.onClick=object : ShopAdapter.OnClick{
            override fun onClickItem(shopitem: Shopitem) {
                Toast.makeText(this@MainActivity, "One Click", Toast.LENGTH_SHORT).show()
                val intent= Intent(this@MainActivity,ShopItemActivity::class.java)
                intent.putExtra("mod",true)
                intent.putExtra("mod_id",shopitem.id)
                startActivity(intent)

            }

            override fun onClickLongItem(shopitem: Shopitem): Boolean {
                /*if (shopitem.enabled){
                viewModel.updateShopItem(Shopitem(id = shopitem.id,
                    name = shopitem.name,
                    count = shopitem.count,
                    enabled = false))}
                else
                {
                    viewModel.updateShopItem(Shopitem(id = shopitem.id,
                        name = shopitem.name,
                        count = shopitem.count,
                        enabled = true))
                }
*/
                Toast.makeText(this@MainActivity, "One long Click", Toast.LENGTH_SHORT).show()

                viewModel.updateShopItem(shopitem)

                return true



            }


        }

        val callback=object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
               // val item=adapter.shoplist[viewHolder.adapterPosition]
                val item=adapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteShopItem(item)
            }

        }
        val itemTouchHelper=ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.rView)

    }



}