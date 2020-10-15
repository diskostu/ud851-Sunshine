package com.example.android.sunshine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

// DONE (1) Add new Activity called SettingsActivity using Android Studio wizard
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        // DONE (2) Set setDisplayHomeAsUpEnabled to true on the support ActionBar
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) {
            Toast.makeText(this, "ActionBar is null!", Toast.LENGTH_SHORT).show();
        } else {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}