<%@page import="com.jacaranda.control.ArticleControl"%>
<%@page import="com.jacaranda.carrito.CarritoItem"%>
<%@page import="com.jacaranda.carrito.Carrito"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style.css" rel="stylesheet"></link>

<title>Insert title here</title>
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
<%
int contador=0;
Carrito miCarro=(Carrito)sesion.getAttribute("miCarro");
if(miCarro!=null){
	contador=miCarro.getCantidadTotal();
}
%>
	<header class="header">
		<a><img src="img/logo1-removebg-preview.png" class="logo1"></a>
		<img src="img/logo2-removebg-preview.png" class="logo2">
		<div class="headerRight ">
		
			<a href='cerrarSesion.jsp' class='enlace'>Cerrar sesion</a>
			<a href="carrito.jsp" class="tooltip"><img src="img/carrito.png" class="carritoImg"><span class="tooltiptext"><%=contador %></span></a>
			<a href="index.jsp" class="tooltip"><img src="img/usuario2.png" class="usuarioImg"><span class="tooltiptext"><%=bienvenida %></span></a>
		</div>
		
</header>

<div class="containerCarrito">
	<div class="listaItems">
	<%
	if(miCarro!=null){
		for (CarritoItem c: miCarro.getItems()){%>
			<div class="item">
				<%=ArticleControl.readArticle(c.getIdItem()).toString() %>
			</div>
		<%
		}
	}
	else{%>
		<h1>No hay items</h1>
	<%	
	}
		%>
		
		
	</div>
	<div class="factura">
		<h1>FACTURA</h1>
	</div>

</div>


	
	
	

</body>
</html>