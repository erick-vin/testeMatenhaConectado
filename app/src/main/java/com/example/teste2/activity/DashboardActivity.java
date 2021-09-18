package com.example.teste2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.teste2.R;
import com.example.teste2.helper.UsuarioDAO;
import com.example.teste2.model.entities.User;

public class DashboardActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        textView = findViewById(R.id.textView2);
        User user = new User();

        UsuarioDAO usuarioDAO = new UsuarioDAO(getApplicationContext());

        user.setNome(usuarioDAO.buscar("emailortel"));
        textView.setText("Nome: " + user.getNome());
    }
}
