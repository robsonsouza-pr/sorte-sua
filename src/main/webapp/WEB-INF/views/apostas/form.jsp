<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo=" Não dependa da sorte, saiba que ela é sua">

	<!--  O enctype informa ao form que ele enviará um arquivo como parâmetro do método -->
	<!--  Essa action é uma nova forma de chamar o método gravar sem perder o contexto da aplicação -->
	<div class="container">

		<!-- <form action="carrinho/remover/${item.produto.id}/${item.tipoPreco}" method="post"> tentar assim -->
		<form:form action="${s:mvcUrl('AC#gravar').build() }" method="POST"
			commandName="aposta">

			<div class="form-group">
				<c:forEach items="${dezenasPossiveis}" var="dezena">
					<form:checkbox path="dezenasSelecionadas" value="${dezena}" label="${dezena.id}" />
					<form:errors path="dezenasSelecionadas" cssClass="error" />
				</c:forEach>
			</div>
			<form:hidden path="tipoId" />

			<button type="submit" class="btn btn-primary">Apostar</button>
		</form:form>
	</div>
</tags:pageTemplate>