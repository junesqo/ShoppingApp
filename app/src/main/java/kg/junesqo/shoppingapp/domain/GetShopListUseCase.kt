package kg.junesqo.shoppingapp.domain

import kg.junesqo.shoppingapp.domain.entity.ShopItem

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

//    fun getShopList(): List<ShopItem>{
//        return shopListRepository.getShopList()
//    }

    fun getShopList() = shopListRepository.getShopList()

}