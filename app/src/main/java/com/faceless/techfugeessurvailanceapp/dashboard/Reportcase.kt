package com.faceless.techfugeessurvailanceapp.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import com.faceless.techfugeessurvailanceapp.R
import kotlinx.android.synthetic.main.fragment_reporting.*

class Reportcase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reportcase)

        val btn_click_me = findViewById(R.id.btn_sendReport) as Button
        // set on-click listener
        btn_click_me.setOnClickListener {
            // your code to perform when the user clicks on the button
            Toast.makeText(this@Reportcase, "You clicked me.", Toast.LENGTH_SHORT).show()
        }
    }



}