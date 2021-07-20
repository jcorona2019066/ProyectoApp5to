package interfaces;

import java.util.List;
import modelo.Usuario;

public interface UsuarioInterface {
    public List listar();
    public Usuario list(int id);
    public String validar(String usuario, String password, int codigoRol);
}
