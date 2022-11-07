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
<jsp:useBean id="UsuarioBD" class="com.jacaranda.control.UserControl"></jsp:useBean>

<title>Insert title here</title>
</head>
<body>
hola
<%
List<User> lista=new ArrayList<>();
lista=UsuarioBD.loadList();
for (User u: lista){
	out.print(u.toString()+"<br>");
}


%>

</body>
</html>