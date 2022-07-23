package kg.junesqo.shoppingapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import kg.junesqo.shoppingapp.data.entity.ShopItemDB

@Database(entities = [ShopItemDB::class], version = 1, exportSchema = false)
abstract class AppDataBase():RoomDatabase() {
    abstract fun shopDao(): ShopItemDao
}