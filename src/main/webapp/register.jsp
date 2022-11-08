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
		<h1>HOLA</h1>
	</header>
    <div class="container">
    <div class="divForm">
    <form id="form" method="post" action="registerExec">
        <div class="form-field">
            <label for="nombre">Nickname</label>
            <input type="text" id="nombre" name="nombre" >
            <small></small>

        </div><br>
        <div class="form-field">
            <label for="nombre">Nombre</label>
            <input type="text" id="nombrePropio" name="nombrePropio" >
            <small></small>

        </div><br>
        <div class="form-field">
            <label for="nombre">Apellidos</label>
            <input type="text" id="apellidos" name="apellidos" >
            <small></small>

        </div><br>
        <div class="form-field">
            <label for="password">Contraseņa</label>
            <input type="password" id="password" name="password" >
            <small></small>

        </div><br>

        <div class="form-field">
            <label for="cPassword">Confirmar Contraseņa</label>
            <input type="password" id="cPassword" >
            <small></small>

        </div><br>

        <div class="form-field">
            <label for="email">Introduce tu email</label>
            <input type="email" id="email" name="email" >
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
            <input type="date" id="fecha" name="fecha">
            <small></small>
        </div><br>
        <button class="btn" type="submit">Enviar</button><br><br>
        <a href="login.jsp">Volver al login</a>

    </form>
    </div>
	</div>
    <script src="register.js"></script>
</body>
</html>