package com.jacaranda.servlet;

import java.io.IOException;

import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jacaranda.control.UserControl;
import com.jacaranda.control.Utilidades;
import com.jacaranda.user.User;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/registerExec")
public class RegisterExec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterExec() {
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
		String nickname = request.getParameter("nombre");
		String password = request.getParameter("password");
		String email=request.getParameter("email");
		String name=request.getParameter("nombrePropio");
		String lastName=request.getParameter("apellidos");
		String date=request.getParameter("fecha");
		String gender=request.getParameter("genero");
		

		boolean error=false;
		int msgError=0;
		
		if(nickname!=null && password!=null && email!=null && name!=null && lastName!=null && date!=null && gender!=null && !nickname.isEmpty() && !password.isEmpty() && !email.isEmpty() && !name.isEmpty() && !lastName.isEmpty() && !date.isEmpty() && !gender.isEmpty()) {
			if(UserControl.readUser(nickname)!=null) {//Comprobamos que el usuario no esté ya registrado
				error=true;
				msgError=2;
			}
			else {
				User u=new User(nickname, name, lastName, email, Utilidades.MD5(password), gender.charAt(0), LocalDate.parse(date), false);
				UserControl.addUser(u);
			}
		}
		else {
			error=true;
			msgError=4;
			
		}
		if(error) {
			response.sendRedirect("error.jsp?msg="+msgError);
		}
		else {
			response.sendRedirect("index.jsp");
		}
	}

}
