package com.jacaranda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
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

		HttpSession sesion=request.getSession();
		
		String name = (String) sesion.getAttribute("usuario");
		String password = (String) sesion.getAttribute("password");
		System.out.println(name);
		
		if (name==null && password==null) {
			name = request.getParameter("nombre");
			password = request.getParameter("password");
			
			sesion.setAttribute("login", "True");
			sesion.setAttribute("usuario", name);
			sesion.setAttribute("password", password);
		}
		System.out.println(name);
		System.out.println(password);
		User u = UserControl.readUser(name);
		
		if (u != null && (u.getPassword().equals(MD5(password)))) {
			
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
			if(u.isAdmin()==true) {
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
			response.sendRedirect("errorUsuario.jsp");
		}
	}

	public static String MD5(String cadena) {
		if (cadena == null || cadena.length() == 0) {
			return null;
		}
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(cadena.getBytes());
			byte[] byteArray = md5.digest();

			BigInteger bigInt = new BigInteger(1, byteArray);
			// El parámetro 16 significa hexadecimal
			String result = bigInt.toString(16);
			// Relleno de ceros de orden superior de menos de 32 bits
			while (result.length() < 32) {
				result = "0" + result;
			}
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
