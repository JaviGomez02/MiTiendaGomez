package com.jacaranda.carrito;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

	private List<CarritoItem> items=new ArrayList<CarritoItem>();

	public Carrito() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean addItem(CarritoItem c) {
		boolean resultado=false;
		if(!items.contains(c)) {
			this.items.add(c);
			resultado=true;
		}
		return resultado;
	}
	
	public boolean deleteItem(CarritoItem c) {
		boolean resultado=false;
		if(items.contains(c)) {
			this.items.remove(c);
			resultado=true;
		}
		return resultado;
	}
	
	public boolean updateItem(CarritoItem c, int cantidad) {
		boolean resultado=false;
		if(items.contains(c)) {
			this.items.get(this.items.indexOf(c)).setCantidad(cantidad);
			resultado=true;
		}
		return resultado;
	}
}
