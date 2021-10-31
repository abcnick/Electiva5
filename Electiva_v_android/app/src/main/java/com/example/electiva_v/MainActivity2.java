package com.example.electiva_v;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void area_cuadrado(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        TextView textView2 = (TextView) findViewById(R.id.textView2);

        Float lado = Float.parseFloat(editText.getText().toString());
        Float area = lado *lado ;
        Float perimetro = 4 * lado ;

        textView2.setText(String.valueOf("El area del cuadrado es " + area + " cm^2" + "\n" + "El perimetro del cuadrado es " + perimetro + " cm" ));

    }
}