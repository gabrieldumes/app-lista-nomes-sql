package com.example.listadenomessql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ArmazenamentoBancoDeDados {

    private Context context;
    private SQLiteDatabase database;

    public ArmazenamentoBancoDeDados(Context context) {
        this.context = context;
        try {
            database = context.openOrCreateDatabase("app_db", Context.MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS nomes (nome VARCHAR)");
        } catch (Exception e) {
            Log.i("INSETO ", e.getMessage());
        }
    }

    public void salvarNome(String nome) {
        try {
            database.execSQL("INSERT INTO nomes(nome) VALUES ('" + nome + "')");
        } catch (Exception e) {
            Log.i("INSETO ", e.getMessage());
        }
    }

    public String recuperarNome(int position) {
        try {
            Cursor cursor = database.rawQuery("SELECT nome FROM nomes", null);
            int indiceColunaNome = cursor.getColumnIndex("nome");
            cursor.moveToPosition(position);
            return cursor.getString(indiceColunaNome);
        } catch (Exception e) {
            Log.i("INSETO ", e.getMessage());
            return "ERRO";
        }
    }

    public int recuperarQuantidadeDeNomes() {
        Cursor cursor = database.rawQuery("SELECT nome FROM nomes", null);
        return cursor.getCount();
    }
}
