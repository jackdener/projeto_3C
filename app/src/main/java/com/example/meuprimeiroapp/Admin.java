package com.example.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Admin extends AppCompatActivity {
    static ArrayList<Usuario> listinha;
    EditText buscaLogin;
    TextView resultado;
    Usuario encontrado = new Usuario();
    Button btnAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().hide();
        buscaLogin = findViewById(R.id.busca);
        resultado = findViewById(R.id.resultado);
        btnAdmin = findViewById(R.id.btnAdmin);
        btnAdmin.setVisibility(View.INVISIBLE);
    }
    public void buscar(View view){
        String login = buscaLogin.getText().toString();
        String mensagem = "Login "+login+" não encontrado!";
        for(Usuario u : listinha){
            if(u.login.equals(login)){
                mensagem = "Login "+login+" encontrado!";
                encontrado = u;
                if(u.isAdmin()){
                    btnAdmin.setText("TORNAR COMUM");
                }
                else{
                    btnAdmin.setText("TORNAR ADMIN");
                }
                btnAdmin.setVisibility(View.VISIBLE);
                break;
            }
        }
        resultado.setText(mensagem);
    }
    public void statusAdmin(View v){
        if(encontrado.isAdmin()){
            encontrado.setAdmin(false);
            btnAdmin.setText("TORNAR ADMIN");
        }
        else{
            encontrado.setAdmin(true);
            btnAdmin.setText("TORNAR COMUM");
        }
    }
}