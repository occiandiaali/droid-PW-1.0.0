package com.occian.droidpw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val arrayAdapter: ArrayAdapter<*>
        val sections = arrayOf(
            "About DroidPW",
            "Account",
            "Data and storage use",
            "Privacy policy",
            "Themes"
        )

        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, sections
            )
        settingsListView.adapter = arrayAdapter
    }//on create
} // class
