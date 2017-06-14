package com.example.toy9986619.finalexam;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MAP_Activity extends AppCompatActivity {

    TextView txResult;
    TextView txRange1;
    TextView txRange2;
    EditText etSBP;
    EditText etDBP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        findViews();
    }

    public void findViews(){
        txResult = (TextView) findViewById(R.id.map_result) ;
        txRange1 = (TextView) findViewById(R.id.map_range1);
        txRange2 = (TextView) findViewById(R.id.map_range2);
        etSBP = (EditText) findViewById(R.id.map_sbp);
        etDBP = (EditText) findViewById(R.id.map_dbp);
    }

    public void Result(View v){
        int sbp = Integer.parseInt(etSBP.getText().toString());
        int dbp = Integer.parseInt(etDBP.getText().toString());
        double map = dbp + ((sbp-dbp)/3);
        txResult.setText(String.format("%.2f", map));
        if(80<=map && map<=100){
            txResult.setTextColor(Color.parseColor("#ff0000ff"));
        }else{
            txResult.setTextColor(Color.parseColor("#ffff0000"));
        }
    }


    public void Exit(View v){
        MAP_Activity.this.finish();
    }

    public void send(View v){

    }

}
