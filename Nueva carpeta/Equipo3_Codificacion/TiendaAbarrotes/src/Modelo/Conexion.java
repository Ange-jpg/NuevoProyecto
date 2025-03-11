package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    public Connection getConnection(){
        try {
            String sql = "jdbc:mysql://localhost:3306/bdtiendaabarrotes";
            con = DriverManager.getConnection(sql, "root", "jasser21");
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
    
}
