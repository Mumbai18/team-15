package com.example.vcare;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class FirstPage extends AppCompatActivity {
    private EditText emailEd,passEd;
    private Button LoginBtn,RegisterBtn;
    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        emailEd = findViewById(R.id.email);
        passEd = findViewById(R.id.password);
        LoginBtn = findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        RegisterBtn = findViewById(R.id.register);
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailStr = emailEd.getText().toString();
                String password = passEd.getText().toString();

                userSIgnin(emailStr,password);
            }
        });
        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotToCreateAcc = new Intent(FirstPage.this,CreateAcc.class);
                startActivity(gotToCreateAcc);
                finish();
            }
        });
    }

    private void userSIgnin(String email,String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                                Intent gotToMainActivity = new Intent(FirstPage.this,MainActivity.class);
                                startActivity(gotToMainActivity);
                                finish();
                        } else {
                            Toast.makeText(FirstPage.this, "Error:"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
}
