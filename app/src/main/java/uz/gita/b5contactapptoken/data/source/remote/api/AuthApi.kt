package uz.gita.b5contactapptoken.data.source.remote.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import uz.gita.b5contactapptoken.data.source.remote.request.LoginRequest
import uz.gita.b5contactapptoken.data.source.remote.request.RegisterContactRequest
import uz.gita.b5contactapptoken.data.source.remote.request.SMSRequest
import uz.gita.b5contactapptoken.data.source.remote.response.LoginResponse
import uz.gita.b5contactapptoken.data.source.remote.response.RegisterResponse
import uz.gita.b5contactapptoken.data.source.remote.response.SMSResponse

interface AuthApi {


    @POST("/api/v1/login")
    fun loginIn(@Body loginData: LoginRequest): Call<LoginResponse>

    @POST("/api/v1/register/verify")
    fun register(@Body registerData: RegisterContactRequest): Call<RegisterResponse>

    @POST("/api/v1/register/verify")
    fun verifySms(@Body request:SMSRequest):Call<SMSResponse>
}