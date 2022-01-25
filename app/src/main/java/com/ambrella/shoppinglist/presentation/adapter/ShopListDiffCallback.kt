package com.ambrella.shoppinglist.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ambrella.shoppinglist.domain.Shopitem
// оставил как пример
class ShopListDiffCallback(
    private val oldList:List<Shopitem>,
    private val newList:List<Shopitem>
                           ): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
         oldList[oldItemPosition] == newList[newItemPosition]

}