package com.jacaranda.usuarioArticle;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

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
		UsuarioArticulosId other = (UsuarioArticulosId) obj;
		return Objects.equals(fecha, other.fecha) && id_article == other.id_article
				&& Objects.equals(name_usuario, other.name_usuario);
	}

	
}
