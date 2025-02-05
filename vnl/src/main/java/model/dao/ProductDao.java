package model.dao;

import model.javabeans.Product;
import model.javabeans.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends AbstractDAO{

    public boolean doSave(Product product){
        try (Connection connection = getConnection();
             PreparedStatement ps= prepareStatement(connection, "INSERT_PRODUCT")){

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

    public boolean doUpdate(Product product){

        try (Connection connection = getConnection();
             PreparedStatement ps= prepareStatement(connection, "UPDATE_PRODUCT")){

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

    public boolean delete(Product product) {
        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "DELETE_PRODUCT")) {

            ps.setString(1, product.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public Product doRetrieveById(String id){
        Product product = null;

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection,"GET_PRODUC_BY_ID" )){

            ps.setString(1, id);
            ResultSet result=  ps.executeQuery();


            if(result.next()){
                product= new Product();
                product.setId(result.getNString("id"));
                product.setPrezzo(result.getFloat("prezzo"));
                product.setDescrizione(result.getString("descrizione"));
                product.setCondizione(result.getString("condizione"));
                product.setTipo(result.getString("tipo"));
                product.setMarca(result.getString("marca"));
                product.setModello(result.getString("modello"));
                product.setNomeVnl(result.getString("nome_vnl"));
                product.setArtista(result.getString("artista"));
                product.setGenere(result.getString("genere"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return product;
    }

    public ArrayList<Product> doRetrieveAll(){
        ArrayList<Product> productsList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection,"GET_ALL_PRODUCTS" )){

            ResultSet result= ps.executeQuery();
            while(result.next()){
                Product product = new Product();

                product.setId(result.getNString("id"));
                product.setPrezzo(result.getFloat("prezzo"));
                product.setDescrizione(result.getString("descrizione"));
                product.setCondizione(result.getString("condizione"));
                product.setTipo(result.getString("tipo"));
                product.setMarca(result.getString("marca"));
                product.setModello(result.getString("modello"));
                product.setNomeVnl(result.getString("nome_vnl"));
                product.setArtista(result.getString("artista"));
                product.setGenere(result.getString("genere"));

                productsList.add(product);

            }


        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return productsList;
    }

    public ArrayList<Product> doRetrievebyGenere(String genere){
        ArrayList<Product> productsList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection,"GET_PRODUCT_BY_GENERE" )){

            ps.setString(1, genere);
            ResultSet result= ps.executeQuery();
            while(result.next()){
                Product product = new Product();

                product.setId(result.getString("id"));
                product.setPrezzo(result.getFloat("prezzo"));
                product.setDescrizione(result.getString("descrizione"));
                product.setCondizione(result.getString("condizione"));
                product.setTipo(result.getString("tipo"));
                product.setMarca(result.getString("marca"));
                product.setModello(result.getString("modello"));
                product.setNomeVnl(result.getString("nome_vnl"));
                product.setArtista(result.getString("artista"));
                product.setGenere(result.getString("genere"));

                productsList.add(product);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return productsList;
    }

    public ArrayList<Product> doRetrievebyArtista(String artista){
        ArrayList<Product> productsList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection,"GET_PRODUCT_BY_ARTISTA" )){

            ps.setString(1, artista);
            ResultSet result= ps.executeQuery();
            while(result.next()){
                Product product = new Product();

                product.setId(result.getString("id"));
                product.setPrezzo(result.getFloat("prezzo"));
                product.setDescrizione(result.getString("descrizione"));
                product.setCondizione(result.getString("condizione"));
                product.setTipo(result.getString("tipo"));
                product.setMarca(result.getString("marca"));
                product.setModello(result.getString("modello"));
                product.setNomeVnl(result.getString("nome_vnl"));
                product.setArtista(result.getString("artista"));
                product.setGenere(result.getString("genere"));

                productsList.add(product);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return productsList;
    }

    public ArrayList<Product> doRetrievebyMarca(String marca){
        ArrayList<Product> productsList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection,"GET_PRODUCT_BY_MARCA" )){

            ps.setString(1, marca);
            ResultSet result= ps.executeQuery();
            while(result.next()){
                Product product = new Product();

                product.setId(result.getString("id"));
                product.setPrezzo(result.getFloat("prezzo"));
                product.setDescrizione(result.getString("descrizione"));
                product.setCondizione(result.getString("condizione"));
                product.setTipo(result.getString("tipo"));
                product.setMarca(result.getString("marca"));
                product.setModello(result.getString("modello"));
                product.setNomeVnl(result.getString("nome_vnl"));
                product.setArtista(result.getString("artista"));
                product.setGenere(result.getString("genere"));

                productsList.add(product);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return productsList;
    }

    public Product doRetrieveByNomeVnl(String nomeVnl){
        Product product = null;

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection,"GET_PRODUCT_BY_NOMEVNL" )){

            ps.setString(1, nomeVnl);
            ResultSet result=  ps.executeQuery();


            if(result.next()){
                product= new Product();
                product.setId(result.getNString("id"));
                product.setPrezzo(result.getFloat("prezzo"));
                product.setDescrizione(result.getString("descrizione"));
                product.setCondizione(result.getString("condizione"));
                product.setTipo(result.getString("tipo"));
                product.setMarca(result.getString("marca"));
                product.setModello(result.getString("modello"));
                product.setNomeVnl(result.getString("nome_vnl"));
                product.setArtista(result.getString("artista"));
                product.setGenere(result.getString("genere"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return product;
    }

    public Product doRetrieveByModello(String modello){
        Product product = null;

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection,"GET_PRODUCT_BY_MODELLO" )){

            ps.setString(1, modello);
            ResultSet result=  ps.executeQuery();


            if(result.next()){
                product= new Product();
                product.setId(result.getNString("id"));
                product.setPrezzo(result.getFloat("prezzo"));
                product.setDescrizione(result.getString("descrizione"));
                product.setCondizione(result.getString("condizione"));
                product.setTipo(result.getString("tipo"));
                product.setMarca(result.getString("marca"));
                product.setModello(result.getString("modello"));
                product.setNomeVnl(result.getString("nome_vnl"));
                product.setArtista(result.getString("artista"));
                product.setGenere(result.getString("genere"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return product;
    }

}
