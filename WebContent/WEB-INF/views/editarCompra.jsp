<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Editar Compra</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Editar Compra</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <c:if test="${not empty producto}">
       <form method="POST" action="edicionCompra">
          <input type="hidden" name="idCompra" value="${producto.idCompra}" />
          <table border="0">
             <tr>
                <td>idCompra</td>
                <td style="color:red;">${producto.idCompra}</td>
             </tr>
             <tr>
                <td>Factura</td>
                <td><input type="text" name="factura" value="${producto.factura}" /></td>
             </tr>
             <tr>
                <td>Codigo</td>
                <td><input type="text" name="codigo" value="${producto.codigo}" /></td>
             </tr>
             <tr>
                <td>Cantidad</td>
                <td><input type="text" name="cantidad" value="${producto.cantidad}" /></td>
             </tr>
             <tr>
                <td>Costo</td>
                <td><input type="text" name="costo" value="${producto.costo}" /></td>
             </tr>
             <tr>
                <td colspan = "2">
                    <input type="submit" value="Submit" />
                    <a href="${pageContext.request.contextPath}/listaCompras">Cancel</a>
                </td>
             </tr>
          </table>
       </form>
    </c:if>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>