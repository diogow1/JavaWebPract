package br.com.fmp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fmp.models.Aluno;
import br.com.fmp.servlet.AlunoServlet;

@WebServlet("/aluno/cadastrar")
public class CadastrarAlunoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.getRequestDispatcher("/cadastrarAluno.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Armazeno os dados fornecidos pelo request.
		String nome = request.getParameter("nome");
		String curso = request.getParameter("curso");
		Integer ano = Integer.valueOf(request.getParameter("ano"));
		
		 // Busco minha lista de Alunos e o Id no Contexto Servlet e armazeno elas.
		List<Aluno> alunos = (List<Aluno>) getServletContext().getAttribute("alunos");
		Integer nextAlunoId = (Integer) getServletContext().getAttribute("nextAlunoId");
		
		//Verifico se minha lista está vazia, se sim ele cria uma nova e armazena no Contexto Servlet
	    if (alunos == null) {
            alunos = new ArrayList<>(); 
            getServletContext().setAttribute("alunos", alunos);
        }
		
	  //Verifico se meu Id está vazio, se sim ele adiciona o parâmetro default e armazena no Contexto Servlet
        if (nextAlunoId == null) {
            nextAlunoId = 1; 
        }
        
        //Crio um novo objeto do tipo Aluno e armazeno na minha lista.
		Aluno aluno = new Aluno(nextAlunoId, nome, curso, ano);
		alunos.add(aluno);
		
	    //Atualizo os atributos no Contexto Servlet.
		getServletContext().setAttribute("alunos", alunos);
        getServletContext().setAttribute("nextAlunoId", nextAlunoId + 1 );
		
		response.sendRedirect("visualizar");
		
		
	}
}
