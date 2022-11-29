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
		
</header>

<div class="containerCarrito">
	<div class="listaItems">
	<%
	if(miCarro!=null){
		for (CarritoItem c: miCarro.getItems()){%>
			<div class="item">
				<%Article a= ArticleControl.readArticle(c.getIdItem());%>
				<h1><%=a.getNombre() %></h1>
				<p>Precio: <%=a.getPrecio() %></p>
				<form method="post" action="ActualizarCantidad">
					Cantidad: <input type="number" name="nuevaCantidad" id="nuevaCantidad" value="<%=c.getCantidad() %>" min="1" max="<%=a.getStock()%>">
					<input type="text" value="<%=c.getIdItem() %>" hidden name="idItem" id="idItem">
					<button type="submit">Modificar cantidad</button>
				</form>
			</div>
		<%
		}
	}
	else{%>
		<h2>No hay items</h2>
		
	<%	
	}
		%>
		
		
	</div>
	<div class="factura">
		<div class="cuenta">
		<h1>Factura</h1><br>
			<%
			if(miCarro!=null){
				for (CarritoItem c: miCarro.getItems()){
					Article a= ArticleControl.readArticle(c.getIdItem());
					int cantidad=c.getCantidad();
				%>
					<p>- <%=a.getNombre() %> x <%=cantidad %>: <%=Math.round((a.getPrecio() * cantidad) *100.0)/100.0 %>€</p>
				<%
				}
			}
			else{%>
				<h2>No hay items</h2>
			<%	
			}
			%>
			
		</div>
		<div class="total">
		<hr><br>
		<%
			if(miCarro!=null){
				double precioTotal=0;
				for (CarritoItem c: miCarro.getItems()){
					Article a= ArticleControl.readArticle(c.getIdItem());
					precioTotal=precioTotal+a.getPrecio()*c.getCantidad();
				
				}
				precioTotal=Math.round(precioTotal *100.0)/100.0;
				%>
				
				<h1>Total: <%= precioTotal%>€</h1><br>
				<form method="post" action="AnadirCompra">
					<button type="submit" class="btn">Comprar</button>
				</form><br>
				<form method="post" action="CancelarCompra">
					<button type="submit" class="btnCancel">Cancelar</button>
				</form>
			<%
			}
			else{%>
				<h2>No hay items</h2><br>
				<form method="post" action="loginExec">
					<button type="submit" class="btn">Volver</button>
				</form>
			<%	
			}
			%>
		</div>
		
	</div>

</div>


	
	
	

</body>
</html>