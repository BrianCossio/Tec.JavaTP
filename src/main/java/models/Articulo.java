package models;

public class Articulo {
int id;
String nombre;
String descripcion;
double precio;


public Articulo() {
	//super();
}

public Articulo(String nombre, String descripcion, double precio) {
	super();
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.precio = precio;
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
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}

@Override
public String toString() {
	return "Articulo [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + "]";
}


}
