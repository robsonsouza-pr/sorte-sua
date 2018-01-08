<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" 	prefix="security"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo=" Não dependa da sorte, saiba que ela é sua">
	<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${s:mvcUrl('HC#index').build()}">Sorte sua</a>
		</div>
		<div>
			<ul class="nav justify-content-center">

				<!-- também pode com <security:authorize access="hasRole('ROLE_ADMIN')"/> -->

				<security:authorize access="isAuthenticated()">
					<li class="nav-item"><a
						href="${s:mvcUrl('LC#listar').build()}" class="nav-link">Lista
							de Produtos</a></li>
					<li class="nav-item"><a href="${s:mvcUrl('LC#form').build()}"
						class="nav-link ">Cadastro de Produtos</a></li>
				</security:authorize>
				<li class="nav-item"><a href="#" class="nav-link ">Carrinho</a></li>
				<li class="nav-item"><a href="#" class="nav-link ">Sobre
						Nós</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<table class="table table-striped table-bordered table-hover">
		<tr>
			<th>Nome:</th>
		</tr>
		<c:forEach items="${loterias}" var="loteria">
			<tr>
				<td>${loteria.nome}</td>
			</tr>
		</c:forEach>
	</table>
</tags:pageTemplate>
