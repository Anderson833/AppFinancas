package com.operacao.financas;

import com.operacao.financas.Modelagem;

/**
 * Essa classe vai modela os dados de ganhos
 */
public class ModeloGanhos extends Modelagem {

    public ModeloGanhos(){

    }
    public ModeloGanhos(int codigo, String descricao, double valor, String data) {
        super(codigo, descricao, valor, data);
    }
}
