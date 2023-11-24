package com.example.projeto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.projeto.R;
import com.example.projeto.model.Chamado;

import java.io.Serializable;
import java.util.List;

public class ListaChamadoAdapter extends BaseAdapter implements Serializable {
    private static final long serialVersionUID = 546546546546L;
    private List<Chamado> listaChamado;
    private Context context;
    private LayoutInflater layout;
    public ListaChamadoAdapter(List<Chamado> listaChamado, Context context) {
        this.listaChamado = listaChamado;
        this.context = context;
        layout = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listaChamado.size();
    }

    @Override
    public Chamado getItem(int i) {
        return listaChamado.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Chamado cham = listaChamado.get(i);
        View v = layout.inflate(R.layout.item_chamado, null);

        TextView txtCodigo = v.findViewById(R.id.txtConsultaChamadoCodigo);
        TextView txtNome = v.findViewById(R.id.txtConsultaChamadoNome);
        TextView txtDescricao = v.findViewById(R.id.txtConsultaChamadoDescricao);
        TextView txtEndereco = v.findViewById(R.id.txtConsultaChamadoEndereco);

        txtCodigo.setText(cham.getCodigo().toString());
        txtNome.setText(cham.getNome());
        txtDescricao.setText(cham.getDescricao());
        txtEndereco.setText(cham.getEndereco());

        return v;
    }
}
