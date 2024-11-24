package factory;

import repositories.ArticulosRepoSingleton;
import repositories.UsuarioRepoSingleton;
import repositories.interfaces.ArticuloRepo;
import repositories.interfaces.UsuarioRepo;

public class RepoFactory {
	
	public ArticuloRepo getArticuloRepo() {
		
		return ArticulosRepoSingleton.getInstance();
	}
	
	public UsuarioRepo getUsuarioRepo() {
		return UsuarioRepoSingleton.getInstance();
	}

}
