package com.example.week2daily1homework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG ="tag_act_one";
    public static final int RESULT_CODE = 6;
    public static final int RESULT_CODES = 5;
    SharedPreferences sharedPreferences;
    TextView tvYear;
    TextView tvMake;
    TextView tvModel;
    TextView tvColor;
    TextView tvEngine;
    TextView tvTransType;
    TextView tvTitleStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        String sMake = sharedPreferences.getString("make", "No value!");
        String sModel = sharedPreferences.getString("model", "No value!");
        Log.d(TAG, "Make: " + sMake + " and Model: "+ sModel);

        tvYear = findViewById(R.id.year);
        tvMake = findViewById(R.id.make);
        tvModel = findViewById(R.id.model);
        tvColor = findViewById(R.id.color);
        tvEngine = findViewById(R.id.engine);
        tvTransType = findViewById(R.id.transType);
        tvTitleStatus = findViewById(R.id.titleStatus);
        
        Intent intent = getIntent();
        if(intent.getExtras() != null){
            Car car = intent.getParcelableExtra("car");
            tvYear.setText(car.getYear());
            tvMake.setText(car.getMake());
            tvModel.setText(car.getModel());
            tvColor.setText(car.getColor());
            tvEngine.setText(car.getEngine());
            tvTransType.setText(car.getTransmissionType());
            tvTitleStatus.setText(car.getTitleStatus());
        }

    }

    public void onClickOne(View view){
        Intent intention = new Intent(this, UserInputActivity1.class);
        startActivityForResult(intention,  RESULT_CODE);
    }

    public void onClickTwo(View view){
        Intent intention = new Intent(this, UserInputActivity1.class);
        startActivityForResult(intention, RESULT_CODES);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null){
            Intent passedIntent = data;
            Car car = passedIntent.getParcelableExtra("car");
            tvYear.setText(car.getYear());
            tvMake.setText(car.getMake());
            tvModel.setText(car.getModel());
            tvColor.setText(car.getColor());
            tvEngine.setText(car.getEngine());
            tvTransType.setText(car.getTransmissionType());
            tvTitleStatus.setText(car.getTitleStatus());
        }

    }

}
