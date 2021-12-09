/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Windows 7
 */
public class DaoBook {
    
    private Connection conection = null;

    public void conectar() {
        
        Properties prop = new Properties();
        prop.setProperty("user", "root");
        prop.setProperty("password", "1234");
        try {
            conection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", prop);
            conection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //INSERT
    public void insert(Book book) throws SQLException {
        conectar();

        String query = "INSERT INTO livraria.Books (title, author, publisher, email) "
                + "VALUES (?,?,?,?)";
        PreparedStatement prep = conection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        prep.setString(1, book.getTitle());
        prep.setString(2, book.getAuthor());
        prep.setString(3, book.getPublisher());
        prep.setString(4, book.getEmail());
        prep.execute();
        conection.commit();

        conection.close();
    }
    
    //UPDATE
    public void update(Book book) throws SQLException {
        conectar();
        try {
            String query = "UPDATE livraria.Books "
                    + "SET title=?, author=?, publisher=?, email=? WHERE id=?";
            PreparedStatement prep = conection.prepareStatement(query);

            prep.setInt(5, book.getId());
            prep.setString(1, book.getTitle());
            prep.setString(2, book.getAuthor());
            prep.setString(3, book.getPublisher());
            prep.setString(4, book.getEmail());
            prep.execute();

            conection.commit();
            conection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //DELETE
    public void delete(Book book) {
        conectar();
        try {
            String query = "DELETE FROM livraria.Books "
                    + "WHERE id=?";
            PreparedStatement prep = conection.prepareStatement(query);

            prep.setInt(1, book.getId());
            prep.execute();

            conection.commit();
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //CONSULTAR
    public int consultarPorTitulo(Book book) {
        conectar();
        int idTmp = -1;
        String query = "SELECT * from livraria.Books "
                + "WHERE title = ?";
        try {
            PreparedStatement prep = conection.prepareStatement(query);
            prep.setString(1, book.getTitle());

            ResultSet list = prep.executeQuery();

            while (list.next()) {
                idTmp = list.getInt("id");
                break;
            }
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        book.setId(idTmp);
        return idTmp;
    }
    
    //Listar
    public List listar(String params) {
        conectar();
        List<Book> listaLivros = new ArrayList<>();
        String query = "SELECT * from livraria.Books " + params;

        try {
            PreparedStatement prep = conection.prepareStatement(query);
            ResultSet lista = prep.executeQuery();

            while (lista.next()) {
                Book book = new Book();
                book.setId(lista.getInt("id"));
                book.setTitle(lista.getString("title"));
                book.setAuthor(lista.getString("author"));
                book.setPublisher(lista.getString("publisher"));
                book.setEmail(lista.getString("email"));
                listaLivros.add(book);
            }
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaLivros;
    }
    
    public int verificaID(Book book){
        conectar();
        int idTmp = -1;
        String query = "SELECT * from livraria.Books "
                + "WHERE id = ?";
        try {
            PreparedStatement prep = conection.prepareStatement(query);
            prep.setInt(1, book.getId());

            ResultSet list = prep.executeQuery();

            while (list.next()) {
                idTmp = list.getInt("id");
                break;
            }
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        book.setId(idTmp);
        return idTmp;
    }
}
