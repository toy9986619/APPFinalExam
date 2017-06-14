package com.example.toy9986619.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_Activity extends AppCompatActivity {

    Button buttonIBW;
    Button buttonBMI;
    Button buttonMAP;
    Button buttonEXIT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    public void findViews(){
        buttonIBW = (Button) findViewById(R.id.main_ibw);
        buttonBMI = (Button) findViewById(R.id.main_bmi);
        buttonMAP = (Button) findViewById(R.id.main_map);
        buttonEXIT = (Button) findViewById(R.id.main_exit);
    }

    public void changeIBW(View v){
        Intent intent = new Intent(Main_Activity.this, IBW_Activity.class);
        startActivity(intent);
    }

    public void changeBMI(View v){
        Intent intent = new Intent(Main_Activity.this, BMI_Activity.class);
        startActivity(intent);
    }

    public void changeMAP(View v){
        Intent intent = new Intent(Main_Activity.this, MAP_Activity.class);
        startActivity(intent);
    }

    public void returnButton(View v){
        this.finish();
    }


}
