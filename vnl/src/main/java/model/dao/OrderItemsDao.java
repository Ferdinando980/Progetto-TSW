package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.javabeans.OrderItems;

public class OrderItemsDao extends AbstractDAO {

    public boolean doSave(OrderItems orderItems) {

        try (Connection connection = getConnection();
                PreparedStatement ps = prepareStatement(connection, "INSERT_ORDERITEMS")) {

            ps.setInt(1,Integer.parseInt(orderItems.getOrdine_id()));
            ps.setInt(2, Integer.parseInt(orderItems.getOrdine_users()));
            ps.setInt(3, Integer.parseInt(orderItems.getProdotto()));
            ps.setInt(4, orderItems.getQuantita());
            ps.setFloat(5, orderItems.getPrezzo());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;

        }

    }

    public boolean doUpdate(OrderItems orderItems) {

        try (Connection connection = getConnection();
                PreparedStatement ps = prepareStatement(connection, "UPDATE_ORDERITEMS")) {

            ps.setInt(4, orderItems.getQuantita());
            ps.setFloat(5, orderItems.getPrezzo());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(OrderItems orderItems) {

        try (Connection connection = getConnection();
                PreparedStatement ps = prepareStatement(connection, "DELETE_ORDERITEMS")) {

            ps.setInt(1, Integer.parseInt(orderItems.getOrdine_id()));
            ps.setInt(2, Integer.parseInt(orderItems.getOrdine_users()));
            ps.setInt(3, Integer.parseInt(orderItems.getProdotto()));

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public OrderItems doRetrieveByKey(String ordine_id, String ordine_users, String prodotto) {

        try (Connection connection = getConnection();
                PreparedStatement ps = prepareStatement(connection, "GET_ORDERITEMS_BY_ORDER")) {
            {

                ps.setInt(1, Integer.parseInt(ordine_id));
                ps.setInt(2, Integer.parseInt(ordine_users));
                ps.setInt(3, Integer.parseInt(prodotto));

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    OrderItems orderItems = new OrderItems();

                    orderItems.setOrdine_id(""+rs.getInt("ordine_id"));
                    orderItems.setOrdine_users(""+rs.getInt("ordine_users"));
                    orderItems.setProdotto(""+rs.getInt("prodotto"));
                    orderItems.setQuantita(rs.getInt("quantita"));
                    orderItems.setPrezzo(rs.getFloat("prezzo"));

                    return orderItems;
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

}
