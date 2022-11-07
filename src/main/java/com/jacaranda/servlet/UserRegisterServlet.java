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

import com.jacaranda.control.UserControl;
import com.jacaranda.user.User;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/registerExec")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
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
		
		User u=new User(nickname, name, lastName, email, MD5(password), gender, date, false);
		UserControl uc = new UserControl();
		String redirect="main.jsp";
		if(uc.readUser(nickname)!=null) {//Comprobamos que el usuario no esté ya registrado
			redirect="errorRegister.jsp";
		}
		else {
			uc.addUser(u);
		}
		response.getWriter()
		.append("<html><head></head><body><script>location.href='" + redirect + "'</script></body></html>");


		
		
		doGet(request, response);
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
