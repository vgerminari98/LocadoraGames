/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author etec
 */
public class Conexao {
    public static java.sql.Connection getConnection() throws SQLException
    {
            
        try 
        {
        Class.forName("org.gjt.mm.mysql.Driver");
        String usuario = "root";
        String senha = "root";
        String url = "jdbc:mysql://localhost:3306/games";
        Connection conexao = DriverManager.getConnection(url, usuario,senha);
        System.out.println("Conectando ao Banco");
        return DriverManager.getConnection(url,usuario,senha);
        }
        catch(ClassNotFoundException e){
            throw new SQLException(e.getMessage ()); 
        } 
    }
        
        public static void fecharConexao(Connection con) {
            try {
                con.close();
                System.out.println("Conexao fechada! ");
            }
            catch(SQLException e) {
               System.out.println(e.getMessage()); 
            }
        }
    }
