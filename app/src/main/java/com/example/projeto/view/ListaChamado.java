package com.example.projeto.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projeto.MainActivity;
import com.example.projeto.MenuPrincipal;
import com.example.projeto.MenuSolicitacao;
import com.example.projeto.R;
import com.example.projeto.adapter.ListaChamadoAdapter;
import com.example.projeto.dao.ChamadoDAO;
import com.example.projeto.model.Chamado;

import org.w3c.dom.Text;

import java.util.List;

public class ListaChamado extends AppCompatActivity {

    TextView txtPesquisa;
    Button btnPesquisar, btnNovo;
    ListView listView;
    ListaChamadoAdapter adapter;
    List<Chamado> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chamado);

        txtPesquisa = findViewById(R.id.txtConsultaChamadoPesquisa);
        btnPesquisar = findViewById(R.id.btnConsultaChamadoPesquisa);
        btnNovo = findViewById(R.id.btnConsultaChamadoNovo);
        listView = findViewById(R.id.listViewConsultaChamado);

        preenche("");

        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preenche(txtPesquisa.getText().toString());
            }
        });

        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaChamado.this, MenuSolicitacao.class);
                startActivity(intent);
            }
        });
    }

    private void preenche(String busca) {
        ChamadoDAO dao = new ChamadoDAO();
        if(busca.isEmpty()){
            lista = dao.getAll();
        }else {
            lista = dao.getAll(busca);
        }


        adapter = new ListaChamadoAdapter(lista, this);
        listView.setAdapter(adapter);
    }

}