package com.example.practicaadivnum;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvwInstruccion;
    TextView tvwIntentos;
    Button btnPrueba;
    EditText edtxtIntroNumero;
    RelativeLayout relativeLayout;
    private int NUMINTENTOS= 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvwInstruccion = findViewById(R.id.tvwInstruccion);
        tvwIntentos = findViewById(R.id.tvwIntentos);
        btnPrueba = findViewById(R.id.btnPrueba);
        relativeLayout = findViewById(R.id.rltLyt);
        edtxtIntroNumero = findViewById(R.id.edtxtIntroNumero);

        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (edtxtIntroNumero.getText().toString().isEmpty()){
                    tvwInstruccion.setText(R.string.introduceNumero);
                }else{
                    int tope= 100;
                    Random rd = new Random();
                    int numAlea = rd.nextInt(tope);
                    NUMINTENTOS--;

                    if (numAlea > Integer.parseInt(edtxtIntroNumero.getText().toString())) {
                        tvwInstruccion.setText(R.string.mayor);
                        tvwIntentos.setText(String.format(getString(R.string.tvwIntentosModificado), NUMINTENTOS));
                    } else if (numAlea < Integer.parseInt(edtxtIntroNumero.getText().toString())) {
                        tvwInstruccion.setText(R.string.menor);
                        tvwIntentos.setText(String.format(getString(R.string.tvwIntentosModificado), NUMINTENTOS));
                    } else {
                        if (numAlea == Integer.parseInt(edtxtIntroNumero.getText().toString())) {
                            tvwInstruccion.setText(R.string.enhorabuena);
                            relativeLayout.setBackgroundColor(getResources().getColor(R.color.verde));
                            btnPrueba.setText(R.string.btnJuegoTerminado);

                        }
                    }

                    if (numAlea != Integer.parseInt(edtxtIntroNumero.getText().toString()) && NUMINTENTOS == 0) {
                        tvwInstruccion.setText(String.format(getString(R.string.perdiste), numAlea));
                        relativeLayout.setBackgroundColor(getResources().getColor(R.color.rojo));
                        btnPrueba.setText(R.string.btnJuegoTerminado);
                        btnPrueba.setEnabled(false);
                    }



                }


            }

        };

        btnPrueba.setOnClickListener(listener);


    }

}