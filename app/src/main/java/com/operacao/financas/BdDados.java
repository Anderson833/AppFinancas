package com.operacao.financas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Essa classe vai servi para criar a database
 */
public class BdDados extends SQLiteOpenHelper {
    // Atributos
    private static  final String database="Financeiro";
    private static final int verion=16;
    private  String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BdDados(Context context){
       super(context,database,null,verion);
       Toast.makeText(context, "database construida com êxito!", Toast.LENGTH_SHORT).show();

   }
    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("create table usuario(id integer primary key autoincrement," +
              "nome Text,login varchar(200),fone varchar(20),senha varchar(100));");
           setMsg("Tabela de usuário criada com sucesso!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
