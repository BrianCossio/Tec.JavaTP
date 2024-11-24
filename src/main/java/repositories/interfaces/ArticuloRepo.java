package repositories.interfaces;

import java.io.IOException;
import java.util.List;

import models.Articulo;

public interface ArticuloRepo {
	
	//throws por si se utiliza base de datos (entrada salida)
	
	public List<Articulo> getAll() throws IOException;
	
	public Articulo findById(int id) throws IOException;
	
	public void insert (Articulo articulo) throws IOException;
	
	public void update (Articulo articulo) throws IOException; 
	
	public void delete(int id)throws IOException ;

}
