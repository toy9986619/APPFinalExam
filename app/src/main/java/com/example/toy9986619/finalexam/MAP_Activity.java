package com.example.toy9986619.finalexam;

import android.content.Intent;
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
    String type;
    double map=0;

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
        map = dbp + ((sbp-dbp)/3);
        txResult.setText(String.format("%.2f", map));
        if(80<=map && map<=100){
            txResult.setTextColor(Color.parseColor("#ff0000ff"));
            type="normal";
        }else{
            txResult.setTextColor(Color.parseColor("#ffff0000"));
            type="out";
        }
    }


    public void Exit(View v){
        MAP_Activity.this.finish();
    }

    public void send(View v){
        if(type == "out"){
            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{"john.smith@abc.com.tw"});
            email.putExtra(Intent.EXTRA_SUBJECT, "Reminding Letter");
            email.putExtra(Intent.EXTRA_TEXT, "It is a goodwill letter to remind you that your Mean Arterial\n" +
                    "Pressure ("+ map +" mmHg) is out of normal range (80mmHg < MAP <100mmHg)");
            email.setType("message/rfc822");
            startActivity(Intent.createChooser(email, "Choose an Email client :"));
        }
    }

}
