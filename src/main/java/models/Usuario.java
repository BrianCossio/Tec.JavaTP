package models;

public class Usuario {
	int id;
	String nombre;
	int contraseña;
	public Usuario(String nombre, int contraseña) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
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
	public int getContraseña() {
		return contraseña;
	}
	public void setContraseña(int contraseña) {
		this.contraseña = contraseña;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contraseña=" + contraseña + "]";
	}
	
	

}
