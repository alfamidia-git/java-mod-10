package repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Professor;

public class ProfessorRepository implements Crud<Professor>{

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("escola");
	
	@Override
	public void create(Professor professor) {
		EntityManager em = factory.createEntityManager();

    	em.getTransaction().begin();

    	em.persist(professor);
    	em.getTransaction().commit();

    	em.close();
		
	}

	@Override
	public void update(Professor professorAtualizado) {
		EntityManager em = factory.createEntityManager();
    	
    	try {
    		Professor velhoProfessor = em.find(Professor.class, professorAtualizado.getId());
    		
    		em.getTransaction().begin();
    		
    		velhoProfessor.setDisciplina(professorAtualizado.getDisciplina());
    		velhoProfessor.setNome(professorAtualizado.getNome());
   
    		em.getTransaction().commit();
    		
    	}finally {
    		em.close();
    	}
		
	}

	@Override
	public void delete(int id) {
		EntityManager em = factory.createEntityManager();
    	
    	try {
    		Professor professor = em.find(Professor.class, id);
    		
    		em.getTransaction().begin();
    		
    		em.remove(professor);
    		
    		em.getTransaction().commit();
    	}finally {
    		em.close();
    	}
		
	}

	@Override
	public List<Professor> readAll() {
		EntityManager em = factory.createEntityManager();
    	List<Professor> resultado = null;
    	
    	try {
    		String jpql = "SELECT p FROM Professor p";
    		
    		TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
    		
    		resultado = query.getResultList();
    	}finally {
    		em.close();
    	}
    	
    	return resultado;
	}

	@Override
	public Professor readById(int id) {
		EntityManager em = factory.createEntityManager();
    	
    	try {
    		return em.find(Professor.class, id);
    	}finally {
    		em.close();
    	}
	}

}
