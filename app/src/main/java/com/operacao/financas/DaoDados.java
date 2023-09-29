package com.operacao.financas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Essa classe vai fazer a manipulação dos dados no banco de dados
 */
public class DaoDados {

    private SQLiteDatabase bd;
    private BdDados conexao;

    public DaoDados(Context context) {
        conexao = new BdDados(context);
        bd = conexao.getReadableDatabase();
    }

    /**
     * Método para inserir os dados no banco de dados
     * @param usuario
     * @return
     */
    public long inserirUsuario(ModeloUsuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("nome",usuario.getNome());
        valores.put("login",usuario.getLogin());
        valores.put("fone",usuario.getFone());
        valores.put("senha",usuario.getSenha());
        return  bd.insert("usuario",null,valores);
    }

    public  long inserirGanhos(ModeloGanhos gns){
     //   ModeloUsuario md = new ModeloUsuario();
        ContentValues valores = new ContentValues();
        valores.put("descricao",gns.getDescricao());
        valores.put("valor",gns.getValor());
        valores.put("data",gns.getData());
        valores.put("idUsuario",gns.getChaveEstrangeira());
        return  bd.insert("ganhos",null,valores);
    }

    public  long inserirGastos(ModeloGastos gts){
        ContentValues valores  = new ContentValues();
        valores.put("descricao",gts.getDescricao());
        valores.put("valor",gts.getValor());
        valores.put("data",gts.getData());
        valores.put("idUsuario",gts.getChaveEstrangeira());
        return  bd.insert("gastos",null,valores);
    }
    /**
     * Método para pegar o login e senha do usuario no banco de dados
     * @param usu, senha o id
     * @return dados usu
     */
    public boolean logarUsuario(String usu,String senha){
        boolean logar=false;
        Cursor bb;
        bb=bd.rawQuery("select * from usuario where login='"+usu+"' and senha='"+senha+"'",null);
        if(bb.getCount()>0){
            while (bb.moveToNext()){
               /* ModeloUsuario MD = new ModeloUsuario();
                usu=bb.getString(4);*/
                logar=true;
            }
        }
        return logar;
    }

    public boolean setDadosGanho(int cod){
        boolean logar=false;
        Cursor bb;
        bb=bd.rawQuery("select * from ganhos where idUsuario="+cod,null);
        if(bb.getCount()>0){
            while (bb.moveToNext()){
               /* ModeloUsuario MD = new ModeloUsuario();
                usu=bb.getString(4);*/
                logar=true;
            }
        }
        return logar;
    }

    public boolean setDadosGastos(int cod){
        boolean logar=false;
        Cursor bb;
        bb=bd.rawQuery("select * from gastos where idUsuario="+cod,null);
        if(bb.getCount()>0){
            while (bb.moveToNext()){
               /* ModeloUsuario MD = new ModeloUsuario();
                usu=bb.getString(4);*/
                logar=true;
            }
        }
        return logar;
    }

    public double setSomaGanhos(){
        double qtd=0;
        Cursor bb;
        bb=bd.rawQuery("select sum(valor) from ganhos",null);
        if(bb.getCount()>0){
            while (bb.moveToNext()){
               /* ModeloUsuario MD = new ModeloUsuario();
                usu=bb.getString(4);*/
                qtd=bb.getInt(0);
            }
        }
        return qtd;
    }

    public double setSomaGastos(){
        double qtd=0;
        Cursor bb;
        bb=bd.rawQuery("select sum(valor) from gastos",null);
        if(bb.getCount()>0){
            while (bb.moveToNext()){
               /* ModeloUsuario MD = new ModeloUsuario();
                usu=bb.getString(4);*/
                qtd=bb.getInt(0);
            }
        }
        return qtd;
    }

    public double setSomaGastosPelasDatas(String datai,String dataf){
        double qtd=0;
        Cursor bb;
        bb=bd.rawQuery("select sum(valor) from gastos where data between  '"+datai+"' and '"+dataf+"'; ",null);
       // bb=bd.rawQuery("select sum(valor) from gastos where data='"+datai+"'",null);

        if(bb.getCount()>0){
            while (bb.moveToNext()){
               /* ModeloUsuario MD = new ModeloUsuario();
                usu=bb.getString(4);*/
                qtd=bb.getDouble(0);
            }
        }
        return qtd;
    }

    public double setSomaGanhosPelasDatas(String datai,String dataf){
        double qtd=0;
        Cursor bb;
        bb=bd.rawQuery("select sum(valor) from ganhos where data between '"+datai+"' and '"+dataf+"' ",null);
        if(bb.getCount()>0){
            while (bb.moveToNext()){
               /* ModeloUsuario MD = new ModeloUsuario();
                usu=bb.getString(4);*/
                qtd=bb.getDouble(0);
            }
        }
        return qtd;
    }

    public double setSomaGanhosPorData(String datai){
        double qtd=0;
        Cursor bb;
        bb=bd.rawQuery("select sum(valor) from ganhos where data="+datai,null);
        if(bb.getCount()>0){
            while (bb.moveToNext()){
               /* ModeloUsuario MD = new ModeloUsuario();
                usu=bb.getString(4);*/
                qtd=bb.getDouble(0);
            }
        }
        return qtd;
    }

    public double setSomaGastosPorData(String data){
        double qtd=0;
        Cursor bb;
        bb=bd.rawQuery("select sum(valor) from gastos where data="+data,null);
        if(bb.getCount()>0){
            while (bb.moveToNext()){
               /* ModeloUsuario MD = new ModeloUsuario();
                usu=bb.getString(4);*/
                qtd=bb.getDouble(0);
            }
        }
        return qtd;
    }
    /**
     * Método para lista todos os dados
     * @return
     */
    public List<ModeloUsuario> buscarUsuario(){
        List<ModeloUsuario> lista = new ArrayList<>();
        Cursor bb;
        bd=this.conexao.getReadableDatabase();
        bb=bd.rawQuery("select * from usuario ",null);
        bb.moveToFirst();
        if(bb.getCount()>0){
            while (bb.moveToNext()){
                ModeloUsuario MD = new ModeloUsuario();
                MD.setCodigo(bb.getInt(0));
                MD.setNome(bb.getString(1));
                MD.setLogin(bb.getString(2));
                MD.setFone(bb.getString(3));
                MD.setSenha(bb.getString(4));
                lista.add(MD);
            }
            bd.close();
        }
        return lista;
    }
}
