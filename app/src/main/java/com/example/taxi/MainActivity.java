package com.example.taxi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putString("name", userName.getText().toString());
                myEdit.putString("surname", userSurname.getText().toString());
                myEdit.putString("phone", userPhone.getText().toString());
                myEdit.apply();

                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("name", userName.getText().toString());
                intent.putExtra("surname", userSurname.getText().toString());
                intent.putExtra("phone", userPhone.getText().toString());
                startActivity(intent);
            }
        });
    }
}
