<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menú de Opciones</title>
</head>
<body>

<h1>Bienvenido <c:out value="${sessionScope.usuario.nombre }" default="Desconocido"/></h1>


<form action="articulos" method="get">
    <button type="submit">Ver Artículos</button>
</form>

<form action="historialCompra" method="get">
    <button type="submit">Historial de Compra</button>
</form>

<form action="logout" method="get">
    <button type="submit">Salir</button>
</form>

</body>
</html>
