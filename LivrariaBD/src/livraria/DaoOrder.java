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
public class DaoOrder {
    
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
    
    public void insert(int idUsu,int idLivro) throws SQLException {
        conectar();

        java.util.Date date=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
        String query = "INSERT INTO livraria.orderP (orderDate, orderTime, idUsuario, idLivro) "
                + "VALUES (?,?,?,?)";
        PreparedStatement prep = conection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        prep.setDate(1,sqlDate);
        prep.setTimestamp(2,sqlTime);
        prep.setInt(3,idUsu);
        prep.setInt(4,idLivro);
        prep.execute();
        conection.commit();

        conection.close();
    }
    
    public List listarPedido(String params) {
        conectar();
        List<Order> listaPedidos = new ArrayList<>();
        String query = "SELECT * from livraria.orderP " + params;

        try {
            PreparedStatement prep = conection.prepareStatement(query);
            ResultSet lista = prep.executeQuery();

            while (lista.next()) {
                Order order = new Order();
                order.setId(lista.getInt("orderId"));
                order.setIdUsu(lista.getInt("idUsuario"));
                order.setIdLiv(lista.getInt("idLivro"));
                order.setDate(lista.getDate("orderDate"));
                order.setTime(lista.getTime("orderTime"));
                listaPedidos.add(order);
            }
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPedidos;
    }
    
    public void deletaPedido(Order order) {
        conectar();
        try {
            String query = "DELETE FROM livraria.orderP "
                    + "WHERE orderId=?";
            PreparedStatement prep = conection.prepareStatement(query);

            prep.setInt(1, order.getId());
            prep.execute();

            conection.commit();
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int verificaIDPedido(Order order){
    conectar();
        int idTmp = -1;
        String query = "SELECT * from livraria.orderP "
                + "WHERE orderId = ?";
        try {
            PreparedStatement prep = conection.prepareStatement(query);
            prep.setInt(1, order.getId());

            ResultSet list = prep.executeQuery();

            while (list.next()) {
                idTmp = list.getInt("orderId");
                break;
            }
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        order.setId(idTmp);
        return idTmp;
    }
}
