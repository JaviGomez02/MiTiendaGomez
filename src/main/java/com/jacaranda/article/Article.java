package com.jacaranda.article;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.jacaranda.categoria.Categoria;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Entity(name = "ARTICLES")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String nombre;
	@Column(name="description")
	private String descripcion;
	@Column(name="price")
	private Double precio;
	@Column(name="stock")
	private int stock;
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
//	@Transient
//	private String url;

	
	public Article(String nombre, String descripcion, Double precio, int stock, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock=stock;
		this.categoria = categoria;
	}
	public Article(int id, String nombre, String descripcion, Double precio, int stock, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock=stock;
		this.categoria = categoria;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	
//	public String getUrl() {
//		return url;
//	}
//	public void setUrl(String url) {
//		this.url = url;
//	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", categoria=" + categoria + "]";
	}
	

	

}
