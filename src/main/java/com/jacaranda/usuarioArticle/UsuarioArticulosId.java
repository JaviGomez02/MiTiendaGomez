package com.jacaranda.usuarioArticle;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Id;

public class UsuarioArticulosId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name_usuario;
	private int id_article;
	private LocalDateTime fecha;
	
	
	public UsuarioArticulosId() {
		super();
	}
	public String getUsuario() {
		return name_usuario;
	}
	public void setUsuario(String usuario) {
		this.name_usuario = usuario;
	}
	public int getArticle() {
		return id_article;
	}
	public void setArticle(int article) {
		this.id_article = article;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}
