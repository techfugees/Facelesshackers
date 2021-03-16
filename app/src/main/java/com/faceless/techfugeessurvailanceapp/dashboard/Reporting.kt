package com.faceless.techfugeessurvailanceapp.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.faceless.techfugeessurvailanceapp.R
import kotlinx.android.synthetic.main.fragment_reporting.*


class Reporting : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reporting, container, false)

//        btn_sendReport.setOnClickListener {
//            val view = View.inflate(this@Reporting, R.layout.success_dialogue, null)
//            val builder = AlertDialog.Builder(this@Report)
//
//            builder.setView(view)
//
//            val dialog = builder.create()
//            dialog.show()
//            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
//        }

    }


    

}