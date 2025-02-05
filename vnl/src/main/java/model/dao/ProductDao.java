package model.dao;

import model.javabeans.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDao extends AbstractDAO{

    public boolean doSave(Product product){
        try (Connection connection = getConnection();
             PreparedStatement ps= prepareStatement(connection, "INSERT_USER")){

            ps.setString(1, product.getId());
            ps.setFloat(2, product.getPrezzo());
            ps.setString(3, product.getDescrizione());
            ps.setString(4, product.getCondizione());
            ps.setString(5, product.getTipo());
            ps.setString(6, product.getMarca());
            ps.setString(7, product.getModello());
            ps.setString(8, product.getNomeVnl());
            ps.setString(9, product.getArtista());
            ps.setString(10, product.getGenere());



            int rowsAffected=  ps.executeUpdate();
            return rowsAffected>0;


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;

        }




    }
}
