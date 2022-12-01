package com.jacaranda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

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
import com.jacaranda.control.Utilidades;
import com.jacaranda.user.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/loginExec")
public class LoginExec extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginExec() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//Obtengo los parametros
		String name = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		//Obtengo la sesión
		HttpSession sesion=request.getSession();
		
		//Declaro variables
		Boolean error=false;
		int msgError=0;
		User u = null;
		String admin="";
		
		if (name==null || password==null || name.isEmpty() || password.isEmpty()) { //Si no se han introducido parametros, compruebo la sesion
			name = (String) sesion.getAttribute("usuario");
			password = (String) sesion.getAttribute("password");
			if (name==null || password==null) { //Si no existe sesión mando el error
				error=true;
				msgError=4;
			}
			else { //Si existe la sesión recojo el usuario
				u=UserControl.readUser(name);
				if(u.isAdmin()==true) { //Si el usuario es Administrador puede añadir articulo
					admin="<a href='annadirArticulo.jsp' class='enlace'>Anadir articulo</a>";
				}
			}
		}
		else {//Si se han introducido parametros, compruebo el usuario
			u=UserControl.readUser(name);
			if (u==null || (!u.getPassword().equals(Utilidades.MD5(password)))) { //Si el usuario no existe o la contraseña es incorrecta mando el error
				error=true;
				msgError=1;
			}
			else { //Si el usuario es correcto creo la sesión
				sesion.setAttribute("login", "True");
				sesion.setAttribute("usuario", name);
				sesion.setAttribute("password", password);
				if(u.isAdmin()==true) { //Si el usuario es Administrador puede añadir articulo
					admin="<a href='annadirArticulo.jsp' class='enlace'>Anadir articulo</a>";
				}
			}
		}
		
		
		//Carrito
		Carrito miCarro=(Carrito) sesion.getAttribute("miCarro");
		int contador=0;
		if(miCarro!=null) {
			contador=miCarro.getCantidadTotal();
		}
		
		
		//Si el usuario existe en la base de datos y la contraseña es correcta, accede a la pagina
		if (!error) {

			List<Article> listaArticulos=ArticleControl.loadList();
			
			PrintWriter out=response.getWriter();
	
			out.println("  <!DOCTYPE html>\n"
					+ "<html lang=\"en\">\n"
					+ "<head>\n"
					+ "    <meta charset=\"UTF-8\">\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
					+ "    <title>Document</title>\n"
					+ "	<link href=\"style.css\" rel=\"stylesheet\"></link>"
					+ "</head>\n"
					+ "<body>\n"
					+ "<header class=\"header\">\n"
					+ "		<a><img src=\"img/logo1-removebg-preview.png\" class=\"logo1\"></a>\n"
					+ "		<img src=\"img/logo2-removebg-preview.png\" class=\"logo2\">\n"
					+ "		<div class=\"headerRight \">\n"
					+ "			\n"
					+ admin
					+ "<a href='mostrarCompras.jsp' class='enlace'>Ver mis compras</a>"
					+ "<a href='cerrarSesion.jsp' class='enlace'>Cerrar sesion</a>"
					+ "			<a href=\"carrito.jsp\" class=\"tooltip\"><img src=\"img/carrito.png\" class=\"carritoImg\"><span class=\"tooltiptext\">"+contador+"</span></a>\n"
					+ "			<a href=\"index.jsp\" class=\"tooltip\"><img src=\"img/usuario2.png\" class=\"usuarioImg\"><span class=\"tooltiptext\">"+name+"</span></a>\n"
					+ "		</div>\n"
					+ "		\n"
					+ "</header>\n"
					+ ""
					+ "<div class=\"container2\">");
			
			
			for(Article a:listaArticulos) {
				out.print("<div class=\"gallery-container\">\n"
						+ "			<div class=\"titulo_categoria\">\n"
						+ 				a.getCategoria().getNombre()
						+ "			</div>\n"
						+ "			<div class=\"titulo_articulo\">\n"
						+ 				a.getNombre()
						+ "			</div>\n"
						+ "         <div class=\"img_articulo\">\n"
						+ "             <img src=\"sin_nombre\" > \n"
						+ "         </div>\n"
						+ "         <div class=\"precio_articulo\">\n"
						+ 				a.getPrecio()
						+ "         </div>\n"
						+ "         <div class=\"stock_articulo\">\n"
						+ 				"Stock:"+a.getStock()
						+ "         </div>\n"
						+ "         <div class=\"comprar_articulo\">\n"
						+ "				<form action=\"AnadirCarrito\" method='post'>\n"
						+ "            		<input type=\"number\" name='cantidadItem' min='1' max='"+a.getStock()+"' value='1'>\n"
						+ "            		<input type=\"text\" hidden name='idItem' value="+a.getId()+">\n"
						+ "            		<input type=\"text\" hidden name='precioItem' value="+a.getPrecio()+">\n"
						+ "            		<button type=\"submit\">Anadir al carrito</button>\n"
						+ "        		</form>"
						+ "         </div>\n"
						+ "     </div>"
						);
				
			}
					
					out.println("\n"
					+ "</div>"
					+ "</body>\n"
					+ "</html>  ");
		}
		else {
			response.sendRedirect("error.jsp?msg="+msgError);
		}
	}

	

}
