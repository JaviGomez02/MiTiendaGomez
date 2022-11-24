<%@page import="com.jacaranda.control.CategoriaControl"%>
<%@page import="com.jacaranda.categoria.Categoria"%>
<%@page import="com.jacaranda.control.ArticleControl"%>
<%@page import="com.jacaranda.article.Article"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.jacaranda.user.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:useBean id="Usuario" class="com.jacaranda.user.User"></jsp:useBean>

<title>Insert title here</title>
<link href="style.css" rel="stylesheet"></link>

</head>
<body>

<header class="header">
		<a><img src="img/logo1-removebg-preview.png" class="logo1"></a>
		<img src="img/logo2-removebg-preview.png" class="logo2">
		<div class="headerRight ">
			
			<a href="carrito.jsp" class="tooltip"><img src="img/carrito.png" class="carritoImg"><span class="tooltiptext">Tooltip text</span></a>
			<a href="index.jsp" class="tooltip"><img src="img/usuario2.png" class="usuarioImg"><span class="tooltiptext">a</span></a>
		</div>
		
</header>


</body>
</html>


