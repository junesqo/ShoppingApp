package kg.junesqo.shoppingapp.domain

import kg.junesqo.shoppingapp.domain.entity.ShopItem

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItemId: Int): ShopItem

    //можно менять
    fun getShopList(): List<ShopItem>

}