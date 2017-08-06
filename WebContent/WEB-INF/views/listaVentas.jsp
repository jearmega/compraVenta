<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Lista de Ventas</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <br>
    <center>
    	<jsp:include page="_menu.jsp"></jsp:include>
 	</center>
 
    <h3>Ventas</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Codigo</th>
          <th>Articulo</th>
          <th>Cantidad</th>
          <th>Costo</th>
          <th>Editar</th>
          <th>Borrar</th>
       </tr>
       <c:forEach items="${productList}" var="product" >
          <tr>
             <td>${product.codigo}</td>
             <td>${product.articulo}</td>
             <td>${product.cantidad}</td>
             <td>${product.costo}</td>
             <td>
                <a href="editarVenta?idVenta=${product.idVenta}">Editar</a>
             </td>
             <td>
                <a href="borrarVenta?idVenta=${product.idVenta}">Borrar</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="crearVenta" >Registrar Venta</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>