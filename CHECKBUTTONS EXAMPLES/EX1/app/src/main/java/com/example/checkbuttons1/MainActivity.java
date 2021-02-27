package com.example.checkbuttons1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox c1, c2, c3, c4, c5;
    Button b1;
    TextView t1, pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButtonClick();

    }

    //Creaing a function for manipulating checkbox data
    public void addListenerOnButtonClick() {
        c1 = (CheckBox) findViewById(R.id.c1);
        c2 = (CheckBox) findViewById(R.id.c2);
        c3 = (CheckBox) findViewById(R.id.c3);
        c4 = (CheckBox) findViewById(R.id.c4);
        c5 = (CheckBox) findViewById(R.id.c5);
        b1 = (Button) findViewById(R.id.b1);
        t1 = (TextView) findViewById(R.id.t1);
        pay = (TextView) findViewById(R.id.pay);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int totalAmount = 0;
                StringBuilder result = new StringBuilder();
                result.append("--Selected Items--");
                if (c1.isChecked()) {
                    result.append("\nPizza");
                    totalAmount += 100;
                }
                if (c2.isChecked()) {
                    result.append("\nBurger");
                    totalAmount += 70;
                }
                if (c3.isChecked()) {
                    result.append("\nCold Drinks");
                    totalAmount += 50;
                }
                if (c4.isChecked()) {
                    result.append("\nChips");
                    totalAmount += 20;
                }
                if (c5.isChecked()) {
                    result.append("\nIceCream");
                    totalAmount += 80;
                }
                result.append("\nTotal Amount: " + totalAmount + "Rs");
                if(payment(totalAmount)) {
                    //t1.setText(result.toString());
                    Intent intent=new Intent(MainActivity.this,Bill.class);
                    intent.putExtra("result",result.toString());
                    intent.putExtra("totalAmount",totalAmount);
                    startActivity(intent);

                }
                    else
                    t1.setText("JYADA PAISE NHI HAI ('CHECK WALLET FIRST')"+"\nTOTAL AMOUNT:"+totalAmount);
            }
        });

    }
    public boolean payment ( int amt) {
        //(amt <= 500) ? return (true) : return (false);
    if (amt <= 250)
        return (true);
    else
        return (false);
    }

}