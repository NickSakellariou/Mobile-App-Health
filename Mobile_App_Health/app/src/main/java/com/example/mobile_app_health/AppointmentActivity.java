package com.example.mobile_app_health;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class AppointmentActivity extends AppCompatActivity {

    EditText editText_orderDoctor;
    EditText editText_name, editText_surname, editText_father, editText_mother, editText_amka;
    EditText editText_address, editText_homephone, editText_mobilephone, editText_allergies, editText_chronicDiseases, editText_pregnancy;

    RadioGroup radioGroup, radioGroupDoctor;

    DatePicker edit_birthdate, edit_date;
    TimePicker edit_time;

    Button button_save, button_dates;

    String regionDate;
    String regionDatetime;

    TextView referencedate, referencedoctor, text_view_referencedate, text_view_referencedoctor;

    boolean booleanValue = false;

    SharedPreferences sharedPreferences;

    DatabaseReference reff0;
    DatabaseReference reff;

    long maxid = 0;

    Appointment1 appointment;

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
        setContentView(R.layout.activity_appointment);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String region = sharedPreferences.getString(KEY_REGION,null);
        String hospital = sharedPreferences.getString(KEY_HOSPITAL,null);
        String health_center = sharedPreferences.getString(KEY_CENTER,null);
        String outpatients = sharedPreferences.getString(KEY_OUTPATIENT,null);

        editText_orderDoctor = findViewById(R.id.edit_textOrderDoctor);
        editText_name = findViewById(R.id.edit_text1);
        editText_surname = findViewById(R.id.edit_text2);
        editText_father = findViewById(R.id.edit_text3);
        editText_mother = findViewById(R.id.edit_text4);
        editText_amka = findViewById(R.id.edit_text5);

        radioGroup = (RadioGroup) findViewById(R.id.gender);

        edit_birthdate = findViewById(R.id.birthdate);
        editText_address = findViewById(R.id.edit_text6);
        editText_homephone = findViewById(R.id.edit_text7);
        editText_mobilephone = findViewById(R.id.edit_text8);
        editText_allergies = findViewById(R.id.edit_text9);
        editText_chronicDiseases = findViewById(R.id.edit_text10);
        editText_pregnancy = findViewById(R.id.edit_text11);
        edit_date = findViewById(R.id.date_picker);
        edit_time = findViewById(R.id.time_picker);

        radioGroupDoctor = (RadioGroup) findViewById(R.id.doctor);

        button_save = findViewById(R.id.button_save);
        button_dates = findViewById(R.id.button_dates);

        edit_birthdate.setMaxDate(System.currentTimeMillis());

        edit_date.setMinDate(System.currentTimeMillis() - 1000);

        edit_time.setIs24HourView(true);

        appointment = new Appointment1();

        reff = FirebaseDatabase.getInstance().getReference().child("appointment");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxid = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        button_dates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleanValue = false;
                referencedate = findViewById(R.id.referencedate);
                referencedate.setText("");
                referencedoctor = findViewById(R.id.referencedoctor);
                referencedoctor.setText("");
                text_view_referencedate = findViewById(R.id.text_view_referencedate);
                text_view_referencedate.setText("");
                text_view_referencedoctor = findViewById(R.id.text_view_referencedoctor);
                text_view_referencedoctor.setText("");

                SimpleDateFormat dfDate  = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

                DatePicker datePicker2 = findViewById(R.id.date_picker);

                Calendar calendarDate = new GregorianCalendar(datePicker2.getYear(),
                        datePicker2.getMonth(),
                        datePicker2.getDayOfMonth());

                Date currentDate = new Date(System.currentTimeMillis());

                if(dfDate.format(currentDate).compareTo(dfDate.format(calendarDate.getTime())) == 0){
                    Toast.makeText(AppointmentActivity.this,"Η επιλεγμένη μέρα πρέπει να είναι μεταγενέστερη της σημερινής και όχι " + dfDate.format(calendarDate.getTime()), Toast.LENGTH_SHORT).show();
                }else{
                    referencedate.setText("Ημερομηνία");
                    referencedoctor.setText("Γιατρός");

                    if (hospital != null) {
                        regionDate = region + hospital + outpatients + dfDate.format(calendarDate.getTime());

                        reff = FirebaseDatabase.getInstance().getReference().child("appointment");

                        Query query = reff.orderByChild("regionDate").equalTo(regionDate);

                        query.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                String content1 = "";
                                String content2 = "";
                                for (DataSnapshot Snapshot: dataSnapshot.getChildren()) {
                                    Appointment1 Appointment2 = Snapshot.getValue(Appointment1.class);
                                    String datetime = Appointment2.getDatetime();
                                    String doctor = Appointment2.getDoctor();

                                    content1 = datetime;
                                    content2 = doctor;

                                    text_view_referencedate.append(content1 + "\n");
                                    text_view_referencedoctor.append(content2 + "\n");

                                    booleanValue = true;
                                }

                                if(booleanValue == false){
                                    referencedate.setText("Κανένα ραντεβού για αυτήν την μέρα");
                                    referencedoctor.setText("");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                    if (health_center != null) {

                        regionDate = region + health_center + outpatients + dfDate.format(calendarDate.getTime());

                        reff = FirebaseDatabase.getInstance().getReference().child("appointment");

                        Query query = reff.orderByChild("regionDate").equalTo(regionDate);

                        query.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                String content1 = "";
                                String content2 = "";
                                for (DataSnapshot Snapshot: dataSnapshot.getChildren()) {
                                    Appointment1 Appointment2 = Snapshot.getValue(Appointment1.class);
                                    String datetime = Appointment2.getDatetime();
                                    String doctor = Appointment2.getDoctor();

                                    content1 = datetime;
                                    content2 = doctor;

                                    text_view_referencedate.append(content1 + "\n");
                                    text_view_referencedoctor.append(content2 + "\n");

                                    booleanValue = true;
                                }

                                if(booleanValue == false){
                                    referencedate.setText("Κανένα ραντεβού για αυτήν την μέρα");
                                    referencedoctor.setText("");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }

                }

            }
        });


        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateOrderDoctor() | !validateName() | !validateSurname() | !validateFather() | !validateMother() | !validateAMKA() | !validateAddress() | !validateHomephone() | !validateMobilehone()) {
                    return;
                }

                SimpleDateFormat dfDate  = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

                DatePicker datePicker1 = findViewById(R.id.birthdate);

                Calendar gc = new GregorianCalendar(datePicker1.getYear(),
                        datePicker1.getMonth(),
                        datePicker1.getDayOfMonth());

                SimpleDateFormat dfDateTime  = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss", Locale.getDefault());

                DatePicker datePicker2 = findViewById(R.id.date_picker);
                TimePicker timePicker =findViewById(R.id.time_picker);

                Date currentDate = new Date(System.currentTimeMillis());

                Calendar calendarDate = new GregorianCalendar(datePicker2.getYear(),
                        datePicker2.getMonth(),
                        datePicker2.getDayOfMonth());

                if(dfDate.format(currentDate).compareTo(dfDate.format(calendarDate.getTime())) == 0){
                    Toast.makeText(AppointmentActivity.this,"Η επιλεγμένη μέρα πρέπει να είναι μεταγενέστερη της σημερινής και όχι " + dfDate.format(calendarDate.getTime()), Toast.LENGTH_SHORT).show();
                }else{
                    if(timePicker.getHour()!=8 && timePicker.getHour()!=9 && timePicker.getHour()!=10 && timePicker.getHour()!=11 && timePicker.getHour()!=12 && timePicker.getHour()!=13){
                        Toast.makeText(AppointmentActivity.this,"Η επιλεγμένη ώρα πρέπει να είναι ή 8 ή 9 ή 10 ή 11 ή 12 ή 13 και όχι " + timePicker.getHour(), Toast.LENGTH_SHORT).show();
                    }else{
                        if(timePicker.getMinute()!=0 && timePicker.getMinute()!=30){
                            Toast.makeText(AppointmentActivity.this,"Το επιλεγμένο λεπτό πρέπει να είναι ή 0 ή 30 και όχι " + timePicker.getMinute(), Toast.LENGTH_SHORT).show();
                        }else{
                            Calendar calendar = new GregorianCalendar(datePicker2.getYear(),
                                    datePicker2.getMonth(),
                                    datePicker2.getDayOfMonth(),
                                    timePicker.getHour(),
                                    timePicker.getMinute());

                            if (hospital != null){

                                regionDate = region + hospital + outpatients + dfDate.format(calendarDate.getTime());

                                regionDatetime = region + hospital + outpatients + dfDateTime.format(calendar.getTime()) + ((RadioButton)findViewById(radioGroupDoctor.getCheckedRadioButtonId())).getText().toString();

                                reff = FirebaseDatabase.getInstance().getReference().child("appointment");

                                Query query = reff.orderByChild("regionDatetime").equalTo(regionDatetime);

                                query.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        if (dataSnapshot.exists()){
                                            Toast.makeText(AppointmentActivity.this,"Έχει προγραμματισθεί ραντεβού για άλλον ασθενή στο συγκεκριμένο ιατρείο με τον συγκεκριμένο γιατρό, διαλέξτε κάποια άλλη ώρα ή κάποιον άλλον γιατρό", Toast.LENGTH_SHORT).show();
                                        }
                                        else{
                                            appointment.setOrderDoctor(editText_orderDoctor.getText().toString().trim());
                                            appointment.setRegion(region);
                                            appointment.setHospital(hospital);
                                            appointment.setOutpatients(outpatients);
                                            appointment.setName(editText_name.getText().toString().trim());
                                            appointment.setSurname(editText_surname.getText().toString().trim());
                                            appointment.setFather(editText_father.getText().toString().trim());
                                            appointment.setMother(editText_mother.getText().toString().trim());
                                            appointment.setAmka(editText_amka.getText().toString().trim());
                                            appointment.setGender(((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString());
                                            appointment.setBirthdate(dfDate.format(gc.getTime()));
                                            appointment.setAddress(editText_address.getText().toString().trim());
                                            appointment.setHomephone(editText_homephone.getText().toString().trim());
                                            appointment.setMobilephone(editText_mobilephone.getText().toString().trim());
                                            appointment.setAllergies(editText_allergies.getText().toString().trim());
                                            appointment.setChronicDiseases(editText_chronicDiseases.getText().toString().trim());
                                            appointment.setPregnancy(editText_pregnancy.getText().toString().trim());
                                            appointment.setDatetime(dfDateTime.format(calendar.getTime()));
                                            appointment.setRegionDate(regionDate);
                                            appointment.setRegionDatetime(regionDatetime);
                                            appointment.setDoctor(((RadioButton)findViewById(radioGroupDoctor.getCheckedRadioButtonId())).getText().toString());

                                            reff.child(String.valueOf(maxid + 1)).setValue(appointment);

                                            SharedPreferences.Editor editor = sharedPreferences.edit();
                                            editor.putString(KEY_ORDERDOCTOR, editText_orderDoctor.getText().toString());
                                            editor.putString(KEY_NAME, editText_name.getText().toString());
                                            editor.putString(KEY_SURNAME, editText_surname.getText().toString());
                                            editor.putString(KEY_FATHER, editText_father.getText().toString());
                                            editor.putString(KEY_MOTHER, editText_mother.getText().toString());
                                            editor.putString(KEY_AMKA, editText_amka.getText().toString());
                                            editor.putString(KEY_GENDER, ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString());
                                            editor.putString(KEY_BIRTHDATE, dfDate.format(gc.getTime()));
                                            editor.putString(KEY_ADDRESS, editText_address.getText().toString());
                                            editor.putString(KEY_SURNAME, editText_surname.getText().toString());
                                            editor.putString(KEY_HOMEPHONE, editText_homephone.getText().toString());
                                            editor.putString(KEY_MOBILEPHONE, editText_mobilephone.getText().toString());
                                            editor.putString(KEY_ALLERGIES, editText_allergies.getText().toString());
                                            editor.putString(KEY_CHRONICKDISEASES, editText_chronicDiseases.getText().toString());
                                            editor.putString(KEY_PREGNANCY, editText_pregnancy.getText().toString());
                                            editor.putString(KEY_DATETIME, dfDateTime.format(calendar.getTime()));
                                            editor.putString(KEY_DOCTOR, ((RadioButton)findViewById(radioGroupDoctor.getCheckedRadioButtonId())).getText().toString());
                                            editor.apply();

                                            startActivity(new Intent(AppointmentActivity.this, AppointmentActivity2.class));
                                        }
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                    }
                                });
                            }

                            if (health_center != null){

                                regionDate = region + health_center + outpatients + dfDate.format(calendarDate.getTime());

                                regionDatetime = region + health_center + outpatients + dfDateTime.format(calendar.getTime()) + ((RadioButton)findViewById(radioGroupDoctor.getCheckedRadioButtonId())).getText().toString();

                                reff = FirebaseDatabase.getInstance().getReference().child("appointment");

                                Query query = reff.orderByChild("regionDatetime").equalTo(regionDatetime);

                                query.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        if (dataSnapshot.exists()){
                                            Toast.makeText(AppointmentActivity.this,"Έχει προγραμματισθεί ραντεβού για άλλον ασθενή στο συγκεκριμένο ιατρείο με τον συγκεκριμένο γιατρό, διαλέξτε κάποια άλλη ώρα ή κάποιον άλλον γιατρό", Toast.LENGTH_SHORT).show();
                                        }
                                        else{
                                            appointment.setOrderDoctor(editText_orderDoctor.getText().toString().trim());
                                            appointment.setRegion(region);
                                            appointment.setHealthCenter(health_center);
                                            appointment.setOutpatients(outpatients);
                                            appointment.setName(editText_name.getText().toString().trim());
                                            appointment.setSurname(editText_surname.getText().toString().trim());
                                            appointment.setFather(editText_father.getText().toString().trim());
                                            appointment.setMother(editText_mother.getText().toString().trim());
                                            appointment.setAmka(editText_amka.getText().toString().trim());
                                            appointment.setGender(((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString());
                                            appointment.setBirthdate(dfDate.format(gc.getTime()));
                                            appointment.setAddress(editText_address.getText().toString().trim());
                                            appointment.setHomephone(editText_homephone.getText().toString().trim());
                                            appointment.setMobilephone(editText_mobilephone.getText().toString().trim());
                                            appointment.setAllergies(editText_allergies.getText().toString().trim());
                                            appointment.setChronicDiseases(editText_chronicDiseases.getText().toString().trim());
                                            appointment.setPregnancy(editText_pregnancy.getText().toString().trim());
                                            appointment.setDatetime(dfDateTime.format(calendar.getTime()));
                                            appointment.setRegionDate(regionDate);
                                            appointment.setRegionDatetime(regionDatetime);
                                            appointment.setDoctor(((RadioButton)findViewById(radioGroupDoctor.getCheckedRadioButtonId())).getText().toString());

                                            reff.child(String.valueOf(maxid + 1)).setValue(appointment);

                                            SharedPreferences.Editor editor = sharedPreferences.edit();
                                            editor.putString(KEY_ORDERDOCTOR, editText_orderDoctor.getText().toString());
                                            editor.putString(KEY_NAME, editText_name.getText().toString());
                                            editor.putString(KEY_SURNAME, editText_surname.getText().toString());
                                            editor.putString(KEY_FATHER, editText_father.getText().toString());
                                            editor.putString(KEY_MOTHER, editText_mother.getText().toString());
                                            editor.putString(KEY_AMKA, editText_amka.getText().toString());
                                            editor.putString(KEY_GENDER, ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString());
                                            editor.putString(KEY_BIRTHDATE, dfDate.format(gc.getTime()));
                                            editor.putString(KEY_ADDRESS, editText_address.getText().toString());
                                            editor.putString(KEY_SURNAME, editText_surname.getText().toString());
                                            editor.putString(KEY_HOMEPHONE, editText_homephone.getText().toString());
                                            editor.putString(KEY_MOBILEPHONE, editText_mobilephone.getText().toString());
                                            editor.putString(KEY_ALLERGIES, editText_allergies.getText().toString());
                                            editor.putString(KEY_CHRONICKDISEASES, editText_chronicDiseases.getText().toString());
                                            editor.putString(KEY_PREGNANCY, editText_pregnancy.getText().toString());
                                            editor.putString(KEY_DATETIME, dfDateTime.format(calendar.getTime()));
                                            editor.putString(KEY_DOCTOR, ((RadioButton)findViewById(radioGroupDoctor.getCheckedRadioButtonId())).getText().toString());
                                            editor.apply();

                                            startActivity(new Intent(AppointmentActivity.this, AppointmentActivity2.class));
                                        }
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                    }
                                });

                            }

                        }
                    }
                }
            }
        });

    }

    private boolean validateOrderDoctor() {
        String orderDoctor = editText_orderDoctor.getText().toString().trim().replaceAll("\\s+","");
        String checkorderDoctor = "^\\p{L}*$";

        if (!orderDoctor.matches(checkorderDoctor)) {
            editText_orderDoctor.setError("Το όνομα του γιατρού περιέχει μόνο γράμματα");
            return false;
        } else {
            editText_orderDoctor.setError(null);
            return true;
        }
    }

    private boolean validateName() {
        String name = editText_name.getText().toString().trim().replaceAll("\\s+","");
        String checkname = "^\\p{L}*$";

        if (name.isEmpty()) {
            editText_name.setError("Το όνομα δεν μπορεί να είναι κενό");
            return false;
        } else if (!name.matches(checkname)) {
            editText_name.setError("Το όνομα περιέχει μόνο γράμματα");
            return false;
        } else {
            editText_name.setError(null);
            return true;
        }
    }

    private boolean validateSurname() {
        String surname = editText_surname.getText().toString().trim().replaceAll("\\s+","");
        String checksurname = "^\\p{L}*$";

        if (surname.isEmpty()) {
            editText_surname.setError("Το επώνυμο δεν μπορεί να είναι κενό");
            return false;
        } else if (!surname.matches(checksurname)) {
            editText_surname.setError("Το επώνυμο περιέχει μόνο γράμματα");
            return false;
        } else {
            editText_surname.setError(null);
            return true;
        }
    }

    private boolean validateFather() {
        String father = editText_father.getText().toString().trim().replaceAll("\\s+","");
        String checkfather = "^\\p{L}*$";

        if (father.isEmpty()) {
            editText_father.setError("Το όνομα του πατέρα δεν μπορεί να είναι κενό");
            return false;
        } else if (!father.matches(checkfather)) {
            editText_father.setError("Το όνομα του πατέρα περιέχει μόνο γράμματα");
            return false;
        } else {
            editText_father.setError(null);
            return true;
        }
    }

    private boolean validateMother() {
        String mother = editText_mother.getText().toString().trim().replaceAll("\\s+","");
        String checkmother = "^\\p{L}*$";

        if (mother.isEmpty()) {
            editText_mother.setError("Το όνομα της μητέρας δεν μπορεί να είναι κενό");
            return false;
        } else if (!mother.matches(checkmother)) {
            editText_mother.setError("Το όνομα της μητέρας περιέχει μόνο γράμματα");
            return false;
        } else {
            editText_mother.setError(null);
            return true;
        }
    }

    private boolean validateAMKA() {
        String amka = editText_amka.getText().toString().trim();

        if (amka.isEmpty()) {
            editText_amka.setError("Το ΑΜΚΑ δεν μπορεί να είναι κενό");
            return false;
        } else if (amka.length() != 11) {
            editText_amka.setError("Το ΑΜΚΑ περιέχει 11 αριθμούς");
            return false;
        }else if(!amka.matches("[0-9]+")){
            editText_amka.setError("Το ΑΜΚΑ περιέχει μόνο αριθμούς");
            return false;
        } else {
            editText_amka.setError(null);
            return true;
        }
    }

    private boolean validateAddress() {
        String address = editText_address.getText().toString().trim();

        if (address.isEmpty()) {
            editText_address.setError("Η διεύθυνση δεν μπορεί να είναι κενή");
            return false;
        } else {
            editText_address.setError(null);
            return true;
        }
    }

    private boolean validateHomephone() {
        String homephone = editText_homephone.getText().toString().trim();

        if (homephone.isEmpty()) {
            editText_homephone.setError("Ο αριθμός τηλεφώνου κατοικίας δεν μπορεί να είναι κενός");
            return false;
        } else if (homephone.length() != 10) {
            editText_homephone.setError("Ο αριθμός τηλεφώνου κατοικίας περιέχει 10 αριθμούς");
            return false;
        }else if(!homephone.matches("[0-9]+")){
            editText_homephone.setError("Ο αριθμός τηλεφώνου κατοικίας περιέχει μόνο αριθμούς");
            return false;
        } else {
            editText_homephone.setError(null);
            return true;
        }
    }

    private boolean validateMobilehone() {
        String mobilephone = editText_mobilephone.getText().toString().trim();

        if (mobilephone.isEmpty()) {
            editText_mobilephone.setError("Ο αριθμός τηλεφώνου κινητού δεν μπορεί να είναι κενός");
            return false;
        } else if (mobilephone.length() != 10) {
            editText_mobilephone.setError("Ο αριθμός τηλεφώνου κινητού περιέχει 10 αριθμούς");
            return false;
        }else if(!mobilephone.matches("[0-9]+")){
            editText_mobilephone.setError("Ο αριθμός τηλεφώνου κινητού περιέχει μόνο αριθμούς");
            return false;
        } else {
            editText_mobilephone.setError(null);
            return true;
        }
    }
}
