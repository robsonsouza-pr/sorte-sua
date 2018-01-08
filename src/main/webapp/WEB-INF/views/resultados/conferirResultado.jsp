<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo=" Meu Ovo">

	<h1>Conferir resultados</h1>

	<div class="container">

		Sorteio número : ${resultado.sorteio.numero} Data:
		<fmt:formatDate value="${resultado.sorteio.dataSorteio.time}"
			pattern="dd/MM/yyyy" />

		<br> Dezenas: ${resultado.dezenasFormatadas } <br>
	</div>
		<h1>Sua Aposta</h1>

	<div class="container">
		<form:form action="${s:mvcUrl('RC#form').build()}"  method="post" commandName="resultado" >
						<div class="form-group">
				<form:checkboxes items="${dezenasPossiveis}" path="dezenasSelecionadas"  element="div  class='form-check form-check-inline'"/>
				</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Conferir</button>
			</div>
		</form:form>
	</div>

</tags:pageTemplate>