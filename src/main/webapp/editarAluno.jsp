<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="br.com.fmp.models.Aluno" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Editar Aluno</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/editarAlunoStyle.css">
	<script src="${pageContext.request.contextPath}/JS/alert.js" defer></script>

</head>
<body>
	<section>
		<div>
			<h1>Editar Aluno</h1>
		</div>
		<div>
			<form action="editar" method="post" onsubmit="mostrarAlerta(event)">
				<%
				List<Aluno> alunos = (List<Aluno>) getServletContext().getAttribute("alunos"); // Busco minha lista no Contexto Servlet
				
		        Integer id = Integer.valueOf(request.getParameter("id"));

		        for (Aluno aluno : alunos) { 
		            if (aluno.getId().equals(id)) {
				%>
				<input type="hidden" name="id" value="<%= id %>" readonly>
      			<label for="nome">Nome: </label>
        		<input type="text" id="nome" name="nome" value="<% out.println(aluno.getNome()); %>" required>
        		<br>
      			<label for="curso">Curso: </label>
        		<input type="text" id="curso" name="curso" value="<% out.println(aluno.getCurso()); %>" required>
				<br>
      			<label for="ano">Ano: </label>
				<input type="number" name="ano" value="<%= aluno.getAno() %>" required>
				
				<% 
                		break;
           			}
       			 }
				%>
				<br>
				<input type="submit" value="Cadastrar">
			</form>
		</div>
		<div id="voltarDiv">
			<a href="visualizar" id="voltar"> Voltar </a>
		</div>
	</section>
</body>
</html>