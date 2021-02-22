package com.faceless.techfugeessurvailanceapp.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.faceless.techfugeessurvailanceapp.data.network.Resource
import com.faceless.techfugeessurvailanceapp.data.network.UserApi
import com.faceless.techfugeessurvailanceapp.data.repository.UserRepository
import com.faceless.techfugeessurvailanceapp.data.response.User
import com.faceless.techfugeessurvailanceapp.databinding.FragmentDashboardBinding
import com.faceless.techfugeessurvailanceapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class DashboardFragment : BaseFragment<DashboardViewModel, FragmentDashboardBinding, UserRepository>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUser()

        viewModel.user.observe(viewLifecycleOwner, Observer {
            when(it) {
                is Resource.Success -> {
                    updateUI(it.value.user)
                }
            }
        })
    }

    private fun updateUI(user: User) {
           with(binding) {

//               text.text = user.name

           }
    }

    override fun geViewModel() = DashboardViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDashboardBinding.inflate(inflater, container, false)

    override fun getFragmentRepository(): UserRepository {
        val api = remoteDataSource.buildApi(UserApi::class.java)
        return UserRepository(api)
    }


}