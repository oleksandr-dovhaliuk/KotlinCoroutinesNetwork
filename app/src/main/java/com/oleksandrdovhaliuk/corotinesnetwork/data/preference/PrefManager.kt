package com.oleksandrdovhaliuk.corotinesnetwork.data.preference

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.oleksandrdovhaliuk.corotinesnetwork.util.EMPTY_STRING

class PrefManager(context: Context) : PrefHelper {

    private companion object {
        const val KEY_AUTH_TOKEN = "auth_token"
    }

    private var prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    override fun setAuthToken(authToken: String) = prefs.putString(KEY_AUTH_TOKEN, authToken)

    override fun getAuthToken(): String = prefs.getString(KEY_AUTH_TOKEN)

    private fun SharedPreferences.putString(key: String, value: String) {
        this.edit().putString(key, value).apply()
    }

    private fun SharedPreferences.getString(key: String): String {
        return this.getString(key, EMPTY_STRING) ?: EMPTY_STRING
    }
}