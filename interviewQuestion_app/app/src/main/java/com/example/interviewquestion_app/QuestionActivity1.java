package com.example.interviewquestion_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity1 extends AppCompatActivity {
    TextView t1;
    Button submitbuton, quitbuton;
    RadioGroup radio_group;
    RadioButton r1,r2,r3,r4;
    String questions[] = {
            "Which of these keywords are used to define an abstract class?",
            " Which of these is not abstract?",
            "  If a class inheriting an abstract class does not define all of its function then it will be known as?",
            " Which of these is not a correct statement?",
            " Which of these packages contains abstract keyword?",
            " Which of this keyword must be used to inherit a class?",
            "  A class member declared protected becomes a member of subclass of which type?",
            "  Which of these is correct way of inheriting class A by class B?",
            " What is not type of inheritance?",
            " Using which of the following, multiple inheritance in Java can be implemented?"
    };
    String answers[] = {" abstract","Thread","Abstract",
            "Abstract class can be initiated by new operator",
            " java.lang"," extends"," private member","class B extends A {}","Double inheritance","Interfaces"};
    String opt[] = {
            " abst" , " abstract" , " Abstract", "abstract class",
            " Thread" , " AbstractList", "List" , "None of the Mentioned",
            "Abstract"," A simple class", "Static class", " None of the mentioned",
            " Every class containing abstract method must be declared abstract", " Abstract class defines only the structure of the class not its implementation", " Abstract class can be initiated by new operator" , " Abstract class can be inherited",
            "java.lang", " java.util", " java.io", " java.system",
            " super", " this", " extent", " extends",
            " public member", " private member", " protected member", " static member",
            "  class B + class A {}", " class B inherits class A {}", " class B extends A {}", " class B extends class A {}",
            "Single inheritance", " Double inheritance", " Hierarchical inheritance", " Multiple inheritance",
            "Interfaces", " Multithreading" , " Protected methods" , " Private methods"
    };
    int Poast=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_question1);
        final TextView score = (TextView)findViewById(R.id.txtView4);
        TextView textView=(TextView)findViewById(R.id.DisName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);

        submitbuton=(Button)findViewById(R.id.buton3);
        quitbuton=(Button)findViewById(R.id.butonquit);
        t1=(TextView) findViewById(R.id.tvqu);

        radio_group=(RadioGroup)findViewById(R.id.answersgrp);
        r1=(RadioButton)findViewById(R.id.radioButon);
        r2=(RadioButton)findViewById(R.id.radioButon2);
        r3=(RadioButton)findViewById(R.id.radioButon3);
        r4=(RadioButton)findViewById(R.id.radioButon4);
        t1.setText(questions[Poast]);
        r1.setText(opt[0]);
        r2.setText(opt[1]);
        r3.setText(opt[2]);
        r4.setText(opt[3]);
        submitbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_group.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_group.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[Poast])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                Poast++;

                if (score != null)
                    score.setText(""+correct);

                if(Poast<questions.length)
                {
                    t1.setText(questions[Poast]);
                    r1.setText(opt[Poast*4]);
                    r2.setText(opt[Poast*4 +1]);
                    r3.setText(opt[Poast*4 +2]);
                    r4.setText(opt[Poast*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity1.class);
                    startActivity(in);
                }
                radio_group.clearCheck();
            }
        });

        quitbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity1.class);
                startActivity(intent);
            }
        });
    }

}

