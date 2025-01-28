package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBManager;



 public abstract class AbstractDAO{

    public AbstractDAO(){
    }

    protected Connection getConnection() throws SQLException {
        try {

            return DBManager.getConnection();
          
            
        } catch (SQLException e) {
              System.out.println(e.getMessage());
        }

        return null;
       
    }

    protected PreparedStatement prepareStatement(Connection conn, String queryId) throws SQLException{
        
        try {
        String sql = DBManager.requestToGetQueryString(queryId);
        return conn.prepareStatement(sql);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    
      
    }






}