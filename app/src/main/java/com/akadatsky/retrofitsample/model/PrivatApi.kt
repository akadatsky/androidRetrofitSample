package com.akadatsky.retrofitsample.model

data class PrivatApi(
    val bank: String?,
    val baseCurrency: Int?,
    val baseCurrencyLit: String?,
    val date: String?,
    val exchangeRate: List<ExchangeRate>?
)