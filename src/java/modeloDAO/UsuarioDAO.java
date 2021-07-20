package modeloDAO;

import configuracion.Conexion;
import interfaces.UsuarioInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Rol;
import modelo.Usuario;


public class UsuarioDAO implements UsuarioInterface {
    Conexion conect = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs = null;
    Usuario vUsuario = new Usuario();
    String alternativa = "";

    @Override
    public List listar() {
         ArrayList<Usuario> listaUsuario = new ArrayList();
        String sql = "select * from Usuario";
        try{
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setCodigoUsuario(rs.getInt("codigoUsuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setCodigoRol(rs.getInt("CodigoRol"));
                listaUsuario.add(usuario);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaUsuario;
    }

    @Override
    public Usuario list(int id) {
        String sql = "select * from usuario where codigoUsuario= "+id;
        try{
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                vUsuario.setCodigoUsuario(rs.getInt("codigoUsuario"));
                vUsuario.setUsuario(rs.getString("usuario"));
                vUsuario.setContraseña(rs.getString("contraseña"));
                vUsuario.setCodigoRol(rs.getInt("codigoRol"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return vUsuario;
    }
    

    @Override
    public String validar(String usuario, String password, int codigoRol) {
          try{
            String sql = "select * from Usuario where usuario = ? and contraseña = ? and codigoRol = ?";
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            ps.setInt(3, codigoRol);
            rs = ps.executeQuery();
            while (rs.next()){
                if (rs.getInt("codigoRol") == 1){
                    alternativa = "admin";
                }else if (rs.getInt("codigoRol") == 2){
                    alternativa = "user";
                }else{
                    alternativa = null;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return alternativa;
    }
    }
    
    

 
    

