package com.example.listadenomessql.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.listadenomessql.ArmazenamentoBancoDeDados;
import com.example.listadenomessql.R;
import com.example.listadenomessql.adapter.Adapter;
import com.example.listadenomessql.model.Nome;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton fabInserirNome;

    private ArmazenamentoBancoDeDados bancoDeDados;
    private List<Nome> listaNomes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fabInserirNome = findViewById(R.id.fabInserirNome);

        bancoDeDados = new ArmazenamentoBancoDeDados(getApplicationContext());

        fabInserirNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InserirNomeActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
    }

    @Override
    protected void onStart() {
        super.onStart();
        listaNomes.clear();
        popularLista();
        Adapter adapter = new Adapter(this.listaNomes);
        recyclerView.setAdapter(adapter);
    }

    public void popularLista() {
        Nome nome;
        for (int i = 0; i < bancoDeDados.recuperarQuantidadeDeNomes(); i++) {
            nome = new Nome(bancoDeDados.recuperarNome(i));
            listaNomes.add(nome);
        }
    }
}