package com.code_riffle.gads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView details;
    Context context;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        context = SecondActivity.this;
        sharedPreferences = new SharedPreferences(context);

        details = findViewById(R.id.details);

        String name = sharedPreferences.retrieve("name");
        String age = sharedPreferences.retrieve("age");

        details.setText("Hi, "+name+ " you're "+ age+ " years old");
    }
}