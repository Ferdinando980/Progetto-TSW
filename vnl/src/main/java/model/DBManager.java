package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.TimeZone;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;


public class DBManager {

    private static DataSource ds;


    public static String requestToGetQueryString(String queryId){
        return QueryPool.getQueryString(queryId);
    }


    public static Connection getConnection() throws SQLException {
        if (ds == null) {

            PoolProperties properties = new PoolProperties();
            properties.setDriverClassName("com.mysql.cj.jdbc.Driver");
            properties.setUrl("jdbc:mysql://localhost:3306/vnl?serverTimezone=" + TimeZone.getDefault().getID());
            properties.setUsername("root");
            properties.setPassword("Ciao123");
            properties.setMaxActive(100);
            properties.setMaxIdle(50); 
            properties.setInitialSize(10);
            properties.setMinIdle(10);
            properties.setRemoveAbandonedTimeout(60);
            properties.setRemoveAbandoned(true);
    
            ds = new DataSource();
            ds.setPoolProperties(properties);
        }
    
        return ds.getConnection();
    }

}