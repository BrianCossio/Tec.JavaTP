package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Articulo;
import repositories.interfaces.ArticuloRepo;

public class ArticulosRepoSingleton implements ArticuloRepo {
	
	
	//convertir a singleton
	private static ArticulosRepoSingleton singleton;
	public static ArticulosRepoSingleton getInstance() {
		if(singleton == null) {
			singleton = new ArticulosRepoSingleton();
		}
		return singleton;
	}
	

	
private List<Articulo> listaArticulos;
	
	private ArticulosRepoSingleton() {
		this.listaArticulos = new ArrayList<Articulo>();
		Articulo articulo1 = new Articulo("Alfajor", "Triple", 1000);
		Articulo articulo2 = new Articulo("Agua", "de pozo", 1000);
		Articulo articulo3 = new Articulo("Coquita", "rica", 2000);
		this.insert(articulo1);
		this.insert(articulo2);
		this.insert(articulo3);
			
	}
	@Override
	public List<Articulo> getAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Articulo>(this.listaArticulos);
	}

	@Override
	public Articulo findById(int id) {
		
		return this.listaArticulos.stream()
		.filter((p)-> p.getId()== id)
		.findAny()
		.orElse(null);
		
//		return this.listaArticulos.stream()
//		.filter((p)-> p.getId()== id)
//		.findAny()
//		.orElseThrow(() -> new IllegalArgumentException("Artículo con ID " + id + " no encontrado"));
	}
	

	@Override
	public void insert(Articulo articulo) {
		
		 int ultimaId = this.listaArticulos.stream()
		            .map(Articulo::getId)
	            .max(Integer::compare)  
	            .orElse(0); 
		 
		 articulo.setId(ultimaId+1);
		 this.listaArticulos.add(articulo);
		
//	    // Verificar si el ID ya existe en la lista
//	    boolean existe = this.listaArticulos.stream()
//	            .anyMatch(p -> p.getId() == articulo.getId());
//
//	    if (existe) {
//	        System.out.println("El artículo con ID " + articulo.getId() + " ya existe.");
//	        return;  
//	    }
//
//	    
//	    if (articulo.getId() == 0) {  
//	        int ultimaId = this.listaArticulos.stream()
//	            .map(Articulo::getId)
//	            .max(Integer::compare)  
//	            .orElse(0); 
//	        
//	        
//	        articulo.setId(ultimaId + 1);
//	    }
//
//	   
//	    this.listaArticulos.add(articulo);
	}
		
		


	@Override
	public void update(Articulo articulo) {
		// Tengo entendido que esto no va porque no vamos a utilizar base de datos
		
	}

	@Override
	public void delete(int id) {
		this.listaArticulos.removeIf( (p)-> p.getId()== id);
		
	}

}
