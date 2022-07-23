package kg.junesqo.shoppingapp.presentation.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kg.junesqo.shoppingapp.R
import kg.junesqo.shoppingapp.databinding.ActivityDetailBinding
import kg.junesqo.shoppingapp.presentation.main.MainViewModel

class DetailActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        initListener()
    }

    private fun initListener() {
        binding.btnAdd.setOnClickListener {
            if (binding.etName.text.isEmpty() || binding.etCount.text.isEmpty()){
                Toast.makeText(this, getString(R.string.empty_et), Toast.LENGTH_SHORT).show()
            } else{
                val name = binding.etName.text.toString()
                val count = binding.etCount.text.toString()
                val intent = Intent()
                intent.putExtra(KEY_NAME, name)
                intent.putExtra(KEY_COUNT, count)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    companion object{
        private val KEY_NAME = "name"
        private val KEY_COUNT = "count"
    }
}