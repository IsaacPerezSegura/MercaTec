package Model;

/**
 *
 * @author Aideé Alvarez
 */
public class Usuario {
    private int idUsuario;
    private String nombre;
    private String usuario;
    private String contraseña;
    private String tipo;
    private String correo;
    private int status;

    public Usuario(int idUsuario, String nombre, String usuario, String contraseña, String tipo, String correo, int status) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
        this.correo = correo;
        this.status = status;
    }
    public Usuario(int idUsuario, String nombre, String usuario, String contraseña, String tipo, String correo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
        this.correo = correo;
    }
    
    public Usuario(){
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}