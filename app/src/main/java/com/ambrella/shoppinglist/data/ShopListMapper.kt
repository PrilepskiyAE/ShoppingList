package com.ambrella.shoppinglist.data

import com.ambrella.shoppinglist.data.database.ShopItemEntity
import com.ambrella.shoppinglist.domain.Shopitem

class ShopListMapper {
    fun mapEntityToDbModel(shopItem: Shopitem) = ShopItemEntity(
        id = shopItem.id,
        name = shopItem.name,
        count = shopItem.count,
        enabled = shopItem.enabled
    )
    fun mapListDbModelToListEntity(list: List<ShopItemEntity>) = list.map {
        mapDbModelToEntity(it)
    }

    fun mapDbModelToEntity(shopItemDbModel: ShopItemEntity) = Shopitem(
        id = shopItemDbModel.id,
        name = shopItemDbModel.name,
        count = shopItemDbModel.count,
        enabled = shopItemDbModel.enabled
    )
}
