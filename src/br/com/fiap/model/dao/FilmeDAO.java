// Guilherme de Araujo Moreira RM: 561848
// Joao Vitor Parizotto Rocha RM: 562719
// Leonardo Silva Pinto RM: 564929
// Samuel Enzo RM: 564391
package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeDAO {
    private Connection con;

    public FilmeDAO(Connection con){
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Filme filme){
        String sql = "insert into ddd_filme(titulo, genero, produtora) values(?, ?, ?)";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getProdutora());
            if (ps.executeUpdate() > 0) {
                return "Filme inserido com sucesso!";
            } else {
                return "Não foi possivel inserir um Filme!";
            }
        } catch (SQLException e) {
            return "ERRO: erro de SQL" + e.getMessage();
        }
    }

    public String alterar(Filme filme){
        String sql = "UPDATE ddd_filme SET titulo = ?, genero = ?, produtora = ? WHERE codigo = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getProdutora());
            ps.setInt(4, filme.getCodigo());
            if (ps.executeUpdate() > 0) {
                return "Filme alterado com sucesso";
            } else {
                return "Filme nao encontrado!";
            }
        } catch (SQLException e) {
            return "ERRO: erro de SQL - " + e.getMessage();
        }
    }

    public String excluir(Filme filme){
        String sql = "DELETE FROM ddd_filme WHERE codigo = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setInt(1, filme.getCodigo());
            if (ps.executeUpdate() > 0){
                return "Filme excluido com sucesso";
            } else {
                return "Filme nao encontrado!";
            }
        } catch (SQLException e) {
            return "ERRO: erro de sql - " + e.getMessage();
        }
    }

    public ArrayList<Filme> listarTodos(){
        String sql = "SELECT codigo, titulo, genero, produtora FROM ddd_filme";
        ArrayList<Filme> listaFilmes = new ArrayList<>();
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setCodigo((rs.getInt("codigo")));
                filme.setTitulo(rs.getString("titulo"));
                filme.setGenero(rs.getString("genero"));
                filme.setProdutora(rs.getString("produtora"));
                listaFilmes.add(filme);
            }
        } catch (SQLException e) {
            System.out.println("ERRO: erro de SQL - " + e.getMessage());
        }
        return listaFilmes;
    }
}
