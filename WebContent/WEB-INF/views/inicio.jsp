<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Inicio</title>
  </head>
  <body>
 
     <jsp:include page="_header.jsp"></jsp:include>
     <br>
    <center>
    	<jsp:include page="_menu.jsp"></jsp:include>
 	</center>
    
    <table border="0" cellpadding="5" cellspacing="1" >
       <tr>
          <th widt="150" align="left">
		      <a href="https://www.facebook.com/LaEscondidaNovedades/" target="new">@LaEscondidaNovedades</a>
		      <ul>
		         <li>Venta de:</li>
		         <li>Ropa para toda la familia</li>
		         <li>Regalos</li>
				 <li>Juguetes</li>
				 <li>Papelería</li>
				 <li>Mercería</li>
				 <li>Productos Vianney</li>
				 <li>Productos Ilusión</li>
				 <li>Cosméticos</li>
				 <li>Y muchos artículos más....</li>
		      </ul>
		   </th>
		   <th widt="700" align="center">
		   		<a href="https://www.google.com.mx/maps/place/Novedades+La+Escondida/@24.0319679,-104.6934176,18z/data=!4m5!3m4!1s0x0:0x5f1d398c55a766fa!8m2!3d24.0318057!4d-104.6937733" target="new">
		   			<IMG SRC="ubicacion.jpg" WIDTH=580 HEIGHT=336 ALT="Ubicación">
		   		</a>
		   </th>
		</tr>
	</table> 
     <jsp:include page="_footer.jsp"></jsp:include>
 
  </body>
</html>