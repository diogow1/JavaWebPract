package br.com.fmp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fmp.models.Nota;

@WebServlet("/nota/visualizar")
public class VisualizarNotasServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Busco minha lista no Contexto Servlet
		List<Nota> notas = (List<Nota>) getServletContext().getAttribute("notas");
		
		// Envio minha lista para o listarNotas.jsp
		request.setAttribute("Notas", notas);
		request.getRequestDispatcher("/listarNotas.jsp").forward(request, response);
		
	}
}
			