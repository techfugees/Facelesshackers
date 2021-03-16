package com.faceless.techfugeessurvailanceapp.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.faceless.techfugeessurvailanceapp.R
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        reportCase.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToReporting2()
            findNavController().navigate(action)
        }

        }


    }



