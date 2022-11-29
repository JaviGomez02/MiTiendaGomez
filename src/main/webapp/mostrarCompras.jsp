<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.jacaranda.control.UserControl"%>
<%@page import="com.jacaranda.usuarioArticle.UsuarioArticulos"%>
<%@page import="com.jacaranda.control.UsuarioArticleControl"%>
<%@page import="com.jacaranda.article.Article"%>
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
		
</header><br>

<form method="post" action="loginExec" class="form">
	<button type="submit" >Volver a la lista</button>
</form>
<div class="containerListaCompra">
	
	<%if(UsuarioArticleControl.loadList().size()>0){
		for(UsuarioArticulos u: UsuarioArticleControl.loadList()){
			if(u.getName_usuario()==UserControl.readUser(userSesion)){
				%>
				<div class="itemListaCompra">
					<p>Articulo: <%=u.getId_article().getNombre()%></p>
					<p>Descripcion: <%=u.getId_article().getDescripcion() %></p>
					<p>Cantidad: <%=u.getCantidad() %> articulos</p>
					<p>Precio: <%=u.getPrecio() %> €</p>
					<p>Fecha: <%=u.getFecha()%></p>
				</div>
				<%
			}
			
		}
	} 
	%>
</div>


	
	
	

</body>
</html>