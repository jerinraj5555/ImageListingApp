package com.hilt.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.hilt.ui.R
import com.hilt.ui.databinding.LoginFragmentBinding
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel.userMutableLiveData.observe(viewLifecycleOwner, Observer {
            if (!it.email.isValidEmail()) {
                binding.etEmail.error = getString(R.string.email_error)
                binding.etEmail.requestFocus()
                return@Observer
            } else if (it.password.isNullOrBlank()) {
                binding.etPwd.error = getString(R.string.pwd_error)
                binding.etPwd.requestFocus()
                return@Observer
            } else {
                Toast.makeText(requireContext(), "Login successfully", Toast.LENGTH_SHORT).show()
            }
        })
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}