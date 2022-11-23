<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet"></link>
</head>
<body>

<header class="header">
		<img src="img/logo1-removebg-preview.png" class="logo1">

		<img src="img/logo2-removebg-preview.png" class="logo2">
		<a href="carrito.jsp"><img src="img/carrito.png" class="carritoImg"></a>
		<a href="index.jsp"><img src="img/usuario2.png" class="usuarioImg"></a>
		
</header>

<div class="container">
	<div class="divNormal">	
		<h2>Articulo anadido al carrito:</h2>
	
		<form action="/loginExec" method="post">
			<button class="btn" type="submit">Seguir comprando</button>
		</form><br>
		<form action="carrito.jsp">
			<button class="btn" type="submit">Ir al carrito</button>
		</form>
	
	</div>
</div>

</body>
</html>