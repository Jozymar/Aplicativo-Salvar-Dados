package br.edu.ifpb.salvardados;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jozimar on 14/03/18.
 */

public class MyDBSQLiteHelper extends SQLiteOpenHelper{

    public static final String NOME_BANCO = "banco";
    public static final String TABELA = "pessoa";
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String CPF = "cpf";
    public static final int VERSAO = 1;

    public MyDBSQLiteHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("CREATE TABLE pessoa(_id integer primary key autoincrement, " +
         "nome text not null, cpf text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
