package com.example.vcare;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class VolInfo extends AppCompatActivity {

    private EditText nameVol,locationVol,hospitalVol,programVol;
    private Button Submit;
    FirebaseFirestore firebaseFirestore;
    Map<String,String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vol_info);
        nameVol = findViewById(R.id.nameVol);
        locationVol = findViewById(R.id.locationVol);
        hospitalVol = findViewById(R.id.hospitalVol);
        programVol = findViewById(R.id.programVol);
        Submit = findViewById(R.id.Submit);
        firebaseFirestore = FirebaseFirestore.getInstance();

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameString = nameVol.getText().toString();
                String locString = locationVol.getText().toString();
                String hospitalString = hospitalVol.getText().toString();
                String programString = programVol.getText().toString();
                data = new HashMap<>();
                data.put("nameVol",nameString);
                data.put("locationVol",locString);
                data.put("hospitalVol",hospitalString);
                data.put("programVol",programString);
                firebaseFirestore.collection("volunteers")
                        .add(data).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(VolInfo.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                            Intent gotoPatientAct = new Intent(VolInfo.this,MainActivity.class);
                            startActivity(gotoPatientAct);
                            finish();
                        }   else{
                            Toast.makeText(VolInfo.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
}
