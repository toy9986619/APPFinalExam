package com.example.toy9986619.finalexam;

import android.content.Intent;
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
    double weight;
    double height;
    double bmi;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        findViews();
    }

    public void findViews(){
        txResult = (TextView) findViewById(R.id.bmi_result);
        txRange = (TextView) findViewById(R.id.map_range1);
        etHeight = (EditText) findViewById(R.id.bmi_height);
        etWeight = (EditText) findViewById(R.id.bmi_weight);
        txRangeText = (TextView) findViewById(R.id.map_rangetext);
    }

    public void Result(View v){
        weight = Double.parseDouble(etWeight.getText().toString());
        height = Double.parseDouble(etHeight.getText().toString());
        bmi = weight/height/height;

        txResult.setText(String.format("%.2f", bmi));
        if(bmi < 16){
            txResult.setTextColor(Color.parseColor("#ffff00ff"));
            txRangeText.setText("Your BMI is in severely underweight range");
            txRange.setText("BMI < 16");
            type="severely underweight";
        }else if(16<=bmi && bmi< 18.5){
            txResult.setTextColor(Color.parseColor("#ff0000ff"));
            txRangeText.setText("Your BMI is in underweight range");
            txRange.setText("16 ≤ BMI < 18.5");
            type="underweight";
        }else if(18.5<=bmi && bmi< 25) {
            txResult.setTextColor(Color.parseColor("#ff00ff00"));
            txRangeText.setText("Your BMI is in normal range");
            txRange.setText("18.5 ≤ BMI < 25");
            type="normal";
        }else if(25<=bmi && bmi< 30){
            txResult.setTextColor(Color.parseColor("#ffffa500"));
            txRangeText.setText("Your BMI is in overweight range");
            txRange.setText("25 ≤ BMI < 30");
            type="overweight";
        }else if(30<=bmi && bmi< 35){
            txResult.setTextColor(Color.parseColor("#ffff0000"));
            txRangeText.setText("Your BMI is in moderately obese range");
            txRange.setText("30 ≤ BMI < 35");
            type="moderately obese";
        }else if(bmi>= 35){
            txResult.setTextColor(Color.parseColor("#ffC00000"));
            txRangeText.setText("Your BMI is in severely obese range");
            txRange.setText("BMI ≤ 35");
            type="severely obese";
        }

    }

    public void Exit(View v){
        BMI_Activity.this.finish();
    }

    public void send(View v){
        if(type!="normal"){
            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{"john.smith@abc.com.tw"});
            email.putExtra(Intent.EXTRA_SUBJECT, "Reminding Letter");
            email.putExtra(Intent.EXTRA_TEXT, "It is a goodwill letter to remind you that your body mass index ("+weight+" Kg) "+
                    "belongs to "+ type +" range as stated in below table"+
                    "\n\n"+
                    "BMI < 16 \t severely underweight (嚴重過輕)\n" +
                    "16 ≤ BMI < 18.5 \t underweight (過輕)\n" +
                    "18.5 ≤ BMI < 25 \t normal (正常)\n" +
                    "25 ≤ BMI < 30 \t overweight (過重)\n" +
                    "30 ≤ BMI < 35 \t moderately obese (肥胖)\n" +
                    "35 ≤ BMI \t severely obese (嚴重肥胖)\n");
            email.setType("message/rfc822");
            startActivity(Intent.createChooser(email, "Choose an Email client :"));
        }



    }
}
