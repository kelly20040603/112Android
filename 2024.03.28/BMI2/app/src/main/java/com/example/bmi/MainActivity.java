package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvShow = findViewById(R.id.txvShow);
        txvShow.setTextSize(36);
        EditText edtHeight = findViewById(R.id.edtHeight);
        EditText edtWeight = findViewById(R.id.edtWeight);
        Button btnCalc = findViewById(R.id.btnCalc);
        Button btnClear = findViewById(R.id.btnClear);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if EditText fields are empty
                if (edtHeight.getText().toString().isEmpty() || edtWeight.getText().toString().isEmpty()) {
                    // Display error message
                    txvShow.setText("請輸入身高體重");
                    txvShow.setTextColor(Color.RED);
                    return; // Exit onClick method
                }

                // Check if height or weight is 0
                double height = Double.parseDouble(edtHeight.getText().toString());
                double weight = Double.parseDouble(edtWeight.getText().toString());
                if (height == 0 || weight == 0) {
                    // Display error message
                    txvShow.setText("身高和體重不能為零");
                    txvShow.setTextColor(Color.RED);
                    return; // Exit onClick method
                }

                // Perform BMI calculation
                double bmi = weight / Math.pow(height / 100.0, 2);

                // Set text color based on BMI value
                if (bmi >= 24)
                    txvShow.setTextColor(Color.RED);
                else if (bmi < 18.5)
                    txvShow.setTextColor(Color.BLUE);
                else
                    txvShow.setTextColor(Color.GREEN);

                // Display calculated BMI
                txvShow.setText(String.format("%.2f", bmi));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtHeight.setText("0");
                edtWeight.setText("0");
                txvShow.setText("");
            }
        });
    }
}
