package com.ambrella.shoppinglist.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.ambrella.shoppinglist.R
import com.ambrella.shoppinglist.databinding.ActivityShopItemBinding
import com.ambrella.shoppinglist.presentation.ViewModel.ShopInfoViewModel
import com.ambrella.shoppinglist.presentation.ViewModel.ShopViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopItemActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityShopItemBinding.inflate(layoutInflater)
    }

    val viewModel: ShopInfoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show()

            viewModel.addShopItem(
                inputName = binding.etTitle.text.toString(),
                inputCount = binding.etCount.text.toString()
            )
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }




    }


}