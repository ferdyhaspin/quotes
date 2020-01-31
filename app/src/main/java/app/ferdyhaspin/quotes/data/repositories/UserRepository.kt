package app.ferdyhaspin.quotes.data.repositories

import app.ferdyhaspin.quotes.data.db.AppDatabase
import app.ferdyhaspin.quotes.data.db.entities.User
import app.ferdyhaspin.quotes.data.network.SafeApiRequest
import app.ferdyhaspin.quotes.data.network.Service
import app.ferdyhaspin.quotes.data.network.responses.AuthResponse
import javax.inject.Inject

class UserRepository @Inject
constructor(
    private val service: Service,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { service.userLogin(email, password) }
    }

    suspend fun userSignUp(name: String, email: String, password: String): AuthResponse {
        return apiRequest { service.userSignup(name, email, password) }
    }

    suspend fun saveUser(user: User) = db.getUserDao().insert(user)

    fun getUser() = db.getUserDao().getUser()
}