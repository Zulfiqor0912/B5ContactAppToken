package uz.gita.b5contactapptoken.data.source.remote.request

data class AddContactRequest(
    val firstName: String,
    val lastName: String,
    val phone: String
)