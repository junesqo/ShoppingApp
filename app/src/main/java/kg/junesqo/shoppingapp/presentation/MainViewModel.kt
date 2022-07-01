package kg.junesqo.shoppingapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.junesqo.shoppingapp.data.ShopListRepositoryImpl
import kg.junesqo.shoppingapp.domain.AddShopItemUseCase
import kg.junesqo.shoppingapp.domain.GetShopListUseCase
import kg.junesqo.shoppingapp.domain.entity.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl()

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val addShopItemUseCase = AddShopItemUseCase(repository)

    val shopListLD = MutableLiveData<List<ShopItem>>()

    fun addShopItem(shopItem: ShopItem){
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun getShopList(){
        shopListLD.value = getShopListUseCase.getShopList()
    }

}