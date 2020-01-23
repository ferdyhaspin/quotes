package app.ferdyhaspin.quotes.data.network.responses

import app.ferdyhaspin.quotes.data.db.entities.User

data class AuthResponse(
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User?
)