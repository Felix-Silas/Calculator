package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {

    String process;
    boolean checkBracket = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mathTextView = findViewById(R.id.mathTextView);
        TextView resultTextView = findViewById(R.id.resultTextView);
        Button zero = findViewById(R.id.zero);
        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);
        Button clearBTN = findViewById(R.id.clearBTN);
        ImageButton backspaceBTN = findViewById(R.id.backspaceBTN);
        Button pointBTN = findViewById(R.id.pointBTN);
        Button addBTN = findViewById(R.id.addBTN);
        Button subtractBTN = findViewById(R.id.subtractBTN);
        Button divideBTN = findViewById(R.id.divideBTN);
        Button multiplyBTN = findViewById(R.id.multiplyBTN);
        Button equalsBTN = findViewById(R.id.equalsBTN);
        Button bracketBTN = findViewById(R.id.bracketBTN);
        Button remainderBTN = findViewById(R.id.remainderBTN);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                mathTextView.setText(process + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                mathTextView.setText(process + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                mathTextView.setText(process + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                mathTextView.setText(process + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                mathTextView.setText(process + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                mathTextView.setText(process + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                mathTextView.setText(process + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                mathTextView.setText(process + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                mathTextView.setText(process + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                mathTextView.setText(process + "9");
            }
        });

        clearBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathTextView.setText("");
                resultTextView.setText("");
            }
        });

        backspaceBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String backspace = null;
                if (mathTextView.getText().toString().length() > 0) {
                    StringBuilder stringBuilder = new StringBuilder(mathTextView.getText());
                    stringBuilder.deleteCharAt(mathTextView.getText().length() - 1);
                    backspace = stringBuilder.toString();
                    mathTextView.setText(backspace);
                }
            }
        });

        pointBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                mathTextView.setText(process + ".");

            }
        });

        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                mathTextView.setText(process + "+");
            }
        });

        subtractBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                mathTextView.setText(process + "-");
            }
        });

        divideBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                mathTextView.setText(process + "÷");
            }
        });

        multiplyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                mathTextView.setText(process + "×");
            }
        });

        remainderBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                mathTextView.setText(process + "%");
            }
        });

        bracketBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBracket){
                    process = mathTextView.getText().toString();
                    mathTextView.setText(process+"(");
                    checkBracket = false;
                } else {
                    process = mathTextView.getText().toString();
                    mathTextView.setText(process+")");
                    checkBracket = true;
                }
            }
        });


        equalsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mathTextView.getText().toString();
                process = process.replaceAll("×", "*");
                process = process.replaceAll("÷", "/");
                process = process.replaceAll("%", "/100");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";

                if (mathTextView.getText().toString().length() == 0) {
                    resultTextView.setText(null);

                } else {
                    try {
                        Scriptable scriptable = rhino.initStandardObjects();
                        finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();
                    } catch (Exception e) {
                        finalResult = "0";
                    }
                    resultTextView.setText(finalResult);


                }
            }
        });


    }
}





