package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
    
    public int IdVenta(){
        int id = 0;
        String sql = "SELECT MAX(idVentas) FROM ventas";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return id;
    }
    
    public int RegistrarVenta(Venta v){
        String sql = "INSERT INTO ventas (Cliente, Vendedor, Total) VALUES (?, ?, ?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getCli());
            ps.setString(2, v.getVen());
            ps.setDouble(3, v.getTol());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    public int RegistrarDetalle(Detalle Dv){
        String sql = "INSERT INTO detalle_ventas (idVentas, idProducto, Cantidad, PrecioVenta, CodigoProd) VALUES (?, ?, ?, ?, ?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Dv.getIdv());
            ps.setInt(2, Dv.getIdp());
            ps.setInt(3, Dv.getCant());
            ps.setDouble(4, Dv.getPre());
            ps.setString(5, Dv.getCodp());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    public boolean ActualizarStock(int cant, String cod){
        String sql = "UPDATE producto SET Stock=?, WHERE Código=?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List ListarVentas(){
        List<Venta> ListaVenta = new ArrayList();
        String sql = "SELECT * FROM ventas";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Venta vent = new Venta();
                vent.setId(rs.getInt("idVentas"));
                vent.setCli(rs.getString("Cliente"));
                vent.setVen(rs.getString("Vendedor"));
                vent.setTol(rs.getDouble("Total"));
                ListaVenta.add(vent);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaVenta;
    }
}
