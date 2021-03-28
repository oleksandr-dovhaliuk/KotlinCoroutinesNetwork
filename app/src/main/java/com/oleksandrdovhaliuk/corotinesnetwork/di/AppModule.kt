package com.oleksandrdovhaliuk.corotinesnetwork.di

import com.oleksandrdovhaliuk.corotinesnetwork.data.network.NetworkHelper
import com.oleksandrdovhaliuk.corotinesnetwork.data.network.NetworkManager
import com.oleksandrdovhaliuk.corotinesnetwork.data.preference.PrefHelper
import com.oleksandrdovhaliuk.corotinesnetwork.data.preference.PrefManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single<PrefHelper> { PrefManager(androidContext()) }
    single<NetworkHelper> { NetworkManager(get(), get()) }
}