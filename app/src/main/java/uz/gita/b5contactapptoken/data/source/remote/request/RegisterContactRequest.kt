package uz.gita.b5contactapptoken.data.source.remote.request

data class RegisterContactRequest(
    val firstname: String,
    val lastName: String,
    val phone: String,
    val password: String
)