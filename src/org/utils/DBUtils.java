package org.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import org.beans.Articulos;
import org.beans.Compras;
import org.beans.Ventas;
import org.beans.CuentaUsuario;
 
public class DBUtils {
 
  public static CuentaUsuario findUser(Connection conn, String nombre, String clave) throws SQLException {
 
      String sql = "Select a.nombre, a.clave from usuarios a "
              + " where a.nombre = ? and a.clave= ?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
  
	pstm.setString(1, nombre);
	pstm.setString(2, clave);
	
      ResultSet rs = pstm.executeQuery();
 
      if (rs.next()) {
          CuentaUsuario user = new CuentaUsuario();
          user.setNombre(nombre);
          user.setClave(clave);
          return user;
      }
      return null;
  }
 
  public static CuentaUsuario findUser(Connection conn, String nombre) throws SQLException {
 
      String sql = "Select a.nombre, a.clave from usuarios a " + " where a.nombre = ? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, nombre);
 
      ResultSet rs = pstm.executeQuery();
 
      if (rs.next()) {
          String clave = rs.getString("clave");
          CuentaUsuario user = new CuentaUsuario();
          user.setNombre(nombre);
          user.setClave(clave);
          return user;
      }
      return null;
  }
  
  public static List<Articulos> queryProduct(Connection conn) throws SQLException {
      String sql = "Select a.codigo, a.articulo, a.cantidad, a.costo from articulos a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Articulos> list = new ArrayList<Articulos>();
      while (rs.next()) {
          String codigo = rs.getString("codigo");
          String articulo = rs.getString("articulo");
          float cantidad = rs.getFloat("cantidad");
          float costo = rs.getFloat("costo");
          Articulos product = new Articulos();
          product.setCodigo(codigo);
          product.setArticulo(articulo);
          product.setCantidad(cantidad);
          product.setCosto(costo);
          list.add(product);
      }
      return list;
  }
  
