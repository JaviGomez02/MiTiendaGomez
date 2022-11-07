package com.jacaranda.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.jacaranda.user.User;

public class UserControl {
	private StandardServiceRegistry sr;
	private SessionFactory sf;
	private Session session;
	
	public UserControl() {
		super();
		sr = new StandardServiceRegistryBuilder().configure().build();
		sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		session = sf.openSession();
	}
	public User readUser(String username) {
		User u=null;
		try {
			u= (User) session.get(User.class,username);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return u;
	}
	public boolean addUser(User u) {
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
	
	public List<User> loadList(){

		List<User> list= new ArrayList<>();
		Query query=session.createQuery("SELECT u FROM USUARIO u");
		list= query.getResultList();
		return list;
		
	}
}
