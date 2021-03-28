package com.oleksandrdovhaliuk.coroutinesnetwork.data.preference

interface PrefHelper {
    fun setAuthToken(authToken: String)
    fun getAuthToken(): String
}