  public static Articulos findProduct(Connection conn, String codigo) throws SQLException {
      String sql = "Select a.codigo, a.articulo, a.cantidad, a.costo from articulos a where a.codigo=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, codigo);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
          String articulo = rs.getString("articulo");
          float cantidad = rs.getFloat("cantidad");
          float costo = rs.getFloat("costo");
          Articulos product = new Articulos(codigo, articulo, cantidad, costo);
          return product;
      }
      return null;
  }
 
  public static void updateProduct(Connection conn, Articulos product) throws SQLException {
      String sql = "Update articulos set codigo =?, articulo =?, cantidad=?, costo=? where codigo=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, product.getCodigo());
      pstm.setString(2, product.getArticulo());
      pstm.setFloat(3, product.getCantidad());
      pstm.setFloat(4, product.getCosto());
      pstm.setString(5, product.getCodigo());
      pstm.executeUpdate();
  }
  
  public static void insertProduct(Connection conn, Articulos product) throws SQLException {
      String sql = "Insert into articulos(codigo, articulo, cantidad, costo) values (?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, product.getCodigo());
      pstm.setString(2, product.getArticulo());
      pstm.setFloat(3, product.getCantidad());
      pstm.setFloat(4, product.getCosto());
 
      pstm.executeUpdate();
  }
  
  public static void deleteProduct(Connection conn, String codigo) throws SQLException {
      String sql = "delete from articulos where codigo= ?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, codigo);
 
      pstm.executeUpdate();
  }
    
  public static void insertCompra(Connection conn, Compras product) throws SQLException {
      String sql = "Insert into compra(factura, codigo, cantidad, costo) values (?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, product.getFactura());
      pstm.setString(2, product.getCodigo());
      pstm.setFloat(3, product.getCantidad());
      pstm.setFloat(4, product.getCosto());
 
      pstm.executeUpdate();
      
      sql = "Update articulos set cantidad=cantidad+?,costo=? where codigo=?";
      
      pstm = conn.prepareStatement(sql);
 
      pstm.setFloat(1, product.getCantidad());   
      pstm.setFloat(2, product.getCosto());
      pstm.setString(3, product.getCodigo());
      
      pstm.executeUpdate();
  }
  
  public static List<Compras> queryCompras(Connection conn) throws SQLException {
      String sql = "Select a.idCompra,a.factura,a.codigo, b.articulo, a.cantidad, a.costo from compra a,articulos b where a.codigo=b.codigo";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Compras> list = new ArrayList<Compras>();
      while (rs.next()) {
    	  int idCompra = rs.getInt("idCompra");
    	  String factura = rs.getString("factura");
    	  String codigo = rs.getString("codigo");
    	  String articulo = rs.getString("articulo");
          float cantidad = rs.getFloat("cantidad");
          float costo = rs.getFloat("costo");
          Compras compra = new Compras();
          compra.setIdCompra(idCompra);
          compra.setFactura(factura);
          compra.setCodigo(codigo);
          compra.setArticulo(articulo);
          compra.setCantidad(cantidad);
          compra.setCosto(costo);
          list.add(compra);
      }
      return list;
  }
  
  public static Compras findCompra(Connection conn, int idCompra) throws SQLException {
      String sql = "Select a.idCompra, a.factura, a.codigo, b.articulo,a.cantidad, a.costo from compra a,articulos b where a.codigo=b.codigo and a.idCompra=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setInt(1, idCompra);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  int nIdCompra = rs.getInt("idCompra");
    	  String factura = rs.getString("factura");
          String codigo = rs.getString("codigo");
          String articulo = rs.getString("articulo");
          float cantidad = rs.getFloat("cantidad");
          float costo = rs.getFloat("costo");
          Compras compra = new Compras(nIdCompra, factura, codigo, articulo, cantidad, costo);
          return compra;
      }
      return null;
  }
  
  public static void updateCompra(Connection conn, Compras product) throws SQLException {
      String sql = "Update compra set factura=?, codigo =?, cantidad=?, costo=? where idCompra=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, product.getFactura());
      pstm.setString(2, product.getCodigo());
      pstm.setFloat(3, product.getCantidad());
      pstm.setFloat(4, product.getCosto());
      pstm.setInt(5, product.getIdCompra());
      pstm.executeUpdate();
  }
  
  public static void deleteCompra(Connection conn, String idCompra) throws SQLException {
      String sql = "delete from compra where idCompra= ?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, idCompra);
 
      pstm.executeUpdate();
  }

  public static void insertVenta(Connection conn, Ventas product) throws SQLException {
      String sql = "Insert into venta(codigo, cantidad, costo) values (?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, product.getCodigo());
      pstm.setFloat(2, product.getCantidad());
      pstm.setFloat(3, product.getCosto());
 
      pstm.executeUpdate();
      
      sql = "Update articulos set cantidad=cantidad+?,costo=? where codigo=?";
      
      pstm = conn.prepareStatement(sql);
 
      pstm.setFloat(1, product.getCantidad());   
      pstm.setFloat(2, product.getCosto());
      pstm.setString(3, product.getCodigo());
      
      pstm.executeUpdate();
  }
  
  public static List<Ventas> queryVentas(Connection conn) throws SQLException {
      String sql = "Select a.idVenta,a.codigo, b.articulo, a.cantidad, a.costo from venta a,articulos b where a.codigo=b.codigo";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Ventas> list = new ArrayList<Ventas>();
      while (rs.next()) {
    	  int idVenta = rs.getInt("idVenta");
    	  String codigo = rs.getString("codigo");
    	  String articulo = rs.getString("articulo");
          float cantidad = rs.getFloat("cantidad");
          float costo = rs.getFloat("costo");
          Ventas venta = new Ventas();
          venta.setIdVenta(idVenta);
          venta.setCodigo(codigo);
          venta.setArticulo(articulo);
          venta.setCantidad(cantidad);
          venta.setCosto(costo);
          list.add(venta);
      }
      return list;
  }
  
  public static void updateVenta(Connection conn, Ventas product) throws SQLException {
      String sql = "Update venta set codigo =?, cantidad=?, costo=? where idVenta=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, product.getCodigo());
      pstm.setFloat(2, product.getCantidad());
      pstm.setFloat(3, product.getCosto());
      pstm.setInt(4, product.getIdVenta());
      pstm.executeUpdate();
  }
  
  public static Ventas findVenta(Connection conn, String idVenta) throws SQLException {
      String sql = "Select a.idVenta, a.codigo, b.articulo,a.cantidad, a.costo from venta a,articulos b where a.codigo=b.codigo and a.idVenta=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, idVenta);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  int nIdVenta = rs.getInt("idVenta");
          String codigo = rs.getString("codigo");
          String articulo = rs.getString("articulo");
          float cantidad = rs.getFloat("cantidad");
          float costo = rs.getFloat("costo");
          Ventas venta = new Ventas(nIdVenta, codigo, articulo, cantidad, costo);
          return venta;
      }
      return null;
  }
  
  public static void deleteVenta(Connection conn, String idVenta) throws SQLException {
      String sql = "delete from venta where idVenta= ?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, idVenta);
 
      pstm.executeUpdate();
  }
}