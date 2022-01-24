package com.ambrella.shoppinglist.domain

data class Shopitem(
    val id:Int=0,
    val name:String,
    val count: Int,
    var enabled: Boolean
    )