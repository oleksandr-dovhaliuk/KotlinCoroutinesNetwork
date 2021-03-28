package com.oleksandrdovhaliuk.coroutinesnetwork.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.oleksandrdovhaliuk.coroutinesnetwork.R
import com.oleksandrdovhaliuk.coroutinesnetwork.data.network.NetworkHelper
import com.oleksandrdovhaliuk.coroutinesnetwork.data.network.dto.RecipeDto
import com.oleksandrdovhaliuk.coroutinesnetwork.data.preference.PrefHelper
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val networkManager: NetworkHelper by inject()
    private val prefManager: PrefHelper by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTestToken()

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val recipeDtoDeferred: Deferred<RecipeDto> = CoroutineScope(Dispatchers.IO).async {
            networkManager.getRecipeById(584)
        }

        CoroutineScope(Dispatchers.Main).launch {
            tvResult.text = recipeDtoDeferred.await().toString()
        }
    }

    private fun setTestToken() {
        val testAuthToken = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
        prefManager.setAuthToken(testAuthToken)
    }
}