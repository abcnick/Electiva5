package com.example.electiva_v;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void area_circulo(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        TextView textView2 = (TextView) findViewById(R.id.textView2);

        Float radio = Float.parseFloat(editText.getText().toString());
        double area = Math.PI * (radio * radio) ;
        double perimetro = 2* Math.PI * radio ;

        textView2.setText(String.valueOf("El area del circulo es " + area + " cm^2" + "\n" + "El perimetro del circulo es " + perimetro + " cm^" ));

    }
}