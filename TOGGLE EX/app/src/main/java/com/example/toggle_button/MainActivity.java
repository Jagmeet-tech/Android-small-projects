package com.example.toggle_button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton simpleToggleButton1, simpleToggleButton2;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleToggleButton1 = (ToggleButton) findViewById(R.id.simpleToggleButton1);
        simpleToggleButton2 = (ToggleButton) findViewById(R.id.simpleToggleButton2);
        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = "ToggleButton1 : " + simpleToggleButton1.getText() +
                        "\n" + "ToggleButton2 : " + simpleToggleButton2.getText();
                Toast.makeText(getApplicationContext(), status, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
