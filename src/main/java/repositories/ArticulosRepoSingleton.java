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
		Articulo articulo1 = new Articulo("Alfajor", "Triple", 1700);
		Articulo articulo2 = new Articulo("Agua", "Manaos", 1000);
		Articulo articulo3 = new Articulo("Cerveza", "Brahma", 3000);
		Articulo articulo4 = new Articulo("Leche", "vaca contenta", 1500);
		Articulo articulo5 = new Articulo("Galletitas", "Oreo", 1900);
		Articulo articulo6 = new Articulo("Aromatizador", "Saphirus", 2000);
		Articulo articulo7 = new Articulo("Coquita", "Coca-cola", 1700);
		Articulo articulo8 = new Articulo("Leche", "vaca contenta", 1500);
		this.insert(articulo1);
		this.insert(articulo2);
		this.insert(articulo3);
		this.insert(articulo4);
		this.insert(articulo5);
		this.insert(articulo6);
		this.insert(articulo7);
		this.insert(articulo8);
			
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
//		.orElseThrow(() -> new IllegalArgumentException("Art�culo con ID " + id + " no encontrado"));
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
//	        System.out.println("El art�culo con ID " + articulo.getId() + " ya existe.");
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


