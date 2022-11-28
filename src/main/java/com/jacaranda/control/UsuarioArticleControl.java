package com.jacaranda.control;

import org.hibernate.Session;

import com.jacaranda.usuarioArticle.UsuarioArticulos;

public class UsuarioArticleControl {
	public static boolean addUsuarioArticle(UsuarioArticulos u) {
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

	
	
	
}
