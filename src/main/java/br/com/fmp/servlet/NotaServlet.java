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

@WebServlet("/nota")
public class NotaServlet extends HttpServlet {
	// Cria uma lista do tipo Nota e um ID.
    private List<Nota> notas = new ArrayList<>();
    private int nextNotaId = 1;
    
    @Override
    public void init() throws ServletException { // Essa função é sempre inicializada junto com o Servlet.
    	List<Nota> notas = new ArrayList<>(); // Crio uma lista do tipo Nota.
    	getServletContext().setAttribute("notas", notas); // Adiciono a lista que criei dentro do Contexto Servlet para que outras classes Servlets possam acessar esse atributo.
    	getServletContext().setAttribute("nextNotaId", 1); // Adiciono também o dado "1" com o atributo nextNotaId.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("notas", notas); // Crio um atributo chamado "Alunos" passando a nossa lista que criamos no inicio da classe.
        req.getRequestDispatcher("listarNotas.jsp").forward(req, resp); // Envio essas informações para listarAlunos.jsp.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	//Armazeno as informações fornecidas pelo request.
    	Integer alunoId = Integer.valueOf(req.getParameter("alunoId"));
        String disciplina = req.getParameter("disciplina");
        Double nota = Double.valueOf(req.getParameter("nota"));
        
        //Crio um objeto do tipo Nota.
        Nota novaNota = new Nota(nextNotaId, alunoId, disciplina, nota);
        
        notas.add(novaNota);
        
		//Atualizo os dados que estão no Contexto Servlet
		getServletContext().setAttribute("alunos", notas);
        getServletContext().setAttribute("nextAlunoId", nextNotaId + 1);
        
        resp.sendRedirect("nota");
    }
}
