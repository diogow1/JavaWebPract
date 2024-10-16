<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="br.com.fmp.models.Aluno" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Nota</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cadastrarNotasStyle.css">
    <script src="${pageContext.request.contextPath}/JS/alert.js" defer></script>
    <src>
</head>
<body>
    <section>
        <h1>Cadastrar Nota</h1>
        <form action="cadastrar" method="post" onsubmit="mostrarAlerta(event)">
            <label for="aluno">Aluno:</label>
            <select id="aluno" name="alunoId" required>
                <option value="">Selecione um aluno</option>
                <%
                List<Aluno> alunos = (List<Aluno>) application.getAttribute("alunos"); //Busco minha lista nos parametros passado pelo request.
                if (alunos != null) { // Verifico se ela está vazia, se não crio um loop para popular meu Select com os alunos.
                	for (Aluno aluno : alunos) {
                %>
                <option value="<%= aluno.getId() %>"><%= aluno.getNome() %></option>
                <%
                    }
                }
                %>
            </select>

            <label for="disciplina">Disciplina:</label>
            <input type="text" id="disciplina" name="disciplina" required>

            <label for="nota">Nota:</label>
            <input type="number" id="nota" name="nota" step="0.1" min="0" max="10" required>

           	<input type="submit" value="Cadastrar Nota">

        </form>
        <div id="voltarDiv">
            <a href="${pageContext.request.contextPath}/" id="voltar" >Voltar</a>
        </div>
    </section>
</body>
</html>
