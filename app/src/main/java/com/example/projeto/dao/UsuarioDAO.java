package com.example.projeto.dao;

import android.util.Log;

import com.example.projeto.conexao.Conexao;
import com.example.projeto.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {

    public Usuario selecionaUsuario(String usuario, String senha) {
        try {
            Connection conn = Conexao.conectar();
            if (conn != null) {
                String sql = "select * from usuario where usuario = '" + usuario + "' and senha = '" + senha + "'";
                Statement st = null;
                st = conn.createStatement();

                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Usuario usu = new Usuario();
                    usu.setCodigo(rs.getInt(1));
                    usu.setUsuario(rs.getString(2));
                    usu.setSenha(rs.getString(3));

                    conn.close();
                    return usu;
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
}
