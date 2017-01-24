package com.shertech.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btConvert;
    EditText etLT;
    TextView tvResult,aTV;
    RadioButton rb;
    RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btConvert = (Button) findViewById(R.id.btConvert);
        etLT = (EditText) findViewById(R.id.etLT);
        tvResult = (TextView) findViewById(R.id.tvResult);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        aTV = (TextView) findViewById(R.id.aTV);

    }

    private double tempCal(int rb)
    {
        double flag;
        String F;
        if(rb == R.id.rbC2F)
        {
            flag = ((Double.parseDouble(etLT.getText().toString())) * 9.0/5.0) + 32.0;
            DecimalFormat df = new DecimalFormat("#.#");
            F=df.format(flag);
            aTV.append("C to F: "+ Double.parseDouble(etLT.getText().toString())+"->"+F+"\n");
            aTV.setText(aTV.getText());
            return flag;
        }else if (rb == R.id.rbF2C){
            flag = ((Double.parseDouble(etLT.getText().toString())) - 32.0)* 5.0/9.0;
            DecimalFormat df = new DecimalFormat("#.#");
            F=df.format(flag);
            aTV.append("F to C: "+ Double.parseDouble(etLT.getText().toString())+"->"+F+"\n");
            aTV.setText(aTV.getText());
            return flag;
        }else{
            return 0.0;
        }
    }

    public void onConvert(View view) {

        int rbID= rg.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(rbID);
        double flag;

        flag=tempCal(rbID);
        //flag=Math.round(100 * flag) / 100d;
        DecimalFormat df = new DecimalFormat("#.#");
        String F=df.format(flag);
        tvResult.setText(F);
    }
}
