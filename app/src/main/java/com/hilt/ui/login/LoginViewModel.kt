package com.hilt.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hilt.ui.repo.login.LoginRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepo: LoginRepo) : ViewModel() {
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var userMutableLiveData: MutableLiveData<LoginUser> = MutableLiveData()

    init {
        email.value = "1@1.com"
        password.value = "1"
    }

    fun onClick() {
        val loginUser = LoginUser(email = email.value?.trim(), pwd = password.value?.trim())
        userMutableLiveData.value = loginUser
    }

    fun getLoginDetails(email: String?) = loginRepo.getLoginDetails(email!!)
}