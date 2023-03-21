<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="modelo.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuario</title>
</head>
<body>
	<% 
	ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
	 %>
	 <table class="table table-success table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Id</th>
		      <th scope="col">Nombre</th>
		      <th scope="col"></th>
		    </tr>
		  </thead>
		  <tbody>
		  <% for (Usuario usuario : usuarios) { %>
		    <tr>
		      <th scope="row"><% out.print(usuario.getId()); %></th>
		      <td><% out.print(usuario.getNombre()); %></td>
		      <td><a href="ElinarUsuario?id=<% out.print(usuario.getId()); %>">Eliminar</a> - </td>
		    </tr>
		    <% } %>
		    <tr>
		      <td><a href="InsertarUsuario?id=<% out.print(usuario.getId()); %>">Insertar</a> - </td>
		    </tr>
		</tbody>
	</table>
</body>
</html>