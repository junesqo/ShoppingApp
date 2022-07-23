package kg.junesqo.shoppingapp

import android.app.Application
import androidx.room.Room
import kg.junesqo.shoppingapp.data.AppDataBase

class App: Application() {

    companion object{
        lateinit var appDataBase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDataBase = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "DB"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

}