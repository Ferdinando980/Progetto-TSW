package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import model.javabeans.Product;

public class ProductDao extends AbstractDAO{

    public boolean doSave(Product product){
        try (Connection connection = getConnection();
             PreparedStatement ps= prepareStatement(connection, "INSERT_PRODUCT")){

    
                ps.setFloat(1, product.getPrezzo());
                ps.setString(2, product.getDescrizione());
                ps.setString(3, product.getCondizione());
                ps.setString(4, product.getTipo());
                ps.setString(6, product.getNomeVnl());  
        
               
                if ("vinile".equalsIgnoreCase(product.getTipo()) || "cd".equalsIgnoreCase(product.getTipo())) {
                    ps.setNull(5,Types.VARCHAR);
                    ps.setString(7, product.getArtista());  
                    ps.setString(8, product.getGenere());   
           
                } else if ("giradischi".equalsIgnoreCase(product.getTipo())) {
                    ps.setString(5, product.getMarca());
                    ps.setNull(7, Types.VARCHAR); 
                    ps.setNull(8, Types.VARCHAR); 
                
                } else {
                    throw new IllegalArgumentException("Invalid product type: " + product.getTipo());
                }
        
                ps.setString(9, product.getImg());


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

            ps.setFloat(1, product.getPrezzo());
            ps.setString(2, product.getDescrizione());
            ps.setString(3, product.getCondizione());
            ps.setString(4, product.getTipo());
            ps.setString(5, product.getMarca());
            ps.setString(6, product.getNomeVnl());
            ps.setString(9, product.getImg());

                     
            if ("vinile".equalsIgnoreCase(product.getTipo()) || "cd".equalsIgnoreCase(product.getTipo())) {
                ps.setNull(5,Types.VARCHAR);
                ps.setString(7, product.getArtista());  
                ps.setString(8, product.getGenere());   
       
            } else if ("giradischi".equalsIgnoreCase(product.getTipo())) {
                ps.setString(5, product.getMarca());
                ps.setNull(7, Types.VARCHAR); 
                ps.setNull(8, Types.VARCHAR); 
            
            } else {
                throw new IllegalArgumentException("Invalid product type: " + product.getTipo());
            }
            ps.setInt(10,product.getId());
    

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

            ps.setInt(1, product.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public Product doRetrieveById(int id){
        Product product = null;

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection,"GET_PRODUCT_BY_ID" )){

            ps.setInt(1, id);
            ResultSet result=  ps.executeQuery();


            if(result.next()){
                product= new Product();
                product.setId(result.getInt("id"));
                product.setPrezzo(result.getFloat("prezzo"));
                product.setDescrizione(result.getString("descrizione"));
                product.setCondizione(result.getString("condizione"));
                product.setTipo(result.getString("tipo"));
                product.setMarca(result.getString("marca"));
                product.setNomeVnl(result.getString("nomeVnl"));
                product.setArtista(result.getString("artista"));
                product.setGenere(result.getString("genere"));
                product.setImg(result.getString("img_path"));
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

                product.setId(result.getInt("id"));
                product.setPrezzo(result.getFloat("prezzo"));
                product.setDescrizione(result.getString("descrizione"));
                product.setCondizione(result.getString("condizione"));
                product.setTipo(result.getString("tipo"));
                product.setMarca(result.getString("marca"));
                product.setNomeVnl(result.getString("nomeVnl"));
                product.setArtista(result.getString("artista"));
                product.setGenere(result.getString("genere"));
                product.setImg(result.getString("img_path"));

                productsList.add(product);

            }


        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Products retrieved: " + productsList.size());

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

                product.setId(result.getInt("id"));
                product.setPrezzo(result.getFloat("prezzo"));
                product.setDescrizione(result.getString("descrizione"));
                product.setCondizione(result.getString("condizione"));
                product.setTipo(result.getString("tipo"));
                product.setMarca(result.getString("marca"));
                product.setNomeVnl(result.getString("nomeVnl"));
                product.setArtista(result.getString("artista"));
                product.setGenere(result.getString("genere"));
                product.setImg(result.getString("img_path"));

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

                product.setId(result.getInt("id"));
                product.setPrezzo(result.getFloat("prezzo"));
                product.setDescrizione(result.getString("descrizione"));
                product.setCondizione(result.getString("condizione"));
                product.setTipo(result.getString("tipo"));
                product.setMarca(result.getString("marca"));
                product.setNomeVnl(result.getString("nomeVnl"));
                product.setArtista(result.getString("artista"));
                product.setGenere(result.getString("genere"));
                product.setImg(result.getString("img_path"));

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

                product.setId(result.getInt("id"));
                product.setPrezzo(result.getFloat("prezzo"));
                product.setDescrizione(result.getString("descrizione"));
                product.setCondizione(result.getString("condizione"));
                product.setTipo(result.getString("tipo"));
                product.setMarca(result.getString("marca"));
                product.setNomeVnl(result.getString("nomeVnl"));
                product.setArtista(result.getString("artista"));
                product.setGenere(result.getString("genere"));
                product.setImg(result.getString("img_path"));

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
                product.setId(result.getInt("id"));
                product.setPrezzo(result.getFloat("prezzo"));
                product.setDescrizione(result.getString("descrizione"));
                product.setCondizione(result.getString("condizione"));
                product.setTipo(result.getString("tipo"));
                product.setMarca(result.getString("marca"));
                product.setNomeVnl(result.getString("nomeVnl"));
                product.setArtista(result.getString("artista"));
                product.setGenere(result.getString("genere"));
                product.setImg(result.getString("img_path"));
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
                product.setId(result.getInt("id"));
                product.setPrezzo(result.getFloat("prezzo"));
                product.setDescrizione(result.getString("descrizione"));
                product.setCondizione(result.getString("condizione"));
                product.setTipo(result.getString("tipo"));
                product.setMarca(result.getString("marca"));
                product.setNomeVnl(result.getString("nomeVnl"));
                product.setArtista(result.getString("artista"));
                product.setGenere(result.getString("genere"));
                product.setImg(result.getString("img_path"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return product;
    }

    public ArrayList<Product> searchProducts(String keyword){
        ArrayList<Product> searchResults = new ArrayList<>();

        
        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection,"SEARCH_PRODUCT" )){
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");

            ResultSet result= ps.executeQuery();
            while(result.next()){
                Product product = new Product();

                product.setId(result.getInt("id"));
                product.setPrezzo(result.getFloat("prezzo"));
                product.setDescrizione(result.getString("descrizione"));
                product.setCondizione(result.getString("condizione"));
                product.setTipo(result.getString("tipo"));
                product.setMarca(result.getString("marca"));
                product.setNomeVnl(result.getString("nomeVnl"));
                product.setArtista(result.getString("artista"));
                product.setGenere(result.getString("genere"));
                product.setImg(result.getString("img_path"));

                searchResults.add(product);

            }


        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Search Results: " + searchResults.size());

        return searchResults;
    }


    


    public ArrayList<Product> getProductbyTypeandCondition(String tipo, String condizione){

        ArrayList<Product> filterResults = new ArrayList<>();

        
        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection,"FILTER_PRODUCTS" )){
                ps.setString(1,tipo);
                ps.setString(2, condizione);
            

            ResultSet result= ps.executeQuery();
            while(result.next()){
                Product product = new Product();

                product.setId(result.getInt("id"));
                product.setPrezzo(result.getFloat("prezzo"));
                product.setDescrizione(result.getString("descrizione"));
                product.setCondizione(result.getString("condizione"));
                product.setTipo(result.getString("tipo"));
                product.setMarca(result.getString("marca"));
                product.setNomeVnl(result.getString("nomeVnl"));
                product.setArtista(result.getString("artista"));
                product.setGenere(result.getString("genere"));
                product.setImg(result.getString("img_path"));

                filterResults.add(product);

            }


        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Search Results: " + filterResults.size());

        return filterResults;


    }

}
