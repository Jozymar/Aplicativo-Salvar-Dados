package br.edu.ifpb.salvardados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jozimar on 15/03/18.
 */

public class BancoController {
    private SQLiteDatabase db;
    private MyDBSQLiteHelper banco;

    public BancoController(Context context) {
        banco = new MyDBSQLiteHelper(context);
    }

    public String insereDado(String nome, String cpf) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(MyDBSQLiteHelper.NOME, nome);
        valores.put(MyDBSQLiteHelper.CPF, cpf);

        resultado = db.insert(MyDBSQLiteHelper.TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    public List<Pessoa> listarPessoas (SQLiteDatabase db) {
        List<Pessoa> pessoas = new ArrayList<>();

        Cursor cursor;
        String[] campos = {MyDBSQLiteHelper.ID, MyDBSQLiteHelper.NOME, MyDBSQLiteHelper.CPF};

        cursor = db.query(MyDBSQLiteHelper.TABELA, campos, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
            String cpf = cursor.getString(cursor.getColumnIndexOrThrow("cpf"));

            Pessoa pessoa = new Pessoa(nome, cpf);
            pessoas.add(pessoa);

        }

        return pessoas;
    }

}