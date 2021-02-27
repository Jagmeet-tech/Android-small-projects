package com.example.interviewquestion_app;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            " Which of the following is not OOPS concept in Java?",
            "Which of the following is a type of polymorphism in Java?",
            " When does method overloading is determined?",
            " When Overloading does not occur?",
            " Which concept of Java is a way of converting real world objects in terms of class?",
            "Which concept of Java is achieved by combining methods and attribute into a class?",
            " What is it called if an object has its own lifecycle and there is no owner?",
            " What is it called where child object gets killed if parent object is killed?",
            " What is it called where object has its own lifecycle and child object cannot belong to another parent object?",
            "Which among the following is the language which supports classes but not polymorphism?"
    };
    String answers[] = {"Compilation","Compile time polymorphism","At compile time",
            "More than one method with same name, same number of parameters and type but different signature",
            "Abstraction"," Encapsulation","Association","Composition","Aggregation","Ada"};
    String opt[] = {
            " Inheritance" , " Encapsulation" , " Polymorphism", "Compilation",
            "Compile time polymorphism","Execution time polymorphism", "Multiple polymorphism", "Multilevel polymorphism",
            "At run time", "At compile time", "At coding time", "At execution time",
            "More than one method with same name but different method signature and different number or type of parameters", "More than one method with same name, same signature but different number of signature", "More than one method with same name, same signature, same number of parameters but different type", "More than one method with same name, same number of parameters and type but different signature",
            "Polymorphism", "Encapsulation" , "Abstraction" , "Inheritance",
            " Encapsulation", " Inheritance", " Polymorphism", "Abstraction",
            " Aggregation", "Composition", "Encapsulation", "Association",
            " Aggregation", "Composition", "Encapsulation", "Association",
            " Aggregation", "Composition", "Encapsulation", "Association",
            "SmallTalk","Java","C++","Ada"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}