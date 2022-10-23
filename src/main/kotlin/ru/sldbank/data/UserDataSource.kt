package ru.sldbank.data

import ru.sldbank.data.models.User

interface UserDataSource {

    suspend fun getUserByUsername(username: String): User?

    suspend fun insertUser(user: User): Boolean
}