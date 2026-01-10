package com.bibo.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtweight, edtage,edtheightft,edtheightIn,edtname;
        Button button1;
        TextView result;
        LinearLayout llmaincolor;

        edtweight=findViewById(R.id.edtweight);
//        edtage=findViewById(R.id.edtage);
//        edtname=findViewById(R.id.edtname);
        edtheightft=findViewById(R.id.edtheightft);
        edtheightIn=findViewById(R.id.edtheightin);
        button1=findViewById(R.id.but1);
        llmaincolor=findViewById(R.id.llmain);
        result=findViewById(R.id.result);

        button1.setOnClickListener(view -> {
            int wt=Integer.parseInt(edtweight.getText().toString());
            int In=Integer.parseInt(edtheightIn.getText().toString());
            int ft=Integer.parseInt(edtheightft.getText().toString());
//                String name=edtname.getText().toString();
//                int age=Integer.parseInt(edtage.getText().toString());
//                double hegFt=ft*12*2.54*0.01;
//                double hegIn=In*2.54*0.01;
            int totalIn=ft*12+In;
            double total_height_meter=totalIn*2.54*0.01;
            double res= wt/(total_height_meter*total_height_meter);
            if (wt>0 && ft>0 ) {


            if (res>25){
                result.setText("You are overweight!.");
                llmaincolor.setBackgroundColor(getResources().getColor(R.color.llmain));
            }else if(res<18){
                result.setText("your are underweight!.");
                llmaincolor.setBackgroundColor(getResources().getColor(R.color.llmainlessweight));

            }else{
                result.setText("You are healthy!");
                llmaincolor.setBackgroundColor(getResources().getColor(R.color.llmainhealthy));
            }


        }else{
                if (wt<=0 && ft>0){
                    result.setText("Body Weight should not be 0. ");

                } else if (ft<=0 && wt>=0) {
                    result.setText("Height should not be 0 ");

                } else {
                    result.setText("Body Weight and Height should not be 0 ");
                    }
            }});



    }
}