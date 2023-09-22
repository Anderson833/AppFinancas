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

    /**
     * Método para pegar o login e senha do usuario no banco de dados
     * @param usu, senha o id
     * @return dados usu
     */
    public boolean setDadosUsuario(String usu,String senha){
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
