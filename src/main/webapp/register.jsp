<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link href="style.css" rel="stylesheet"></link>
</head>
<body>
	<header class="header">
		<img src="img/logo1-removebg-preview.png" class="logo1">

		<img src="img/logo2-removebg-preview.png" class="logo2">
	</header>
    <div class="container"><br><br>
    <div class="divForm">
    <h1 align="center">Register</h1><br><hr></hr><br>
    <form id="form" method="post" action="registerExec">
        <div class="form-field">
            <label for="nombre">Nickname</label>
            <input type="text" id="nombre" name="nombre" required >
            <small></small>

        </div><br>
        <div class="form-field">
            <label for="nombre">Nombre</label>
            <input type="text" id="nombrePropio" name="nombrePropio" required>
            <small></small>

        </div><br>
        <div class="form-field">
            <label for="nombre">Apellidos</label>
            <input type="text" id="apellidos" name="apellidos" required>
            <small></small>

        </div><br>
        <div class="form-field">
            <label for="password">Contraseña</label>
            <input type="password" id="password" name="password" required>
            <small></small>

        </div><br>

        <div class="form-field">
            <label for="cPassword">Confirmar Contraseña</label>
            <input type="password" id="cPassword" required>
            <small></small>

        </div><br>

        <div class="form-field">
            <label for="email">Introduce tu email</label>
            <input type="email" id="email" name="email" required>
            <small></small>

        </div><br>
        <div class="form-field">
        	<label for="genero">Genero</label>
            <select id="genero" name="genero">
            	<option value="M">Hombre</option>
            	<option value="F">Mujer</option>
            </select>
            <small></small>
        </div><br>
        <div class="form-field">
        	<label for="fecha">Fecha de nacimiento</label>
            <input type="date" id="fecha" name="fecha" required>
            <small></small>
        </div><br>
        <button class="btn" type="submit">Registrarse</button><br><br>
        <a href="index.jsp">Volver al login</a>

    </form>
    </div><br><br>
	</div>
    <script src="register.js"></script>
</body>
</html>