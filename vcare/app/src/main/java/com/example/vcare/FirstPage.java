package com.example.vcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstPage extends AppCompatActivity {
    private EditText emailEd,passEd;
    private Button LoginBtn,RegisterBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        emailEd = findViewById(R.id.email);
        passEd = findViewById(R.id.password);
        LoginBtn = findViewById(R.id.login);
        RegisterBtn = findViewById(R.id.register);
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
}
