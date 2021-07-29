package com.akadatsky.retrofitsample.model

import com.google.gson.annotations.SerializedName

data class Exchange(

    @SerializedName("base_ccy")
    val baseCurrencyCode: String?,
    val buy: String?,

    @SerializedName("ccy")
    val currencyCode: String?,
    val sale: String?

)