package org.beans;

public class CuentaUsuario {
	   public static final String GENDER_MALE ="M";
	   public static final String GENDER_FEMALE = "H";
	    
	   private String nombre;
	   private String sexo;
	   private String clave;
	    
	 
	   public CuentaUsuario() {
	        
	   }
	    
	   public String getNombre() {
	       return nombre;
	   }
	 
	   public void setNombre(String nombre) {
	       this.nombre = nombre;
	   }
	 
	   public String getSexo() {
	       return sexo;
	   }
	 
	   public void setSexo(String sexo) {
	       this.sexo = sexo;
	   }
	 
	   public String getClave() {
	       return clave;
	   }
	 
	   public void setClave(String clave) {
	       this.clave = clave;
	   }
}
