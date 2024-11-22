

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar Articulo</title>
</head>
<body>
<h1>Articulo</h1>
<p>
Nombre:
 <c:out value= "${articulo.nombre }"/> 
 </p>
 <p>
Precio: 
<c:out value= "${articulo.precio }"/>
 </p>
<p>
Descripcion: 
<c:out value= "${articulo.descripcion }"/> 
</p>
<p>

</body>
</html>



