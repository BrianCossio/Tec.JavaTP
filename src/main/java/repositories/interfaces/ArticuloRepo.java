package repositories.interfaces;

import java.util.List;

import models.Articulo;

public interface ArticuloRepo {
	
	public List<Articulo> getAll();
	
	public Articulo findById(int id);
	
	public void insert (Articulo articulo);
	
	public void update (Articulo articulo); //ESTO ES PARA BASE DE DATOS CREO xddd
	
	public void delete(int id);

}
