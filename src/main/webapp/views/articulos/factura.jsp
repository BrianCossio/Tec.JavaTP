<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Factura</title>
</head>
<body>

<h1>Factura de Compra</h1>

<h2>Resumen del Carrito</h2>

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

<h3>Total: <c:out value="${sessionScope.totalCarrito}" /></h3>
<a href="articulos?accion=index"><button>Volver a la lista de artículos</button></a>

<p>Gracias, vuelva prontos</p>

</body>
</html>
