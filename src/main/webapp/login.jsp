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
    <form id="form" method="post" action="loginExec">
        <div class="form-field">
            <label for="nombre">Nickname</label>
            <input type="text" id="nombre" name="nombre" >
            <small></small>

        </div><br>
        <div class="form-field">
            <label for="password">Contraseņa</label>
            <input type="password" id="password" name="password" >
            <small></small>
        </div><br>
        <button class="btn" type="submit">Entrar</button><br><br><br>
    </form>
	<a href="register.jsp"><button class="btn">Registrate aqui</button></a>
    
    </div>
    </div>

    <script src="login.js"></script>
</body>
</html>