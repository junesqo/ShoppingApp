package kg.junesqo.shoppingapp.presentation.list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kg.junesqo.shoppingapp.R
import kg.junesqo.shoppingapp.databinding.ItemShopDisabledBinding
import kg.junesqo.shoppingapp.databinding.ItemShopEnabledBinding
import kg.junesqo.shoppingapp.domain.entity.ShopItem

class ListAdapter(private val onItemClick: (shopItem: ShopItem) -> Unit?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list = listOf<ShopItem>()
        set(value) {
            val callback = ShopListDiffCallback(list,value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_shop_disabled -> {
                ViewHolderDiss(
                    ItemShopDisabledBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            R.layout.item_shop_enabled -> {
                ViewHolderEnabled(
                    ItemShopEnabledBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        when (getItemViewType(position)) {
            R.layout.item_shop_enabled -> (holder as ViewHolderEnabled).bind(item)
            R.layout.item_shop_disabled -> (holder as ViewHolderDiss).bind(item)
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position].enable) {
            true -> R.layout.item_shop_enabled
            false -> R.layout.item_shop_disabled
        }

    }

    inner class ViewHolderEnabled(private val binding: ItemShopEnabledBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(shopItem: ShopItem) = binding.apply {
            binding.tvName.text = shopItem.name
            binding.tvCount.text = shopItem.count.toString()
            root.setOnClickListener {
                onItemClick(shopItem)
                notifyItemChanged(adapterPosition)
            }

            root.setOnLongClickListener {
                val item = list[position]
                Log.e("TAG", "Item: $item")
                true
            }
        }
    }

    inner class ViewHolderDiss(private val binding: ItemShopDisabledBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(shopItem: ShopItem) = binding.apply {
            binding.tvName.text = shopItem.name
            binding.tvCount.text = shopItem.count.toString()
            root.setOnClickListener {
                shopItem.enable = true
                notifyItemChanged(adapterPosition)
            }

            root.setOnLongClickListener {
                val item = list[position]
                Log.e("TAG", "Item: $item")
                true
            }
        }
    }
}