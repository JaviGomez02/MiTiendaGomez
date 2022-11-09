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
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginServlet() {
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

		String name = request.getParameter("nombre");
		String password = request.getParameter("password");
		User u = UserControl.readUser(name);
		
		if (u != null && (u.getPassword().equals(MD5(password)))) {
			HttpSession sesion=request.getSession();
			sesion.setAttribute("login", "True");
			sesion.setAttribute("usuario", name);
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
					+ "<table border='1' class=\"tabla\">\n"
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
			response.getWriter().append("<!DOCTYPE html>\n"
					+ "<html>\n"
					+ "<head>\n"
					+ "<meta charset=\"ISO-8859-1\">\n"
					+ "<title>Insert title here</title>\n"
					+ "</head>\n"
					+ "<body>\n"
					+ "<h1>Usuario y/o contraseña incorrectos</h1><br>\n"
					+ "<a href=\"login.jsp\">Volver</a>\n"
					+ "</body>\n"
					+ "</html>");
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
