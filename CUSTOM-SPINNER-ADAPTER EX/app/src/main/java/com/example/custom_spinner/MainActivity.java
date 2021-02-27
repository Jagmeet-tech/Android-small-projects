package com.example.custom_spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    String[] technology={"Ajax","Java","JS","Kotlin","Php","Python"};
    int logo[] = {R.drawable.stepajax, R.drawable.stepjava,
            R.drawable.stepjs,
            R.drawable.stepkotlin, R.drawable.stepphp,
            R.drawable.steppython};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.s1);
        spin.setOnItemSelectedListener(this);

        CustomAdapter customAdapter=new CustomAdapter
                (getApplicationContext(),
                        logo,technology);
        spin.setAdapter(customAdapter);
    }


    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0,
                               View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),
                technology[position],
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }
}

