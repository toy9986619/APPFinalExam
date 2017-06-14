package com.example.toy9986619.finalexam;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BMI_Activity extends AppCompatActivity {

    TextView txResult;
    TextView txRange;
    TextView txRangeText;
    EditText etHeight;
    EditText etWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        findViews();
    }

    public void findViews(){
        txResult = (TextView) findViewById(R.id.bmi_result);
        txRange = (TextView) findViewById(R.id.bmi_range);
        etHeight = (EditText) findViewById(R.id.bmi_height);
        etWeight = (EditText) findViewById(R.id.bmi_weight);
        txRangeText = (TextView) findViewById(R.id.bmi_rangetext);
    }

    public void Result(View v){
        double weight = Double.parseDouble(etWeight.getText().toString());
        double height = Double.parseDouble(etHeight.getText().toString());
        double bmi = weight/height/height;

        txResult.setText(String.format("%a", bmi));
        if(bmi < 16){
            txResult.setTextColor(Color.parseColor("#ffff00ff"));
            txRangeText.setText("Your BMI is in severely underweight range");
            txRange.setText("BMI < 16");
        }else if(16<=bmi && bmi< 18.5){
            txResult.setTextColor(Color.parseColor("#ff0000ff"));
            txRangeText.setText("Your BMI is in underweight range");
            txRange.setText("16 ≤ BMI < 18.5");
        }else if(18.5<=bmi && bmi< 25) {
            txResult.setTextColor(Color.parseColor("#ff00ff00"));
            txRangeText.setText("Your BMI is in normal range");
            txRange.setText("18.5 ≤ BMI < 25");
        }else if(25<=bmi && bmi< 30){
            txResult.setTextColor(Color.parseColor("#ffffa500"));
            txRangeText.setText("Your BMI is in overweight range");
            txRange.setText("25 ≤ BMI < 30");
        }else if(30<=bmi && bmi< 35){
            txResult.setTextColor(Color.parseColor("#ffff0000"));
            txRangeText.setText("Your BMI is in moderately obese range");
            txRange.setText("30 ≤ BMI < 35");
        }else if(bmi<= 35){
            txResult.setTextColor(Color.parseColor("#ffC00000"));
            txRangeText.setText("Your BMI is in se verely obese range");
            txRange.setText("35 ≤ BMI");
        }

    }

    public void Exit(View v){
        BMI_Activity.this.finish();
    }
}
