package com.jacaranda.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacaranda.carrito.Carrito;
import com.jacaranda.carrito.CarritoItem;
import com.jacaranda.control.UserControl;
import com.jacaranda.user.User;

/**
 * Servlet implementation class ActualizarCantidad
 */
@WebServlet("/ActualizarCantidad")
public class ActualizarCantidad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarCantidad() {
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
		
		//Obtengo el usuario de la seison
		User u=UserControl.readUser((String)sesion.getAttribute("usuario"));
		
		//Obtengo el carrito de la seison
		Carrito miCarro=(Carrito) sesion.getAttribute("miCarro");
	
		//Recojo los valores del item
		String cantidad=request.getParameter("nuevaCantidad");
		String idItem=request.getParameter("idItem");
		
		for(CarritoItem c: miCarro.getItems()) {
			if(c.getIdItem()==Integer.parseInt(idItem)) {
				c.setCantidad(Integer.parseInt(cantidad));
			}
		}
		response.sendRedirect("carrito.jsp");

		

		
		
	}

}
