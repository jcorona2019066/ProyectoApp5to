package modeloDAO;

import configuracion.Conexion;
import interfaces.RolInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Persona;
import modelo.Rol;


public class RolDAO implements RolInterface {
    Conexion conect = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Rol bRol = new Rol();

    @Override
    public List listar() {
       ArrayList<Rol> listaRol = new ArrayList();
        String sql = "select * from rol";
        try{
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Rol rol = new Rol();
                rol.setCodigoRol(rs.getInt("codigoRol"));
                rol.setNombreRol(rs.getString("nombreRol"));
                listaRol.add(rol);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaRol;
    }

    @Override
    public Rol list(int id) {
       String sql = "select * from rol where codigoRol= "+id;
        try{
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                bRol.setCodigoRol(rs.getInt("codigoRol"));
                bRol.setNombreRol(rs.getString("nombreRol"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return bRol;
    }
    
    
    
}
