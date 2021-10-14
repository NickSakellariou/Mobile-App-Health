package com.example.mobile_app_health;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class OutpatientsActivity extends AppCompatActivity {

    Spinner sp_outpatients;

    ArrayList<String> arrayList_outpatients;
    ArrayAdapter<String> arrayAdapter_outpatients;

    TextView textView_outpatients;

    Button btn_outpatients;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_REGION = "health_region";
    private static final String KEY_HOSPITAL = "hospital";
    private static final String KEY_CENTER = "health_center";
    private static final String KEY_OUTPATIENT = "outpatient";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outpatients);

        textView_outpatients = findViewById(R.id.tv_outpatients);

        sp_outpatients = (Spinner) findViewById(R.id.sp_outpatients);

        btn_outpatients = findViewById(R.id.btn_outpatients);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String hospital = sharedPreferences.getString(KEY_HOSPITAL,null);

        String health_center = sharedPreferences.getString(KEY_CENTER,null);

        if (hospital != null){
            textView_outpatients.setText("Επιλέξτε εξωτερικό ιατρείο :");

            if(hospital.equals("Ευαγγελισμός")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Παθολογικό ιατρείο");
                arrayList_outpatients.add("Οφθαλμολογικό ιατρείο");
                arrayList_outpatients.add("Αιμοληψίες");
                arrayList_outpatients.add("Γαστρεντερολογικό ιατρείο");
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("Λαϊκό")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Ακτινογραφίες");
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Υπέρηχοι ακτινολογικού");
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Ορθοπαιδικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("Ιπποκράτειο")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Αιμοληψίες");
                arrayList_outpatients.add("Γαστρεντερολογικό ιατρείο");
                arrayList_outpatients.add("Παθολογικό ιατρείο");
                arrayList_outpatients.add("Ουρολογικό ιατρείο");
                arrayList_outpatients.add("Γυναικολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("Τζάνειο")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Ορθοπαιδικό ιατρείο");
                arrayList_outpatients.add("Ακτινογραφίες ιατρείο");
                arrayList_outpatients.add("Αιμοληψίες");
                arrayList_outpatients.add("Γαστρεντερολογικό ιατρείο");
                arrayList_outpatients.add("Ιατρείο φυσικής ιατρικής και αποκατάστασης");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("Μεταξά")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Ουρολογικό ιατρείο");
                arrayList_outpatients.add("Παθολογικό ιατρείο");
                arrayList_outpatients.add("Υπέρηχοι ακτινολογικού");
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Ορθοπαιδικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("Βοστάνειο")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Χειρουργικό ιατρείο");
                arrayList_outpatients.add("Οφθαλομολογικό ιατρείο");
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Ουρολογικό ιατρείο");
                arrayList_outpatients.add("Γυναικολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("ΓΝ Παπαγεωργίου")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Γυναικολογικό ιατρείο");
                arrayList_outpatients.add("Ουρολογικό ιατρείο");
                arrayList_outpatients.add("Χειρουργικό ιατρείο");
                arrayList_outpatients.add("Γαστρεντερολογικό ιατρείο");
                arrayList_outpatients.add("Υπέρηχοι ακτινολογικού");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("ΓΝ Καστοριάς")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Οφθαλμολογικό ιατρείο");
                arrayList_outpatients.add("Υπέρηχοι ακτινολογικού");
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Ορθοπαιδικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("ΓΝ Γρεβενών")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Ουρολογικό ιατρείο");
                arrayList_outpatients.add("Γαστρεντερολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("ΓΝ Χαλκιδικής")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Γυναικολογικό ιατρείο");
                arrayList_outpatients.add("Γαστρεντερολογικό ιατρείο");
                arrayList_outpatients.add("Υπέρηχοι ακτινολογικού");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("ΓΝ Δράμας")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Ουρολογικό ιατρείο");
                arrayList_outpatients.add("Χειρουργικό ιατρείο");
                arrayList_outpatients.add("Ορθοπαιδικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("ΓΝ Ξάνθης")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Οφθαλμολογικό ιατρείο");
                arrayList_outpatients.add("Υπέρηχοι ακτινολογικού");
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Ουρολογικό ιατρείο");
                arrayList_outpatients.add("Γαστρεντερολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("ΓΝ Καρδίτσας")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Χειρουργικό ιατρείο");
                arrayList_outpatients.add("Οφθαλμολογικό ιατρείο");
                arrayList_outpatients.add("Ορθοπαιδικό ιατρείο");
                arrayList_outpatients.add("Παθολογικό ιατρείο");
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("ΓΝ Βόλου")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Υπέρηχοι ακτινολογικού");
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Ουρολογικό ιατρείο");
                arrayList_outpatients.add("Χειρουργικό ιατρείο");
                arrayList_outpatients.add("Ορθοπαιδικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("ΓΝ Τρικάλων")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Ουρολογικό ιατρείο");
                arrayList_outpatients.add("Χειρουργικό ιατρείο");
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Υπέρηχοι καρδιολογικού");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("ΓΝ Λευκάδας")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Ουρολογικό ιατρείο");
                arrayList_outpatients.add("Χειρουργικό ιατρείο");
                arrayList_outpatients.add("Παθολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("ΓΝ Κεφαλληνίας")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Οφθαλμολογικό ιατρείο");
                arrayList_outpatients.add("Ορθοπαιδικό ιατρείο");
                arrayList_outpatients.add("Υπέρηχοι ακτινολογικού");
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Ουρολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("ΓΝ Κέρκυρας")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Ουρολογικό ιατρείο");
                arrayList_outpatients.add("Υπέρηχοι καρδιολογικού");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("ΓΝ Ρεθύμνου")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Χειρουργικό ιατρείο");
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Οφθαλμολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("ΓΝ Αγίου Νικολάου")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Ορθοπαιδικό ιατρείο");
                arrayList_outpatients.add("Παθολογικό ιατρείο");
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Υπέρηχοι ακτινολογικού");


                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(hospital.equals("ΓΝ Ηρακλείου")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Ουρολογικό ιατρείο");
                arrayList_outpatients.add("Χειρουργικό ιατρείο");
                arrayList_outpatients.add("Ορθοπαιδικό ιατρείο");
                arrayList_outpatients.add("Υπέρηχοι καρδιολογικού");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

        }

        if (health_center != null){

            textView_outpatients.setText("Επιλέξτε ιατρείο :");

            if(health_center.equals("Αμαρουσίου")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Αιματολογικό ιατρείο");
                arrayList_outpatients.add("Αλλεργιολογικό ιατρείο");
                arrayList_outpatients.add("Δερματολογικό ιατρείο");
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Γυναικολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(health_center.equals("Καλλιθέας")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Χειρουργικό ιατρείο");
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Οφθαλμολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(health_center.equals("Καμινιών")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Οφθαλμολογικό ιατρείο");
                arrayList_outpatients.add("Αιματολογικό ιατρείο");
                arrayList_outpatients.add("Αλλεργιολογικό ιατρείο");
                arrayList_outpatients.add("Γυναικολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(health_center.equals("Δραπετσώνας")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Δερματολογικό ιατρείο");
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Γυναικολογικό ιατρείο");
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Οφθαλμολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(health_center.equals("Ευόσμου")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Γυναικολογικό ιατρείο");
                arrayList_outpatients.add("Αλλεργιολογικό ιατρείο");
                arrayList_outpatients.add("Δερματολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(health_center.equals("Αμπελοκήπων")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Γυναικολογικό ιατρείο");
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Οφθαλμολογικό ιατρείο");
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(health_center.equals("Τούμπας")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Δερματολογικό ιατρείο");
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Οφθαλμολογικό ιατρείο");
                arrayList_outpatients.add("Αλλεργιολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(health_center.equals("Πολύκαστρου")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Γυναικολογικό ιατρείο");
                arrayList_outpatients.add("Αλλεργιολογικό ιατρείο");
                arrayList_outpatients.add("Οφθαλμολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(health_center.equals("Σκιάθου")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Γυναικολογικό ιατρείο");
                arrayList_outpatients.add("Αλλεργιολογικό ιατρείο");
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Οφθαλμολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(health_center.equals("Σκοπέλου")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Αιματολογικό ιατρείο");
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Γυναικολογικό ιατρείο");
                arrayList_outpatients.add("Αλλεργιολογικό ιατρείο");
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(health_center.equals("Αμφιλοχίας")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Αλλεργιολογικό ιατρείο");
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Αιματολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(health_center.equals("Τρίπολης")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Ουρολογικό ιατρείο");
                arrayList_outpatients.add("Αλλεργιολογικό ιατρείο");
                arrayList_outpatients.add("Χειρουργικό ιατρείο");
                arrayList_outpatients.add("Δερματολογικό ιατρείο");
                arrayList_outpatients.add("Γυναικολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(health_center.equals("Ηρακλείου")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Γυναικολογικό ιατρείο");
                arrayList_outpatients.add("Οφθαλομολογικό ιατρείο");
                arrayList_outpatients.add("Δερματολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

            if(health_center.equals("Καστελιού")){
                arrayList_outpatients = new ArrayList<>();
                arrayList_outpatients.add("Νευρολογικό ιατρείο");
                arrayList_outpatients.add("Ενδοκρινολογικό ιατρείο");
                arrayList_outpatients.add("Καρδιολογικό ιατρείο");
                arrayList_outpatients.add("Αλλεργιολογικό ιατρείο");
                arrayList_outpatients.add("Οφθαλομολογικό ιατρείο");

                arrayAdapter_outpatients = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_outpatients);

                sp_outpatients.setAdapter(arrayAdapter_outpatients);
            }

        }

        btn_outpatients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String spinnerValueOutpatients = sp_outpatients.getSelectedItem().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_OUTPATIENT, spinnerValueOutpatients);
                editor.apply();

                startActivity(new Intent(OutpatientsActivity.this, AppointmentActivity.class));

            }
        });
    }
}
