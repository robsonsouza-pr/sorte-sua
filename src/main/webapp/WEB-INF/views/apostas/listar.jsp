<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo=" Não dependa da sorte">

	<!--  O enctype informa ao form que ele enviará um arquivo como parâmetro do método -->
	<!--  Essa action é uma nova forma de chamar o método gravar sem perder o contexto da aplicação -->
	<div class="container">

		<table>
			<tr>
				<th>Loteria</th>
				<th>Concurso</th>
				<th>Dezenas</th>
				<th>Acerto</th>
			</tr>
			<c:forEach items="${apostas}" var="aposta">
			<tr>
				<td>${aposta.tipo.tipo.nome}</td>
				<td>${aposta.tipo.numero}</td>
				<td>${aposta.dezenasFormatadas}</td>
				<td>0</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</tags:pageTemplate>