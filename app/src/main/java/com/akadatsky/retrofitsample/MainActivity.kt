package com.akadatsky.retrofitsample

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.akadatsky.retrofitsample.api.ApiManager
import com.akadatsky.retrofitsample.model.ExchangeRate
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<Button>(R.id.textView)

        findViewById<Button>(R.id.load).setOnClickListener {

            lifecycleScope.launch {
                val data = ApiManager.apiService.getExchangeRatesHistory("28.07.2021")
                val historyList: List<ExchangeRate> = data.exchangeRate ?: emptyList()
                var result = ""
                historyList.forEach {
                    result += "${it.currency}: ${it.saleRateNB}\n"
                }
                textView.text = result
            }


        }

    }
}