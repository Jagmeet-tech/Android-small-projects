package com.example.checkbutton2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    CheckBox Pun, Del, Mum, Bang, Shim;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pun = findViewById(R.id.myPun);
        Mum = findViewById(R.id.mymum);
        Del = findViewById(R.id.myDel);
        Bang = findViewById(R.id.myBang);
        Shim = findViewById(R.id.myShimla);
        Button showbtn = findViewById(R.id.showBtn);
        b1=(Button) findViewById(R.id.b1);
        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Res = "Favourite cities";
                if (Pun.isChecked()) {
                    Res += "\n Pune";
                }
                if (Mum.isChecked()) {
                    Res += "\n Mumbai";
                }
                if (Del.isChecked()) {
                    Res += "\n Delhi";
                }
                if (Bang.isChecked()) {
                    Res += "\n Bangalore";
                }
                if (Shim.isChecked()) {
                    Res += "\n Shimla";
                }
                Toast.makeText(getApplicationContext(), Res, Toast.LENGTH_SHORT).show();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pun.setChecked(true);Mum.setChecked(true);Del.setChecked(true);Bang.setChecked(true);Shim.setChecked(true);
            }
        });
    }
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        String msg = "";
        switch (view.getId()) {
            case R.id.myPun:
                msg = checked ? "Pune Selected" : "Pune Deselected";
                break;
            case R.id.mymum:
                msg = checked ? "Mumbai Selected" : "Mumbai Deselected";
                break;
            case R.id.myDel:
                msg = checked ? "Delhi Selected" : "Delhi Deselected";
                break;
            case R.id.myBang:
                msg = checked ? "Bangalore Selected" : "Bangalore Deselected";
                break;
            case R.id.myShimla:
                msg = checked ? "Shimla Selected" : "Shimla Deselected";
                break;
        }
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
