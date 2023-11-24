package com.example.projeto;

import static com.example.projeto.R.id.btnMenuChamados;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projeto.view.ListaChamado;

public class MenuPrincipal extends AppCompatActivity {

    Button btnChamados = null;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnChamados = findViewById(btnMenuChamados);
        btnChamados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipal.this, ListaChamado.class);
                startActivity(intent);
            }
        });
    }
}