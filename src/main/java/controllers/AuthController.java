package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repositories.UsuarioRepoSingleton;
import models.Usuario;

@WebServlet("/auth")
public class AuthController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioRepoSingleton usuarioRepo;

    public AuthController() {
        usuarioRepo = UsuarioRepoSingleton.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("usuario"); 
        String contraseña = request.getParameter("contraseña"); 

        
        Usuario usuario = usuarioRepo.findByUsernameAndPassword(nombre, contraseña);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);  
            response.sendRedirect("articulos");  
        } else {
            response.getWriter().write("Usuario o contraseña incorrectos");
        }
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
    }
}


