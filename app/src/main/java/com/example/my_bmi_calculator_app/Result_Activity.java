package com.example.my_bmi_calculator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result_Activity extends AppCompatActivity {
    TextView result;
    Button retry_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result=findViewById(R.id.result);
        retry_btn=findViewById(R.id.Retry_btn);

        float totlebmi=getIntent().getFloatExtra("BMI_VALUE",0);
        Log.d("BBBBBBBBBBBBBBBBBBB", "onCreate: bmi========"+totlebmi);

         if (totlebmi>25)
         {
         result.setText("Over Weight");
         result.setTextColor(getColor(R.color.red));
         }else  if(totlebmi>18)
         {
             result.setText("Healthy");
             result.setTextColor(getColor(R.color.green));
         }else
         {
             result.setText("Under Weight");
             result.setTextColor(getColor(R.color.yellow));
         }


         retry_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent1=new Intent(Result_Activity.this,MainActivity.class);
                 startActivity(intent1);
             }
         });
    }
}