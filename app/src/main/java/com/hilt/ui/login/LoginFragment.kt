package com.hilt.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import com.hilt.ui.R
import com.hilt.ui.databinding.LoginFragmentBinding
import com.hilt.ui.isValidEmail
import com.hilt.ui.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.loginViewModel = loginViewModel
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLivedata()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvRegister.setOnClickListener {
            findNavController().navigate(R.id.action_LoginFragment_to_SecondFragment)
        }
    }

    private fun initLivedata() {
        loginViewModel.userMutableLiveData.observe(this
            , Observer {
            when {
                !it.email.isValidEmail() -> {
                    binding.etEmail.error = getString(R.string.email_error)
                    binding.etEmail.requestFocus()
                    return@Observer
                }
                it.pwd.isNullOrBlank() -> {
                    binding.etPwd.error = getString(R.string.pwd_error)
                    binding.etPwd.requestFocus()
                    return@Observer
                }
                else -> {
                    loginViewModel.getLoginDetails(it.email!!)?.asLiveData()
                        ?.observe(viewLifecycleOwner) { it1 ->

                            if (it1?.email.equals(it.email, ignoreCase = true)
                                && it.pwd.equals(it1?.password)
                            )
                                requireContext().toast(getString(R.string.login_success))
                            else
                                requireContext().toast(getString(R.string.login_failure))
                        }
                }
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}