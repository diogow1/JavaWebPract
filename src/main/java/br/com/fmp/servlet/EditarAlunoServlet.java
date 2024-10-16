package br.com.fmp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fmp.models.Aluno;

@WebServlet("/aluno/editar")
public class EditarAlunoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idAluno = Integer.valueOf(request.getParameter("id")); // Armazeno o Id que foi enviado com o GET
        request.setAttribute("idAluno", idAluno);
		request.getRequestDispatcher("/editarAluno.jsp").forward(request, response); // Crio um atributo e envio ele pelo método POST
	}
	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//Armazeno as informações que o formulário está me enviando
        Integer id = Integer.valueOf(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String curso = request.getParameter("curso");
        Integer ano = Integer.valueOf(request.getParameter("ano"));

        List<Aluno> alunos = (List<Aluno>) getServletContext().getAttribute("alunos"); // Busco minha lista no Contexto Servlet
        

        // Percorro minha lista e verifico se o id que foi passado corresponde a algum que esta na lista.
        // Caso sim ele muda as informações.
        for (Aluno aluno : alunos) { 
            if (aluno.getId().equals(id)) {
                aluno.setNome(nome);
                aluno.setCurso(curso);
                aluno.setAno(ano);
                break;
            }
        }
        
        getServletContext().setAttribute("alunos", alunos); // Atualizo o COntexto Servlet

        // Redireciona para a listagem de alunos após a edição
        response.sendRedirect("visualizar");
    }
}

