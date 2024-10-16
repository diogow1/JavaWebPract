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


@WebServlet("/aluno/excluir")
public class ExcluirAlunoServlet extends HttpServlet {

    @Override
    public void init() throws ServletException { // Essa função é sempre inicializada junto com o Servlet.
        List<Aluno> alunos = (List<Aluno>) getServletContext().getAttribute("alunos"); // Busco minha lista no Contexto Servlet e armazeno ela.
        // Verifico se a lista está vazia, se sim crio uma nova lista e armazeno ela no Contexto Servlet.
        if (alunos == null) { 
            alunos = new ArrayList<>();
            getServletContext().setAttribute("alunos", alunos);
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	Integer id = Integer.valueOf(request.getParameter("id")); //Armazeno o Id do request
		List<Aluno> alunos = (List<Aluno>) getServletContext().getAttribute("alunos"); // Busco minha lista no Contexto Servlet
		
        // O removeIf é um método que percorre a lista e remove os itens que satisfazer uma condição.
		// Nesse caso, criamos uma expressão que verifica através do equals se o Id do aluno é o mesmo do fornecido pelo request
		// Se sim, ele remove o dado referente ao ID.
		alunos.removeIf(aluno -> aluno.getId().equals(id)); 
		
		getServletContext().setAttribute("alunos", alunos);
		
        response.sendRedirect("visualizar"); 
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response); // Como o request é feito pela URL (GET), mas preciso trabalhar com os dados pelo POST, eu chamo ele e envio os dados do request.
    }
}
