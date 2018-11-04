package com.example.andersmaehlumhalvorsen.fotosort;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class Main2Activity extends AppCompatActivity {


        @Override
        protected void onCreate (Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//------------------------------------------INISILATION OF BUTTONS AND SHIT-----------------------------------------------


        final Matrix m = new Matrix(MainActivity.num1, MainActivity.num2);
        Button addBtn = findViewById(R.id.addBtn);
        Button determinantBtn = findViewById(R.id.determinantBtn);
        Button inverseBtn = findViewById(R.id.inverseBtn);
        Button viewMatrixBtn = findViewById(R.id.viewMatrixBtn);
        Button transposeBtn = findViewById(R.id.transposeBtn);


//-------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------OPPDATERING AV TELLER----------------------------------------------------------

        Thread t = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(10);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                TextView ruteTextView = findViewById(R.id.ruteTextView);

                                if (m.i + 1 <= m.column) {
                                    ruteTextView.setText((m.i + 1) + " X " + (m.j + 1));
                                }

                                if (m.i + 1 > m.column) {
                                    ruteTextView.setText("Done!");
                                }

                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        t.start();

//------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------Adds new double to Matrix---------------------------------------------------

        addBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try {

                    EditText insertNumberTextEdit = findViewById(R.id.insertNumberTextEdit);
                    m.add(Double.parseDouble(insertNumberTextEdit.getText().toString()));
                    insertNumberTextEdit.setText(null);


                } catch (Exception e) {

                }

            }
        });

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Calculate the determinant-----------------------------------------------------
        try {

            determinantBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Matrix mu = m;

                    TextView answerTextView = findViewById(R.id.answerTextView);
                    answerTextView.setText(null);
                    answerTextView.setText(mu.determinant(mu.data) + "");


                }
            });
        } catch (Exception e) {

        }
//------------------------------------------------------------------------------------------------------------------------
//------------------------------------------View Matrix-------------------------------------------------------------------

        try {
            viewMatrixBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    TextView answerTextView = findViewById(R.id.answerTextView);
                    answerTextView.setMovementMethod(new ScrollingMovementMethod());
                    answerTextView.setSelected(true);
                    answerTextView.setText(null);

                    Matrix mp = m;

                    for (int p = 0; p < m.column; p++) {
                        for (int l = 0; l < m.row; l++) {
                            answerTextView.append("| " + mp.data[p][l] + (" |\t\t"));

                        }
                        answerTextView.append("\n");
                        answerTextView.append("\n");
                        answerTextView.append("\n");
                        answerTextView.append("\n");
                    }
                }
            });

        } catch (Exception e) {

        }
//------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------Inverse of Matrix-----------------------------------------------------------

        try {


            inverseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    TextView answerTextView = findViewById(R.id.answerTextView);
                    answerTextView.setMovementMethod(new ScrollingMovementMethod());
                    answerTextView.setSelected(true);
                    answerTextView.setText(null);
                    DecimalFormat f = new DecimalFormat("##.00");

                    Matrix mn = m;
                    Matrix mm = m;

                    double[][] temp3 = mn.inverse(mn.data);


                    for (int p = 0; p < m.column; p++) {

                        for (int l = 0; l < m.row; l++) {

                            answerTextView.append("| " + f.format(temp3[p][l]) + " | \t\t");

                        }

                        answerTextView.append("\n");
                        answerTextView.append("\n");
                        answerTextView.append("\n");
                        answerTextView.append("\n");


                    }
                }

            });

        } catch (Exception e) {


        }


//------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------Transpose the Matrix------------------------------------------------------

        try {
            transposeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    TextView answerTextView = findViewById(R.id.answerTextView);
                    answerTextView.setMovementMethod(new ScrollingMovementMethod());
                    answerTextView.setSelected(true);
                    answerTextView.setText(null);


                    Matrix my = m;
                    double[][] temp2 = m.transposeMatrix(my.data);


                    for (int p = 0; p < m.column; p++) {
                        for (int l = 0; l < m.row; l++) {
                            answerTextView.append("| " + temp2[p][l] + (" |\t\t"));

                        }
                        answerTextView.append("\n");
                        answerTextView.append("\n");
                        answerTextView.append("\n");
                        answerTextView.append("\n");


                    }
                }
            });

        } catch (Exception e) {

        }


//------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------


    }


    }

