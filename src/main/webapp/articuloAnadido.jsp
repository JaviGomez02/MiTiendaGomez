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
<%
String bienvenida="";
HttpSession sesion=request.getSession();
String isSesion = (String) sesion.getAttribute("login");
String userSesion= (String) sesion.getAttribute("usuario");
if(isSesion != null && userSesion!=null && isSesion.equals("True")){
	bienvenida=userSesion;
}
else{
%> <jsp:forward page="error.jsp?msg=3"></jsp:forward> <%
}
%>

<header class="header">
		<a><img src="img/logo1-removebg-preview.png" class="logo1"></a>
		<img src="img/logo2-removebg-preview.png" class="logo2">
		<div class="headerRight ">
			
			<a href="carrito.jsp" class="tooltip"><img src="img/carrito.png" class="carritoImg"><span class="tooltiptext"></span></a>
			<a href="index.jsp" class="tooltip"><img src="img/usuario2.png" class="usuarioImg"><span class="tooltiptext"><%=bienvenida %></span></a>
		</div>
		
</header>

<div class="container">
	<div class="divNormal">	
		<h2>Articulo anadido al carrito:</h2><br>
	
		<form action="loginExec" method="post">
			<button class="btn" type="submit">Seguir comprando</button>
		</form><br>
		<form action="carrito.jsp">
			<button class="btn" type="submit">Ir al carrito</button>
		</form>
	
	</div>
</div>

</body>
</html>