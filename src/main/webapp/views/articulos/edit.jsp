
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
</head>
<body>
<h1>Editar</h1>
<form action="articulos" method="post">
  <input type="hidden" name="accion" value="update"/> 
  <input type="hidden" name="id" value="${articulo.id}"/> 
  <p>Nombre: <input value="${articulo.nombre}" name="nombre" /></p>
  <p>Precio: <input value="${articulo.precio}" name="precio" /></p>
  <p>Descripcion: <input value="${articulo.descripcion}" name="descripcion" /></p>
  <input type="submit" value="Editar"/>
</form>


</body>
</html>