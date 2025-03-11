package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarCliente(Cliente cl){
        String sql = "INSERT INTO cliente (Dni, Nombres, Teléfono, Dirección) VALUES (?, ?, ?, ?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNom());
            ps.setInt(3, cl.getTel());
            ps.setString(4, cl.getDir());
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    public List ListarCliente(){
        List<Cliente> ListaCl = new ArrayList();
        String sql = "SELECT * FROM cliente";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setId(rs.getInt("idCliente"));
                cl.setDni(rs.getString("Dni"));
                cl.setNom(rs.getString("Nombres"));
                cl.setTel(rs.getInt("Teléfono"));
                cl.setDir(rs.getString("Dirección"));
                ListaCl.add(cl);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaCl;
    }
    
    public boolean EliminarCliente(int id){
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }
    
    public boolean ModificarCliente(Cliente cl){
        String sql = "UPDATE cliente SET Dni=?, Nombres=?, Teléfono=?, Dirección=? WHERE idCliente=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNom());
            ps.setInt(3, cl.getTel());
            ps.setString(4, cl.getDir());
            ps.setInt(5, cl.getId());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
               con.close(); 
            }catch(SQLException e){
                System.out.println(e.toString());
            }   
        }
    }
    
    /*public Cliente BuscarCliente(int dni){
        Cliente cl = new Cliente();
        String sql = "SELECT * FROM cliente WHERE Dni = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            if(rs.next()){
                cl.setDni(rs.getString("Dni"));
                cl.setNom(rs.getString("Nombres"));
                cl.setTel(rs.getInt("Teléfono"));
                cl.setDir(rs.getString("Dirección"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return cl;
    }*/
}
