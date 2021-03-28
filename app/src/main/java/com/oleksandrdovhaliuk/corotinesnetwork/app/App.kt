package com.oleksandrdovhaliuk.corotinesnetwork.app

import android.app.Application
import com.oleksandrdovhaliuk.corotinesnetwork.di.appModule
import com.oleksandrdovhaliuk.corotinesnetwork.di.networkModule
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