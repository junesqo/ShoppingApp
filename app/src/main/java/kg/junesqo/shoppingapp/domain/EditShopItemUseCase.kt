package kg.junesqo.shoppingapp.domain

import kg.junesqo.shoppingapp.domain.entity.ShopItem

class EditShopItemUseCase (private val shopListRepository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItem){
        shopListRepository.editShopItem(shopItem)
    }
}