package com.example.jcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
 EditText e1,e2;
 TextView t1,t2;
 Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.n1);
        e2=(EditText)findViewById(R.id.n2);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        t1=(TextView)findViewById(R.id.res);
        t2=(TextView)findViewById(R.id.value);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1=Integer.parseInt(e1.getText().toString());
                int n2=Integer.parseInt(e2.getText().toString());
                int sum=n1+n2;
                String str=String.valueOf(sum);
                t2.setText(str);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1=Integer.parseInt(e1.getText().toString());
                int n2=Integer.parseInt(e2.getText().toString());
                int sum=n1-n2;
                String str=String.valueOf(sum);
                t2.setText(str);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1=Integer.parseInt(e1.getText().toString());
                int n2=Integer.parseInt(e2.getText().toString());
                int sum=n1*n2;
                String str=String.valueOf(sum);
                t2.setText(str);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1=Integer.parseInt(e1.getText().toString());
                int n2=Integer.parseInt(e2.getText().toString());
                int sum=n1/n2;
                String str=String.valueOf(sum);
                t2.setText(str);
            }
        });

    }
}