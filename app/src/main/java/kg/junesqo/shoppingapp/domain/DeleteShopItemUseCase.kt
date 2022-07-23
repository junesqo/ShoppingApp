package kg.junesqo.shoppingapp.domain

import kg.junesqo.shoppingapp.domain.entity.ShopItem

class DeleteShopItemUseCase (private val shopListRepository: ShopListRepository) {
    fun deleteShopItem(shopItem: ShopItem){
        shopListRepository.deleteShopItem(shopItem)
    }
}