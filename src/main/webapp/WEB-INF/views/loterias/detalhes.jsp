<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Loterias</title>
</head>
<body>
	<table>
		<tr>
			<td>Nome</td>
			<td>Descrição</td>
			<td>Digitos</td>
			<td>Data</td>
			<td>Imagem</td>
			<td>Ação</td>
			<td> quantidade</td>
		</tr>
		<tr>
			<td>${loteria.nome}</td>
			<td>${loteria.descricao}</td>
			<td>${loteria.digitos}</td>
			<td><fmt:formatDate pattern="dd/MM/yyyy"
					value="${loteria.dataCadastro.time}" /></td>
			<td><img src="${loteria.sumarioPath}" /></td>
			<td>
				<form action='<c:url value="/carrinho/add" />' method="post">
					<input type="hidden" name="loteriaId" value="${loteria.id}" />
					<button type="submit" alt="Compre Agora" title="Aposte  Agora${loteria.nome}" >Apostar</button>
				</form>
			</td>
			<td><a href='${s:mvcUrl('PC#finalizarPedido').build()}' rel="nofollow">Carrinho (${carrinhoAposta.quantidade}) </a></td>
		</tr>
	</table>

</body>
</html>