package com.example.interviewquestion_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ResultActivity1 extends AppCompatActivity {
    TextView t1, t2, t3;
    Button btnR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);

        t1 = (TextView)findViewById(R.id.tres);
        t2 = (TextView)findViewById(R.id.tres2);
        t3 = (TextView)findViewById(R.id.tres3);
        btnR = (Button) findViewById(R.id.btRestart);
        //btnN=(Button)findViewById(R.id.btnNext);

        StringBuffer s = new StringBuffer();
        s.append("Correct answers: " + QuestionActivity1.correct + "\n");
        StringBuffer s2 = new StringBuffer();
        s2.append("Wrong Answers: " + QuestionActivity1.wrong + "\n");
        StringBuffer s3 = new StringBuffer();
        s3.append("Final Score: " + QuestionActivity1.correct + "\n");
        t1.setText(s);
        t2.setText(s2);
        t3.setText(s3);

        QuestionActivity1.correct=0;
        QuestionActivity1.wrong=0;

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(in);


            }
        });
    }

}
