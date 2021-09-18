package com.example.teste2.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.teste2.model.entities.User;

public class UsuarioDAO implements IUsuarioDAO {

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public UsuarioDAO(Context context) {
        DBHelper db = new DBHelper(context);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(User user) {

        ContentValues cv = new ContentValues();
        cv.put("emailortel", user.getNome());
        cv.put("senha", user.getSenha());

        try{
            escreve.insert(DBHelper.TABELA_USUARIO, null, cv);
            Log.e("INFO", "Sucesso ao salvar tarefa");
        }catch (Exception e){
            Log.e("INFO", "Erro ao salvar tarefa " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizar(User user) {
        return false;
    }

    @Override
    public boolean deletar(User user) {
        return false;
    }

    @Override
    public String buscar(String column) {

        String sql = "SELECT * FROM " + DBHelper.TABELA_USUARIO + " ;";

        Cursor c = le.rawQuery(sql, null);
        c.moveToFirst();

        String valorColumn = c.getString(c.getColumnIndex(column));

        return valorColumn;
    }
}
