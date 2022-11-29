package com.jacaranda.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

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
	
	public static List<UsuarioArticulos> loadList(){
		Session session = Connection.getSession();
		List<UsuarioArticulos> list= new ArrayList<>();
		Query query=session.createQuery("SELECT ua FROM USUARIO_ARTICLES ua ORDER BY fecha ASC");
		list= query.getResultList();
		return list;
	}

	
	
	
}
