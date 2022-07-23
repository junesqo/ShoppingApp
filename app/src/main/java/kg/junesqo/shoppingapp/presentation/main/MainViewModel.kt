package kg.junesqo.shoppingapp.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.junesqo.shoppingapp.data.ShopListRepositoryImpl
import kg.junesqo.shoppingapp.domain.*
import kg.junesqo.shoppingapp.domain.entity.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl()

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val getShopItemUseCase = GetShopItemUseCase(repository)

    val shopListLD = MutableLiveData<List<ShopItem>>()

    fun addShopItem(shopItem: ShopItem){
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun editShopItem(shopItem: ShopItem) {
        val newItem = ShopItem("tomato", 5, enable = !shopItem.enable, 0)
        editShopItemUseCase.editShopItem(newItem)
    }

    fun getShopList() = getShopListUseCase.getShopList()

    fun getShopItem(shopItem: ShopItem) : ShopItem {
        return getShopItemUseCase.getShopItem(shopItem.id)
    }

}