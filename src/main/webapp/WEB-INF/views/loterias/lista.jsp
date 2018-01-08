<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo=" Não dependa da sorte, saiba que ela é sua">

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="${s:mvcUrl('HC#index').build()}">Sorte
					sua</a>
			</div>
			<div>
				<ul class="nav justify-content-center">
					<li class="nav-item"><a
						href="${s:mvcUrl('LC#listar').build()}" class="nav-link">Lista
							de Produtos</a></li>
					<li class="nav-item"><a href="${s:mvcUrl('LC#form').build()}"
						class="nav-link ">Cadastro de Produtos</a></li>
				</ul>
			</div>
		</div>
	</nav>



	<div class="container">
		${sucesso}
		<table class="table table-striped table-bordered table-hover">
			<tr>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Digitos</th>
				<th>Data</th>
				<th>Imagem</th>
			</tr>

			<c:forEach items="${loterias}" var="loteria">
				<tr>
					<td><a
						href="${s:mvcUrl('LC#detalhe').arg(0, loteria.id).build()}">${loteria.nome}</a></td>
					<td>${loteria.descricao}</td>
					<td>${loteria.digitos}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${loteria.dataCadastro.time}" /></td>
					<td><img src="<c:url value='${loteria.sumarioPath}'/>" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</tags:pageTemplate>