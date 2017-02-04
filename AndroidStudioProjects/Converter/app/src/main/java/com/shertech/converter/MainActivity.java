package com.shertech.converter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btConvert,btCH;
    EditText etLT;
    TextView tvResult,aTV;
    RadioButton rb;
    RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btConvert = (Button) findViewById(R.id.btConvert);
        btCH = (Button) findViewById(R.id.btCH);
        etLT = (EditText) findViewById(R.id.etLT);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvResult.setMovementMethod(new ScrollingMovementMethod());
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        aTV = (TextView) findViewById(R.id.aTV);
        aTV.setMovementMethod(new ScrollingMovementMethod());
    }

    private double tempCal(int rb)
    {
        double flag;
        Context c;
        CharSequence t;
        String F;
        if(rb == R.id.rbC2F)
        {
            if(etLT.getText().toString().matches("")){
                c = getApplicationContext();
                t = "Please enter some value to Convert";
                Toast.makeText(c,t, Toast.LENGTH_SHORT).show();
                return 999999;
            }else {
                flag = ((Double.parseDouble(etLT.getText().toString())) * 9.0 / 5.0) + 32.0;
                F = String.format("%.1f", flag);
                aTV.setText("C to F: " + Double.parseDouble(etLT.getText().toString()) + " -> " + F + "\n" + aTV.getText());
                return flag;
            }
        }else if (rb == R.id.rbF2C){
            if(etLT.getText().toString().matches("")){
                c = getApplicationContext();
                t = "Please Enter some value to Convert";
                Toast.makeText(c,t, Toast.LENGTH_SHORT).show();
                return 999999;
            }else {
                flag = ((Double.parseDouble(etLT.getText().toString())) - 32.0) * 5.0 / 9.0;
                F = String.format("%.1f", flag);
                aTV.setText("F to C: " + Double.parseDouble(etLT.getText().toString()) + " -> " + F + "\n" + aTV.getText());
                return flag;
            }
        }else{
            return 999999;
        }
    }

    public void onConvert(View view) {

        int rbID= rg.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(rbID);
        double flag;
        String F;

        flag=tempCal(rbID);
        if(flag != 999999){
            F=String.format("%.1f",flag);
            tvResult.setText(F);
        }
    }

    public void onClear(View view){
        aTV.setText("");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("aTV",aTV.getText().toString());
        outState.putString("tvResult",tvResult.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        aTV.setText(savedInstanceState.getString("aTV"));
        tvResult.setText(savedInstanceState.getString("tvResult"));
    }
}
