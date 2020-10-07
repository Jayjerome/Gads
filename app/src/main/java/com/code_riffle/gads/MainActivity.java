package com.code_riffle.gads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText full_name;
    private EditText age;
    private RadioButton yes, no;
    private Button next;

    String name;
    int your_age;

    SharedPreferences sharedPreferences;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        sharedPreferences = new SharedPreferences(context);



        full_name = findViewById(R.id.full_name);
        age = findViewById(R.id.age);
        yes = findViewById(R.id.radio_button_yes);
        no = findViewById(R.id.radio_button_no);

        next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextActivity = new Intent(context, SecondActivity.class);
                startActivity(nextActivity);
            }
        });



        no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
                if (check){
                    yes.setChecked(false);
                }
            }
        });

        yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
                if (check){
                    no.setChecked(false);
                }
            }
        });


    }

    public void sign_me_in(View view) {

        if (yes.isChecked())
            registerUser();
        else
            Toast.makeText(context, "You must accept terms and conditions to proceed...", Toast.LENGTH_SHORT).show();



    }

    private void registerUser() {
        name = full_name.getText().toString();
        your_age = Integer.parseInt(age.getText().toString());

        if (name.length() <= 2 ){
            full_name.setError("Your name must be above 2 characters");
        }else{
            if (your_age <= 18){
                age.setError("You're too young to use this app, please grow older");
            }else{
                saveUserDetails(name, String.valueOf(your_age));
            }
        }
    }

    private void saveUserDetails(String full_name, String age) {
        sharedPreferences.save("name", full_name);
        sharedPreferences.save("age", age);

        Intent intent = new Intent(context, SecondActivity.class);
        startActivity(intent);
    }


}