package br.com.fmp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fmp.models.Aluno;

@WebServlet("/aluno/visualizar")
public class VisualizarAlunosServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Busco minha lista no Contexto Servlet
		List<Aluno> alunos = (List<Aluno>) getServletContext().getAttribute("alunos");
		
		// Envio minha lista para o listarAlunos.jsp
		request.setAttribute("Alunos", alunos);
		request.getRequestDispatcher("/listarAlunos.jsp").forward(request, response);
	}
}