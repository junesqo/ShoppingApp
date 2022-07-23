package kg.junesqo.shoppingapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import kg.junesqo.shoppingapp.R
import kg.junesqo.shoppingapp.databinding.ActivityMainBinding
import kg.junesqo.shoppingapp.domain.entity.ShopItem

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    companion object {
        var TAG = "Main"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        initListener()
    }

    private fun initListener() {
        binding.btnAdd.setOnClickListener {
            Log.e(TAG, "add:  ${viewModel.addShopItem(ShopItem(binding.etTitle.text.toString(), 5, false))}")
        }

        binding.btnDelete.setOnClickListener {
            Log.e(TAG, "delete: ${viewModel.deleteShopItem(ShopItem(binding.etTitle.text.toString(), 5, false, 0))}")
        }

        binding.btnEdit.setOnClickListener {
            Log.e(TAG, "edit: ${viewModel.editShopItem(ShopItem(binding.etTitle.text.toString(), 5, false, 0))}")
        }

        binding.btnGetItem.setOnClickListener {
            Log.e(TAG, "getItem: ${viewModel.getShopItem(ShopItem(binding.etTitle.text.toString(), 5, false, 0))}")
        }

    }
}