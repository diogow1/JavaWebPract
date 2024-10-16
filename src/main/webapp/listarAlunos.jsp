<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="br.com.fmp.models.Aluno" %>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Alunos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/listarStyle.css">
</head>
</head>
<body>
    <section>
        <h1>Lista de Alunos</h1>
    </section>

    <section>
        <table>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Curso</th>
                <th>Ano</th>
                <th></th>
            </tr>
            <%
    		List<Aluno> alunos = (List<Aluno>) getServletContext().getAttribute("alunos"); // Busco minha lista no Contexto Servlet
            
            if (alunos == null) { // Verifico se ela está vazia, se sim cria uma nova lista do tipo Aluno.
                alunos = new ArrayList<Aluno>();
            }
            
            for (Aluno aluno : alunos) { 
            %>
            <tr>
                <td><%out.println(aluno.getId()); %></td>
                <td><%out.println(aluno.getNome()); %></td>
                <td><%out.println(aluno.getCurso()); %></td>
                <td><%out.println(aluno.getAno()); %></td>
                <td>
					<a href="/SistemaEscola/aluno/editar?id=<%= aluno.getId() %>">Editar</a>
					<a href="/SistemaEscola/aluno/excluir?id=<%= aluno.getId() %>">Excluir</a>
	
                </td>
            </tr>
            <%
            }
            %>
        </table>
    </section>
    <section id="voltarSec">
    	<div>
			<a href="${pageContext.request.contextPath}/"  id="voltar" > Voltar </a>
		</div>
    </section>
</body>
</html>
