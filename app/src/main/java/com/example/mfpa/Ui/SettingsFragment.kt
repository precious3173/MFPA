package com.example.mfpa.Ui

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.preference.Preference
import androidx.preference.PreferenceDataStore
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import com.example.mfpa.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        val dataStore = DataStores()

       val accSettings = findPreference<Preference>("key_Settings")

        accSettings!!.setOnPreferenceClickListener{

        findNavController().navigate(R.id.action_settingsFragment_to_privacySetting)

            true
        }


        val notification = findPreference<SwitchPreference>("key_notification")

        notification?.summaryProvider = Preference.SummaryProvider<SwitchPreference> {
            switchNot ->

            if (switchNot?.isChecked!!)
                "Status: ON"
            else "Status: OFF"

        }

        notification?.preferenceDataStore = dataStore
    }

    class DataStores: PreferenceDataStore(){
        override fun getBoolean(key: String?, defValue: Boolean): Boolean {

            return  defValue
        }


        override fun putBoolean(key: String?, value: Boolean) {
            if (key == "key_notification"){

                
            }
        }

    }
}