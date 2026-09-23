// Guilherme de Araujo Moreira RM: 561848
// Joao Vitor Parizotto Rocha RM: 562719
// Leonardo Silva Pinto RM: 564929
// Samuel Enzo RM: 564391
package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection abrirConexao(){
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
            final String USER = "";
            final String PASS = "";
            con = DriverManager.getConnection(url, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO: A classe de conexão não foi encontrada\n" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("ERRO: erro de SQL\n" + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        return con;
    }

    public static Connection fecharConexao(Connection con){
        try {
            con.close();
            System.out.println("Conexão fechada!");
        } catch (SQLException e) {
            System.out.println("ERRO: erro de SQL" + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRO:" + e.getMessage());
        }
        return con;
    }

}

