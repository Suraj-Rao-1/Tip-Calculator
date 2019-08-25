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
    EditText editTextBBill;
    EditText editTextPTip;
    EditText editTextBTax;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBBill = findViewById(R.id.bbill);
        editTextPTip = findViewById(R.id.ptip);
        editTextBTax = findViewById(R.id.btax);
        button = findViewById(R.id.button);

        editTextBBill.addTextChangedListener(loginTextWatcher);
        editTextPTip.addTextChangedListener(loginTextWatcher);
        editTextBTax.addTextChangedListener(loginTextWatcher);
    }

    TextWatcher loginTextWatcher = new TextWatcher(){

        /*
        Next three methods beforeTextChanged(), onTextChanged(), and afterTextChanged() are
        to determine when the button should be enabled
        */

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String bill = editTextBBill.getText().toString().trim();
            String tip = editTextPTip.getText().toString().trim();
            String tax = editTextBTax.getText().toString().trim();

            if(!bill.equals(".") && !tip.equals(".") && !tax.equals("."))
                button.setEnabled(!bill.isEmpty() && !tip.isEmpty() && !tax.isEmpty());
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String bill = editTextBBill.getText().toString().trim();
            String tip = editTextPTip.getText().toString().trim();
            String tax = editTextBTax.getText().toString().trim();

            if(!bill.equals(".") && !tip.equals(".") && !tax.equals("."))
                button.setEnabled(!bill.isEmpty() && !tip.isEmpty() && !tax.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {
            String bill = editTextBBill.getText().toString().trim();
            String tip = editTextPTip.getText().toString().trim();
            String tax = editTextBTax.getText().toString().trim();

            if(!bill.equals(".") && !tip.equals(".") && !tax.equals("."))
                button.setEnabled(!bill.isEmpty() && !tip.isEmpty() && !tax.isEmpty());
        }
    };

    public void calculateBill(View v){
        DecimalFormat df = new DecimalFormat("0.00");

        EditText num1EditText = (EditText) findViewById(R.id.bbill);
        EditText num2EditText = (EditText) findViewById(R.id.ptip);
        EditText num3EditText = (EditText) findViewById(R.id.btax);

        TextView num1TextView = (TextView) findViewById(R.id.textView6);
        TextView num2TextView = (TextView) findViewById(R.id.textView8);
        TextView num3TextView = (TextView) findViewById(R.id.tax);

        double bill = Double.parseDouble(num1EditText.getText().toString());
        double tipPercentage = Double.parseDouble(num2EditText.getText().toString());
        double taxPercentage = Double.parseDouble(num3EditText.getText().toString());

        double tipDecimal = tipPercentage * 0.01;
        double taxDecimal = taxPercentage * 0.01;

        double tax = bill*taxDecimal;
        double almost = bill + tax;

        double tips = almost*tipDecimal;
        double finalBill = almost + tips;

        num1TextView.setText("Tip: $" + df.format(tips));
        num2TextView.setText("Bill: $" + df.format(finalBill));
        num3TextView.setText("Tax: $" + df.format(tax));

    }

    // Wish this method could be used to determine if the code has a decimal point

    /*public boolean hasDecimal(View v){
        editTextBBill = findViewById(R.id.bbill);
        editTextPTip = findViewById(R.id.ptip);
        editTextBTax = findViewById(R.id.btax);

        String bill = editTextBBill.getText().toString();

        if(bill.equals("."))
            return true;
        return false;

    }*/
}


