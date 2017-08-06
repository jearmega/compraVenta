<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<div style="background: #E0E0E0; height: 100px; padding: 5px;">
	
  <div style="float: left">
  <table border="0"  >
       <tr>
          <th><IMG SRC="fachada.jpg" WIDTH=100 HEIGHT=100 ALT="Novedades La Escondida"></th>
          <th align="center" width="650"><h1>Novedades La Escondida</h1></th>  
       </tr>
  </table>
     
  </div>
 
  <div style="float: right; padding: 10px; text-align: right;">
 
     <!-- User store in session with attribute: loginedUser -->
     ¡Bienvenid@!  <b>${loginedUser.userName}</b>
   <br/>
     
 
  </div>
 
</div>