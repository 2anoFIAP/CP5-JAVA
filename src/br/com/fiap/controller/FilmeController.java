// Guilherme de Araujo Moreira RM: 561848
// Joao Vitor Parizotto Rocha RM: 562719
// Leonardo Silva Pinto RM: 564929
// Samuel Enzo RM: 564391
package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.SQLException;

public class FilmeController {
    public String inserirFilme(String titulo, String genero, String produtora) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();

    }

    public String alterarFilme(int codigo, String titulo, String genero, String produtora){

    }

    public String excluirFilme(int codigo){

    }

    public String listarTodosFilmes(){

    }
}
