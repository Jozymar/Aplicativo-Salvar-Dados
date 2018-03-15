package br.edu.ifpb.salvardados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText nome = (EditText)findViewById(R.id.editText);
                EditText cpf = (EditText)findViewById((R.id.editText2));

                String nomeString = nome.getText().toString();
                String cpfString = cpf.getText().toString();
                String resultado;

                resultado = crud.insereDado(nomeString, cpfString);

                if(resultado == "Registro inserido com sucesso"){
                    Intent intent = new Intent(MainActivity.this, Listar.class);
                    MainActivity.this.startActivity(intent);
                }

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
             }
        });
    }
}