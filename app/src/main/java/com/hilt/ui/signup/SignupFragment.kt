package com.hilt.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.hilt.ui.R
import com.hilt.ui.databinding.FragmentSignupBinding
import com.hilt.ui.db.LoginModel
import com.hilt.ui.isValidEmail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignupFragment : Fragment() {

    private var _binding: FragmentSignupBinding? = null
    private val viewModel: SignUpViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        binding.signUpViewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userSignUpMutableLiveData.observe(viewLifecycleOwner, {
            when {
                !it.email.isValidEmail() -> {
                    updateView(binding.etEmail, getString(R.string.email_error))
                    return@observe
                }
                it.password1.isNullOrBlank() -> {
                    updateView(binding.password1, getString(R.string.pwd_error))
                    return@observe
                }
                it.password2.isNullOrBlank() -> {
                    updateView(binding.password2, getString(R.string.pwd_error))
                    return@observe
                }
                !it.password1.equals(it.password2) -> {
                    updateView(binding.password2, getString(R.string.pwd_wrng))
                    return@observe
                }
                else -> {
                    viewModel.insert(LoginModel(it.email!!,it.password1))
                    findNavController().navigate(R.id.action_SecondFragment_to_LoginFragment)
                }
            }

        })
//        binding.buttonSecond.setOnClickListener {
//           // findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
    }

    private fun updateView(view: TextInputEditText, msg: String?) {
        view.error = msg
        view.requestFocus()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}