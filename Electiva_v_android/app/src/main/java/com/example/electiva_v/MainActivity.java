package com.example.electiva_v;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */


    public void buttonClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent1 = new Intent(this, MainActivity3.class);
                startActivity(intent1);
                break;
            case R.id.button3:
                Intent intent2 = new Intent(this, MainActivity4.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}