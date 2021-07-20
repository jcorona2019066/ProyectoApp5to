package modelo;

public class Usuario {
    public int codigoUsuario;
    public String usuario;
    public String contraseña;
    public int codigoRol;

    public Usuario() {
    }

    public Usuario(int codigoUsuario, String usuario, String contraseña, int codigoRol) {
        this.codigoUsuario = codigoUsuario;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.codigoRol = codigoRol;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(int codigoRol) {
        this.codigoRol = codigoRol;
    }

    
    
}
