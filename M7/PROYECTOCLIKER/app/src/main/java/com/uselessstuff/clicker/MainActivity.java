package com.uselessstuff.clicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton ibPlaneta;
    Button bAmigos,bMejoras;
    TextView tvPuntos;
    static int puntos;
    static int bonus;
    int vida,fondo=20;
    private ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.pantallaPrincipal);
        ibPlaneta = findViewById(R.id.ibPlaneta);
        bAmigos = findViewById(R.id.bAmiga);
        bMejoras = findViewById(R.id.bMejoras);
        tvPuntos= findViewById(R.id.tvPuntos);
        ibPlaneta.setOnClickListener(this);
        bMejoras.setOnClickListener(this);
        bAmigos.setOnClickListener(this);
        //puntos = 0;
        bonus=1;
        vida= 10;
        fondo = 1;
        tvPuntos.setText(Integer.toString(puntos));
    }

    @Override
    public void onClick(View v) {
        if(ibPlaneta.isPressed()){
            actualizarPuntos();
        }else if(bMejoras.isPressed()){
            Intent intent = new Intent(this,MejorasActivity.class);
            //intent.putExtra("puntos",puntos);
            startActivity(intent);
        }else if(bAmigos.isPressed()){
            Intent intent = new Intent(this,AmigosActivity.class);
            //intent.putExtra("puntos",puntos);
            startActivity(intent);
        }
    }

    @SuppressLint("SetTextI18n")
    private void actualizarPuntos() {
        puntos=puntos+bonus;
        vida--;
        if(vida <= 0){
            vida = 20;
            if(fondo == 1) {
                ibPlaneta.setImageResource(R.drawable.planet2);
                constraintLayout.setBackgroundResource(R.drawable.fondo2);
                fondo =2;
            }else if(fondo==2){
                constraintLayout.setBackgroundResource(R.drawable.fondo3);
                fondo =3;
            }else{
                ibPlaneta.setImageResource(R.drawable.planetanaranja);
                constraintLayout.setBackgroundResource(R.drawable.fondo1);
                fondo = 1;
            }
        }
        tvPuntos.setText(Integer.toString(puntos));
    }
}
