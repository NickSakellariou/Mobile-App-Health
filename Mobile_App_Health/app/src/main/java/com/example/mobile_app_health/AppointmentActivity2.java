package com.example.mobile_app_health;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AppointmentActivity2 extends AppCompatActivity {

    TextView textView_orderDoctor;
    TextView textView_region, textView_hospital, textView_outpatients, textView_doctor;
    TextView textView_name, textView_surname, textView_father, textView_mother, textView_amka;
    TextView textView_address, textView_homephone, textView_mobilephone, textView_allergies, textView_chronicDiseases, textView_pregnancy;
    TextView textView_gender, textView_birthdate, textView_datetime;

    Button button_cancel;

    String regionDatetime;

    SharedPreferences sharedPreferences;

    DatabaseReference reff;

    long maxid = 0;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_REGION = "health_region";
    private static final String KEY_HOSPITAL = "hospital";
    private static final String KEY_CENTER = "health_center";
    private static final String KEY_OUTPATIENT = "outpatient";

    private static final String KEY_ORDERDOCTOR = "orderDoctor";
    private static final String KEY_NAME = "name";
    private static final String KEY_SURNAME = "surname";
    private static final String KEY_FATHER = "father";
    private static final String KEY_MOTHER = "mother";
    private static final String KEY_AMKA = "amka";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_BIRTHDATE = "birthdate";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_HOMEPHONE = "homephone";
    private static final String KEY_MOBILEPHONE = "mobilephone";
    private static final String KEY_ALLERGIES = "allergies";
    private static final String KEY_CHRONICKDISEASES = "chronicDiseases";
    private static final String KEY_PREGNANCY = "pregnancy";
    private static final String KEY_DATETIME = "datetime";
    private static final String KEY_DOCTOR = "doctor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment2);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String region = sharedPreferences.getString(KEY_REGION,null);
        String hospital = sharedPreferences.getString(KEY_HOSPITAL,null);
        String health_center = sharedPreferences.getString(KEY_CENTER,null);
        String outpatients = sharedPreferences.getString(KEY_OUTPATIENT,null);

        String orderDoctor = sharedPreferences.getString(KEY_ORDERDOCTOR,null);
        String name = sharedPreferences.getString(KEY_NAME,null);
        String surname = sharedPreferences.getString(KEY_SURNAME,null);
        String father = sharedPreferences.getString(KEY_FATHER,null);
        String mother = sharedPreferences.getString(KEY_MOTHER,null);
        String amka = sharedPreferences.getString(KEY_AMKA,null);
        String gender = sharedPreferences.getString(KEY_GENDER,null);
        String birthdate = sharedPreferences.getString(KEY_BIRTHDATE,null);
        String address = sharedPreferences.getString(KEY_ADDRESS,null);
        String homephone = sharedPreferences.getString(KEY_HOMEPHONE,null);
        String mobilephone = sharedPreferences.getString(KEY_MOBILEPHONE,null);
        String allergies = sharedPreferences.getString(KEY_ALLERGIES,null);
        String chronicDiseases = sharedPreferences.getString(KEY_CHRONICKDISEASES,null);
        String pregnancy = sharedPreferences.getString(KEY_PREGNANCY,null);
        String datetime = sharedPreferences.getString(KEY_DATETIME,null);
        String doctor = sharedPreferences.getString(KEY_DOCTOR,null);

        textView_orderDoctor = findViewById(R.id.orderDoctor);
        textView_region = findViewById(R.id.region);
        textView_hospital = findViewById(R.id.hospital);
        textView_outpatients = findViewById(R.id.outpatients);
        textView_name = findViewById(R.id.name);
        textView_surname = findViewById(R.id.surname);
        textView_father = findViewById(R.id.father);
        textView_mother = findViewById(R.id.mother);
        textView_amka = findViewById(R.id.amka);
        textView_gender = findViewById(R.id.gender);
        textView_birthdate = findViewById(R.id.birthdate);
        textView_address = findViewById(R.id.address);
        textView_homephone = findViewById(R.id.homephone);
        textView_mobilephone = findViewById(R.id.mobilephone);
        textView_allergies = findViewById(R.id.allergies);
        textView_chronicDiseases = findViewById(R.id.chronicDiseases);
        textView_pregnancy = findViewById(R.id.pregnancy);
        textView_datetime = findViewById(R.id.datetime);
        textView_doctor = findViewById(R.id.doctor);
        button_cancel = findViewById(R.id.button_cancel);

        if (name != null){
            if (orderDoctor.equals("")) {
                textView_orderDoctor.setText("Ο ασθενής από μόνος του προγραμμάτισε το ραντεβού");
            }else{
                textView_orderDoctor.setText("Ο γιατρός " + orderDoctor + " προγραμμάτισε το ραντεβού");
            }
            textView_region.setText("Υγειονομική περιφέρεια : " +region);
            if (hospital != null){
                textView_hospital.setText("Νοσοκομείο : " +hospital);
                textView_outpatients.setText("Εξωτερικό ιατρείο : " +outpatients);
            }
            if (health_center != null){
                textView_hospital.setText("Κέντρο υγείας : " +health_center);
                textView_outpatients.setText("Ιατρείο : " +outpatients);
            }
            textView_name.setText("Όνομα : " +name);
            textView_surname.setText("Επώνυμο : " +surname);
            textView_father.setText("Όνομα πατέρα : " +father);
            textView_mother.setText("Όνομα μητέρας : " +mother);
            textView_amka.setText("ΑΜΚΑ : " +amka);
            textView_gender.setText("Φύλλο : " +gender);
            textView_birthdate.setText("Ημερομηνία γέννησης : " +birthdate);
            textView_address.setText("Διεύθυνση : " +address);
            textView_homephone.setText("Αριθμός τηλεφώνου κατοικίας : " +homephone);
            textView_mobilephone.setText("Αριθμός τηλεφώνου κινητού : " +mobilephone);
            textView_datetime.setText("Ημερομηνία ραντεβού : " +datetime);
            textView_doctor.setText("Γιατρός : " +doctor);

            if (allergies.equals("")) {
                textView_allergies.setText("Αλλεργίες : καμία");
            }else{
                textView_allergies.setText("Αλλεργίες : " +allergies);
            }

            if (chronicDiseases.equals("")) {
                textView_chronicDiseases.setText("Χρόνιες ασθένειες : καμία");
            }else{
                textView_chronicDiseases.setText("Χρόνιες ασθένειες : " +chronicDiseases);
            }

            if (gender.equals("Αρσενικό")) {
                textView_pregnancy.setVisibility(View.INVISIBLE);
            }else{
                if (pregnancy.equals("")) {
                    textView_pregnancy.setText("Κύηση : καμία");
                }else{
                    textView_pregnancy.setText("Κύηση : " +pregnancy);
                }
            }
        }

        button_cancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(AppointmentActivity2.this,"Το ραντεβού σας ακυρώθηκε", Toast.LENGTH_SHORT).show();

            regionDatetime = region + hospital + outpatients + datetime + doctor;

            reff = FirebaseDatabase.getInstance().getReference().child("appointment");

            Query query = reff.orderByChild("regionDatetime").equalTo(regionDatetime);

            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot Snapshot: dataSnapshot.getChildren()) {
                        Snapshot.getRef().removeValue();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });

            Intent intent = new Intent(AppointmentActivity2.this, AppointmentActivity.class);
            startActivity(intent);
            }
        });
    }
}
