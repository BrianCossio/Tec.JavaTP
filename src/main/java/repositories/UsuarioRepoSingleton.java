package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Usuario;
import repositories.interfaces.UsuarioRepo;

public class UsuarioRepoSingleton implements UsuarioRepo {

   
    private static UsuarioRepoSingleton singleton2;

    public static UsuarioRepoSingleton getInstance() {
        if (singleton2 == null) {
            singleton2 = new UsuarioRepoSingleton();
        }
        return singleton2;
    }

    
    private List<Usuario> listaUsuarios;

    
    private UsuarioRepoSingleton() {
        this.listaUsuarios = new ArrayList<Usuario>();
        
        
        Usuario usuario1 = new Usuario("admin", "123");
        Usuario usuario2 = new Usuario("user", "123");
        
        
        this.insert(usuario1);
        this.insert(usuario2);
    }

    
    @Override
    public List<Usuario> getAll() {
        return new ArrayList<Usuario>(this.listaUsuarios);
    }

    @Override
    public Usuario findById(int id) {
        return this.listaUsuarios.stream()
                .filter((p) -> p.getId() == id)
                .findAny()
                .orElse(null);
    }

    
    @Override
    public void insert(Usuario usuario) {
        int ultimaId = this.listaUsuarios.stream()
                .map(Usuario::getId)
                .max(Integer::compare)
                .orElse(0);

        usuario.setId(ultimaId + 1);
        this.listaUsuarios.add(usuario);
    }

    
    @Override
    public void delete(int id) {
        this.listaUsuarios.removeIf((p) -> p.getId() == id);
    }

    
    public Usuario findByUsernameAndPassword(String nombre, String contraseña) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null;  
    }
}
