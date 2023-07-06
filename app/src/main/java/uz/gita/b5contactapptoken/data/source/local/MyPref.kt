package uz.gita.b5contactapptoken.data.source.local

import android.content.Context
import uz.gita.b5contactapptoken.app.App

class MyPref {
    private val pref = App.instance.getSharedPreferences("MYCONTACT", Context.MODE_PRIVATE)

    companion object {
        private lateinit var pref: MyPref

        fun instance(): MyPref {
            if (!::pref.isInitialized) pref = MyPref()
            return pref
        }
    }

    var token: String
        set(value) = pref.edit().putString("token", value).apply()
        get() = pref.getString("token", "").toString()

    var hasToken: Boolean
        set(value) = pref.edit().putBoolean("hasToken", value).apply()
        get() = pref.getBoolean("hasToken", false)

    var login: String
        set(value) = pref.edit().putString("login", value).apply()
        get() = pref.getString("login", "").toString()

    var password: String
        set(value) = pref.edit().putString("password", value).apply()
        get() = pref.getString("password", "").toString()
}