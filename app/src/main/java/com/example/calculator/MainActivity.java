package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean isfirstInput = true; //입력 값이 처음 입력되는가를 체크
    int resultNumber = 0; // 계산된 결과 값을 저장하는 변수
    char operator = '+'; // 입력된 연산자를 저장하는 변수
    boolean repeatoperator= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView result = findViewById(R.id.result);
        EditText input=findViewById(R.id.input);
        Button zero = (Button) findViewById(R.id.zero);
        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);
        Button seven = (Button) findViewById(R.id.seven);
        Button eight = (Button) findViewById(R.id.eight);
        Button nine = (Button) findViewById(R.id.nine);
        Button clearBTN = (Button) findViewById(R.id.clearBTN);
        Button subtractBTN = (Button) findViewById(R.id.subtractBTN);
        Button divideBTN = (Button) findViewById(R.id.divideBTN);
        Button multiplyBTN = (Button) findViewById(R.id.multiplyBTN);
        Button addBTN = (Button) findViewById(R.id.addBTN);
        Button plusMinusBTN = (Button) findViewById(R.id.plusMinusBTN);
        Button pointBTN = (Button) findViewById(R.id.pointBTN);
        Button equalsBTN = (Button) findViewById(R.id.equalsBTN);
        ImageButton backspaceBTN = (ImageButton) findViewById(R.id.backspaceBTN);

        clearBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isfirstInput = true;
                resultNumber = 0;
                operator = '+';
                input.setText(String.valueOf(resultNumber));
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isfirstInput) {
                    input.setText("0");
                    isfirstInput=false;
                }else{
                    input.append("0");
                }
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isfirstInput) {
                    input.setText("1");
                    isfirstInput=false;
                }else{
                    input.append("1");
                }
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isfirstInput) {
                    input.setText("2");
                    isfirstInput=false;
                }else{
                    input.append("2");
                }
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isfirstInput) {
                    input.setText("3");
                    isfirstInput=false;
                }else{
                    input.append("3");
                }
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isfirstInput) {
                    input.setText("4");
                    isfirstInput=false;
                }else{
                    input.append("4");
                }
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isfirstInput) {
                    input.setText("5");
                    isfirstInput=false;
                }else{
                    input.append("5");
                }
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isfirstInput) {
                    input.setText("6");
                    isfirstInput=false;
                }else{
                    input.append("6");
                }
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isfirstInput) {
                    input.setText("7");
                    isfirstInput=false;
                }else{
                    input.append("7");
                }
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isfirstInput) {
                    input.setText("8");
                    isfirstInput=false;
                }else{
                    input.append("8");
                }
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isfirstInput) {
                    input.setText("9");
                    isfirstInput=false;
                }else{
                    input.append("9");
                }
            }
        });

        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(isfirstInput==false && repeatoperator==true){
                  input.append("+");
                  repeatoperator = false;
              }else{}
                    }
                });

        subtractBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isfirstInput==false && repeatoperator==true){
                    input.append("-");
                    repeatoperator = false;
                }else{}
            }
        });

        divideBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isfirstInput==false && repeatoperator==true){
                    input.append("÷");
                    repeatoperator = false;
                }else{}
            }
        });

        multiplyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isfirstInput==false && repeatoperator==true){
                    input.append("×");
                    repeatoperator = false;
                }else{}
            }
        });

        backspaceBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().length() >1){
                    String getInput = input.getText().toString();
                    String subInput = getInput.substring(0,getInput.length()-1);
                    input.setText(subInput);
                } else {
                    input.setText("");
                }
            }
        });

        equalsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


}

