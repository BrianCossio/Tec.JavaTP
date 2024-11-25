package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.RepoFactory;
import models.Articulo;
import repositories.ArticulosRepoSingleton;
import repositories.interfaces.ArticuloRepo;

/**
 * Servlet implementation class ArticulosController
 */
@WebServlet("/articulos")
public class ArticulosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private ArticuloRepo articulosRepo;
	
	
    public ArticulosController() {
    	RepoFactory factory = new RepoFactory();
       this.articulosRepo=factory.getArticuloRepo(); 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		accion = Optional.ofNullable(accion).orElse("index");
		
		switch (accion) {
		case "index"  -> getIndex (request,response);
		case "bienvenida" ->getBienvenida(request,response);
		case "show" -> getShow(request,response);
		case "edit" -> getEdit(request,response);
		case "create" -> getCreate(request,response);
		
		
		
		default -> response.sendError(404);
		
		}
	}

	
	private void getBienvenida(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/articulos/bienvenida.jsp").forward(request, response);
		
	}


	private void getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/articulos/create.jsp").forward(request, response);
		
	}


	private void getEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId= request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		
		Articulo articu = articulosRepo.findById(id);
		
		request.setAttribute("articulo", articu);
		
		request.getRequestDispatcher("/views/articulos/edit.jsp").forward(request, response);
	}


	private void getShow(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String sId= request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		
		Articulo articu = articulosRepo.findById(id);
		
		request.setAttribute("articulo", articu);
		request.getRequestDispatcher("/views/articulos/show.jsp").forward(request, response);
	}


	private void getIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		List <Articulo> listaArt = articulosRepo.getAll();
		request.setAttribute("listita", listaArt);
		
		
		request.getRequestDispatcher("/views/articulos/index.jsp").forward(request, response);
		
	}


	private void postInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String sPrecio = request.getParameter("precio");
		double precio= Double.parseDouble(sPrecio);
		
		Articulo articu = new Articulo(nombre, descripcion, precio);
		
		articulosRepo.insert(articu);
	
		response.sendRedirect("articulos");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//LA EXCEPCION NO SE POR QUE NO ME FUNCIONA, bueno a veces si xdd
		String accion = request.getParameter("accion");
		if(accion==null) {
			response.sendError(400, "No hay accion");
			return;
		}
		//accion= Optional.ofNullable(accion).orElse("insert");
		switch (accion) {
		case "insert" -> postInsert(request,response);
		case "update" -> postUpdate(request,response);
		case "delete" -> postDelete(request,response);
		 case "agregarAlCarrito" -> postAgregarAlCarrito(request, response);
		 case "finalizarCompra" -> postFinalizarCompra(request, response);
		default -> response.sendError(404);
		
		}
//		String nombre = request.getParameter("nombre");
//		String descripcion = request.getParameter("descripcion");
//		String sPrecio = request.getParameter("precio");
//		double precio= Double.parseDouble(sPrecio);
//		
//		Articulo articu = new Articulo(nombre, descripcion, precio);
//		
//		articulosRepo.insert(articu);
//	
//		response.sendRedirect("articulos");
	}


	private void postDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sId= request.getParameter("id");
		int id= Integer.parseInt(sId);
		
		articulosRepo.delete(id);
		
		response.sendRedirect("articulos");
	}


	private void postUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    String sId = request.getParameter("id");
	    int id = Integer.parseInt(sId);  

	   
	    String nombre = request.getParameter("nombre");
	    String descripcion = request.getParameter("descripcion");
	    String sPrecio = request.getParameter("precio");
	    double precio = Double.parseDouble(sPrecio);  

	  
	    Articulo articulo = articulosRepo.findById(id);

	   
	    if (articulo != null) {
	        articulo.setNombre(nombre);  
	        articulo.setDescripcion(descripcion); 
	        articulo.setPrecio(precio);  

	       
	        articulosRepo.update(articulo);

	       
	        response.sendRedirect("articulos");
	    } else {
	       
	        response.getWriter().write("Artículo no encontrado para actualizar.");
	    }
	}
	
	private void postAgregarAlCarrito(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    String sId = request.getParameter("id");
	    int id = Integer.parseInt(sId);

	    Articulo articulo = articulosRepo.findById(id);

	    if (articulo != null) {
	        // Recuperar el carrito de la sesión
	        List<Articulo> carrito = (List<Articulo>) request.getSession().getAttribute("carrito");
	        if (carrito == null) {
	            carrito = new ArrayList<>();
	            request.getSession().setAttribute("carrito", carrito);
	        }

	        // Agregar el artículo al carrito
	        carrito.add(articulo);

	     // Calcular el total del carrito
	        double total = 0;
	        for (Articulo a : carrito) {
	            total += a.getPrecio();
	        }

	        // Establecer el total actualizado en la sesión con la clave correcta
	        request.getSession().setAttribute("totalCarrito", total);

	        // Eliminar el artículo del inventario
	        articulosRepo.delete(id);

	        // Redirigir a la misma página para mostrar los cambios
	        response.sendRedirect("articulos?accion=index");
	    } else {
	        response.sendError(404, "Artículo no encontrado");
	    }
	}
	
//	private void postFinalizarCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	  
//	    List<Articulo> carrito = (List<Articulo>) request.getSession().getAttribute("carrito");
//
//	 
//	    double total = 0;
//	    for (Articulo a : carrito) {
//	        total += a.getPrecio();
//	    }
//
//	
//	    request.getSession().setAttribute("totalCarrito", total);
//	    
//	    //request.getSession().removeAttribute("carrito");
//
//	   
//	    request.getRequestDispatcher("/views/articulos/factura.jsp").forward(request, response);
//	}
	private void postFinalizarCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Obtener los artículos del carrito de la sesión
	    List<Articulo> carrito = (List<Articulo>) request.getSession().getAttribute("carrito");

	    
	    if (carrito == null) {
	       
	        response.sendRedirect("error.jsp");
	        return;
	    }

	    // Calcular el total
	    double total = 0;
	    for (Articulo a : carrito) {
	        total += a.getPrecio();
	    }

	    request.getSession().setAttribute("totalCarrito", total);
	    
	    request.getSession().setAttribute("carrito", carrito);

	   
	    request.getRequestDispatcher("/views/articulos/factura.jsp").forward(request, response);

	    
	    //request.getRequestDispatcher("/views/articulos/factura.jsp").forward(request, response);



	    

	}
	





	
	    }

