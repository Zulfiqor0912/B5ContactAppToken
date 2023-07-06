package uz.gita.b5contactapptoken.data.source.remote.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query
import uz.gita.b5contactapptoken.data.source.remote.request.AddContactRequest
import uz.gita.b5contactapptoken.data.source.remote.request.EditContactRequest
import uz.gita.b5contactapptoken.data.source.remote.response.AddContactResponse
import uz.gita.b5contactapptoken.data.source.remote.response.EditContactResponse
import uz.gita.b5contactapptoken.data.source.remote.response.GetContactsResponseItem

interface ContactApi {
    @POST("/api/v1/contact")
    fun addContact(
        @Header("token") token: String,
        @Body request: AddContactRequest
    ): Call<AddContactResponse>

    @GET("/api/v1/contact")
    fun getAllContacts(@Header("token") token: String): Call<List<GetContactsResponseItem>>

    @PUT("/api/v1/contact")
    fun updateContact(
        @Header("token") token: String,
        @Body request: EditContactRequest
    ): Call<EditContactResponse>

    @DELETE("/api/v1/contact")
    fun deleteContact(@Header("token") token: String, @Query("id") id: Int): Call<Unit>
}