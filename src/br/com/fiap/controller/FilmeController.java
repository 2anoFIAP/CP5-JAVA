// Guilherme de Araujo Moreira RM: 561848
// Joao Vitor Parizotto Rocha RM: 562719
// Leonardo Silva Pinto RM: 564929
// Samuel Enzo RM: 564391
package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.FilmeDAO;
import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeController {
    public String inserirFilme(String titulo, String genero, String produtora) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.inserir(filme);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarFilme(int codigo, String titulo, String genero, String produtora) throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();
        filme.setCodigo(codigo);
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.alterar(filme);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirFilme(int codigo) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();
        filme.setCodigo(codigo);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.excluir(filme);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarTodosFilmes() throws ClassNotFoundException, SQLException{
        String resultado = "";
        Connection con = ConnectionFactory.abrirConexao();
        FilmeDAO filmeDAO = new FilmeDAO(con);
        ArrayList<Filme> filmes = filmeDAO.listarTodos();
        ConnectionFactory.fecharConexao(con);

        for (Filme filme : filmes) {
            resultado +=
                    "Código: " + filme.getCodigo() + "\n" +
                    "Título: " + filme.getTitulo() + "\n" +
                    "Gênero: " + filme.getGenero() + "\n" +
                    "Produtora: " + filme.getProdutora() + "\n" +
                    "-----------------------------\n";
        }
        return resultado;
    }
}
