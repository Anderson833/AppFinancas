package com.operacao.financas;

/**
 * Essa classe vai modela os atributos
 */
public class Modelagem {
    //Atributos
    private int codigo;
    private String descricao;
    private double valor;
    private String data;
    //Construtor vazio
    public Modelagem(){

    }
    // Construido um construtor
    public Modelagem(int codigo,String descricao, double valor, String data) {
        this.codigo=codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    //Gerados os métodos getters e setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCodigo(int codigo){
        this.codigo=codigo;
    }

    public int getCodigo(){
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
