package uz.gita.b5contactapptoken.domain.repository

import android.content.Context
import retrofit2.Callback
import uz.gita.b5contactapptoken.data.source.remote.Client
import uz.gita.b5contactapptoken.data.source.remote.api.AuthApi
import uz.gita.b5contactapptoken.data.source.remote.request.LoginRequest
import uz.gita.b5contactapptoken.data.source.remote.request.RegisterContactRequest
import uz.gita.b5contactapptoken.data.source.remote.request.SMSRequest
import uz.gita.b5contactapptoken.data.source.remote.response.LoginResponse
import uz.gita.b5contactapptoken.data.source.remote.response.RegisterResponse
import uz.gita.b5contactapptoken.data.source.remote.response.SMSResponse

class AuthRepository {
    private val api: AuthApi = Client.retrofit.create(AuthApi::class.java)

    companion object {
        private lateinit var repository: AuthRepository

        fun instances(): AuthRepository {
            if (!::repository.isInitialized) repository = AuthRepository()
            return repository
        }
    }

    fun login(loginRequest: LoginRequest, callback: Callback<LoginResponse>) {
        api.loginIn(loginRequest).enqueue(callback)
    }

    fun register(registerRequest: RegisterContactRequest, callback: Callback<RegisterResponse>) {
        api.register(registerRequest).enqueue(callback)
    }

    fun verify(request: SMSRequest, callback: Callback<SMSResponse>) {
        api.verifySms(request).enqueue(callback)
    }
}