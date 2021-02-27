package com.example.checkbuttons1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Bill extends AppCompatActivity {
    TextView t1,pay;
    Button b1,b2;
    int amt;
    String result;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill_main);
        Intent intent=getIntent();
          result=intent.getStringExtra("result");
         b1=(Button)findViewById(R.id.b1);
         b2=(Button)findViewById(R.id.b2);
          amt = intent.getIntExtra("totalAmount",0);
          //System.out.println(amt);
        t1=(TextView)findViewById(R.id.t1);
        pay=(TextView)findViewById(R.id.pay);
        t1.setText(result);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 amt =250- amt;

                t1.setText("YOUR ORDERED IS PLACED FOR THESE :"+result+"and TOTAL AMOUNT IN WALLET IS: "+amt);
                pay.setText("WALLET: "+amt);
            }
        });
       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(getApplicationContext(),MainActivity.class);
               startActivity(i);

           }
       });
    }

}
