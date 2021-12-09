
package livraria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexaoBD {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/livraria","root","1234");
            Statement stmt = conn.createStatement();
               stmt.execute(
                       "CREATE TABLE IF NOT EXISTS livraria.Books (" +
                          "id INT PRIMARY KEY AUTO_INCREMENT," +
                          "title VARCHAR(25)," +
                          "author VARCHAR(25)," +
                          "publisher VARCHAR(25)," +
                          "email VARCHAR(100))" +
                       "ENGINE=InnoDB;");
            System.out.println("Conectado");
        }catch(SQLException e){
            System.out.println("Não Conectado");
        }
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/livraria","root","1234");
            Statement stmt = conn.createStatement();
               stmt.execute(
                       "CREATE TABLE IF NOT EXISTS livraria.user (" +
                          "userId INT PRIMARY KEY AUTO_INCREMENT," +
                          "userName VARCHAR(25)," +
                          "userEmail VARCHAR(100)," +
                          "password VARCHAR(20))" +
                       "ENGINE=InnoDB;");
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/livraria","root","1234");
            Statement stmt = conn.createStatement();
               stmt.execute(
                       "CREATE TABLE IF NOT EXISTS livraria.orderP (" +
                          "orderId INT PRIMARY KEY AUTO_INCREMENT," +
                          "orderDate date," +
                          "orderTime time," +
                          "idUsuario int," +
                          "idLivro int)"+     
                       "ENGINE=InnoDB;");
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
    }
}
