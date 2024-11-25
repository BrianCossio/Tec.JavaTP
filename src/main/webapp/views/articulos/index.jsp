<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Artículos</title>
</head>
<body>

<form action="menu" method="get">
    <button type="submit">Volver al Menú</button>
</form>

<h1>Bienvenido <c:out value="${sessionScope.usuario.nombre}" default="Desconocido"/></h1>

<a href="articulos?accion=create">
    <button type="button">Agregar artículo</button>
</a>

<h2>Lista de Artículos</h2>

<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Descripción</th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="articulo" items="${listita}">
            <tr>
                <td><c:out value="${articulo.id}" /></td>
                <td><c:out value="${articulo.nombre}" /></td>
                <td><c:out value="${articulo.precio}" /></td>
                <td><c:out value="${articulo.descripcion}" /></td>
                <td>
                    <a href="articulos?accion=show&id=${articulo.id}">Ver</a> |
                    <a href="articulos?accion=edit&id=${articulo.id}">Editar</a> |
                    
                    <form action="articulos?accion=agregarAlCarrito" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${articulo.id}" />
                        <button type="submit">Agregar al Carrito</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<h2>Carrito de Compras</h2>

<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Descripción</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="articulo" items="${sessionScope.carrito}">
            <tr>
                <td><c:out value="${articulo.id}" /></td>
                <td><c:out value="${articulo.nombre}" /></td>
                <td><c:out value="${articulo.precio}" /></td>
                <td><c:out value="${articulo.descripcion}" /></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<h3>Total: 
    <c:out value="${sessionScope.totalCarrito != null ? sessionScope.totalCarrito : 0}" />
</h3>

<form action="views/articulos/factura.jsp" method="get">
    <button type="submit">Finalizar compra</button>
</form>


</body>
</html>