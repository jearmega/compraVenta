package org.beans;

public class Ventas {
	private int idVenta;
	private String codigo;
	private String articulo;
	private float cantidad;
	private float costo;
	
	public Ventas(){
		
	}
	
	public Ventas(int idVenta, String codigo, String articulo,float cantidad, float costo){
		this.idVenta = idVenta;
		this.codigo = codigo;
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.costo = costo;
	}
	
	public int getIdVenta(){
		return idVenta;
	}
	
	public void setIdVenta(int idVenta){
		this.idVenta = idVenta;
	}
	
	public String getCodigo(){
		return codigo;
	}

	public void setArticulo(String articulo){
		this.articulo = articulo;
	}
	
	public String getArticulo(){
		return articulo;
	}

	public void setCodigo(String codigo){
		this.codigo = codigo;
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
