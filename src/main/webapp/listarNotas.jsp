<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="br.com.fmp.models.Nota" %>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Notas</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/listarStyle.css">
</head>
<body>
    <section>
        <h1>Lista de Notas</h1>
    </section>

    <section>
        <table>
            <tr>
                <th>ID</th>
                <th>ID Aluno</th>
                <th>Disciplina</th>
                <th>Nota</th>
                <th></th>
            </tr>
            <%
            
            List<Nota> notas = (List<Nota>) getServletContext().getAttribute("notas");
			
            
            if (notas == null){
            	notas = new ArrayList<Nota>();
            }
            
            for (Nota nota : notas) { 
            %>
            <tr>
                <td><%out.println(nota.getId()); %></td>
                <td><%out.println(nota.getAlunoId()); %></td>
                <td><%out.println(nota.getDisciplina()); %></td>
                <td><%out.println(nota.getNota()); %></td>
                <td></td>
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
