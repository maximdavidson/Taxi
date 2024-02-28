package com.example.taxi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText userName, userSurname, userPhone;
    Button buttonRegister;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.userName);
        userSurname = findViewById(R.id.userSurname);
        userPhone = findViewById(R.id.userPhone);
        buttonRegister = findViewById(R.id.buttonRegister);

        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String surname = sharedPreferences.getString("surname", "");
        String phone = sharedPreferences.getString("phone", "");

        if (!name.equals("") && !surname.equals("") && !phone.equals("")) {
            userName.setText(name);
            userSurname.setText(surname);
            userPhone.setText(phone);
            buttonRegister.setText("Войти");
        }

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                String surname = userSurname.getText().toString();
                String phone = userPhone.getText().toString();

                if (!name.isEmpty() && !surname.isEmpty() && !phone.isEmpty()) {
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
                    myEdit.putString("name", name);
                    myEdit.putString("surname", surname);
                    myEdit.putString("phone", phone);
                    myEdit.apply();

                    Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("surname", surname);
                    intent.putExtra("phone", phone);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Введите все данные", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }
}
