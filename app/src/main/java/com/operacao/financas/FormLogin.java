package com.operacao.financas;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormLogin extends AppCompatActivity {
    private  DaoDados dados;
    private EditText email, senha;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);
         email = findViewById(R.id.Edit_email);
         senha = findViewById(R.id.Edit_senha);
         login = (Button) findViewById(R.id.bt_entrar);
        getSupportActionBar().hide();
        dados = new DaoDados(this);
     /*   addUsuario();
       //  login();
       addGanhos();
      //  setaGanhos();
        addGastos();
      addGastosGanhos();*/
    }

    public void logar(View V){
      //  login();
        //setaGanhos();
       // exibirTotais();
        convertPintero();
        // dataUnica();
       // addGastosGanhos();
    }

    public  void telaInicio(){
        Intent  intentt = new Intent(FormLogin.this, Principal.class);
        startActivity(intentt);
        finish();
    }
    public void login(){
       String Email=String.valueOf(email.getText().toString());
       String Senha=String.valueOf(senha.getText().toString());
        boolean log=  dados.logarUsuario(Email,Senha);
       // boolean log=  dados.logarUsuario("AndersonDev","1234");
        // boolean log=true;
        String msg="";
        if(log){
           // msg="Tem esse usuário cadastrado";
            telaInicio();
        }else {
            msg="Não tem esses dados no banco de dados";
        }
        Toast.makeText(this, " "+msg, Toast.LENGTH_SHORT).show();
    }

    public void setaGanhos(){
       // boolean log=  dados.setDadosGanho(1);
       // boolean log= dados.setDadosGastos(1);
        // boolean log=true;
        double ganhos=dados.setSomaGanhos();
        double gastos=dados.setSomaGastos();
        String msg="";
        if(ganhos >0 && gastos>0){
            msg="Tem valores cadastrado";
          //  msg="Tem gastos";
        }else {
            msg="Não tem ganho no banco de dados";
           // msg="não tem gastos";
        }
        Toast.makeText(this, " "+msg, Toast.LENGTH_SHORT).show();
      //  int qtd=dados.setSomaGanhos();
       // int qtd=dados.setSomaGastos();
        Toast.makeText(this, gastos+"gastos antes e depois ganhos = "+ganhos, Toast.LENGTH_SHORT).show();
    }

    public void  addUsuario(){
        ModeloUsuario mdUsuario = new ModeloUsuario(0,"Anderson","8499214567","AndersonDev","1234");
        long dd= dados.inserirUsuario(mdUsuario);
        Toast.makeText(this, "Dados do usuário adicionado com sucesso! "+dd, Toast.LENGTH_SHORT).show();
    }

    public void  addGanhos(){
        ModeloGanhos mdl = new ModeloGanhos(0,"fuba",50,"2012023",1);
        long d=dados.inserirGanhos(mdl);
        Toast.makeText(this, "Ganhos adicionado com sucesso! "+d, Toast.LENGTH_SHORT).show();
    }

    public  void addGastos(){
        ModeloGastos gts = new ModeloGastos(0,"café",10,"15012023",1);
        long addgastos=dados.inserirGastos(gts);
        Toast.makeText(this, "Gasto adicionado com sucesso!"+addgastos, Toast.LENGTH_SHORT).show();
    }

    public void addGastosGanhos(){
        ModeloGastos gts1 = new ModeloGastos(0,"café",15,"15022023",1);
        long addgastos1=dados.inserirGastos(gts1);
        ModeloGanhos mdl1 = new ModeloGanhos(0,"fuba",40,"2022023",1);
        long d1s=dados.inserirGanhos(mdl1);


        ModeloGastos gts2 = new ModeloGastos(0,"café",15,"15022023",1);
        long addgastos2=dados.inserirGastos(gts2);
        ModeloGanhos mdl2 = new ModeloGanhos(0,"fuba",40,"2022023",1);
        long d2=dados.inserirGanhos(mdl2);

        // mês 3 em baixo
        ModeloGastos gts3 = new ModeloGastos(0,"café",15,"15032023",1);
        long addgastos3=dados.inserirGastos(gts3);
        ModeloGanhos mdl3 = new ModeloGanhos(0,"fuba",40,"2032023",1);
        long d3=dados.inserirGanhos(mdl3);
        // mês 4 em baixo
        ModeloGastos gts4 = new ModeloGastos(0,"café",60,"15042023",1);
        long addgastos4=dados.inserirGastos(gts4);
        ModeloGanhos mdl4 = new ModeloGanhos(0,"fuba",45,"2042023",1);
        long d4=dados.inserirGanhos(mdl4);
        // mês 5 em baixo
        ModeloGastos gts5 = new ModeloGastos(0,"café",18,"15052023",1);
        long addgastos5=dados.inserirGastos(gts5);
        ModeloGanhos mdl5 = new ModeloGanhos(0,"fuba",35,"2052023",1);
        long d5=dados.inserirGanhos(mdl5);
        Toast.makeText(this, "Todos dados salvos com sucesso!", Toast.LENGTH_SHORT).show();
    }


    public void exibirTotais(String datai,String dataf){

        double gst=dados.setSomaGanhosPelasDatas(datai,dataf);
        double gns=dados.setSomaGastosPelasDatas(datai,dataf);
        Toast.makeText(this, "ganhos total "+gst, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "gastos total "+gns, Toast.LENGTH_SHORT).show();
    }

    public void convertPintero(){


        String dado=String.valueOf(email.getText().toString());
        String inicio[]=dado.split(",");
        String dp=inicio[0];
        String ds=inicio[1];
    //    String dti=dp.replace("/","");
      //  String dtf=ds.replace("/","");
    //   int di=Integer.parseInt(dti);
      // int df=Integer.parseInt(dtf);
    // double x=   dados.setSomaGanhosPorData(datai);
         exibirTotais(dp,ds);
      /* Toast.makeText(this, "data inicio "+di, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Data final "+df, Toast.LENGTH_SHORT).show();*/
      //  Toast.makeText(this, "DATA UNICA "+x, Toast.LENGTH_SHORT).show();

    }

    public void dataUnica(){

        String dado=String.valueOf(email.getText().toString());

        String data[]=dado.split("/");
        String dia=data[0], mes=data[1],ano=data[2];
        int d=Integer.parseInt(dia);
        int m=Integer.parseInt(mes);
        int a=Integer.parseInt(ano);

        double somaGastos=0,somaGanhos=0;
        String in=d+""+m+""+a;
        double dt=dados.setSomaGastosPorData(d+""+m+""+a);
        Toast.makeText(this, dt+"Gasto data unica "+in, Toast.LENGTH_SHORT).show();
        int i,contaI=0;
      /*  for(i=1;i<=d;i++){
            double gastos=dados.setSomaGastosPorData(i+""+m+""+a);
            somaGastos=somaGastos+gastos;
           // double ganhos=dados.setSomaGanhosPorData(i+""+m+""+a);
          //  somaGanhos=somaGanhos+ganhos;
            contaI=i;
        }*/
            Toast.makeText(this, "Total do gasto  "+somaGastos, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Total do ganho  "+somaGanhos, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Total de  i "+contaI, Toast.LENGTH_SHORT).show();
    }


}