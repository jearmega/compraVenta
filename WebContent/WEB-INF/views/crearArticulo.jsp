<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Create Product</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
    
    <h3>Crear Articulo</h3>
    
    <p style="color: red;">${errorString}</p>
    
    <form method="POST" action="creacionArticulo">
       <table border="0">
          <tr>
             <td>Codigo</td>
             <td><input type="text" name="codigo" value="${nArticulo.codigo}" /></td>
          </tr>
          <tr>
             <td>Articulo</td>
             <td><input type="text" name="articulo" value="${nArticulo.articulo}" /></td>
          </tr>
          <tr>
             <td>Cantidad</td>
             <td><input type="text" name="cantidad" value="${nArticulo.cantidad}" /></td>
          </tr>
          <tr>
             <td>Costo</td>
             <td><input type="text" name="costo" value="${nArticulo.costo}" /></td>
          </tr>
          <tr>
             <td colspan="2">                  
                 <input type="submit" value="Submit" />
                 <a href="listaArticulos">Cancel</a>
             </td>
          </tr>
       </table>
    </form>
    
    <jsp:include page="_footer.jsp"></jsp:include>
    
 </body>
</html>