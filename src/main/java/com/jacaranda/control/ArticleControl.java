package com.jacaranda.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.jacaranda.article.Article;
import com.jacaranda.categoria.Categoria;

public class ArticleControl {
	public static Article readArticle(int id) {
		Session session = Connection.getSession();

		Article a=null;
		try {
			a= (Article) session.get(Article.class,id);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return a;
	}
	public static boolean addArticle(Article a) {
		Session session = Connection.getSession();

		boolean resultado=false;
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(a);
			session.getTransaction().commit();
			resultado=true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	
	public static List<Article> loadList(){
		Session session = Connection.getSession();
		List<Article> list= new ArrayList<>();
		Query query=session.createQuery("SELECT a FROM ARTICLES a");
		list= query.getResultList();
		return list;
		
	}

}
