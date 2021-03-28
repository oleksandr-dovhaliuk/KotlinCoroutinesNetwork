package com.oleksandrdovhaliuk.coroutinesnetwork.app

import android.app.Application
import com.oleksandrdovhaliuk.coroutinesnetwork.di.appModule
import com.oleksandrdovhaliuk.coroutinesnetwork.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(appModule, networkModule)
        }
    }
}