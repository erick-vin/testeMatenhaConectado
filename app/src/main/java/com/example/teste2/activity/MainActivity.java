package com.example.teste2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.teste2.R;
import com.example.teste2.helper.DBHelper;
import com.example.teste2.helper.UsuarioDAO;
import com.example.teste2.model.entities.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextSenha;
    Button button;
    List<User> list = new ArrayList<>();
    CheckBox checkBoxMatenhaConect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editText2);
        button = findViewById(R.id.button);
        checkBoxMatenhaConect = findViewById(R.id.checkBoxMatenhaConect);

        list.add(new User("Erick", "123456"));
        list.add(new User("Vinicius", "123456"));
        list.add(new User("Lima", "123456"));
        list.add(new User("Pereira", "123456"));
        list.add(new User("Santos", "123456"));

        DBHelper db = new DBHelper(getApplicationContext());

        User user = new User();

        UsuarioDAO usuarioDAO = new UsuarioDAO(getApplicationContext());

        try{
            Log.i("INFO try", "Entrou no bloco try");

            user.setNome(usuarioDAO.buscar("emailortel"));
            user.setSenha(usuarioDAO.buscar("senha"));

            Log.i("INFO try", "Fez a execução no banco de dados");
            boolean validation = false;

            for (User s : list) {
                if (user.equals(s)) {
                    validation = true;

                }
            }
            if(validation == true){
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
            }

        }catch (Exception e){
            Log.i("Info Main Error: ", "Deu algo errado: " + e.getMessage());
        }


    }

    public void clicar(View view) {
        if (editTextEmail != null && editTextSenha != null) {

            boolean validation = false;
            User user = new User();
            user.setNome(editTextEmail.getText().toString());
            user.setSenha(editTextSenha.getText().toString());

            for (User s : list) {
                if (user.equals(s)) {
                    validation = true;

                }
            }
            if (validation == true){
                if (checkBoxMatenhaConect.isChecked()){

                    user.setMatenhaConect(true);

                    UsuarioDAO usuarioDAO = new UsuarioDAO(getApplicationContext());

                    ContentValues cv = new ContentValues();

                    usuarioDAO.salvar(user);

                }
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
            }
        }

    }
}
