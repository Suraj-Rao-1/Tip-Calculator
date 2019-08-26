package com.example.surajtipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void calculateBill(View v){
        DecimalFormat df = new DecimalFormat("0.00");

        double bill, tipPercentage, taxPercentage;

        EditText num1EditText = findViewById(R.id.bbill);
        EditText num2EditText = findViewById(R.id.ptip);
        EditText num3EditText = findViewById(R.id.btax);

        TextView num1TextView = findViewById(R.id.textView6);
        TextView num2TextView = findViewById(R.id.textView8);
        TextView num3TextView = findViewById(R.id.tax);
        TextView numTextView = findViewById((R.id.textView7));

        try {
             bill = Double.parseDouble(num1EditText.getText().toString());
             tipPercentage = Double.parseDouble(num2EditText.getText().toString());
             taxPercentage = Double.parseDouble(num3EditText.getText().toString());

            double tipDecimal = tipPercentage * 0.01;
            double taxDecimal = taxPercentage * 0.01;

            double tax = bill*taxDecimal;
            double almost = bill + tax;

            double tips = almost*tipDecimal;
            double finalBill = almost + tips;

            num1TextView.setText("Tip: $" + df.format(tips));
            num2TextView.setText("Bill: $" + df.format(finalBill));
            num3TextView.setText("Tax: $" + df.format(tax));

            numTextView.setText("");


        }catch(Exception e){
            numTextView.setText("Please Enter Valid Inputs!");
            num1TextView.setText("Tip: N/A");
            num2TextView.setText("Bill: N/A");
            num3TextView.setText("Tax: N/A");
        }

    }
}


