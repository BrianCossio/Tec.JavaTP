package controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Usuario;
import utils.ProyectoBuilder;

/**
 * Servlet implementation class CreacionProyectoController
 */
@WebServlet("/CreacionProyectoController")
public class CreacionProyectoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CreacionProyectoController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Usuario usuarioLogNulleable = (Usuario) session.getAttribute("usuario");
		Usuario usuarioLog=Optional.ofNullable(usuarioLogNulleable)
				.orElseThrow(()->new IOException("Usuario no logeado"));
		
		
		ProyectoBuilder proyecto = (ProyectoBuilder) session.getAttribute("proyecto");
		proyecto = Optional.ofNullable(proyecto).orElseGet(()->{
			ProyectoBuilder pro = new ProyectoBuilder(usuarioLog);
			session.setAttribute("proyecto", pro);
			return pro;
		});
		
		
		
		
		request.setAttribute("proyecto", proyecto);
		
		
		request.getRequestDispatcher("/views/creacion-proyecto/index.jsp").forward(request, response);
	

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		
		switch (accion) {
		case "modificarPresu" -> doModificarPresupuesto(request,response);
	
		default -> response.sendError(404);
		}
	}

	
	private void doModificarPresupuesto(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    HttpSession session = request.getSession();
	    ProyectoBuilder proyecto = (ProyectoBuilder) session.getAttribute("proyecto");
	    Usuario usuarioLogNulleable = (Usuario) session.getAttribute("usuario");
	    Usuario usuarioLog = Optional.ofNullable(usuarioLogNulleable).orElseThrow(() -> new IOException("Usuario no logeado"));

	    
	    proyecto = Optional.ofNullable(proyecto).orElseGet(() -> {
	        ProyectoBuilder pro = new ProyectoBuilder(usuarioLog);
	        session.setAttribute("proyecto", pro);
	        return pro;
	    });

	   
	    String sImporte = request.getParameter("importe");
	    
	    
	    if (sImporte != null && !sImporte.isEmpty()) {
	        try {
	            double importe = Double.parseDouble(sImporte);
	            proyecto.setPresupuesto(importe);
	            
	            session.setAttribute("proyecto", proyecto);
	        } catch (NumberFormatException e) {
	            response.getWriter().write("Valor de importe no válido");
	            return;
	        }
	    }

	 
	    request.setAttribute("proyecto", proyecto); 
	    request.getRequestDispatcher("/views/creacion-proyecto/index.jsp").forward(request, response);
	}


	}
