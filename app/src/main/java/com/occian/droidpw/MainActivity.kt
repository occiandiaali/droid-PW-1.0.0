package com.occian.droidpw

import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.content.getSystemService
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private var radioSelection: Int = 0
    private var numsChecked: Boolean = false
    private var symsChecked: Boolean = false
    private var alphasChecked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        copyView.setOnClickListener {
            Toast.makeText(applicationContext, "PW copied!", Toast.LENGTH_SHORT).show()
        }

        floatingActionButton.setOnClickListener {
            getAlphaNumericString(radioSelection, numsChecked, symsChecked, alphasChecked)
        }
    } // on create

    fun onRadioButtonClick(view: View): Int {
       // var ans: String
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.radio_16 ->
                    if (checked) {
                        radioSelection = 16
                    }
                R.id.radio_32 ->
                    if (checked) {
                        radioSelection = 32
                    }
                R.id.radio_64 ->
                    if (checked) {
                        radioSelection = 64
                    }
            }
        }
                 return radioSelection
    } // on radio button click

    fun onCheckboxClick(view: View): Boolean {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            when (view.id) {
                R.id.numsCheckBox -> {
                    numsChecked = checked
                    return numsChecked
                }
                R.id.symbolsCheckBox -> {
                    symsChecked = checked
                    return symsChecked
                }
                R.id.alphasCheckBox -> {
                    alphasChecked = checked
                    return alphasChecked
                }
                // TODO: Veggie sandwich
            }
        }
              return false
    } // on check box click

    private fun getAlphaNumericString(n: Int, numsCheck: Boolean, symsCheck: Boolean, alphasCheck: Boolean): String {
        var baseStr = ""
            if (numsCheck) baseStr += "0123456789"
            if (symsCheck) baseStr += "@!#$%"
            if (alphasCheck) baseStr += "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz"

        val alphaNumericString = baseStr
        val sb = StringBuilder(n)

        if (n == 16) {
            Toast.makeText(applicationContext, "Password is okay", Toast.LENGTH_SHORT).show()
        }
        if (n == 32) {
            Toast.makeText(applicationContext, "Password is good", Toast.LENGTH_SHORT).show()
        }
        if (n == 64) {
            Toast.makeText(applicationContext, "Password is strong!", Toast.LENGTH_SHORT).show()
        }

        if (n > 0) {
            for (i in 0..n) {
                var index = (alphaNumericString.length * Math.random()).toInt()
                try {
                    sb.append(alphaNumericString[index])
                } catch (e: Exception) {
                    Toast.makeText(applicationContext, "Password cannot be empty!", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(
                applicationContext,
                "Password must have a length!",
                Toast.LENGTH_SHORT
            ).show()
        }
        pwstringView.text = sb.toString()
       return pwstringView.toString()
    } // get alphanumeric string function

    private fun copyView() {
        val clipBoard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
       inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.settings -> {
                //settings()
                Toast.makeText(
                    applicationContext,
                    "Settings for you",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            R.id.help -> {
                //showHelp()
                Toast.makeText(
                    applicationContext,
                    "Do you need help?",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
} // class
