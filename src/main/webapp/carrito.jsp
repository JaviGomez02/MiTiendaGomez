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
	bienvenida=("Sesion: "+userSesion);
}
else{
%> <jsp:forward page="error.jsp?msg=3"></jsp:forward> <%
}
%>
	<header class="header">
		<img src="img/logo1-removebg-preview.png" class="logo1">

		<img src="img/logo2-removebg-preview.png" class="logo2">
		<img src="img/carrito.png" class="carritoImg">
		<a href="index.jsp"><img src="img/usuario2.png" class="usuarioImg"></a>
		
		<div>
			
		<%=bienvenida %>
		</div>
	</header>
	<form action=""></form>
	
	
	

</body>
</html>