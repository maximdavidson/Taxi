package com.example.taxi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    EditText userStreet, userHouse, userFlat;
    EditText userStreetTo, userHouseTo, userFlatTo;
    Button buttonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);
        Log.d("OrderActivity", "onCreate");

        userStreet = findViewById(R.id.userStreet);
        userHouse = findViewById(R.id.userHouse);
        userFlat = findViewById(R.id.userFlat);
        userStreetTo = findViewById(R.id.userStreetTo);
        userHouseTo = findViewById(R.id.userHouseTo);
        userFlatTo = findViewById(R.id.userFlatTo);
        buttonOk = findViewById(R.id.buttonOk);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fromStreet = userStreet.getText().toString();
                String fromHouse = userHouse.getText().toString();
                String fromFlat = userFlat.getText().toString();
                String toStreet = userStreetTo.getText().toString();
                String toHouse = userHouseTo.getText().toString();
                String toFlat = userFlatTo.getText().toString();

                if (!fromStreet.isEmpty() && !fromHouse.isEmpty() && !fromFlat.isEmpty() &&
                        !toStreet.isEmpty() && !toHouse.isEmpty() && !toFlat.isEmpty()) {
                    Intent intent = new Intent();
                    String path = "From: " + fromStreet + ", " + fromHouse + ", " + fromFlat +
                            " To: " + toStreet + ", " + toHouse + ", " + toFlat;
                    intent.putExtra("path", path);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(OrderActivity.this, "Введите все данные", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("OrderActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("OrderActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("OrderActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("OrderActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("OrderActivity", "onDestroy");
    }
}
