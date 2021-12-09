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
public class DaoUser {
    
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
    
    public void cadastrar(User user) throws SQLException {
        conectar();

        String query = "INSERT INTO livraria.user (userName, userEmail, password) "
                + "VALUES (?,?,?)";
        PreparedStatement prep = conection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        prep.setString(1, user.getName());
        prep.setString(2, user.getEmail());
        prep.setString(3, user.getPassword());
        prep.execute();
        conection.commit();

        conection.close();
    }
    
    public int logar(User user){
        conectar();
        int idTmp = -1;
        String query = "SELECT * from livraria.user "
                + "WHERE userName = ? and password = ?";
        try {
            PreparedStatement prep = conection.prepareStatement(query);
            prep.setString(1, user.getName());
            prep.setString(2, user.getPassword());

            ResultSet list = prep.executeQuery();

            while (list.next()) {
                idTmp = list.getInt("userId");
                break;
            }
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        user.setId(idTmp);
        return idTmp;
    }
    
    public List dados(String params,User user) {
        conectar();
        List<User> listaDados = new ArrayList<>();
        String query = "SELECT * from livraria.user where userId = ?" + params;

        try {
            PreparedStatement prep = conection.prepareStatement(query);
            prep.setInt(1, user.getId());
            ResultSet lista = prep.executeQuery();

            while (lista.next()) {
                user.setId(lista.getInt("userId"));
                user.setName(lista.getString("userName"));
                user.setEmail(lista.getString("userEmail"));
                user.setPassword(lista.getString("password"));
                listaDados.add(user);
            }
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDados;
    }
    
    public void alterar(User user) throws SQLException {
        conectar();
        try {
            String query = "UPDATE livraria.user "
                    + "SET userName=?, userEmail=?, password=? WHERE userId=?";
            PreparedStatement prep = conection.prepareStatement(query);

            prep.setInt(4, user.getId());
            prep.setString(1, user.getName());
            prep.setString(2, user.getEmail());
            prep.setString(3, user.getPassword());
            prep.execute();

            conection.commit();
            conection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void excluir(User user) {
        conectar();
        try {
            String query = "DELETE FROM livraria.user "
                    + "WHERE userId=?";
            PreparedStatement prep = conection.prepareStatement(query);

            prep.setInt(1, user.getId());
            prep.execute();

            conection.commit();
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
