package com.app.cubegame;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNumber = findViewById(R.id.etNum);
        MaterialButton btnNext = findViewById(R.id.btnNext);
//        etNumber.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
//        etNumber.setKeyListener(DigitsKeyListener.getInstance("0123456789"));

        btnNext.setOnClickListener((v) -> {
            if (etNumber.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter any number", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(this, GameActivity.class);
                intent.putExtra("number", etNumber.getText().toString().trim());
                startActivity(intent);
                etNumber.setText("");
            }
        });
    }
}