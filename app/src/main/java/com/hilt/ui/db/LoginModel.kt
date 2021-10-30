package com.hilt.ui.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "login"
)
data class LoginModel(
    @PrimaryKey
    var email:String,
    var password:String?
    )
