package ru.sldbank.data.models

import org.bson.types.ObjectId

data class User(
    val id: ObjectId = ObjectId(),
    val username: String,
    val password: String,
    val salt: String
)
