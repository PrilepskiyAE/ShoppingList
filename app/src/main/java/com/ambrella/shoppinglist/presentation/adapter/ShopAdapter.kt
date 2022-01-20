package com.ambrella.shoppinglist.presentation.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ambrella.shoppinglist.R
import com.ambrella.shoppinglist.domain.Shopitem

class ShopAdapter : RecyclerView.Adapter<ShopViewHolder>() {

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
        holder.tvName.text=shopitem.name
        holder.tvCount.text=shopitem.count.toString()
        holder.itemView.setOnLongClickListener {
            true
        }
    }

    override fun getItemCount(): Int =shoplist.size


}
class ShopViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val tvName=view.findViewById<TextView>(R.id.tvTitle)
    val tvCount=view.findViewById<TextView>(R.id.tvCount)


}