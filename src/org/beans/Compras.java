package org.beans;

public class Compras {
	private int idCompra;
	private String factura;
	private String codigo;
	private String articulo;
	private float cantidad;
	private float costo;
	
	public Compras(){
		
	}
	
	public Compras(int idCompra, String factura, String codigo, String articulo,float cantidad, float costo){
		this.idCompra = idCompra;
		this.factura = factura;
		this.codigo = codigo;
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.costo = costo;
	}
	
	public int getIdCompra(){
		return idCompra;
	}
	
	public void setIdCompra(int idCompra){
		this.idCompra = idCompra;
	}
	
	public String getFactura(){
			return factura;
	}
	
	public void setFactura(String factura){
		this.factura = factura;
	}
	
	public String getCodigo(){
		return codigo;
	}

	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	
	public String getArticulo(){
		return factura;
	}
	
	public void setArticulo(String factura){
		this.factura = factura;
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
