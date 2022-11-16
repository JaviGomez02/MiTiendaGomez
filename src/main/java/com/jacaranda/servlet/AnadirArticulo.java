package com.jacaranda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jacaranda.article.Article;
import com.jacaranda.categoria.Categoria;
import com.jacaranda.control.ArticleControl;
import com.jacaranda.control.CategoriaControl;

/**
 * Servlet implementation class AnadirArticuloServlet
 */
@WebServlet("/AnadirArticulo")
public class AnadirArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnadirArticulo() {
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
		// TODO Auto-generated method stub
		String name=request.getParameter("nombre");
		String description=request.getParameter("description");
		String price=request.getParameter("price");
		String c=request.getParameter("categoria");
		
		
		PrintWriter out=response.getWriter();
		Boolean error=false;
		int msgError=0;
		
		
		if(name==null || name.isEmpty() || description==null || description.isEmpty() || price==null || price.isEmpty() || c==null || c.isEmpty()) {
			error=true;
			msgError=5;
		}
		
		if(error) {
			response.sendRedirect("error.jsp?msg="+msgError);
		}
		else {
			Article a=new Article(name, description, Double.parseDouble(price), CategoriaControl.readCategoria(Integer.parseInt(c)));	
			ArticleControl.addArticle(a);
			
			out.println("\n"
					+ "<!DOCTYPE html>\n"
					+ "<html>\n"
					+ "<head>\n"
					+ "<meta charset=\"UTF-8\">\n"
					+ "<title>Insert title here</title>\n"
					+ "<link href=\"style.css\" rel=\"stylesheet\"></link>\n"
					+ "</head>\n"
					+ "<body>\n"
					+ "\n"
					+ "<header class=\"header\">\n"
					+ "		<h1>HOLA</h1>\n"
					+ "</header>\n"
					+ "<div class=\"container\">\n"
					+ "	<div class=\"divNormal\">	\n"
					+ "<form action='loginExec' method='post'>"
					+ "		<h1>Articulo annadido correctamente!!</h1><br><br>\n"
					+ "		<h3>Articulo: "+a.getNombre()+"</h3><br>\n"
					+ "		<button type='submit'>Volver a la lista</button>\n"
					+ "</form>"
					+ "	</div>\n"
					+ "</div>\n"
					+ "\n"
					+ "</body>\n"
					+ "</html>");
		}

		
	}

}
