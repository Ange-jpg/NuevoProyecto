package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public login log(String Usuario, String Pass){
        login lo = new login();
        String sql = "SELECT * FROM usuarios Where Usuario=? AND Pass=?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, Usuario);
            ps.setString(2, Pass);
            rs = ps.executeQuery();
            if (rs.next()){
                lo.setId(rs.getInt("idUsuario"));
                lo.setDni(rs.getString("Dni"));
                lo.setNom(rs.getString("Nombres"));
                lo.setTel(rs.getInt("Teléfono"));
                lo.setUsu(rs.getString("Usuario"));
                lo.setDir(rs.getString("Dirección"));
                lo.setCor(rs.getString("Correo"));
                lo.setPass(rs.getString("Pass"));               
            }
        }catch(SQLException e){
            System.out.print(e.toString());
        }
        return lo;
    }
}
