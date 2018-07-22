package com.example.vcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText name,contact,gender,city,income,type,stage,state;
    private Button reg_pat;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.patName);
        contact = findViewById(R.id.patContact);
        gender = findViewById(R.id.patGender);
        city = findViewById(R.id.patCity);
        income = findViewById(R.id.patIncome);
        type = findViewById(R.id.cancerType);
        stage = findViewById(R.id.stage);
        reg_pat = findViewById(R.id.regPat);
        state = findViewById(R.id.state);
        firebaseFirestore = firebaseFirestore.getInstance();



        reg_pat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nameStr = name.getText().toString();
                String contactStr = contact.getText().toString();
                String genderStr = gender.getText().toString();
                String cityStr = city.getText().toString();
                String incomeStr = income.getText().toString();
                String typeStr = type.getText().toString();
                String stageStr = stage.getText().toString();
                String stateStr = state.getText().toString();

                if(TextUtils.isEmpty(nameStr))
                {
                    name.setError("Name Required");
                    name.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(contactStr))
                {
                    contact.setError("Contact Required");
                    contact.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(genderStr))
                {
                    gender.setError("Gender Required");
                    gender.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(cityStr))
                {
                    city.setError("City Required");
                    city.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(incomeStr))
                {
                    income.setError("Income Required");
                    income.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(typeStr))
                {
                    type.setError("Type of Cancer Required");
                    type.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(stageStr))
                {
                    stage.setError("Stage of Cancer Required");
                    stage.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(stageStr))
                {
                    state.setError("State is Required");
                    state.requestFocus();
                    return;
                }


                Map<String, String> data = new HashMap<>();
                data.put("name", nameStr);
                data.put("contact", contactStr);
                data.put("gender", genderStr);
                data.put("city", cityStr);
                data.put("income", incomeStr);
                data.put("type",typeStr);
                data.put("stage", stageStr);
                data.put("state", stateStr.toLowerCase().trim());
                //Toast.makeText(MainActivity.this, name.getText().toString(), Toast.LENGTH_SHORT).show();




                firebaseFirestore.collection("patients")
                        .add(data)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(MainActivity.this, "Patient added successfully", Toast.LENGTH_SHORT).show();
                                Log.i("test","inserted");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });




    }



    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item1:


            case R.id.item2:
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(MainActivity.this, FirstPage.class);
                startActivity(i);

            default:
                return super.onOptionsItemSelected(item);
        }

    }

















}
