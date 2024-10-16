package br.com.fmp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fmp.models.Nota;

@WebServlet("/nota/cadastrar")
public class CadastrarNotaServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.getRequestDispatcher("/cadastrarNotas.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Armazeno os dados fornecidos pelo request.
        String alunoIdStr = request.getParameter("alunoId");
        String disciplina = request.getParameter("disciplina");
        String notaStr = request.getParameter("nota");
        
        // Busco minha lista de Notas e o Id no Contexto Servlet e armazeno elas.
        List<Nota> notas = (List<Nota>) getServletContext().getAttribute("notas");
        Integer nextNotaId = (Integer) getServletContext().getAttribute("nextNotaId");
        
        
        
        //Verifico se minha lista está vazia, se sim ele cria uma nova e armazena no Contexto Servlet
        if (notas == null) {
        	notas = new ArrayList<>();
        	getServletContext().setAttribute("notas", notas);
        }
        
        //Verifico se meu Id está vazio, se sim ele adiciona o parâmetro default e armazena no Contexto Servlet
        if (nextNotaId == null) {
        	nextNotaId = 1;
        	getServletContext().setAttribute("nextNotaId", nextNotaId);
        }
        
        //Crio variáveis onde irei converter os dados fornecidos pelo request (Tive que fazer isso porque por algum motivo tava dando erro de tipo de dado).
        Integer alunoId;
        Double nota;

        //Converto e armazeno os dados.
        alunoId = Integer.valueOf(alunoIdStr);
        nota = Double.valueOf(notaStr);
        
        //Crio um objeto do tipo Nota.
        Nota novaNota = new Nota(nextNotaId, alunoId, disciplina, nota);
        
        //Armazeno a novaNota na lista den notas.
        notas.add(novaNota);
        
        //Atualizo os atributos no Contexto Servlet.
        getServletContext().setAttribute("notas", notas);
        getServletContext().setAttribute("nextNotaId", nextNotaId + 1);
        
        response.sendRedirect("visualizar");
	}
}