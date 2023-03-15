package com.example.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText campo, login, senha;
    ArrayList<Usuario> listinha = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState){ //Primeiro método da activity a ser executado
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//Obter o banner com o titulo do app e esconder
        campo = findViewById(R.id.nome);//Vincular variável do java com do xml
        login = findViewById(R.id.login);
        senha = findViewById(R.id.senha);
        criaUsuarios();
    }
    public void clicar(View v){ //O parâmetro view torna o método visível ao arquivo xml
        String mensagem = "Olá "+campo.getText()+", bora programar Android?";
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
    public void logar(View v){
        String user = login.getText().toString();
        String pass = senha.getText().toString();
        String mensagem = "Bem vindo!";
        for(Usuario u:listinha){
            if(user.equals(u.getLogin()) && pass.equals(u.getSenha())){
                if(u.isAdmin()){
                    Intent i = new Intent(this,Admin.class);
                    startActivity(i);
                    Admin.listinha = listinha;
                }
                else{
                    Intent i = new Intent(this,Comum.class);
                    startActivity(i);
                }
                mensagem = "Bem Vindo!";
                break;
            }
            else{
                mensagem = "Login ou Senha incorreta!";
            }
        }
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
    private void criaUsuarios() {
        Usuario u1 = new Usuario("admin","admin",true);
        Usuario u2 = new Usuario("jack","java",true);
        Usuario u3 = new Usuario("pikachu","123",false);
        Usuario u4 = new Usuario("batata","abc",false);
        Usuario u5 = new Usuario("batatinha","quandonasce",false);
        listinha.add(u1);
        listinha.add(u2);
        listinha.add(u3);
        listinha.add(u4);
        listinha.add(u5);
    }
    public void cadastro(View v){
        Intent i = new Intent(this, Cadastro.class);
        startActivity(i);
        Cadastro.listinha = listinha;
    }

}