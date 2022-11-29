package com.jacaranda.usuarioArticle;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jacaranda.article.Article;
import com.jacaranda.user.User;
@Entity (name="USUARIO_ARTICLES")
@IdClass(UsuarioArticulosId.class)

public class UsuarioArticulos {
	
	@Id 
	@ManyToOne
	@JoinColumn(name="name_usuario", insertable=false, updatable=false)
	User name_usuario;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_article", insertable=false, updatable=false)
	Article id_article;
	
	@Id
	LocalDateTime fecha;
	
	int cantidad;
	
	Double precio;

	public UsuarioArticulos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioArticulos(User name_usuario, Article id_article, LocalDateTime fecha, int cantidad, Double precio) {
		super();
		this.name_usuario = name_usuario;
		this.id_article = id_article;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public User getName_usuario() {
		return name_usuario;
	}

	public void setName_usuario(User name_usuario) {
		this.name_usuario = name_usuario;
	}

	public Article getId_article() {
		return id_article;
	}

	public void setId_article(Article id_article) {
		this.id_article = id_article;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, id_article, name_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioArticulos other = (UsuarioArticulos) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(id_article, other.id_article)
				&& Objects.equals(name_usuario, other.name_usuario);
	}
	
	

}
