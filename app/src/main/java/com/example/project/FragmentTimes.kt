package com.example.project

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class FragmentTimes : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
    }
}