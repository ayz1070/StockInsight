package com.example.stockinsight.api

import com.example.stockinsight.model.Stock
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface StockSearchApi {
    @GET("/getStockInfo")
    fun searchStock(
        @Query("name") name:String,

    ): Call<Stock>
}