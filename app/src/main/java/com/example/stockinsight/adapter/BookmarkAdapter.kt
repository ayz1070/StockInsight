package com.example.stockinsight.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.stockinsight.databinding.ItemBookmarkBinding
import com.example.stockinsight.model.StockModel


class BookmarkViewHolder(val binding:ItemBookmarkBinding): RecyclerView.ViewHolder(binding.root)
class BookmarkAdapter(val stocks:MutableList<StockModel>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    = BookmarkViewHolder(ItemBookmarkBinding.inflate(LayoutInflater.from(parent.context)))
    override fun getItemCount(): Int = stocks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = (holder as BookmarkViewHolder).binding


        binding.tvName.text = stocks[position].name
        binding.tvPrice.text = stocks[position].price
        binding.tvPercent.text = stocks[position].percentage
    }

}