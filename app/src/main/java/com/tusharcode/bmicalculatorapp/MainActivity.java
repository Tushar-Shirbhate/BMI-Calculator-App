package com.tusharcode.bmicalculatorapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText n1, n2, n3;
    private TextView textView, textView2;
    private Button calculate;
    String range = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float w = Integer.parseInt(n1.getText().toString());
                float h = Integer.parseInt(n2.getText().toString());
                //int sum = Integer.parseInt(n1.getText().toString()) + Integer.parseInt(n2.getText().toString());
                float bmi = (w/(h*h))*10000;


               //textView.setText("BMI = " + bmi);
                //int sum = w + h;
                //textView.setText("BMI = " + sum);

                double age = Integer.parseInt(n3.getText().toString());
                if(age<2){
                   // textView2.setText("");
                }
                else if(age>=2 && age<18){
                    //textView2.setText("");
                }
                else if (age>=18 && age <=99){
                    if(bmi<18.5){
                       // textView2.setText("BMI range : Underweight ");
                         range = "Range : Underweight!";
                    }
                    else if (bmi>=18.5 && bmi <25){
//                        textView2.setText("BMI range : Normal Weight ");
                         range = "Range : Normal Weight!";
                    }
                    else if(bmi>=25 && bmi <30){
//                        textView2.setText("BMI range : Over Weight ");
                        range = "Range : Over Weight!";
                    }
                    else{
//                        textView2.setText("BMI range : Obese ");
                         range = "Range : Obese!";
                    }
                }
                else{
                    //textView2.setText("");
                }
                //double bmi1 = Math.round(bmi, 2);
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.drawable.ic_baseline_bookmarks_24)
                        .setTitle("BMI")
                        .setMessage(""+ String.format("%.2f", bmi) + "\n" + range)
                        .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNeutralButton("Help", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "BMI = " + String.format("%.2f",bmi), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Back", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.ic_baseline_bookmarks_24)
                .setTitle("EXIT")
                .setMessage("Do you want to exit")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNeutralButton("HELP", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      //  Toast.makeText(MainActivity.this, "BMI = " + String.format("%.2f",bmi), Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }
}




