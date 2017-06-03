package com.wordpress.sjatyourservice.programminglanguage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Question4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        TextView tv4 =(TextView) findViewById(R.id.tv4);

        tv4.setText("  public class RandomNoGenerator {\n" +
                "\n" +
                "public static void main(String[] args) {\n\n"
                +
                "//way to generate any random no between 0 and 1\n\n"
                +
                "double no = Math.random();\n"
                +
                "System.out.println(“random no in double format ” + no);\n\n"
                +
                "// Way to generate any random no\n\n"
                +
                "Random no2 = new Random();\n\n"
                +
                "int n = no2.nextInt();\n\n"
                +
                "System.out.println(“2nd random no is ” + n);\n\n"
                +
                "//correct way to generate random no between two no here 5 and 10 are two no\n"
                +
                "int rn = 5 + (int) (Math.random() * (10 – 5) + 1);\n\n"
                +
                "System.out.println(“random no between 5 and 10 is ” + rn);\n\n" +
                "" +
                "}\n\n" +
                "}");
    }
}
