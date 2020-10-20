package com.example.android.sunshine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

// DONE (10) Implement OnSharedPreferenceChangeListener from SettingsFragment
public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {


    // DONE (5) Override onCreatePreferences and add the preference xml file using addPreferencesFromResource
    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.pref_weather);

        // Do step 9 within onCreatePreference
        // DONE (9) Set the preference summary on each preference that isn't a CheckBoxPreference
        final SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();
        final PreferenceScreen prefScreen = getPreferenceScreen();
        int count = prefScreen.getPreferenceCount();
        for (int i = 0; i < count; i++) {
            Preference p = prefScreen.getPreference(i);
            if (!(p instanceof CheckBoxPreference)) {
                String value = sharedPreferences.getString(p.getKey(), "");
                setPreferenceSummary(p, value);
            }
        }
    }

    // DONE (8) Create a method called setPreferenceSummary that accepts a Preference and an Object and sets the summary of the preference
    private void setPreferenceSummary(final Preference preference, final String value) {
        preference.setSummary(value);
    }


    // DONE (12) Register SettingsFragment (this) as a SharedPreferenceChangedListener in onStart
    @Override
    public void onStart() {
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        super.onStart();
    }

    // DONE (13) Unregister SettingsFragment (this) as a SharedPreferenceChangedListener in onStop
    @Override
    public void onStop() {
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onStop();
    }

    // DONE (11) Override onSharedPreferenceChanged to update non CheckBoxPreferences when they are changed
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        final Preference preference = findPreference(key);
        if (!(preference instanceof CheckBoxPreference)) {
            setPreferenceSummary(preference, sharedPreferences.getString(key, ""));
        }
    }
}