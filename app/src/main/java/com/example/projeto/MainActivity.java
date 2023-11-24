package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projeto.dao.UsuarioDAO;
import com.example.projeto.model.Usuario;

public class MainActivity extends AppCompatActivity {

    EditText txtUsuario, txtSenha;
    TextView lbResultado;
    Button btnLogar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario = findViewById(R.id.txtUsuarioLogin);
        txtSenha =  findViewById(R.id.txtSenhaLogin);
        lbResultado = findViewById(R.id.lbResultadoLogin);
        btnLogar = findViewById(R.id.btnLogar);
    }
    public void login(View v){
        String usuario = txtUsuario.getText().toString();
        String senha = txtSenha.getText().toString();

        Usuario usu = new UsuarioDAO().selecionaUsuario(usuario, senha);
        if(usu != null){
            lbResultado.setText("Login com sucesso!");
            Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
            startActivity(intent);

            finish();

        }else {
            lbResultado.setText("Usuario e/ou Senha inválido");
            limpar();
        }
    }
    private void limpar(){
        //txtUsuario.setText("");
        txtSenha.setText("");
        txtUsuario.requestFocus();
    }
}