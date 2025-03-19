package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.javabeans.Order;

public class OrderDao extends AbstractDAO {

    public boolean doSave(Order order){

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "INSERT_ORDER")){

            ps.setInt(1, Integer.parseInt(order.getUsers()));
            ps.setString(2, order.getStato());
            ps.setDate(3, (Date) order.getDataOrdine());
            ps.setFloat(4, order.getTotAmount());
            ps.setString(5, order.getNome());
            ps.setString(6, order.getCognome());
            ps.setString(7, order.getVia());
            ps.setString(8, order.getCivico());
            ps.setString(9, order.getCap());
            ps.setString(10, order.getPaese());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean doUpdate(Order order){

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "UPDATE_ORDER")){

            ps.setInt(1, Integer.parseInt(order.getUsers()));
            ps.setString(2, order.getStato());
            ps.setDate(3, (Date) order.getDataOrdine());
            ps.setFloat(4, order.getTotAmount());
            ps.setString(5, order.getNome());
            ps.setString(6, order.getCognome());
            ps.setString(7, order.getVia());
            ps.setString(8, order.getCivico());
            ps.setString(9, order.getCap());
            ps.setString(10, order.getPaese());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(Order order){

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "DELETE_ORDER")){

            ps.setString(1, order.getId());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Order doRetrieveById(String id) throws SQLException{

        Order order = null;

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ORDER_BY_ID")){

            ps.setString(1, id);
            ResultSet result = ps.executeQuery();
            if(result.next()){
                order = new Order();

                order.setId(result.getString("id"));
                order.setUsers(result.getString("users"));
                order.setStato(result.getString("stato"));
                order.setDataOrdine(result.getDate("dataOrdine"));
                order.setTotAmount(result.getFloat("totAmount"));
                order.setNome(result.getString("nome"));
                order.setCognome(result.getString("cognome"));
                order.setVia(result.getString("via"));
                order.setCivico(result.getString("civico"));
                order.setCap(result.getString("cap"));
                order.setPaese(result.getString("paese"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

    public ArrayList<Order> doRetrieveAll(){

        ArrayList<Order> ordersList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ALL_ORDERS")){

            ResultSet result = ps.executeQuery();
            while(result.next()){
                Order order = new Order();
                order.setId(result.getString("id"));
                order.setUsers(result.getString("users"));
                order.setStato(result.getString("stato"));
                order.setDataOrdine(result.getDate("dataOrdine"));
                order.setTotAmount(result.getFloat("totAmount"));
                order.setNome(result.getString("nome"));
                order.setCognome(result.getString("cognome"));
                order.setVia(result.getString("via"));
                order.setCivico(result.getString("civico"));
                order.setCap(result.getString("cap"));
                order.setPaese(result.getString("paese"));
                ordersList.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ordersList;
    }

    public ArrayList<Order> doRetrievebyUsers(String users){

        ArrayList<Order> ordersList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ORDERS_BY_USER")){

            ps.setString(1, users);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                Order order = new Order();
                order.setId(result.getString("id"));
                order.setUsers(result.getString("users"));
                order.setStato(result.getString("stato"));
                order.setDataOrdine(result.getDate("dataOrdine"));
                order.setTotAmount(result.getFloat("totAmount"));
                order.setNome(result.getString("nome"));
                order.setCognome(result.getString("cognome"));
                order.setVia(result.getString("via"));
                order.setCivico(result.getString("civico"));
                order.setCap(result.getString("cap"));
                order.setPaese(result.getString("paese"));
                ordersList.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ordersList;
    }

    public ArrayList<Order> doRetrievebyStato(String stato){

        ArrayList<Order> ordersList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ORDER_BY_STATO")){

            ps.setString(1, stato);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                Order order = new Order();
                order.setId(result.getString("id"));
                order.setUsers(result.getString("users"));
                order.setStato(result.getString("stato"));
                order.setDataOrdine(result.getDate("dataOrdine"));
                order.setTotAmount(result.getFloat("totAmount"));
                order.setNome(result.getString("nome"));
                order.setCognome(result.getString("cognome"));
                order.setVia(result.getString("via"));
                order.setCivico(result.getString("civico"));
                order.setCap(result.getString("cap"));
                order.setPaese(result.getString("paese"));
                ordersList.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ordersList;
    }

    public boolean updateOrderStatus(int orderId, String  stato){
        try (Connection connection = getConnection();
         PreparedStatement ps = prepareStatement(connection, "UPDATE_ORDER_STATUS")) {

        ps.setString(1, stato);
        ps.setInt(2, orderId);

        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        return false;
    }


    }



}