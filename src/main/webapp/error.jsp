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
<%String msg=request.getParameter("msg");
String error="Error inesperado";
String redirect="index.jsp";
if (msg!=null){
	
	switch (msg){
	case "1":
		error="Usuario y/o contraseña incorrectos";
		break;
	case "2":
		error="Usuario ya existente";
		redirect="register.jsp";
		break;
	case "3":
		error="Debe iniciar sesion";
		break;
	case "4":
		error="No se han introducido todos los parametros";
		break;
	case "5":
		error="No se han introducido todos los parametros";
		redirect="annadirArticulo.jsp";
		break;
	}
}
%>
<header class="header">
		<a><img src="img/logo1-removebg-preview.png" class="logo1"></a>
		<img src="img/logo2-removebg-preview.png" class="logo2">
		<div class="headerRight ">
			
			<a href="index.jsp" class="tooltip"><img src="img/usuario2.png" class="usuarioImg"><span class="tooltiptext">Inicie sesion</span></a>
		</div>
		
</header>
<div class="container">
	<div class="divNormal">	
		<h1>Oops!!</h1><br><br>
		<h3><%=error %></h3><br>
		<a href="<%=redirect%>">Volver</a>
	</div>
</div>

</body>
</html>