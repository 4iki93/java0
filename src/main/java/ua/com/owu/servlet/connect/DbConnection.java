package ua.com.owu.servlet.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {
    private String  url="jdbc:mysql://localhost:3306/db1600";
    private String  username="root";
    private String  password="root";

    Connection connection;
     public DbConnection (){
         try {
             this.connection = DriverManager.getConnection(url,username,password);
         } catch (SQLException e) {
             e.printStackTrace();
             //throw new
         }
     }

public  void save(String username){
    try {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USER (USERNAME) VALUES ('"+username+"')");
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        try {
            connection.rollback();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }


}

}
