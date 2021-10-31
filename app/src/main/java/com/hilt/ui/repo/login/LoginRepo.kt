package com.hilt.ui.repo.login

import com.hilt.ui.db.LoginModel
import kotlinx.coroutines.flow.Flow

interface LoginRepo {
    suspend fun insert(login: LoginModel)
    fun getLoginDetails(email: String): Flow<LoginModel>?
}