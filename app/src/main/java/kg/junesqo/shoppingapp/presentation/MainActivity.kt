package kg.junesqo.shoppingapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import kg.junesqo.shoppingapp.R
import kg.junesqo.shoppingapp.domain.entity.ShopItem

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        initData()
    }

    private fun initData(){

        viewModel.shopListLD.observe(this){
            Log.e("TAG", "initData: ${it}")
        }

        for (i in 0..10){
            viewModel.addShopItem(ShopItem("potato", i, false))
        }
        viewModel.getShopList()
    }
}