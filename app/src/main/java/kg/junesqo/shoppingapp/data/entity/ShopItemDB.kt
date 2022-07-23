package kg.junesqo.shoppingapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_table")
data class ShopItemDB(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String?,
    val count: Int?,
    var enable: Boolean
)