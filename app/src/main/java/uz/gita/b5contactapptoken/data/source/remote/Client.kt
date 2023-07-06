package uz.gita.b5contactapptoken.data.source.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    val okHttpClient = OkHttpClient.Builder().build()
    val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://e9fb-213-230-118-102.ngrok-free.app")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}