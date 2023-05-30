package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import java.util.ArrayList;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import java.util.ArrayList;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import java.util.ArrayList;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import java.util.ArrayList;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SpeechRecognizer speechRecognizer;
    private EditText activeEditText;


    EditText et1, et2;
    TextView res;
    Button Sumar, Resta, Multi, Divi;
    Button Salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(new RecognitionListener() {

            public void onReadyForSpeech(Bundle params) {
                // El reconocimiento de voz está listo
            }


            public void onBeginningOfSpeech() {
                // Comienza el habla del usuario
            }


            public void onRmsChanged(float rmsdB) {
                // Cambios en el nivel de sonido
            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {

            }


            public void onResults(Bundle results) {
                // Resultados del reconocimiento de voz
                ArrayList<String> speechResults = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if (speechResults != null && !speechResults.isEmpty() && activeEditText != null) {
                    String spokenText = speechResults.get(0);
                    activeEditText.setText(spokenText);
                }
            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }


        });


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

        Multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multi();

            }
        });

        Divi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                divi();

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

    private void multi(){
        double  x,y;
        double r;
        x= Integer.parseInt(et1.getText().toString());
        y= Integer.parseInt(et2.getText().toString());
        r= x*y;
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

    private void divi(){
        double  x,y;
        double r;
        x= Integer.parseInt(et1.getText().toString());
        y= Integer.parseInt(et2.getText().toString());
        r= x/y;
        res.setText(String.valueOf(r));
    }
  private void salir(){
   finish();

  }
    private void startListening() {
        activeEditText = et1; // Establece el campo de texto activo al EditText et1
        speechRecognizer.startListening(new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH));
    }

    private void stopListening() {
        activeEditText = null; // No se requiere un campo de texto activo
        speechRecognizer.stopListening();
    }

}