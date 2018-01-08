<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Finalizar Pedidos</title>
</head>
<body>
	<table>
		<tr>
			<td>Ação</td>
		</tr>
		<tr>
			<td>
				<form action="${s:mvcUrl('PC#finalizarPedido').build()}"method="post">
					<button type="submit" alt="Compre Agora" title="Aposte  Agora${loteria.nome}" >Apostar</button>
				</form>
			</td>
		</tr>
	</table>

</body>
</html>