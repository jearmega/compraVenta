package org.beans;

public class Articulos {
	private String codigo;
	private String articulo;
	private float cantidad;
	private float costo;
	
	public Articulos(){
		
	}
	
	public Articulos(String codigo, String articulo, float cantidad, float costo){
		this.codigo = codigo;
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.costo = costo;
	}
	
	public String getCodigo(){
		return codigo;
	}

	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	
	public String getArticulo(){
			return articulo;
	}
	
	public void setArticulo(String articulo){
		this.articulo = articulo;
	}
	
	public float getCosto(){
		return costo;
	}
	
	public void setCosto(float costo){
		this.costo = costo;
	}
	
	public float getCantidad(){
		return cantidad;
	}
	
	public void setCantidad(float cantidad){
		this.cantidad = cantidad;
	}
}
