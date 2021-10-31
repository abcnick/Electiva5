package com.example.electiva_v;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void area_triangulo(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        EditText editText4 = (EditText) findViewById(R.id.editText4);
        TextView textView2 = (TextView) findViewById(R.id.textView2);

        Float lado1 = Float.parseFloat(editText.getText().toString());
        Float lado2 = Float.parseFloat(editText1.getText().toString());
        Float lado3 = Float.parseFloat(editText2.getText().toString());
        Float base = Float.parseFloat(editText3.getText().toString());
        Float altura = Float.parseFloat(editText4.getText().toString());


        Float area = (base * altura) / 2 ;
        Float perimetro = lado1 + lado2 +lado3 ;

        textView2.setText(String.valueOf("El area del triangulo es " + area + " cm^2" + "\n" + "El perimetro del triangulo es " + perimetro + " cm" ));

    }
}