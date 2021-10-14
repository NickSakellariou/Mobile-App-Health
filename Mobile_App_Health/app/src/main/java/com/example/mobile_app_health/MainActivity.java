package com.example.mobile_app_health;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import android.os.Bundle;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner sp_regions;

    ArrayList<String> arrayList_regions;
    ArrayAdapter<String> arrayAdapter_regions;

    Button btn_regions;

    SharedPreferences sharedPreferences;

    private boolean isSpinnerInitial = true;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_REGION = "health_region";
    private static final String KEY_HOSPITAL = "hospital";
    private static final String KEY_CENTER = "health_center";
    private static final String KEY_OUTPATIENT = "outpatient";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_regions = (Spinner)findViewById(R.id.sp_regions);

        btn_regions = findViewById(R.id.btn_regions);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        arrayList_regions = new ArrayList<>();
        arrayList_regions.add("Αττικής");
        arrayList_regions.add("Πειραιώς και Αιγαίου");
        arrayList_regions.add("Μακεδονίας");
        arrayList_regions.add("Μακεδονίας και Θράκης");
        arrayList_regions.add("Θεσσαλίας και Στερεάς Ελλάδας");
        arrayList_regions.add("Πελοποννήσου, Ιονίων Νήσων, Ηπείρου και Δυτικής Ελλάδας");
        arrayList_regions.add("Κρήτης");

        arrayAdapter_regions = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_regions);

        sp_regions.setAdapter(arrayAdapter_regions);

        btn_regions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String spinnerValueRegions = sp_regions.getSelectedItem().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_REGION, spinnerValueRegions);
                editor.apply();

                startActivity(new Intent(MainActivity.this, HospitalsActivity.class));

            }
        });

    }
}