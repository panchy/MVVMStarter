package com.panch.mvvmstarterapp.data.sharedPref

import android.content.SharedPreferences
import androidx.core.content.edit

class UserDataProvider(private val sharedPreferences: SharedPreferences) {

    var token: String
        get() = sharedPreferences.getString("token", "")!!
        set(value) = sharedPreferences.edit {
            putString("token", value)
        }


}


