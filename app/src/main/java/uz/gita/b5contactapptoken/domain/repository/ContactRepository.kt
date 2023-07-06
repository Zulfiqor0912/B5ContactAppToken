package uz.gita.b5contactapptoken.domain.repository

import retrofit2.Callback
import uz.gita.b5contactapptoken.data.source.local.MyPref
import uz.gita.b5contactapptoken.data.source.remote.Client
import uz.gita.b5contactapptoken.data.source.remote.api.ContactApi
import uz.gita.b5contactapptoken.data.source.remote.request.AddContactRequest
import uz.gita.b5contactapptoken.data.source.remote.request.EditContactRequest
import uz.gita.b5contactapptoken.data.source.remote.response.AddContactResponse
import uz.gita.b5contactapptoken.data.source.remote.response.EditContactResponse
import uz.gita.b5contactapptoken.data.source.remote.response.GetContactsResponseItem


class ContactRepository {
    private val api: ContactApi = Client.retrofit.create(ContactApi::class.java)

    private val shPref = MyPref.instance()

    companion object {
        private lateinit var repository: ContactRepository

        fun instance(): ContactRepository {
            if (!::repository.isInitialized) repository = ContactRepository()
            return repository
        }
    }

    fun addContact(addContactRequest: AddContactRequest, callback: Callback<AddContactResponse>) {
        api.addContact(shPref.token, addContactRequest).enqueue(callback)
    }

    fun updateContact(
        editContactRequest: EditContactRequest,
        callback: Callback<EditContactResponse>
    ) {
        api.updateContact(shPref.token, editContactRequest).enqueue(callback)
    }

    fun getContacts(callback: Callback<List<GetContactsResponseItem>>) {
        api.getAllContacts(shPref.token).enqueue(callback)
    }

    fun deleteContact(contact: GetContactsResponseItem, callback: Callback<Unit>) {
        api.deleteContact(shPref.token, contact.id).enqueue(callback)
    }


}