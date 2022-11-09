package com.jacaranda.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.jacaranda.categoria.Categoria;

public class CategoriaControl {
	public static Categoria readCategoria(int id) {
		Session session = Connection.getSession();

		Categoria c=null;
		try {
			c= (Categoria) session.get(Categoria.class,id);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return c;
	}
	public static boolean addCategoria(Categoria c) {
		Session session = Connection.getSession();

		boolean resultado=false;
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(c);
			session.getTransaction().commit();
			resultado=true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	
	public static List<Categoria> loadList(){
		Session session = Connection.getSession();
		List<Categoria> list= new ArrayList<>();
		Query query=session.createQuery("SELECT c FROM CATEGORIA c");
		list= query.getResultList();
		return list;
		
	}

}
