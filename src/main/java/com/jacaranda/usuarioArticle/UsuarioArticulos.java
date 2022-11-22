package com.jacaranda.usuarioArticle;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.jacaranda.article.Article;
import com.jacaranda.user.User;
@Entity (name="USUARIO_ARTICLES")
@IdClass(UsuarioArticulosId.class)

public class UsuarioArticulos {
	
	@Id 
	User name_usuario;
	
	@Id
	Article id_article;
	
	@Id
	LocalDateTime fecha;
	
	int cantidad;
	

}
