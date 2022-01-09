package com.ambrella.shoppinglist.domain

data class Shopitem(
    val id:Int,
    val name:String,
    val count: Int,
    val enabled: Boolean
    )