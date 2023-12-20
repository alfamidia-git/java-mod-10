package controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Professor;
import repository.ProfessorRepository;

@WebServlet(urlPatterns ={"/professor", "/professores", "/cadastrarProfessor", "/editarProfessor", "/excluirProfessor"})
public class ProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProfessorRepository repository = new ProfessorRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  	String uri = request.getRequestURI();
		    
		    if(uri.contains("cadastrar")) {
		    	this.cadastrarProfessor(request, response);
		    }else if(uri.contains("editar")){
	            this.setarProfessorParaEditar(request, response);
	        }else if(uri.contains("excluir")){
	            this.excluirProfessor(request, response);
	        }else {
		    	this.listarProfessores(request, response);
		    }
	}

	private void excluirProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idString = request.getParameter("id");
	    if(Objects.nonNull(idString) && !idString.isEmpty()){
	        int id = Integer.parseInt(idString);
            repository.delete(id);
        }
    
        response.sendRedirect("professor");
	}
	
	private void setarProfessorParaEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idString = request.getParameter("id");
	    if(Objects.nonNull(idString) && !idString.isEmpty()){
	        int id = Integer.parseInt(idString);

	        Professor professor = repository.readById(id);

	        request.setAttribute("professor", professor);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/formProfessor.jsp");
	        dispatcher.forward(request, response);
	    }
	}
	
	private void cadastrarProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/formProfessor.jsp");
	    dispatcher.forward(request, response);
	}
	
	private void listarProfessores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Professor> professores = repository.readAll();

	    request.setAttribute("professores", professores);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/professores.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");

        Integer id = Objects.nonNull(idString) && !idString.isEmpty() ? Integer.parseInt(idString) : null;
        String nome = request.getParameter("nome");
        String disciplina = request.getParameter("disciplina");

        Professor professor = new Professor();
        professor.setId(id);
        professor.setNome(nome);
        professor.setDisciplina(disciplina);

        if(Objects.nonNull(professor.getId())){
            repository.update(professor);
        }else{
            repository.create(professor);
        }

        response.sendRedirect("professores");
	}

}
