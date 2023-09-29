package com.operacao.financas;

import com.operacao.financas.Modelagem;

/**
 * Essa classe vai modela os gastos
 */
public class ModeloGastos extends Modelagem {

    public ModeloGastos(){

    }
    public ModeloGastos(int codigo, String descricao, double valor, String data,int chave) {
        super(codigo, descricao, valor, data,chave);
    }
}
