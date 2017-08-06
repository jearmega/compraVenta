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
 
@WebServlet(urlPatterns = { "/editarVenta" })
public class editarVenta extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public editarVenta() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String idVenta = (String) request.getParameter("idVenta");
 
        Ventas product = null;
 
        String errorString = null;
       
        
        try {
        	product = DBUtils.findVenta(conn, idVenta);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
         
        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.
        if (errorString != null && product == null) {
            response.sendRedirect(request.getServletPath() + "/listaVentas");
            return;
        }
 
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("nArticulo", product);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editarVenta.jsp");
        dispatcher.forward(request, response);
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}
