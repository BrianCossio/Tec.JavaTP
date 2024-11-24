<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creacion Proyecto</title>
</head>
<body>

<h1>Bienvenido creador de proyectos</h1>
<p> Usuario logeado:
	 <c:out value="${proyecto.admin.nombre }"/> 
	 
	 </p>

<p>Presupuesto: $
	 <c:out value="${proyecto.presupuesto }"/>
	  
	 </p>

<h3>Cambiar Presupuesto</h3>
<form action="CreacionProyectoController" method="post">
<input type="hidden" value="modificarPresu" name="accion">
<input name="importe"/>
<input type ="submit">
</form>



</body>
</html>