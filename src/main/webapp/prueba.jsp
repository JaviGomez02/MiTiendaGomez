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
</head>
<body>
hola
<%
/* List<User> lista=new ArrayList<>();
lista=UsuarioBD.loadList();
for (User u: lista){
	out.print(u.toString()+"<br>");
}
 */
 /* List<Categoria> lista=new ArrayList<>();
 lista=CategoriaControl.loadList();
 for (Categoria a: lista){
 	out.print(a.toString()+"<br>");
 } */
 
 List<Article> lista=new ArrayList<>();
 lista=ArticleControl.loadList();
 for (Article a: lista){
 	out.print(a.toString()+"<br>");
 }

%>

</body>
</html>