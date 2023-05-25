package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    TextView res;
    Button Sumar, Resta, Multi, Divi;
    Button Salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        res = (TextView) findViewById(R.id.res);
        Sumar = (Button) findViewById(R.id.Sumar);
        Resta = (Button) findViewById(R.id.Restar);
        Multi = (Button) findViewById(R.id.Multi);
        Divi = (Button) findViewById(R.id.Divi);
        Salir = (Button) findViewById(R.id.Salir);

        Sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumar();

            }
        });

        Resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restar();

            }
        });
        Salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir();

            }
        });
    }
 private void sumar(){
        double  x,y;
        double r;
        x= Integer.parseInt(et1.getText().toString());
        y= Integer.parseInt(et2.getText().toString());
        r= x+y;
        res.setText(String.valueOf(r));
 }

    private void restar(){
        double  x,y;
        double r;
        x= Integer.parseInt(et1.getText().toString());
        y= Integer.parseInt(et2.getText().toString());
        r= x-y;
        res.setText(String.valueOf(r));
    }
  private void salir(){
   finish();

  }
}