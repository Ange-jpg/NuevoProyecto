package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class ProductosDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProductos(Productos pro){
        String sql = "INSERT INTO producto (Código, Descripción, Proveedor, Stock, Precio, Contenido) VALUES (?, ?, ?, ?, ?, ?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCod());
            ps.setString(2, pro.getDes());
            ps.setString(3, pro.getPro());
            ps.setInt(4, pro.getSto());
            ps.setDouble(5, pro.getPre());
            ps.setInt(6, pro.getCont());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    public void ConsultarProveedor(JComboBox proveedor){
        String sql = "SELECT Nombres FROM proveedor";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                proveedor.addItem(rs.getString("Nombres"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    public List ListarProductos(){
        List<Productos> Listapro = new ArrayList();
        String sql = "SELECT * FROM producto";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos pro = new Productos();
                pro.setId(rs.getInt("idProducto"));
                pro.setCod(rs.getString("Código"));
                pro.setDes(rs.getString("Descripción"));
                pro.setPro(rs.getString("Proveedor"));
                pro.setSto(rs.getInt("Stock"));
                pro.setPre(rs.getDouble("Precio"));
                pro.setCont(rs.getInt("Contenido"));
                Listapro.add(pro);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return Listapro;
    }
    
    public boolean EliminarProductos(int id){
        String sql = "DELETE FROM producto WHERE idProducto = ?";
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
    
    public boolean ModificarProductos(Productos pro){
        String sql = "UPDATE producto SET Código=?, Descripción=?, Proveedor=?, Stock=?, Precio=?, Contenido=? WHERE idProducto=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCod());
            ps.setString(2, pro.getDes());
            ps.setString(3, pro.getPro());
            ps.setInt(4, pro.getSto());
            ps.setDouble(5, pro.getPre());
            ps.setInt(6, pro.getCont());
            ps.setInt(7, pro.getId());
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
    
    public Productos BuscarPro(String cod){
        Productos producto = new Productos();
        String sql = "SELECT * FROM producto WHERE Código = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if(rs.next()){
                producto.setDes(rs.getString("Descripción"));
                producto.setPre(rs.getDouble("Precio"));
                producto.setSto(rs.getInt("Stock"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return producto;
    }
}
