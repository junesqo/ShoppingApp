package kg.junesqo.shoppingapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import kg.junesqo.shoppingapp.data.entity.ShopItemDB

@Dao
interface ShopItemDao {

    @Query("SELECT * FROM shop_table")
    fun getShopList(): LiveData<List<ShopItemDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addShopItem(shopItemDB: ShopItemDB)

    @Delete
    fun deleteShopItem(shopItemDB: ShopItemDB)

    @Update
    fun updateShopItem(shopItemDB: ShopItemDB)

    @Query("SELECT * FROM shop_table WHERE id = :shopItemId LIMIT 1")
    fun getShopItem(shopItemId: Int): ShopItemDB

}