package com.jacaranda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacaranda.article.Article;
import com.jacaranda.carrito.Carrito;
import com.jacaranda.carrito.CarritoItem;
import com.jacaranda.control.ArticleControl;
import com.jacaranda.control.UserControl;
import com.jacaranda.user.User;

/**
 * Servlet implementation class AnadirCarrito
 */
@WebServlet("/AnadirCarrito")
public class AnadirCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnadirCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		//Obtengo la sesión
		HttpSession sesion=request.getSession();
		
		//Obtengo el usuario de la seison
		User u=UserControl.readUser((String)sesion.getAttribute("usuario"));
		
		//Obtengo el carrito de la seison
		Carrito miCarro;

		miCarro=(Carrito) sesion.getAttribute("miCarro");
		if (miCarro==null) { //Si la sesion no tiene carrito, lo creo y se lo asigno
			miCarro= new Carrito();
			sesion.setAttribute("miCarro", miCarro);
		}
		
		
		//Recojo los valores del item
		String idItem=request.getParameter("idItem");
		String cantidad=request.getParameter("cantidadItem");
		String precio=request.getParameter("precioItem");
		
		//Creo el item
		CarritoItem c = new CarritoItem (u.getNickname(), Integer.parseInt(idItem), Integer.parseInt(cantidad), Double.parseDouble(precio), LocalDateTime.now());
		
		//Compruebo si el item existe en el carrito
		Boolean existe=false;
		int cantidadItem=c.getCantidad();
		if (miCarro.getItems().contains(c)) {//Si ya existe, actualizo la cantidad
			cantidadItem=miCarro.getItems().get(miCarro.getItems().indexOf(c)).getCantidad()+Integer.parseInt(cantidad);
			existe=true;
		}
		
		//Compruebo que la cantidad añadida no sobrepase el stock
		Article a=ArticleControl.readArticle(Integer.parseInt(idItem));
		int stock=a.getStock();
		if (stock>=cantidadItem) {
			
			if (existe==true) {//Si ya existe le asigno la cantidad
				miCarro.getItems().get(miCarro.getItems().indexOf(c)).setCantidad(cantidadItem);
			}
			else {//Si no existe lo añade al carrito
				miCarro.addItem(c);
			}
			
			out.println("<!DOCTYPE html>\n"
					+ "<html>\n"
					+ "<head>\n"
					+ "<meta charset=\"UTF-8\">\n"
					+ "<title>Insert title here</title>\n"
					+ "<link href=\"style.css\" rel=\"stylesheet\"></link>\n"
					+ "</head>\n"
					+ "<body>\n"
					+ "\n"
					+ "<header class=\"header\">\n"
					+ "		<a><img src=\"img/logo1-removebg-preview.png\" class=\"logo1\"></a>\n"
					+ "		<img src=\"img/logo2-removebg-preview.png\" class=\"logo2\">\n"
					+ "		<div class=\"headerRight \">\n"
					+ "<a href='cerrarSesion.jsp' class='enlace'>Cerrar sesion</a>"
					+ "			<a href=\"carrito.jsp\" class=\"tooltip\"><img src=\"img/carrito.png\" class=\"carritoImg\"><span class=\"tooltiptext\">"+miCarro.getCantidadTotal()+"</span></a>\n"
					+ "			<a href=\"index.jsp\" class=\"tooltip\"><img src=\"img/usuario2.png\" class=\"usuarioImg\"><span class=\"tooltiptext\">"+u.getName()+"</span></a>\n"
					+ "		</div>\n"
					+ "		\n"
					+ "</header>\n"
					+ "\n"
					+ "<div class=\"container\">\n"
					+ "	<div class=\"divNormal\">	\n"
					+ "		<h2>Articulo anadido al carrito:</h2><br>\n"
					+ "	<p>"+a.getNombre() +"</p>"
					+ "<p>Cantidad: "+cantidadItem+"</p><br>"
					+ "		<form action=\"loginExec\" method=\"post\">\n"
					+ "			<button class=\"btn\" type=\"submit\">Seguir comprando</button>\n"
					+ "		</form><br>\n"
					+ "		<form action=\"carrito.jsp\">\n"
					+ "			<button class=\"btn\" type=\"submit\">Ir al carrito</button>\n"
					+ "		</form>\n"
					+ "	\n"
					+ "	</div>\n"
					+ "</div>\n"
					+ "\n"
					+ "</body>\n"
					+ "</html>");
		}
		else {
			out.println("<!DOCTYPE html>\n"
					+ "<html>\n"
					+ "<head>\n"
					+ "<meta charset=\"UTF-8\">\n"
					+ "<title>Insert title here</title>\n"
					+ "<link href=\"style.css\" rel=\"stylesheet\"></link>\n"
					+ "</head>\n"
					+ "<body>\n"
					+ "\n"
					+ "<header class=\"header\">\n"
					+ "		<img src=\"img/logo1-removebg-preview.png\" class=\"logo1\">\n"
					+ "\n"
					+ "		<img src=\"img/logo2-removebg-preview.png\" class=\"logo2\">\n"
					+ "		<a href=\"carrito.jsp\"><img src=\"img/carrito.png\" class=\"carritoImg\"></a>\n"
					+ "		<a href=\"index.jsp\"><img src=\"img/usuario2.png\" class=\"usuarioImg\"></a>\n"
					+ "		\n"
					+ "</header>\n"
					+ "\n"
					+ "<div class=\"container\">\n"
					+ "	<div class=\"divNormal\">	\n"
					+ "		<h2>No hay stock:</h2>\n"
					+ "	<p>Cantidad elegida: "+cantidadItem+"</p>"
					+ "<p>Stock del artículo: "+a.getStock()+"</p><br>"
					+ "		<form action=\"loginExec\" method=\"post\">\n"
					+ "			<button class=\"btn\" type=\"submit\">Volver a la lista</button>\n"
					+ "		</form><br>\n"
					+ "		<form action=\"carrito.jsp\">\n"
					+ "			<button class=\"btn\" type=\"submit\">Ir al carrito</button>\n"
					+ "		</form>\n"
					+ "	\n"
					+ "	</div>\n"
					+ "</div>\n"
					+ "\n"
					+ "</body>\n"
					+ "</html>");
			
		}
		
		
		
	}

}
