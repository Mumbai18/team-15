package com.example.vcare;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirstPage extends AppCompatActivity {
    private EditText emailEd,passEd;
    private Button LoginBtn,RegisterBtn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        emailEd = findViewById(R.id.email);
        passEd = findViewById(R.id.password);
        LoginBtn = findViewById(R.id.login);
        RegisterBtn = findViewById(R.id.register);
        mAuth = FirebaseAuth.getInstance();







        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailStr = emailEd.getText().toString();
                String passStr = passEd.getText().toString();
                if (TextUtils.isEmpty(emailStr)) {
                    emailEd.setError("Email is required");
                    emailEd.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(passStr)) {
                    passEd.setError("Password is required");
                    passEd.requestFocus();
                    return;
                }
                userSignIn(emailStr,passStr);
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

    private void userSignIn(String emailStr, String passStr) {
        mAuth.signInWithEmailAndPassword(emailStr,passStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent gotToMainAcc = new Intent(FirstPage.this,MainActivity.class);
                    startActivity(gotToMainAcc);

                }else
                {
                    Toast.makeText(FirstPage.this, "Error:"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
