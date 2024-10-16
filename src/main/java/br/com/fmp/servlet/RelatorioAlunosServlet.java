package br.com.fmp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fmp.models.Aluno;
import br.com.fmp.models.Nota;

@WebServlet("/aluno/relatorio")
public class RelatorioAlunosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//Busco minhas listas no Contexto Servlet
        List<Nota> notas = (List<Nota>) getServletContext().getAttribute("notas");
        
        //Crio um dicionário, onde meu Id vai ser do tipo Inteiro e meus dados serão listas do tipo Double.
        Map<Integer, List<Double>> notasPorAluno = new HashMap<>();
        
        //Verifico se minha lista de notas está vazia, se sim crio uma nova e armzeno ela no Contexto Servlet.
        if (notas == null) {
        	notas = new ArrayList<>();
        	getServletContext().setAttribute("notas", notas);
        }

        //Aqui eu percorro minha lista de notas adicionando os id's dos alunos e criando uma nova lista no meu discionário.
        for (Nota nota : notas) {
        	notasPorAluno.putIfAbsent(nota.getAlunoId(), new ArrayList<>());
        	notasPorAluno.get(nota.getAlunoId()).add(nota.getNota()); //Aqui eu armazeno as nota correspondentes ao id da mesma.
        }

        // Envio meu discionário para relatoriosAlunos.jsp
        request.setAttribute("notasPorAluno", notasPorAluno);
        request.getRequestDispatcher("/relatorioAlunos.jsp").forward(request, response);
    }
}

