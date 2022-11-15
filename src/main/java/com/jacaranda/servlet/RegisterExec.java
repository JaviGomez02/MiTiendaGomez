package com.jacaranda.servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		LocalDate date=LocalDate.parse(request.getParameter("fecha"));
		char gender=request.getParameter("genero").charAt(0);
		
		User u=new User(nickname, name, lastName, email, Utilidades.MD5(password), gender, date, false);
		if(UserControl.readUser(nickname)!=null) {//Comprobamos que el usuario no esté ya registrado
			response.sendRedirect("error.jsp?msg=2");
		}
		else {
			UserControl.addUser(u);
			response.sendRedirect("index.jsp");
		}
	}

}
