package com.example.vcare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText name,contact,gender,city,income,type,stage;
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


    }
}
