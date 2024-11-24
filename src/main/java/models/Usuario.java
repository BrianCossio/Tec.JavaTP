package models;

public class Usuario {
	int id;
	String nombre;
	int contrase�a;
	public Usuario(String nombre, int contrase�a) {
		super();
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
	public int getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(int contrase�a) {
		this.contrase�a = contrase�a;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrase�a=" + contrase�a + "]";
	}
	
	

}
