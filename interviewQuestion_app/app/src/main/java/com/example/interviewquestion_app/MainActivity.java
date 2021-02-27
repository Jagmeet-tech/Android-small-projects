package com.example.interviewquestion_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar simpleProgressBar;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initiate progress bar and start button
        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);
        final int[] i={0};
        simpleProgressBar.setProgress(progress);
        // set the progress
        // thread is used to change the progress value

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    for (i[0] = 0; i[0] < 100; i[0] += 10) {
                        simpleProgressBar.setProgress(progress + i[0]);
                        Thread.sleep(500);
                    }
                    if (i[0] >= 100) {
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start(); }
}

