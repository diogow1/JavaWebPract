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

@WebServlet("/aluno")
public class AlunoServlet extends HttpServlet {
	
	// Cria uma lista do tipo Aluno e um ID.
	private List<Aluno> alunos = new ArrayList<>(); 
	private int nextAlunoId = 1;

    @Override
    public void init() throws ServletException { // Essa função é sempre inicializada junto com o Servlet.
        List<Aluno> alunos = new ArrayList<>(); // Crio uma lista do tipo Aluno.
        getServletContext().setAttribute("alunos", alunos); // Adiciono a lista que criei dentro do Contexto Servlet para que outras classes Servlets possam acessar esse atributo.
        getServletContext().setAttribute("nextAlunoId", 1); // Adiciono também o dado "1" com atributo nextAlunoId
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("Alunos", alunos); // Crio um atributo chamado "Alunos" passando a nossa lista que criamos no inicio da classe.
		req.getRequestDispatcher("listarAlunos.jsp").forward(req, resp); // Envio essas informações para listarAlunos.jsp.
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Armazeno as informações fornecidas pelo request.
		String nome = req.getParameter("nome");
		String curso = req.getParameter("curso");
		Integer ano = Integer.valueOf(req.getParameter("ano"));
		
		
        Integer nextAlunoId = (Integer) getServletContext().getAttribute("nextAlunoId"); // Busco o nextAlunoId no Contexto Servlet e armezeno em uma variável.

		Aluno aluno = new Aluno(nextAlunoId, nome, curso, ano); // Crio um novo objeto do tipo aluno
		alunos.add(aluno);
		
		//Atualizo os dados que estão no Contexto Servlet
		getServletContext().setAttribute("alunos", alunos);
        getServletContext().setAttribute("nextAlunoId", nextAlunoId + 1);

		
		
		resp.sendRedirect("aluno");
	}
	
	
}