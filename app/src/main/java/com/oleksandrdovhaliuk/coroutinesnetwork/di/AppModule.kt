package com.oleksandrdovhaliuk.coroutinesnetwork.di

import com.oleksandrdovhaliuk.coroutinesnetwork.data.network.NetworkHelper
import com.oleksandrdovhaliuk.coroutinesnetwork.data.network.NetworkManager
import com.oleksandrdovhaliuk.coroutinesnetwork.data.preference.PrefHelper
import com.oleksandrdovhaliuk.coroutinesnetwork.data.preference.PrefManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single<PrefHelper> { PrefManager(androidContext()) }
    single<NetworkHelper> { NetworkManager(get(), get()) }
}