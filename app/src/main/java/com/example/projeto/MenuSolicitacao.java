package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projeto.dao.ChamadoDAO;
import com.example.projeto.model.Chamado;
import com.example.projeto.view.ListaChamado;

public class MenuSolicitacao extends AppCompatActivity {

    EditText txtNome, txtDescricao, txtEndereco;
    TextView lbStatus;
    Button btnSalvar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_solicitacao);

        txtNome = findViewById(R.id.txtMenuSolicitacaoNome);
        txtDescricao = findViewById(R.id.txtMenuSolicitacaoDescricao);
        txtEndereco = findViewById(R.id.txtMenuSolicitacaoEndereco);

        btnSalvar = findViewById(R.id.btnMenuSolicitacaoSalvar);

        lbStatus = findViewById(R.id.lbMenuSolicitacaoStatus);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    private void salvar(){
        Chamado c = new Chamado();
        c.setNome(txtNome.getText().toString());
        c.setDescricao(txtDescricao.getText().toString());
        c.setEndereco(txtEndereco.getText().toString());

        ChamadoDAO dao = new ChamadoDAO();
        dao.cadastrar(c);

        Intent intent = new Intent(MenuSolicitacao.this, ListaChamado.class);
        startActivity(intent);
    }

}