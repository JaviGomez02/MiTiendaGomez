package com.jacaranda.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;


import com.jacaranda.user.User;

public class UserControl {
	
	public static User readUser(String username) {
		Session session = Connection.getSession();

		User u=null;
		try {
			u= (User) session.get(User.class,username);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return u;
	}
	public static boolean addUser(User u) {
		Session session = Connection.getSession();

		boolean resultado=false;
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(u);
			session.getTransaction().commit();
			resultado=true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	
	public static List<User> loadList(){
		Session session = Connection.getSession();
		List<User> list= new ArrayList<>();
		Query query=session.createQuery("SELECT u FROM USUARIO u");
		list= query.getResultList();
		return list;
		
	}
}
