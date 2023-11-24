package com.example.projeto.dao;

import android.util.Log;
import android.widget.TextView;

import com.example.projeto.conexao.Conexao;
import com.example.projeto.model.Chamado;
import com.example.projeto.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChamadoDAO {
    private Connection conn = null;
    TextView lbStatus;

    public  void cadastrar(Chamado c){
        try {
            executeSql("insert into chamado (nome, descricao, endereco) values ('"+c.getNome()+"','"+c.getDescricao()+"','"+c.getEndereco()+"')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Chamado carregaPorId(Integer id){
        try {
            conn = Conexao.conectar();
            if (conn != null) {
                String sql = "select * from chamado where id = "+id+"";

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Chamado cham = new Chamado();
                    cham.setCodigo(rs.getInt(1));
                    cham.setNome(rs.getString(2));
                    cham.setDescricao(rs.getString(3));
                    cham.setEndereco(rs.getString(4));

                    conn.close();
                    return cham;
                }
                
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.e("Erro Aula 1", e.getMessage());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Log.e("Erro Aula 1", throwables.getMessage());
        }

        return null;
    }

    private void executeSql(String sql) throws SQLException, ClassNotFoundException {
        conn = Conexao.conectar();
        if (conn != null) {
            Statement st = conn.createStatement();
            st.executeQuery(sql);
            conn.close();
        }
    }

    private List<Chamado> getChamado(String sql) throws SQLException {
        List<Chamado> lista = new ArrayList<Chamado>();

        Statement st = null;
        st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Chamado cham = new Chamado();
            cham.setCodigo(rs.getInt(1));
            cham.setNome(rs.getString(2));
            cham.setDescricao(rs.getString(3));
            cham.setEndereco(rs.getString(4));

            lista.add(cham);
        }
        return lista;
    }
    public List<Chamado> getAll() {
        List<Chamado> lista = new ArrayList<Chamado>();
        try {
            conn = Conexao.conectar();
            if (conn != null) {
                String sql = "select * from chamado";
                lista = getChamado(sql);

                conn.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.e("Erro Aula 1", e.getMessage());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Log.e("Erro Aula 1", throwables.getMessage());
        }
        return lista;
    }

    public List<Chamado> getAll(String busca) {
        List<Chamado> lista = new ArrayList<Chamado>();
        try {
            conn = Conexao.conectar();
            if (conn != null) {
                String sql = "select * from chamado where nome like '%"+busca+"%'";
                lista = getChamado(sql);

                conn.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.e("Erro Aula 1", e.getMessage());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Log.e("Erro Aula 1", throwables.getMessage());
        }
        return lista;
    }
}
