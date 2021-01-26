package com.example.listadenomessql.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listadenomessql.ArmazenamentoBancoDeDados;
import com.example.listadenomessql.R;

public class InserirNomeActivity extends AppCompatActivity {

    private EditText editNome;
    private Button buttonSalvar;

    private ArmazenamentoBancoDeDados bancoDeDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_nome);

        editNome = findViewById(R.id.editNome);
        buttonSalvar = findViewById(R.id.buttonSalvar);

        bancoDeDados = new ArmazenamentoBancoDeDados(getApplicationContext());

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editNome.getText().toString().equals("")) {
                    Toast.makeText(InserirNomeActivity.this, "Campo nome VAZIO!", Toast.LENGTH_SHORT).show();
                } else {
                    bancoDeDados.salvarNome(editNome.getText().toString());
                    Toast.makeText(InserirNomeActivity.this, "Nome salvo com sucesso!", Toast.LENGTH_SHORT).show();
                    editNome.setText("");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fechar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}