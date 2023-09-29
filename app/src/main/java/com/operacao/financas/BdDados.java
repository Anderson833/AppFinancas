package com.operacao.financas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import org.w3c.dom.Text;

import kotlinx.coroutines.SupervisorKt;

/**
 * Essa classe vai servi para criar a database
 */
public class BdDados extends SQLiteOpenHelper {
    // Atributos
    private static  final String database="Financeiro";
    private static final int version=25;


    public BdDados(Context context){
       super(context,database,null,version);
       Toast.makeText(context, "database construida com êxito!", Toast.LENGTH_SHORT).show();

   }

   @Override
   public void onOpen(SQLiteDatabase bd){
       super.onOpen(bd);
       if(!bd.isReadOnly()){
           bd.execSQL("PRAGMA foreign_keys=on;");
       }
   }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String  sql_Usuario="create table usuario(id integer primary key autoincrement," +
                "nome Text,login varchar(200) unique not null,fone varchar(20),senha varchar(100) not null);";
        String sql_Ganhos="create table ganhos(codigo integer primary key autoincrement,descricao varchar(200),valor double,data TEXT,idUsuario integer," +
                "FOREIGN KEY(idUsuario) REFERENCES usuario(id))";
        String sql_Gastos="create table gastos(codigo integer primary key autoincrement,descricao varchar(200),valor double,data TEXT,idUsuario integer," +
                "FOREIGN KEY(idUsuario) REFERENCES usuario(id))";
      db.execSQL(sql_Usuario);
      db.execSQL(sql_Ganhos);
      db.execSQL(sql_Gastos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         String onUpgrade_Usuario="DROP TABLE IF EXISTS usuario";
         String onUpgrade_Ganhos="DROP TABLE IF EXISTS ganhos";
        String onUpgrade_Gastos="DROP TABLE IF EXISTS gastos";
         db.execSQL(onUpgrade_Usuario);
         db.execSQL(onUpgrade_Ganhos);
         db.execSQL(onUpgrade_Gastos);
         onCreate(db);
    }
}
