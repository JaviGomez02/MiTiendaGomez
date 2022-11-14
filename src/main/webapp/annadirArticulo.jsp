<%@page import="java.util.List"%>
<%@page import="com.jacaranda.control.CategoriaControl"%>
<%@page import="com.jacaranda.categoria.Categoria"%>
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
	bienvenida=("Sesion: "+userSesion);
}
else{
%> <jsp:forward page="errorUsuario.jsp"></jsp:forward> <%
}
%>
<header class="header">
		<h1>HOLA</h1>
		<%=bienvenida %>
	</header>
	<div class="container">
	<h1>ANNADIR ARTICULO</h1><br>
    <div class="divForm">
    <form id="form" method="post" action="AnadirArticulo">
        <div class="form-field">
            <label for="nombre">Name</label>
            <input type="text" id="nombre" name="nombre" required >
            <small></small>

        </div><br>
        <div class="form-field">
            <label for="description">Description</label>
            <input type="text" id="description" name="description" required>
            <small></small>
        </div><br>
        <div class="form-field">
            <label for="price">Price</label>
            <input type="number" id="price" name="price" step="0.01" min="1" max="1000" required>
            <small></small>
        </div><br>
        <div class="form-field">
            <label for="categoria">Categoria</label>
            <select id="categoria" name="categoria" required>
            <%List<Categoria> lista=CategoriaControl.loadList(); 
            	for(Categoria c:lista){
            		%><option value="<%=c.getId()%>"><%=c.getNombre() %></option><%
            	}
            
            %>
            </select>
            <small></small>
        </div><br>
        <div class="form-field">
            <label for="imagen">Imagen (Opcional)</label>
            <input type="file" id="imagen" name="imagen">
            <small></small>
        </div><br>
        <button class="btn" type="submit">Annadir</button><br><br>
    </form>
    <form method="post" action="loginExec">
    
    	<button class="btnCancel" type="submit">Cancelar</button><br>
    </form>
    
    </div>
    </div>

<script src="annadirArticulo.js"></script>
</body>
</html>