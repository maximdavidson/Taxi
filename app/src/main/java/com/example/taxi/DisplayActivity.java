package com.example.taxi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    TextView textViewName, textViewSurname, textViewPhone;
    TextView textViewTaxi;
    TextView textViewPath; // Новое текстовое поле
    Button buttonSetPath, buttonCallTaxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayactivity);
        Log.d("DisplayActivity", "onCreate");

        textViewName = findViewById(R.id.textViewName);
        textViewSurname = findViewById(R.id.textViewSurname);
        textViewPhone = findViewById(R.id.textViewPhone);
        textViewTaxi = findViewById(R.id.textViewTaxi);
        textViewPath = findViewById(R.id.textViewPath); // Инициализация нового текстового поля
        buttonSetPath = findViewById(R.id.buttonOrderTaxi);
        buttonCallTaxi = findViewById(R.id.buttonOrder);

        Intent intent = getIntent();
        if (intent.hasExtra("name")) {
            String name = intent.getStringExtra("name");
            String surname = intent.getStringExtra("surname");
            String phone = intent.getStringExtra("phone");

            textViewName.setText(name);
            textViewSurname.setText(surname);
            textViewPhone.setText(phone);
        }

        buttonSetPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayActivity.this, OrderActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        buttonCallTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textViewPath.getText().toString().isEmpty()) {
                    Toast.makeText(DisplayActivity.this, "Такси скоро приедет. Удачной поездки!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DisplayActivity.this, "Пожалуйста, добавьте все данные о поездке.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("DisplayActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("DisplayActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("DisplayActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("DisplayActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("DisplayActivity", "onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("DisplayActivity", "onActivityResult");

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String path = data.getStringExtra("path");
                textViewPath.setText(path); // Обновление нового текстового поля
                buttonCallTaxi.setEnabled(true);
            }
        }
    }
}
