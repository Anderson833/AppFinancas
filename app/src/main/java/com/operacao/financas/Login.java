package com.operacao.financas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private  DaoDados dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dados = new DaoDados(this);
       // addUsuario();
         setaUsuario();
    }

    public void setaUsuario(){
      boolean log=  dados.setDadosUsuario("AndersonDev","1234");
     // boolean log=true;
      String msg="";
      if(log){
          msg="Tem esse usuário cadastrado";
      }else {
          msg="Não tem esses dados no banco de dados";
      }
        Toast.makeText(this, " "+msg, Toast.LENGTH_SHORT).show();
    }

    public void  addUsuario(){
        ModeloUsuario mdUsuario = new ModeloUsuario(0,"Anderson","8499214567","AndersonDev","1234");
     long dd= dados.inserirUsuario(mdUsuario);
        Toast.makeText(this, "Dados do usuário adicionado com sucesso! "+dd, Toast.LENGTH_SHORT).show();
    }
}