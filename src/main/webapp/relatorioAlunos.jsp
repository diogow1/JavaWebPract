<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="br.com.fmp.models.Aluno" %>
<%@ page import="br.com.fmp.models.Nota" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

<%@ page import="java.util.stream.Collectors" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Relatório de Alunos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/listarStyle.css">
</head>
<body>
    <section>
        <h1>Relatório de Alunos</h1>
    </section>

    <section>
        <table>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Curso</th>
                <th>Ano</th>
                <th>Notas</th>
                <th>Média</th>
            </tr>
            <%
            List<Aluno> alunos = (List<Aluno>) getServletContext().getAttribute("alunos"); //Busco minha lista no Contexto Servlet
            
            Map<Integer, List<Double>> notasPorAluno = (Map<Integer, List<Double>>) request.getAttribute("notasPorAluno"); //Busco meu discionário no parâmetro passado pelo request.


            if (alunos != null) {
            	
                for (Aluno aluno : alunos) {
                	
                	// Tento recuperar a lista de notas correspondente ao ID do aluno. Se não encontrar (ou seja, se o ID não estiver presente no discionário), retorna uma nova lista vazia.
                    List<Double> notasDoAluno = notasPorAluno.getOrDefault(aluno.getId(), new ArrayList<>());
                    double media = 0;

                    if (!notasDoAluno.isEmpty()) {
                        media = notasDoAluno.stream().mapToDouble(Double::doubleValue).average().orElse(0); // O método averange calcula a média dos valores presentes no stream. Se não houver notas, será 0.
                    }
            %>
            <tr>
                <td><% out.println(aluno.getId()); %></td>
                <td><% out.println(aluno.getNome()); %></td>
                <td><% out.println(aluno.getCurso()); %></td>
                <td><% out.println(aluno.getAno()); %></td>
                <%
                // Transformo a lista de notas em uma string com o stream separando os valores com uma ",".
                // Com o map eu converto os valores para string.
                // O método collect transforma uma stream em outro formato. Aqui, estamos usando Collectors.joining(", ") para unir as strings em uma única string, separando cada nota por uma vírgula e um espaço.
                %>
                <td><% out.println(notasDoAluno.stream().map(String::valueOf).collect(Collectors.joining(", "))); %></td>
				<td><%= String.format("%.2f", media) %></td>

            </tr>
            <%
                }
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
