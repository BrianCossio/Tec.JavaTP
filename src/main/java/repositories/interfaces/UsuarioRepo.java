package repositories.interfaces;

import java.util.List;

import models.Usuario;

public interface UsuarioRepo {
	
	public List<Usuario> getAll();
	
	public Usuario findById(int id);
	
	public void insert (Usuario usuario);
	
	public void delete (int id);
	

}
