<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
</head>
<body>

<h2>Iniciar sesi�n</h2>
<form action="auth" method="post">
    <p>Nombre de usuario: <input type="text" name="usuario" required/></p>
    <p>Contrase�a: <input type="password" name="contrase�a" required/></p>
    <input type="submit" value="Identificarse"/>
</form>



</body>
</html>
