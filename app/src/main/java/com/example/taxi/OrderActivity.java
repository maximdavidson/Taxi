package com.example.taxi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                Intent intent = new Intent();
                String path = "From: " + userStreet.getText().toString() + ", " + userHouse.getText().toString() + ", " + userFlat.getText().toString() +
                        " To: " + userStreetTo.getText().toString() + ", " + userHouseTo.getText().toString() + ", " + userFlatTo.getText().toString();
                intent.putExtra("path", path);
                setResult(RESULT_OK, intent);
                finish();
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
