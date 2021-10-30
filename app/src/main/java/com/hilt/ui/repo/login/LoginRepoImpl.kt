package com.hilt.ui.repo.login

import com.hilt.ui.db.LoginDao
import com.hilt.ui.db.LoginModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginRepoImpl @Inject constructor (private val dao: LoginDao): LoginRepo {
    override suspend fun insert(login: LoginModel) {
        dao.insert(login)
    }

    override fun getLoginDetails(email:String): Flow<LoginModel> {
        return dao.getLoginDetails(email)
    }
}