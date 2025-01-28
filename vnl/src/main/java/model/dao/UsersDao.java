package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.javabeans.Users;


public class UsersDao extends AbstractDAO{

        public Users doSave(Users user){
            try {
                Connection connection= getConnection();
                PreparedStatement query= prepareStatement(connection, "INSERT_USER");
                
                
            } catch (Exception e) {
                // TODO: handle exception
            }
     
            


            return user;
        }


        
    
    
}
