package kg.junesqo.shoppingapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kg.junesqo.shoppingapp.data.entity.ShopItemDB

@Dao
interface ShopItemDao {

    @Query("SELECT * FROM shop_table")
    fun getShopList(): LiveData<List<ShopItemDB>>

    @Insert
    fun addShopItem(shopItemDB: ShopItemDB)

}