package com.example.vcare;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreateAcc extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;
    private EditText emailAcc,passAcc;
    private FirebaseAuth mAuth;
    private Button CreateAcc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);
        emailAcc = findViewById(R.id.emailCreate);
        passAcc = findViewById(R.id.passCreate);
        CreateAcc = findViewById(R.id.CreateAcc);
        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        CreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailStr = emailAcc.getText().toString().trim();
                String passStr = passAcc.getText().toString().trim();
                if (TextUtils.isEmpty(emailStr)) {
                    emailAcc.setError("Email is required");
                    emailAcc.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(passStr)) {
                    passAcc.setError("Email is required");
                    passAcc.requestFocus();
                    return;
                }
                createNewAccount(emailStr,passStr);
            }
        });


    }

    private void createNewAccount(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(CreateAcc.this, "Vol data added successfully", Toast.LENGTH_SHORT).show();
                            Intent goToVolInfo = new Intent(CreateAcc.this,VolInfo.class);
                            startActivity(goToVolInfo);
                            finish();
                        } else {
                            Toast.makeText(CreateAcc.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });


    }
}
