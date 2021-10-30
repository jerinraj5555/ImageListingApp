package com.hilt.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var userMutableLiveData: MutableLiveData<LoginUser> = MutableLiveData()

    fun onClick() {
        val loginUser = LoginUser(email = email.value,password = password.value)
        userMutableLiveData.value = loginUser
    }


}