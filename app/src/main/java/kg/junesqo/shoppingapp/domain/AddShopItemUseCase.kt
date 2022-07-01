package kg.junesqo.shoppingapp.domain

import kg.junesqo.shoppingapp.domain.entity.ShopItem

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun addShopItem(shopItem: ShopItem){
        shopListRepository.addShopItem(shopItem)
    }

}