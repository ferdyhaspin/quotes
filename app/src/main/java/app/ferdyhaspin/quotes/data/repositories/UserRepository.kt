/*
 * Created by ferdyhaspin on 1/23/20 5:58 PM
 */

package app.ferdyhaspin.quotes.data.repositories

import app.ferdyhaspin.quotes.data.db.AppDatabase
import app.ferdyhaspin.quotes.data.db.entities.User
import app.ferdyhaspin.quotes.data.network.ApiService
import app.ferdyhaspin.quotes.data.network.SafeApiRequest
import app.ferdyhaspin.quotes.data.network.responses.AuthResponse
import app.ferdyhaspin.quotes.utils.Coroutines
import javax.inject.Inject

class UserRepository @Inject
constructor(
    private val apiService: ApiService,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { apiService.userLogin(email, password) }
    }

    suspend fun userSignUp(name: String, email: String, password: String): AuthResponse {
        return apiRequest { apiService.userSignup(name, email, password) }
    }

    suspend fun saveUser(user: User) = db.getUserDao().insert(user)

    fun getUser() = db.getUserDao().getUser()

    fun deleteUser(user: User) {
        db.getUserDao().deleteUser(user)
    }
}