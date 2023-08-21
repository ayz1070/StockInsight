package com.example.stockinsight

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stockinsight.adapter.BookmarkAdapter
import com.example.stockinsight.databinding.FragmentBookmarkBinding
import com.example.stockinsight.model.StockModel


class BookmarkFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentBookmarkBinding = FragmentBookmarkBinding.inflate(inflater,container,false)
        val stocks = mutableListOf<StockModel>()
        stocks.add(StockModel("삼성전자","78000","3%"))
        stocks.add(StockModel("sk하이닉스","90000","5%"))

        val adapter = BookmarkAdapter(stocks)
        val layoutManager = LinearLayoutManager(activity)
        binding.rvBookmark.layoutManager = layoutManager
        binding.rvBookmark.adapter = adapter

        return binding.root
    }


}