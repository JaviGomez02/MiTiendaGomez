package com.jacaranda.carrito;


import java.time.LocalDateTime;
import java.util.Objects;

public class CarritoItem {

	private String usuario;
	private int idItem;
	private int cantidad;
	private Double precio;
	private LocalDateTime fecha;
	
	public CarritoItem(String usuario, int idItem, int cantidad, Double precio, LocalDateTime fecha) {
		super();
		this.usuario = usuario;
		this.idItem = idItem;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fecha = fecha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
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

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "CarritoItem [usuario=" + usuario + ", idItem=" + idItem + ", cantidad=" + cantidad + ", precio="
				+ precio + ", fecha=" + fecha + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idItem, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarritoItem other = (CarritoItem) obj;
		return idItem == other.idItem && Objects.equals(usuario, other.usuario);
	}


	
}
