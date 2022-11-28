package com.jacaranda.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

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
import com.jacaranda.control.UsuarioArticleControl;
import com.jacaranda.user.User;
import com.jacaranda.usuarioArticle.UsuarioArticulos;

/**
 * Servlet implementation class AnadirCompra
 */
@WebServlet("/AnadirCompra")
public class AnadirCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnadirCompra() {
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
		
		//Obtengo la sesión
				HttpSession sesion=request.getSession();
				
				//Declaro variables
				Boolean error=false;
				int msgError=0;
				User u = null;
				
				if (sesion.getAttribute("usuario")==null || sesion.getAttribute("password")==null) { //Si no se han introducido parametros, compruebo la sesion
						error=true;
						msgError=4;
				}
				else { //Si existe la sesión recojo el usuario
					u=UserControl.readUser((String)sesion.getAttribute("usuario"));
				}
		
		Carrito miCarro=(Carrito) sesion.getAttribute("miCarro");
		
		if(!error) {
			for(CarritoItem c: miCarro.getItems()) {
				Article a=ArticleControl.readArticle(c.getIdItem());
				UsuarioArticulos ua=new UsuarioArticulos(u, a, LocalDateTime.now(), c.getCantidad(), c.getPrecio());
				UsuarioArticleControl.addUsuarioArticle(ua);
			}
			response.sendRedirect("compraRealizada.jsp");
		}
		else {
			response.sendRedirect("error.jsp?msg="+msgError);
		}
		

		
		
		
		
	}

}
