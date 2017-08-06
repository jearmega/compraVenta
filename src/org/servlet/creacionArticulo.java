package org.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.beans.Articulos;
import org.utils.DBUtils;
import org.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/creacionArticulo" })
public class creacionArticulo extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   public creacionArticulo() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       Connection conn = MyUtils.getStoredConnection(request);
 
       String codigo = (String) request.getParameter("codigo");
       String articulo = (String) request.getParameter("articulo");
       String cantidadStr = (String) request.getParameter("cantidad");
       String costoStr = (String) request.getParameter("costo");
       float cantidad = 0;
       float costo = 0;
       try {
    	   cantidad = Float.parseFloat(cantidadStr);
    	   costo = Float.parseFloat(costoStr);
    	   
       } catch (Exception e) {
       }
       Articulos nArticulo = new Articulos(codigo, articulo, cantidad, costo);
 
       String errorString = null;
 
      
       // Product ID is the string literal [a-zA-Z_0-9]
       // with at least 1 character
       String regex = "\\w+";
 
       if (codigo == null || !codigo.matches(regex)) {
           errorString = "Codigo de artículo invalido!";
       }
 
       if (errorString == null) {
           try {
               DBUtils.insertProduct(conn, nArticulo);
           } catch (SQLException e) {
               e.printStackTrace();
               errorString = e.getMessage();
           }
       }
        
       // Store infomation to request attribute, before forward to views.
       request.setAttribute("errorString", errorString);
       request.setAttribute("nArticulo", nArticulo);
 
       // If error, forward to Edit page.
       if (errorString != null) {
           RequestDispatcher dispatcher = request.getServletContext()
                   .getRequestDispatcher("/WEB-INF/views/crearArticulo.jsp");
           dispatcher.forward(request, response);
       }
 
       // If everything nice.
       // Redirect to the product listing page.            
       else {
           response.sendRedirect(request.getContextPath() + "/listaArticulos");
       }
 
   }
 
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request, response);
   }
 
}
