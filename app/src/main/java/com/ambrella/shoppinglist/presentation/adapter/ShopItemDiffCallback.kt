package com.ambrella.shoppinglist.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ambrella.shoppinglist.domain.Shopitem

class ShopItemDiffCallback:DiffUtil.ItemCallback<Shopitem>() {
    override fun areItemsTheSame(oldItem: Shopitem, newItem: Shopitem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Shopitem, newItem: Shopitem): Boolean =
        oldItem == newItem
}