package com.example.toy9986619.finalexam;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class IBW_Activity extends AppCompatActivity {

    RadioGroup RG;
    TextView txKG;
    TextView txRange1;
    TextView txRange2;
    EditText etHeight;
    EditText etWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibw);
        findViews();
    }

    public void findViews(){
        RG = (RadioGroup) findViewById(R.id.sex);
        txKG = (TextView) findViewById(R.id.ibw_kg);
        txRange1 = (TextView) findViewById(R.id.map_range1);
        txRange2 = (TextView) findViewById(R.id.ibw_range2);
        etHeight = (EditText) findViewById(R.id.ibw_height);
        etWeight = (EditText) findViewById(R.id.ibw_weight);
    }

    public void Result(View v){
        double IBW=0;
        double weight = Double.parseDouble(etWeight.getText().toString());
        double height = Double.parseDouble(etHeight.getText().toString());
        txKG.setText(String.format("%a", weight));

        switch (RG.getCheckedRadioButtonId()){
            case R.id.ibw_male:
                IBW = (height-170)*0.6+62;
                txRange1.setText(String.format("%a", IBW*0.9));
                txRange2.setText(String.format("%a", IBW*1.1));
                break;
            case R.id.ibw_female:
                IBW = (height-158)*0.5+52;
                txRange1.setText(String.format("%a", IBW*0.9));
                txRange2.setText(String.format("%a", IBW*1.1));
                break;
        }

        if(weight<IBW*0.9 || weight > IBW*1.1){
            txKG.setTextColor(Color.parseColor("#ffff0000"));
        }else{
            txKG.setTextColor(Color.parseColor("#ff0000ff"));
        }

    }

    public void Exit(View v){
        IBW_Activity.this.finish();
    }

    public void send(View v){

    }
}
