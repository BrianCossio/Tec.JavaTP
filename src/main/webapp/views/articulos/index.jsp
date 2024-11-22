
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Articulos</title>
</head>
<body>
<a href="articulos?accion=create">Agregar articulo</a>
<table border ="1">
<thead>
<tr>
<th>ID</th>
<th>Nombre</th>
<th>Precio</th>
<th>Descripcion</th>
<th></th>
<th></th>
</tr>
</thead>
<tbody>
<c:forEach var = "articulo" items="${listita }">
<tr>
<td><c:out value="${articulo.id }"></c:out> </td>
<td><c:out value="${articulo.nombre }"></c:out> </td>
<td><c:out value="${articulo.precio }"></c:out> </td>
<td><c:out value="${articulo.descripcion }"></c:out> </td>
<td><a href="articulos?accion=show&id=${articulo.id }">Ver</a> </td>
<td><a href="articulos?accion=edit&id=${articulo.id }">Editar</a> </td>


</tr>


</c:forEach>

</tbody>
</table>


</body>
</html>