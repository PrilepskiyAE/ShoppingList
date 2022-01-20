package com.ambrella.shoppinglist.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ambrella.shoppinglist.R
import com.ambrella.shoppinglist.domain.Shopitem

class ShopAdapter : RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {
lateinit var onClick: OnClick
    var shoplist= listOf<Shopitem>()
    set(value){
        field=value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_shop,parent,false)
        return ShopViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
       val shopitem=shoplist[position]
        holder.init(shopitem)
        holder.itemView.setOnLongClickListener {

            Log.d("TAG22", "onBindViewHolder: ")
            onClick.onClickLongItem(shopitem)
        }
        holder.itemView.setOnClickListener {
            onClick.onClickItem(shopitem)
            Log.d("TAG22", "onBindViewHolder: ")
        }



    }



    interface OnClick
    {
        fun onClickItem(shopitem: Shopitem)
        fun onClickLongItem(shopitem: Shopitem):Boolean

    }
    override fun getItemCount(): Int =shoplist.size

    class ShopViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val tvName=view.findViewById<TextView>(R.id.tvTitle)
        val tvCount=view.findViewById<TextView>(R.id.tvCount)
        fun init(shopitem: Shopitem) {
            tvName.text = shopitem.name
            tvCount.text = shopitem.count.toString()
        }

    }

}
