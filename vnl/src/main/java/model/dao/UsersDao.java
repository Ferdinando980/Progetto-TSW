package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.javabeans.Users;


public class UsersDao extends AbstractDAO{

        public boolean doSave(Users user){
            try (Connection connection = getConnection();
            PreparedStatement ps= prepareStatement(connection, "INSERT_USER")){

           
                ps.setString(1, user.getUserId());
                ps.setString(2, user.getUsername());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPassword());
                ps.setString(5, user.getDataDiNascita());
                ps.setString(6, user.getNumeroDiTelefono());
                ps.setString(7, user.getTipo());
     

        
                int rowsAffected=  ps.executeUpdate();
                return rowsAffected>0;
                
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            
            }
     
            


        }

        public boolean doUpdate(Users user){

            try (Connection connection = getConnection();
            PreparedStatement ps= prepareStatement(connection, "UPDATE_USER")){

                ps.setString(2, user.getUsername());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPassword());
                ps.setString(5, user.getDataDiNascita());
                ps.setString(6, user.getNumeroDiTelefono());
                ps.setString(7, user.getTipo());
     

                
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
            Users user= null;
                
            try (Connection connection = getConnection();
                 PreparedStatement ps = prepareStatement(connection,"GET_USER_BY_ID" )){
    
                ps.setString(1, id);
                ResultSet result=  ps.executeQuery();
             

                if(result.next()){
                 user= new Users();   
                user.setUserId(result.getString("user_id"));
                user.setUsername(result.getString("username"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setDataDiNascita(result.getString("data_di_nascita"));
                user.setNumeroDiTelefono(result.getString("numero_di_telefono"));
                user.setTipo(result.getString("tipo"));
                }
           
                
                
               

                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            return user;


        }

        public List<Users> doRetrieveAll(){
            List<Users> usersList = new ArrayList<>();

            try (Connection connection = getConnection();
            PreparedStatement ps = prepareStatement(connection,"GET_ALL_USERS" )){

            ResultSet result= ps.executeQuery();
            while(result.next()){
                Users user = new Users();
                result.getString("id");
                result.getString("username");
                result.getString("password");
                result.getString("email");
                result.getDate("data_di_nascita");
                result.getString("numero_di_telefono");
                result.getString("tipo");
                
                usersList.add(user);

            }

                
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
            }

            return usersList;
        }



        public Users doRetrievebyEmail(String email){
            Users user= null;

            try (Connection connection = getConnection();
            PreparedStatement ps = prepareStatement(connection,"GET_USER_BY_EMAIL" )){

                ps.setString(1,email);

                ResultSet result=  ps.executeQuery();
             

                if(result.next()){
                    user= new Users();
                    user.setUserId(result.getString("id"));
                    user.setEmail(result.getString("email"));
                    user.setPassword(result.getString("password"));
                    user.setDataDiNascita(result.getString("data_di_nascita"));
                    user.setNumeroDiTelefono(result.getString("numero_di_telefono"));
                    user.setTipo(result.getString("tipo"));
                }


            }

            catch(SQLException e){
                System.out.println(e.getMessage());
            }


            return user;




        }
    }
     


        
    
    
