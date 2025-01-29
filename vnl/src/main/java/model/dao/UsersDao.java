package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.javabeans.Users;


public class UsersDao extends AbstractDAO{

        public boolean doSave(Users user){
            try (Connection connection = getConnection();
            PreparedStatement ps= prepareStatement(connection, "INSERT_USER")){
    
                ps.setString(1, user.getUserId());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getDataDiNascita());
                ps.setString(5, user.getNumeroDiTelefono());
     

        
                int rowsAffected=  ps.executeUpdate();
                return rowsAffected>0;
                
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            
            }
     
            


        }

        public boolean doUpdate(Users user){

            try (Connection connection = getConnection();
            PreparedStatement ps= prepareStatement(connection, "INSERT_USER")){
    
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getDataDiNascita());
                ps.setString(5, user.getNumeroDiTelefono());
     

                
                int rowsAffected=  ps.executeUpdate();
                return rowsAffected>0;
                
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            
            }
     


        }

        public boolean delete(Users user){
        
    
            try (Connection connection = getConnection();
                 PreparedStatement ps = prepareStatement(connection,"DELETE_USER" )){
    
                ps.setString(1, user.getUserId());
                int rowsAffected=  ps.executeUpdate();
                return rowsAffected>0;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }

        public Users doRetrieveById(String id){
                
            try (Connection connection = getConnection();
                 PreparedStatement ps = prepareStatement(connection,"GET_USER_BY_ID" )){
    
                ps.setString(1, id);
                ResultSet result=  ps.executeQuery();
                Users user= new Users();

                while( result.next()){
                       
                user.setUserId(result.getString("user_id"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password_hash"));
                user.setDataDiNascita(result.getString("data_di_nascita"));
                    user.setNumeroDiTelefono(result.getString("numero_di_telefono"));
                }
           
                
                
                return user;

                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return null;
            }


        }
    }


        
    
    
