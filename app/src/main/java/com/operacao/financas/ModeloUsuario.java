package com.operacao.financas;

/**
 * Essa classe vai modela os dados de usuário
 */
public class ModeloUsuario {

    //Atributos
    private int codigo;
    private String nome;
    private String fone;
    private String login;
    private String senha;

    //Construtor vazio
    public ModeloUsuario(){

    }
    // Criado um construtor
    public ModeloUsuario(int codigo,String nome, String fone, String login, String senha) {
        this.codigo=codigo;
        this.nome = nome;
        this.fone = fone;
        this.login = login;
        this.senha = senha;
    }

    // Gerados os métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
