package model.dao;

import model.javabeans.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDao extends AbstractDAO{

    public boolean doSave(Product product){
        try (Connection connection = getConnection();
             PreparedStatement ps= prepareStatement(connection, "INSERT_USER")){

            ps.setString(1, product.getProductId());




            int rowsAffected=  ps.executeUpdate();
            return rowsAffected>0;


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;

        }




    }
}
