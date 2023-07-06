package uz.gita.b5contactapptoken.data.source.remote.response

data class AddContactResponse(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phone: String
)