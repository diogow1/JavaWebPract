<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastrar Aluno</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cadastrarAlunoStyle.css">
	<script src="${pageContext.request.contextPath}/JS/alert.js" defer></script>
	</head>
<body>
	<section>
		<div>
			<h1>Cadastrar Aluno</h1>
		</div>
		<div>
			<form action="cadastrar" method="post" onsubmit="mostrarAlerta(event)">
      			<label for="nome">Nome: </label>
        		<input type="text" id="nome" name="nome" required>
        		<br>
      			<label for="curso">Curso: </label>
        		<input type="text" id="curso" name="curso" required>
				<br>
      			<label for="ano">Ano: </label>
				<input type="number" name="ano" required>
				<br>
				<input type="submit" value="Cadastrar">
			</form>
		</div>
		<div id="voltarDiv">
			<a href="${pageContext.request.contextPath}/" id="voltar"> Voltar </a>
		</div>
	</section>
</body>
</html>