package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.RepoFactory;
import models.Usuario;
import repositories.interfaces.UsuarioRepo;





/**
 * Servlet implementation class AuthController
 */
@WebServlet("/auth")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioRepo usuarioRepo;
       
   
    public AuthController() {
      RepoFactory factory = new RepoFactory();
      this.usuarioRepo= factory.getUsuarioRepo();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> listausuarios= usuarioRepo.getAll();
		request.setAttribute("usuario", listausuarios);
		
		
		request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//LA SESSION CARA
		String sId = request.getParameter("usuario_id");
		int id = Integer.parseInt(sId);
		 Usuario usua = usuarioRepo.findById(id);
		 
		 HttpSession session = request.getSession();
		 
		 session.setAttribute("usuario", usua);
		 
		 response.sendRedirect("articulos");
		 
		
	}

}
