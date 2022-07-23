package kg.junesqo.shoppingapp.presentation.list

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import kg.junesqo.shoppingapp.R
import kg.junesqo.shoppingapp.databinding.ActivityListBinding
import kg.junesqo.shoppingapp.domain.entity.ShopItem
import kg.junesqo.shoppingapp.presentation.detail.DetailActivity
import kg.junesqo.shoppingapp.presentation.main.MainViewModel

class ListActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityListBinding
    private val adapter = ListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.fab.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startForResult.launch(intent)
        }
    }

    private fun initAdapter() {
        binding.recyclerList.adapter = adapter
    }

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                val name = intent?.getStringExtra(KEY_NAME)
                val count = intent?.getStringExtra(KEY_COUNT)
                viewModel.addShopItem(ShopItem(name, count?.toInt(), false))
                adapter.addItem(viewModel.getShopList())
            }
        }

    companion object{
        private val KEY_NAME = "name"
        private val KEY_COUNT = "count"
    }
}