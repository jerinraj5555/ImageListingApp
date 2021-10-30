package com.hilt.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hilt.ui.db.LoginModel
import com.hilt.ui.repo.login.LoginRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val loginRepo : LoginRepo): ViewModel() {
    var userSignUpMutableLiveData: MutableLiveData<SignUp> = MutableLiveData()
    var rePassword = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    fun onValidateAndSave(){
        val signup = SignUp(email = email.value,password1 = password.value,password2 = rePassword.value)
        userSignUpMutableLiveData.value = signup
    }
     fun insert(login:LoginModel){
         viewModelScope.launch{
             loginRepo.insert(login)
         }
    }
}