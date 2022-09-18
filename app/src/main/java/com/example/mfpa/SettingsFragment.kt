package com.example.mfpa

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import java.util.prefs.Preferences

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

       val accSettings = findPreference<Preference>("key_Settings")

        accSettings!!.setOnPreferenceClickListener{

        findNavController().navigate(R.id.action_settingsFragment_to_privacySetting)

            true
        }

    }
}