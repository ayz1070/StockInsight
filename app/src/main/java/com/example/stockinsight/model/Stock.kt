package com.example.stockinsight.model

data class Stock(
    var stockName:String,
    var currentPrice:Int,
    var change:Float,
    var changePercentage:Float,
    var stockCode:String
)
