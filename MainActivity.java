package com.example.homework;

import static com.example.homework.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        EditText et = findViewById(id.editText1);
        findViewById(id.button).setOnClickListener(v -> {
            if(et.getText().toString().trim().length() != 0){
                Intent newIntent = new Intent(getApplicationContext(), RecyclerActivity.class);
                newIntent.putExtra("location", et.getText().toString());
                startActivity(newIntent);
            }
        });
    }
}