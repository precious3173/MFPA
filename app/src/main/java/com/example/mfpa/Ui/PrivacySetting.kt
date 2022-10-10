package com.example.mfpa.Ui

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.mfpa.R

class PrivacySetting : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.privacy_settings, rootKey)


    }


}