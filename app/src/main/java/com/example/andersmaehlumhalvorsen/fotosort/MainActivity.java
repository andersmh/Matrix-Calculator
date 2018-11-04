package com.example.andersmaehlumhalvorsen.fotosort;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static int num1;
    public static int num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button selectBtn = findViewById(R.id.selectBtn);


        selectBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                EditText firstNumEditText = findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = findViewById(R.id.secondNumEditText);

                try {
                    num1 = Integer.parseInt(firstNumEditText.getText().toString());
                    num2 = Integer.parseInt(secondNumEditText.getText().toString());


                    if (num1 > 1 && num2 > 1 && num1 < 21 && num2 < 21) {
                        Intent startIntent = new Intent(getApplicationContext(), Main2Activity.class);
                        startActivity(startIntent);
                    }


                } catch (Exception e) {

                }

            }
        });

      }

    }