<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo=" Meu Ovo">

	<h1>Listando Resultados</h1>
<div class="container">
	<table class="table table-striped table-bordered table-hover">
		<tr>
			<th>Data do sorteio</th>
			<th>Loteria</th>
			<th>Acumulou ?</th>
			<th>Conferir?</th>
		</tr>
		<c:forEach items="${sorteios}" var="sorteio">
			<tr>
				<td><fmt:formatDate value="${sorteio.dataSorteio.time}"
						pattern="dd/MM/yyyy" /></td>
				<td>${sorteio.tipo.nome}</td>
				<td>${sorteio.acumulou }</td>
				<td><a
						href="${s:mvcUrl('AC#form').arg(0, sorteio.id).build()}">Conferir</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</tags:pageTemplate>