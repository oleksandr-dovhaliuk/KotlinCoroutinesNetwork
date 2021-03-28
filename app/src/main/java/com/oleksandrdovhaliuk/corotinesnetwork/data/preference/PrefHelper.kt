package com.oleksandrdovhaliuk.corotinesnetwork.data.preference

interface PrefHelper {
    fun setAuthToken(authToken: String)
    fun getAuthToken(): String
}