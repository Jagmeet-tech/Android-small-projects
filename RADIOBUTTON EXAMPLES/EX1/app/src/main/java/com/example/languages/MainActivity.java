package com.example.languages;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton r1,r2,r3,r4,r5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        r3=(RadioButton)findViewById(R.id.r3);
        r4=(RadioButton)findViewById(R.id.r4);
        r5=(RadioButton)findViewById(R.id.r5);
    }
    public void onRadioButtonClicked(View v)
    {
        boolean checked=((RadioButton)v).isChecked();
        String msg="";
        switch(v.getId())
        {
            case R.id.r1:
                if(checked)
                    msg="ENGLISH Clicked";
                break;
            case R.id.r2:
                if(checked)
                    msg="HINDI Clicked";
                break;
            case R.id.r3:
                if(checked)
                    msg="PUNJABI Clicked";
                break;
            case R.id.r4:
                if(checked)
                    msg="TELUGU Clicked";
                break;
            case R.id.r5:
                if(checked)
                    msg="HARYANVI Clicked";
                break;
        }
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
