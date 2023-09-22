package com.operacao.financas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Gastos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastos);
    }

     public  void  setDados(){
        ModeloGastos g = new ModeloGastos(1,"fuba",120,"20/09/2023");

     }
}