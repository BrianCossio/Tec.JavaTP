
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
<form action="" method="post"></form>
<p>ID: <input value="${articulo.id}"name="id"/>
 <p>
 <p>Nombre: <input value="${articulo.nombre}"name="nombre"/>
 <p>
 <p>Precio: <input value="${articulo.precio}"name="precio"/>
 <p>
 <p>Descripcion: <input value="${articulo.precio}"name="descripcion"/>
 <p>
 <input type="submit" value= "Editar"/>
</body>
</html>