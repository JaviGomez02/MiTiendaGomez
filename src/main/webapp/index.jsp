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
<%session.invalidate(); %>
	<header class="header">
		<h1>HOLA</h1>
	</header>
	<div class="container">
    <div class="divForm">
    <h1 align="center">Login</h1><br><hr></hr><br>
    
    <form id="form" method="post" action="loginExec">
        <div class="form-field">
            <label for="nombre">Nickname</label>
            <input type="text" id="nombre" name="nombre" >
            <small></small>

        </div><br>
        <div class="form-field">
            <label for="password">Contrase�a</label>
            <input type="password" id="password" name="password" >
            <small></small>
        </div><br>
        <button class="btn" type="submit">Entrar</button><br><br>
    </form>
	<a href="register.jsp">�No tienes una cuenta? Click aqui para registrarte.</a>
    
    </div>
    </div>

    <script src="login.js"></script>
</body>
</html>