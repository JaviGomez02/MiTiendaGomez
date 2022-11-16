package com.jacaranda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacaranda.article.Article;
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
		
		if (name==null || password==null || name.isEmpty() || password.isEmpty()) { //Si no se han introducido parametros, compruebo la sesion
			name = (String) sesion.getAttribute("usuario");
			password = (String) sesion.getAttribute("password");
			if (name==null || password==null) { //Si no existe sesión mando el error
				error=true;
				msgError=4;
			}
			else { //Si existe la sesión recojo el usuario
				u=UserControl.readUser(name);
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
				
			}
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
					+ "</head>\n"
					+ "<body>\n"
					+ "<p>Bienvenido "+ name + "</p>"
					+ "<a href='cerrarSesion.jsp'>Cerrar sesion</a>");
			if(u.isAdmin()==true) { //Si el usuario es Administrador puede añadir articulo
				out.println("<a href='annadirArticulo.jsp'>Anadir articulo</a><br><br>");
			}
			out.println(
					"<table border='1' class=\"tabla\">\n"
					+ "	<tr>\n"
					+ "		<td>\n"
					+ "			Nombre\n"
					+ "		</td>\n"
					+ "		<td>\n"
					+ "			Descripcion\n"
					+ "		</td>\n"
					+ "		<td>\n"
					+ "			Precio\n"
					+ "		</td>\n"
					+ "		<td>\n"
					+ "			Categoria\n"
					+ "		</td>	\n"
					+ "	</tr>\n");
			for(Article a:listaArticulos) {
				out.print("<tr>\n"
						+"<td>\n"
						+a.getNombre()+"\n"
						+"</td>\n"
						+"<td>\n"
						+a.getDescripcion()+"\n"
						+"</td>\n"
						+"<td>\n"
						+a.getPrecio()+"\n"
						+"</td>\n"
						+"<td>\n"
						+a.getCategoria().getNombre()+"\n"
						+"</td>\n"
						+"</tr>\n"
						);
				
			}
					
					out.println("\n"
					+ "</table>"
					+ "</body>\n"
					+ "</html>  ");
		}
		else {
			response.sendRedirect("error.jsp?msg="+msgError);
		}
	}

	

}
