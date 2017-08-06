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
 
import org.beans.Ventas;
import org.utils.DBUtils;
import org.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/edicionVenta" })
public class edicionVenta extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   public edicionVenta() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       Connection conn = MyUtils.getStoredConnection(request);
 
       String idVentaStr = (String) request.getParameter("idVenta");
       String codigo = (String) request.getParameter("codigo");
       String articulo = (String) request.getParameter("articulo");
       String cantidadStr = (String) request.getParameter("cantidad");
       String costoStr = (String) request.getParameter("costo");
       float cantidad = 0;
       float costo = 0 ;
       int idVenta = 0;
       try {
    	   idVenta = Integer.parseInt(idVentaStr);
    	   cantidad = Float.parseFloat(cantidadStr);
           costo = Float.parseFloat(costoStr);
       } catch (Exception e) {
       }
       Ventas product = new Ventas(idVenta, codigo, articulo, cantidad, costo);
 
       String errorString = null;
 
       try {
           DBUtils.updateVenta(conn, product);
       } catch (SQLException e) {
           e.printStackTrace();
           errorString = e.getMessage();
       }
 
       // Store infomation to request attribute, before forward to views.
       request.setAttribute("errorString", errorString);
       request.setAttribute("nArticulo", product);
 
 
       // If error, forward to Edit page.
       if (errorString != null) {
           RequestDispatcher dispatcher = request.getServletContext()
                   .getRequestDispatcher("/WEB-INF/views/editarVenta.jsp");
           dispatcher.forward(request, response);
       }
        
       // If everything nice.
       // Redirect to the product listing page.            
       else {
           response.sendRedirect(request.getContextPath() + "/listaVentas");
       }
 
   }
 
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request, response);
   }
 
}