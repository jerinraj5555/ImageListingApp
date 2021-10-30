package com.hilt.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hilt.ui.db.LoginModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var userMutableLiveData: MutableLiveData<Loginuser> = MutableLiveData()
    fun onClick() {
        val loginUser = Loginuser(email = email.value,pwd = password.value)
        userMutableLiveData.value = loginUser
    }

}