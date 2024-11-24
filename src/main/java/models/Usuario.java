package models;

public class Usuario {
    int id;
    String nombre;
    String contrase�a; 

    public Usuario(String nombre, String contrase�a) {
        this.nombre = nombre;
        this.contrase�a = contrase�a;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrase�a() {
        return contrase�a;
    }

    public void setContrase�a(String contrase�a) {
        this.contrase�a = contrase�a;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", contrase�a=" + contrase�a + "]";
    }
}
