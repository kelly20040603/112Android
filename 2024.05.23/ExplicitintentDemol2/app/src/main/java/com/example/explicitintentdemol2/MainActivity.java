package com.example.explicitintentdemol2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.lblOutput);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtOpd1, txtOpd2;
                txtOpd1 = (EditText) findViewById(R.id.txtOpd1);
                txtOpd2 = (EditText) findViewById(R.id.txtOpd2);
                Intent intent = new Intent(MainActivity.this, OpActivity.class);
                Bundle bundle = new Bundle();
                Bundle.putString("OPERAND01", txtOpd1.getText().toString());
                Bundle.putString("OPERAND02", txtOpd2.getText().toString());

            }
        });
    }
}