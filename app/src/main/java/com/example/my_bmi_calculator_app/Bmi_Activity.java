package com.example.my_bmi_calculator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Bmi_Activity extends AppCompatActivity {
    LinearLayout male,female;
    EditText txt_ft,txt_in,txt_weight,txt_Age;
  Button bme_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        bme_btn=findViewById(R.id.bme_btn);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        txt_ft=findViewById(R.id.ft);
        txt_in=findViewById(R.id.txt_in);
        txt_weight=findViewById(R.id.txt_weight);
        txt_Age=findViewById(R.id.txt_Age);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                male.setBackgroundResource(R.drawable.box2);
                female.setBackground(null);
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setBackgroundResource(R.drawable.box2);
                male.setBackground(null);
            }
        });




        bme_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                float weight=Float.parseFloat(txt_weight.getText().toString());
                float ft=Float.parseFloat(txt_ft.getText().toString());
                float heightIn=Float.parseFloat(txt_in.getText().toString());
                int age=Integer.parseInt(txt_Age.getText().toString());


                float height=(float)(ft*0.3048+heightIn*0.0254);
                float bmi=weight/(height*height);
                Log.d("AAAAAAA********", "onClick: bmi========"+bmi);





                Intent intent=new Intent(Bmi_Activity.this, Result_Activity.class);
                intent.putExtra("BMI_VALUE",bmi);
                startActivity(intent);



            }
        });
    }
}