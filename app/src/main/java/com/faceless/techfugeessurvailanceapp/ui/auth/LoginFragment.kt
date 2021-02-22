package com.faceless.techfugeessurvailanceapp.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.faceless.techfugeessurvailanceapp.dashboard.DashboardActivity
import com.faceless.techfugeessurvailanceapp.databinding.FragmentLoginBinding
import com.faceless.techfugeessurvailanceapp.data.network.AuthApi
import com.faceless.techfugeessurvailanceapp.data.network.Resource
import com.faceless.techfugeessurvailanceapp.data.repository.AuthRepository
import com.faceless.techfugeessurvailanceapp.ui.base.BaseFragment
import com.faceless.techfugeessurvailanceapp.ui.enable
import com.faceless.techfugeessurvailanceapp.ui.startNewActivity
import com.faceless.techfugeessurvailanceapp.ui.visible
import kotlinx.coroutines.launch


class LoginFragment : BaseFragment<AuthViewModel,FragmentLoginBinding, AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.progressbar.visible(false)
        binding.buttonLogin.enable(false)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            binding.progressbar.visible(false)
            when (it) {
                is Resource.Success -> {

//                        viewModel.saveAuthToken(it.value.user.token!!)
                        requireActivity().startNewActivity(DashboardActivity::class.java)

                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.editTextEmail.addTextChangedListener {
            val email = binding.editTextEmail.text.toString().trim()
            binding.buttonLogin.enable(email.isNotEmpty() && it.toString().isNotEmpty())
        }


        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextEmail.text.toString().trim()


            binding.progressbar.visible(true)
            viewModel.login(email, password)
        }
    }

    override fun geViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java), userPreferences)


}