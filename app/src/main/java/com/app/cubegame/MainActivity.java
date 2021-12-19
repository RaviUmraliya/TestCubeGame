package com.app.cubegame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNumber = findViewById(R.id.etNumber);
        MaterialButton btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener((v) -> {
            if (etNumber.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter any number", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(this, GameActivity.class);
                intent.putExtra("number", etNumber.getText().toString().trim());
                startActivity(intent);
            }
        });
    }
}