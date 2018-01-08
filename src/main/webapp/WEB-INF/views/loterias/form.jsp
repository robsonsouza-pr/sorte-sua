<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo=" Não dependa da sorte, saiba que ela é sua">

	<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${s:mvcUrl('HC#index').build()}">Sorte sua</a>
		</div>
		<div>
			<ul class="nav justify-content-center">
				<li class="nav-item"><a href="${s:mvcUrl('LC#listar').build()}" class="nav-link" >Lista de Produtos</a></li>
				<li class="nav-item"><a href="${s:mvcUrl('LC#form').build()}" class="nav-link ">Cadastro de Produtos</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<!--  O enctype informa ao form que ele enviará um arquivo como parâmetro do método -->
	<!--  Essa action é uma nova forma de chamar o método gravar sem perder o contexto da aplicação -->
	<div class="container">
		<form:form action="${s:mvcUrl('LC#gravar').build()}" method="post"
			commandName="loteria" enctype="multipart/form-data">
			<div class="form-group">
				<label>Nome</label>
				<form:input path="nome" cssClass="form-control" />
				<form:errors path="nome" />
			</div>
			<div class="form-group">
				<label>Descrição</label>
				<form:textarea path="descricao" cssClass="form-control" />
				<form:errors path="descricao" />
			</div>
			<div class="form-group">
				<label>Dígitos</label>
				<form:input path="digitos" cssClass="form-control" />
				<form:errors path="digitos" />
			</div>
			<div class="form-group">
				<label>Data de Cadastro</label>
				<form:input path="dataCadastro" cssClass="form-control" />
				<form:errors path="dataCadastro" />
			</div>
			<div class="form-group">
				<label>Sumário</label> <input name="sumario" type="file"
					class="form-control" />
			</div>
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form:form>
	</div>
</tags:pageTemplate>