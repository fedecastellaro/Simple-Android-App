package com.example.parcial1.activities

import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.GravityCompat
import androidx.preference.PreferenceFragmentCompat
import com.example.parcial1.R
import kotlinx.android.synthetic.main.activity_main2.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import com.example.parcial1.view.LoginViewModel

class SettingsActivity : AppCompatActivity() {
    lateinit var buttonTheme : Button
    lateinit var vSettings : View
    lateinit var res : Resources
    var theme: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings, SettingsFragment())
            .commit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.preferencias, rootKey)
        }
    }

    override fun onStart() {
        super.onStart()


        val prefs = PreferenceManager.getDefaultSharedPreferences(this)

        theme=prefs.getBoolean("modoTheme",false).toString()

        if ( theme == "true")
        {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            Log.d("SettingsActivity", theme)
        }
        else
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            Log.d("SettingsActivity", theme)

        }

    }
}