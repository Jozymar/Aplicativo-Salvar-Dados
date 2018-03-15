package br.edu.ifpb.salvardados;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by jozimar on 15/03/18.
 */

public class Listar  extends AppCompatActivity {

    private MyDBSQLiteHelper banco;
    private SQLiteDatabase db;
    private BancoController crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar);

        crud = new BancoController(getBaseContext());
        banco = new MyDBSQLiteHelper(this);
        db = banco.getWritableDatabase();

        List<Pessoa> pessoas = crud.listarPessoas(db);

        ListView lista = (ListView) findViewById(R.id.listView);

        ArrayAdapter<Pessoa> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, pessoas);
        lista.setAdapter(adapter);
    }
}