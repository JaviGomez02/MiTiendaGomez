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
	case "2":{
		error="Usuario ya existente";
		redirect="register.jsp";
	}
	}
}
%>
<header class="header">
		<h1>HOLA</h1>
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