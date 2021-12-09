/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Windows 7
 */
/*
public class CreateTables {
    public void create() throws ClassNotFoundException{
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/livraria","root","1234");
            Statement stmt = conn.createStatement();
               stmt.execute(
                       "CREATE TABLE IF NOT EXISTS livraria.publisher (" +
                          "puid INT PRIMARY KEY AUTO_INCREMENT," +
                          "title VARCHAR(25)," +
                          "author VARCHAR(25)," +
                          "email VARCHAR(100))" +
                       "ENGINE=InnoDB;");
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/livraria","root","1234");
            Statement stmt = conn.createStatement();
               stmt.execute(
                       "CREATE TABLE IF NOT EXISTS livraria.author (" +
                          "auid INT PRIMARY KEY AUTO_INCREMENT," +
                          "name VARCHAR(25))" +
                       "ENGINE=InnoDB;");
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/livraria","root","1234");
            Statement stmt = conn.createStatement();
               stmt.execute(
                       "CREATE TABLE IF NOT EXISTS livraria.user (" +
                          "usid INT PRIMARY KEY AUTO_INCREMENT," +
                          "name VARCHAR(25)," +
                          "type VARCHAR(25))" +
                       "ENGINE=InnoDB;");
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/livraria","root","1234");
            Statement stmt = conn.createStatement();
               stmt.execute(
                       "CREATE TABLE IF NOT EXISTS livraria.orderItens (" +
                          "orid INT PRIMARY KEY AUTO_INCREMENT," +
                          "fkorid INT NOT NULL,"+
                          "fkboid INT NOT NULL,"+
                          "CONSTRAINT FK_orid FOREIGN KEY(fkorid)"+
                          "REFERENCES LIVRARIA.publisher(orid),"+
                          "CONSTRAINT FK_boid FOREIGN KEY(fkboid)"+
                          "REFERENCES LIVRARIA.book(boid))"+
                       "ENGINE=InnoDB;");
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/livraria","root","1234");
            Statement stmt = conn.createStatement();
               stmt.execute(
                       "CREATE TABLE IF NOT EXISTS livraria.Books (" +
                          "boid INT PRIMARY KEY AUTO_INCREMENT," +
                          "title VARCHAR(25)," +
                          "author VARCHAR(25)," +
                          "email VARCHAR(100)," +
                          "fkpuid INT NOT NULL,"+
                          "fkauid INT NOT NULL,"+
                          "CONSTRAINT FK_puid FOREIGN KEY(fkpuid)"+
                          "REFERENCES LIVRARIA.publisher(puid),"+
                          "CONSTRAINT FK_auid FOREIGN KEY(fkauid)"+
                          "REFERENCES LIVRARIA.author(auid))"+
                       "ENGINE=InnoDB;");
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        //order
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/livraria","root","1234");
            Statement stmt = conn.createStatement();
               stmt.execute(
                       "CREATE TABLE IF NOT EXISTS livraria.order (" +
                          "orid INT PRIMARY KEY AUTO_INCREMENT," +
                          "date VARCHAR(8)," +
                          "numberfbooks INT(6) NOT NULL,"+
                          "fkusid INT NOT NULL,"+
                          "CONSTRAINT FK_puid FOREIGN KEY(fkusid)"+
                          "REFERENCES LIVRARIA.user(usid))"+
                       "ENGINE=InnoDB;");
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
    }
}
*/
