package com.example.week2daily1homework;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserInputActivity2 extends AppCompatActivity {
    EditText etYear;
    EditText etMake;
    EditText etModel;
    EditText etColor;
    EditText etEngine;
    EditText etTransType;
    EditText etTitleStatus;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input1);

        sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        etYear = findViewById(R.id.etYear);
        etMake = findViewById(R.id.etMake);
        etModel = findViewById(R.id.etModel);
        etColor = findViewById(R.id.etColor);
        etEngine = findViewById(R.id.etEngine);
        etTransType = findViewById(R.id.etTransType);
        etTitleStatus = findViewById(R.id.etTitleStatus);

    }

    public void onClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        Car car = new Car(etYear.getText().toString(),
                etMake.getText().toString(),
                etModel.getText().toString(),
                etColor.getText().toString(),
                etEngine.getText().toString(),
                etTransType.getText().toString(),
                etTitleStatus.getText().toString());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("make",car.getMake());
        editor.putString("model",car.getModel());
        editor.commit();

        Bundle extra = new Bundle();
        extra.putParcelable("car",car);
        intent.putExtras(extra);
        startActivity(intent);
    }

}
