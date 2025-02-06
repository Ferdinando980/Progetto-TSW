package model.dao;

import model.javabeans.OrderItems;
import java.sql.*;

public class OrderItemsDao extends AbstractDAO{

    public boolean doSave(OrderItems orderItems){

        try (Connection connection = getConnection();
             PreparedStatement ps= prepareStatement(connection, "INSERT_ORDERITEMS")){

            ps.setString(1, orderItems.getOrdine_id());
            ps.setString(2, orderItems.getOrdine_users());
            ps.setString(3, orderItems.getProdotto());
            ps.setInt(4, orderItems.getQuantita());
            ps.setFloat(5, orderItems.getPrezzo());

            int rowsAffected=  ps.executeUpdate();
            return rowsAffected>0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;

        }

    }

    public boolean doUpdate(OrderItems orderItems){

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "UPDATE_ORDERITEMS")){

            ps.setInt(4, orderItems.getQuantita());
            ps.setFloat(5, orderItems.getPrezzo());

            int rowsAffected=  ps.executeUpdate();
            return rowsAffected>0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(OrderItems orderItems){

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "DELETE_ORDERITEMS")){

            ps.setString(1, orderItems.getOrdine_id());
            ps.setString(2, orderItems.getOrdine_users());
            ps.setString(3, orderItems.getProdotto());

            int rowsAffected=  ps.executeUpdate();
            return rowsAffected>0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public OrderItems doRetrieveByKey(String ordine_id, String ordine_users, String prodotto) {

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "SELECT_ORDERITEMS")) {

            ps.setString(1, ordine_id);
            ps.setString(2, ordine_users);
            ps.setString(3, prodotto);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                OrderItems orderItems = new OrderItems();

                orderItems.setOrdine_id(rs.getString("ordine_id"));
                orderItems.setOrdine_users(rs.getString("ordine_users"));
                orderItems.setProdotto(rs.getString("prodotto"));
                orderItems.setQuantita(rs.getInt("quantita"));
                orderItems.setPrezzo(rs.getFloat("prezzo"));

                return orderItems;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

}