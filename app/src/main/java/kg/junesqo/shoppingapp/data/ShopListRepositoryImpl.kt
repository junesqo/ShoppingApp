package kg.junesqo.shoppingapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kg.junesqo.shoppingapp.App
import kg.junesqo.shoppingapp.domain.ShopListRepository
import kg.junesqo.shoppingapp.domain.entity.ShopItem

class ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    private val mapper = ShopListMapper()

    override fun addShopItem(shopItem: ShopItem) {
//        if (shopItem.id == autoIncrementId){
//            shopItem.id = autoIncrementId++
//        }
//        shopList.add(shopItem)
        App.appDataBase.shopDao().addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldItem = getShopItem(shopItem.id)
        deleteShopItem(oldItem)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList[shopItemId]
    }

    override fun getShopList(): LiveData<List<ShopItem>> = Transformations.map(
        App.appDataBase.shopDao().getShopList()
    ) {
        mapper.mapListDbModelToListEntity(it)
    }
}