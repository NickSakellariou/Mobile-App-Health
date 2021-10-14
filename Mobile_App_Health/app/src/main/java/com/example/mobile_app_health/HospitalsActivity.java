package com.example.mobile_app_health;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HospitalsActivity extends AppCompatActivity {

    Spinner sp_hospitals,sp_centers;

    ArrayList<String> arrayList_hospitals,arrayList_centers;
    ArrayAdapter<String> arrayAdapter_hospitals,arrayAdapter_centers;

    Button btn_hospitals,btn_centers;

    SharedPreferences sharedPreferences;

    private boolean isSpinnerInitial1 = true;
    private boolean isSpinnerInitial2 = true;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_REGION = "health_region";
    private static final String KEY_HOSPITAL = "hospital";
    private static final String KEY_CENTER = "health_center";
    private static final String KEY_OUTPATIENT = "outpatient";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);

        sp_hospitals = (Spinner) findViewById(R.id.sp_hospitals);
        sp_centers = (Spinner) findViewById(R.id.sp_centers);

        btn_hospitals = findViewById(R.id.btn_hospitals);
        btn_centers = findViewById(R.id.btn_centers);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String region = sharedPreferences.getString(KEY_REGION,null);

        if(region.equals("Αττικής")){
            arrayList_hospitals = new ArrayList<>();
            arrayList_hospitals.add("Ευαγγελισμός");
            arrayList_hospitals.add("Λαϊκό");
            arrayList_hospitals.add("Ιπποκράτειο");

            arrayAdapter_hospitals = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_hospitals);

            sp_hospitals.setAdapter(arrayAdapter_hospitals);

            arrayList_centers = new ArrayList<>();
            arrayList_centers.add("Αμαρουσίου");
            arrayList_centers.add("Καλλιθέας");

            arrayAdapter_centers = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_centers);

            sp_centers.setAdapter(arrayAdapter_centers);
        }

        if(region.equals("Πειραιώς και Αιγαίου")){
            arrayList_hospitals = new ArrayList<>();
            arrayList_hospitals.add("Τζάνειο");
            arrayList_hospitals.add("Μεταξά");
            arrayList_hospitals.add("Βοστάνειο");

            arrayAdapter_hospitals = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_hospitals);

            sp_hospitals.setAdapter(arrayAdapter_hospitals);

            arrayList_centers = new ArrayList<>();
            arrayList_centers.add("Καμινιών");
            arrayList_centers.add("Δραπετσώνας");

            arrayAdapter_centers = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_centers);

            sp_centers.setAdapter(arrayAdapter_centers);
        }

        if(region.equals("Μακεδονίας")){
            arrayList_hospitals = new ArrayList<>();
            arrayList_hospitals.add("ΓΝ Παπαγεωργίου");
            arrayList_hospitals.add("ΓΝ Καστοριάς");
            arrayList_hospitals.add("ΓΝ Γρεβενών");

            arrayAdapter_hospitals = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_hospitals);

            sp_hospitals.setAdapter(arrayAdapter_hospitals);

            arrayList_centers = new ArrayList<>();
            arrayList_centers.add("Ευόσμου");
            arrayList_centers.add("Αμπελοκήπων");

            arrayAdapter_centers = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_centers);

            sp_centers.setAdapter(arrayAdapter_centers);
        }

        if(region.equals("Μακεδονίας και Θράκης")){
            arrayList_hospitals = new ArrayList<>();
            arrayList_hospitals.add("ΓΝ Χαλκιδικής");
            arrayList_hospitals.add("ΓΝ Δράμας");
            arrayList_hospitals.add("ΓΝ Ξάνθης");

            arrayAdapter_hospitals = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_hospitals);

            sp_hospitals.setAdapter(arrayAdapter_hospitals);

            arrayList_centers = new ArrayList<>();
            arrayList_centers.add("Τούμπας");
            arrayList_centers.add("Πολύκαστρου");

            arrayAdapter_centers = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_centers);

            sp_centers.setAdapter(arrayAdapter_centers);
        }

        if(region.equals("Θεσσαλίας και Στερεάς Ελλάδας")){
            arrayList_hospitals = new ArrayList<>();
            arrayList_hospitals.add("ΓΝ Καρδίτσας");
            arrayList_hospitals.add("ΓΝ Βόλου");
            arrayList_hospitals.add("ΓΝ Τρικάλων");

            arrayAdapter_hospitals = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_hospitals);

            sp_hospitals.setAdapter(arrayAdapter_hospitals);

            arrayList_centers = new ArrayList<>();
            arrayList_centers.add("Σκιάθου");
            arrayList_centers.add("Σκοπέλου");

            arrayAdapter_centers = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_centers);

            sp_centers.setAdapter(arrayAdapter_centers);
        }

        if(region.equals("Πελοποννήσου, Ιονίων Νήσων, Ηπείρου και Δυτικής Ελλάδας")){
            arrayList_hospitals = new ArrayList<>();
            arrayList_hospitals.add("ΓΝ Λευκάδας");
            arrayList_hospitals.add("ΓΝ Κεφαλληνίας");
            arrayList_hospitals.add("ΓΝ Κέρκυρας");

            arrayAdapter_hospitals = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_hospitals);

            sp_hospitals.setAdapter(arrayAdapter_hospitals);

            arrayList_centers = new ArrayList<>();
            arrayList_centers.add("Αμφιλοχίας");
            arrayList_centers.add("Τρίπολης");

            arrayAdapter_centers = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_centers);

            sp_centers.setAdapter(arrayAdapter_centers);
        }

        if(region.equals("Κρήτης")){
            arrayList_hospitals = new ArrayList<>();
            arrayList_hospitals.add("ΓΝ Ρεθύμνου");
            arrayList_hospitals.add("ΓΝ Αγίου Νικολάου");
            arrayList_hospitals.add("ΓΝ Ηρακλείου");

            arrayAdapter_hospitals = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_hospitals);

            sp_hospitals.setAdapter(arrayAdapter_hospitals);

            arrayList_centers = new ArrayList<>();
            arrayList_centers.add("Ηρακλείου");
            arrayList_centers.add("Καστελιού");

            arrayAdapter_centers = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_centers);

            sp_centers.setAdapter(arrayAdapter_centers);
        }


        btn_hospitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String spinnerValueHospitals = sp_hospitals.getSelectedItem().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_HOSPITAL, spinnerValueHospitals);
                editor.putString(KEY_CENTER, null);
                editor.apply();

                startActivity(new Intent(HospitalsActivity.this, OutpatientsActivity.class));

            }
        });

        btn_centers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String spinnerValueCenters = sp_centers.getSelectedItem().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_CENTER, spinnerValueCenters);
                editor.putString(KEY_HOSPITAL, null);
                editor.apply();

                startActivity(new Intent(HospitalsActivity.this, OutpatientsActivity.class));

            }
        });
    }
}
